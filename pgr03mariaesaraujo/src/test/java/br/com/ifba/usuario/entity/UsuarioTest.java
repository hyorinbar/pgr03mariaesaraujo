/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.entity.Vinculo;
import br.com.ifba.usuario.entity.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author guest
 */
public class UsuarioTest {
    @Test
    void deveAdicionarVinculo() {
        Usuario usuario = new Usuario();

        int tamanhoInicial = usuario.getVinculos().size();

        Vinculo vinculo = new Vinculo();
        usuario.adicionarVinculo(vinculo);

        assertEquals(tamanhoInicial + 1, usuario.getVinculos().size());
    }
    
    @Test
    void deveDefinirStatusDoVinculo() {
        Vinculo vinculo = new Vinculo();

        vinculo.setStatus(Status.ATIVO);

        assertEquals(Status.ATIVO, vinculo.getStatus());
    }

    @Test
    void deveAdicionarPerfil() {
        Usuario usuario = new Usuario();
        Perfil perfil = new Perfil();

        usuario.adicionarPerfil(perfil);

        assertTrue(usuario.getPerfis().contains(perfil));
    }
}
