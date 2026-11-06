/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.infrastructure.dao.GenericDao;
import br.com.ifba.infrastructure.exception.DAOException;
import br.com.ifba.infrastructure.util.JPAUtil;
import br.com.ifba.usuario.entity.Psicologo;

import jakarta.persistence.EntityManager;

/**
 *
 * @author guest
 */
public class PsicologoDao extends GenericDao<Psicologo, String>
        implements PsicologoIDao {

    public PsicologoDao() {
        super(Psicologo.class);
    }

    @Override
    public Psicologo findByCrp(String crp) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT p FROM Psicologo p WHERE p.crp = :crp",
                    Psicologo.class
            )
            .setParameter("crp", crp)
            .getResultList()
            .stream()
            .findFirst()
            .orElse(null);

        } catch (RuntimeException e) {
            throw new DAOException("Erro ao buscar psicólogo pelo CRP.", e);

        } finally {
            em.close();
        }
    }
}

