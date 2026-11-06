/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.infrastructure.dao.GenericDao;
import br.com.ifba.infrastructure.exception.DAOException;
import br.com.ifba.infrastructure.util.JPAUtil;
import br.com.ifba.usuario.entity.Paciente;

import jakarta.persistence.EntityManager;

/**
 *
 * @author guest
 */
public class PacienteDao extends GenericDao<Paciente, String>
        implements PacienteIDao {

    public PacienteDao() {
        super(Paciente.class);
    }

    @Override
    public Paciente findByEmail(String email) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT p FROM Paciente p WHERE p.email = :email",
                    Paciente.class
            )
                    .setParameter("email", email)
                    .getResultList()
                    .stream()
                    .findFirst()
                    .orElse(null);

        } catch (RuntimeException e) {
            throw new DAOException("Erro ao buscar paciente pelo email.", e);

        } finally {
            em.close();
        }
    }
}
