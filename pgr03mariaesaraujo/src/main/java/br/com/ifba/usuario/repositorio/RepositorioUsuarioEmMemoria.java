
package br.com.ifba.usuario.repositorio;

import br.com.ifba.infrastructure.util.JPAUtil;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.exception.UsuarioNaoEncontradoException;
import jakarta.persistence.EntityManager;
import java.util.List;

public class RepositorioUsuarioEmMemoria {

    public void cadastrar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Usuario> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT u FROM Usuario u",
                    Usuario.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    // Busca por login usando o banco de dados
    public Usuario buscarPorLoginLinear(String login) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            List<Usuario> usuarios = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.login = :login",
                    Usuario.class
            )
            .setParameter("login", login)
            .getResultList();

            if (usuarios.isEmpty()) {
                throw new UsuarioNaoEncontradoException(login);
            }

            return usuarios.get(0);
        } finally {
            em.close();
        }
    }

    // Busca por login usando o banco de dados
    public Usuario buscarPorLogin(String login) {
        return buscarPorLoginLinear(login);
    }
}
