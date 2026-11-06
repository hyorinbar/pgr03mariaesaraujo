/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.infrastructure.dao.GenericIDao;
import br.com.ifba.usuario.entity.Psicologo;

/**
 *
 * @author guest
 */
public interface PsicologoIDao extends GenericIDao<Psicologo, String> {

    Psicologo findByCrp(String crp);

}

