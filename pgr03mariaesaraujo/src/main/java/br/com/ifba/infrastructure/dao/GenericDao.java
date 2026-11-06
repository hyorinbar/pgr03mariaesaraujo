
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.util.JPAUtil;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import br.com.ifba.infrastructure.dao.GenericIDao;
import br.com.ifba.infrastructure.entity.PersistenceEntity;
import br.com.ifba.infrastructure.exception.DAOException;

public class GenericDao<Entity extends PersistenceEntity, ID> implements GenericIDao<Entity, ID> {

    private final Class<Entity> tipo;

    public GenericDao(Class<Entity> tipo) {
        this.tipo = tipo;
    }

    @Override
    public void save(Entity entity) {
        executarTransacao(em -> em.persist(entity));
    }

    @Override
    public void update(Entity entity) {
        executarTransacao(em -> em.merge(entity));
    }

    @Override
    public void delete(Entity entity) {
        executarTransacao(em -> {
            Entity entidadeGerenciada = em.contains(entity)
                    ? entity
                    : em.merge(entity);

            em.remove(entidadeGerenciada);
        });
    }

    @Override
    public Entity findById(ID id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.find(tipo, id);
        } catch (RuntimeException e) {
            throw new DAOException("Erro ao buscar registro.", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Entity> findAll() {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT e FROM " + tipo.getSimpleName() + " e",
                    tipo
            ).getResultList();

        } catch (RuntimeException e) {
            throw new DAOException("Erro ao listar registros.", e);
        } finally {
            em.close();
        }
    }

    private void executarTransacao(
            java.util.function.Consumer<EntityManager> operacao) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();

            operacao.accept(em);

            transacao.commit();

        } catch (RuntimeException e) {

            if (transacao.isActive()) {
                transacao.rollback();
            }

            throw new DAOException(
                    "Erro ao executar operação no banco de dados.", e
            );

        } finally {
            em.close();
        }
    }
}

