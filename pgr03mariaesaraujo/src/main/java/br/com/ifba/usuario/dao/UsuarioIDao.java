/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.infrastructure.dao.GenericIDao;
import br.com.ifba.usuario.entity.Usuario;

/**
 *
 * @author guest
 */
public interface UsuarioIDao extends GenericIDao<Usuario, String> {

    Usuario findByLogin(String login);

}
