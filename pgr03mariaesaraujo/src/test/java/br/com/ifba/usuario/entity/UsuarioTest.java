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

    @Test
    void deveUsarMetodoHerdado() {
        Paciente paciente = new Paciente();

        paciente.setEmail("paciente@email.com");

        assertEquals("paciente@email.com", paciente.getEmail());
    }

    @Test
    void pacienteDeveRetornarSeuProprioTipo() {
        Paciente paciente = new Paciente();

        assertEquals("Paciente", paciente.getTipo());
    }

    @Test
    void psicologoDeveRetornarSeuProprioTipo() {
        Psicologo psicologo = new Psicologo();

        assertEquals("Psicologo", psicologo.getTipo());
    }
}
