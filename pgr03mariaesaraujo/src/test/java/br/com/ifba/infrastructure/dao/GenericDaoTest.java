/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.exception.DAOException;
import br.com.ifba.usuario.entity.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author guest
 */
public class GenericDaoTest {

    @Test
    public void deveLancarDAOExceptionAoSalvarEntidadeNula() {

        GenericDao<Usuario, String> dao = new GenericDao<>(Usuario.class);

        assertThrows(DAOException.class, () -> {dao.save(null);
        });
    }
}
