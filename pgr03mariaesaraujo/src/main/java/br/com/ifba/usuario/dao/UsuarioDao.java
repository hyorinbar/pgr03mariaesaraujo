/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.infrastructure.dao.GenericDao;
import br.com.ifba.infrastructure.exception.DAOException;
import br.com.ifba.infrastructure.util.JPAUtil;
import br.com.ifba.usuario.entity.Usuario;

import jakarta.persistence.EntityManager;

/**
 *
 * @author guest
 */
public class UsuarioDao extends GenericDao<Usuario, String> implements UsuarioIDao {

    public UsuarioDao() {
        super(Usuario.class);
    }

    @Override
    public Usuario findByLogin(String login) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.login = :login",
                    Usuario.class
            )
                    .setParameter("login", login)
                    .getResultList()
                    .stream()
                    .findFirst()
                    .orElse(null);

        } catch (RuntimeException e) {
            throw new DAOException("Erro ao buscar usuário pelo login.", e);

        } finally {
            em.close();
        }
    }
}
