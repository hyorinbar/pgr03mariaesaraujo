package br.com.ifba.usuario.entity;

import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.interfaces.Autenticavel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PolimorfismoTest {

    @Test
    public void testeAutenticacaodePacientePaciente() {
        Autenticavel paciente = new Usuario(
            "paciente",
            "11111111111",
            "Feminino",
            "01/01/2000",
            "77999999999",
            "paciente@email.com",
            "1234"
        );

        boolean resultado = paciente.realizarLogin(paciente, "paciente", "1234");

        assertTrue(resultado);
    }

    @Test
    public void testeAutenticacaodePsicologo() {
        Autenticavel psicologo = new Usuario(
            "psicologo",
            "22222222222",
            "Feminino",
            "01/01/1995",
            "77988888888",
            "psicologo@email.com",
            "1234"
        );

        boolean resultado = psicologo.realizarLogin(psicologo, "psicologo", "1234");

        assertTrue(resultado);
    }
}
