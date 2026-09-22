/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.validar;
import br.com.ifba.usuario.entity.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author guest
 */
public class ValidadorUsuarioTest {
    
    //Iniciando sequencia de testes
    @Test 
    public void testarSeFoiInseridoPalavraProibidaNoLogin (){
        Usuario usuario = new Usuario ("suport","12345678987", "feminino", "18/01/2005", "74991070780", "maria@gmail.com", "duda4321");
        boolean error = ValidadorUsuario.contemPalavraProibida(usuario.getLogin());
        
        assertTrue(error);
    }
    
    @Test
    public void testarSeNãoFoiInseridoPalavraProibidaNoLogin (){
        Usuario usuario = new Usuario ("dumbhyo","12345678987", "feminino", "18/01/2005", "74991070780", "maria@gmail.com", "Duda4321");
        boolean error = ValidadorUsuario.contemPalavraProibida(usuario.getLogin());
        
        assertFalse(error);
    }
    
    @Test
    public void testarSeTodosOsCamposForamPreenchidos (){
        boolean error = ValidadorUsuario.camposPreenchidos("Maria", "12345678987", "18/01/2005", "74991070780", "maria@gmail.com", "Duda4321", "Duda4321");

        assertTrue(error);
    }

    @Test
    public void testarSeExisteCampoVazio (){
        boolean error = ValidadorUsuario.camposPreenchidos("Maria", "", "18/01/2005", "74991070780", "maria@gmail.com", "Duda4321", "Duda4321");

        assertFalse(error);
    }

    @Test
    public void testarSeAsSenhasConferem (){
        boolean error = ValidadorUsuario.senhasConferem("Duda4321", "Duda4321");

        assertTrue(error);
    }

    @Test
    public void testarSeAsSenhasNãoConferem (){
        boolean error = ValidadorUsuario.senhasConferem("Duda4321", "Duda1234");

        assertFalse(error);
    }

    @Test
    public void testarSeOCpfEValido (){
        boolean error = ValidadorUsuario.cpfValido("12345678987");

        assertTrue(error);
    }

    @Test
    public void testarSeOCpfPossuiLetras (){
        boolean error = ValidadorUsuario.cpfValido("123abc45678987");

        assertFalse(error);
    }

    @Test
    public void testarSeOCpfPossuiQuantidadeInvalidaDeNumeros (){
        boolean error = ValidadorUsuario.cpfValido("123456");

        assertFalse(error);
    }

    @Test
    public void testarSeASenhaEValida (){
        boolean error = ValidadorUsuario.senhaForte("Duda4321");

        assertTrue(error);
    }

    @Test
    public void testarSeASenhaPossuiMenosDeOitoCaracteres (){
        boolean error = ValidadorUsuario.senhaForte("Dud123");

        assertFalse(error);
    }

    @Test
    public void testarSeASenhaNaoPossuiLetraMaiuscula (){
        boolean error = ValidadorUsuario.senhaForte("duda4321");

        assertFalse(error);
    }

    @Test
    public void testarSeASenhaNaoPossuiLetraMinuscula (){
        boolean error = ValidadorUsuario.senhaForte("DUDA4321");

        assertFalse(error);
    }

    @Test
    public void testarSeASenhaNaoPossuiNumero (){
        boolean error = ValidadorUsuario.senhaForte("DudaSenha");

        assertFalse(error);
    }
    
        @Test
    public void testarSeOLoginFoiRealizadoComCredenciaisCorretas() {
        Usuario usuario = new Usuario("duda", "12345678987", "feminino", "18/01/2005", "74991070780", "maria@gmail.com", "duda4321");

        boolean error = usuario.autenticar("duda", "duda4321");

        assertTrue(error);
    }

    @Test
    public void testarSeOLoginFoiRecusadoComSenhaIncorreta() {
        Usuario usuario = new Usuario("duda", "12345678987", "feminino", "18/01/2005", "74991070780", "maria@gmail.com", "duda4321");

        boolean error = usuario.autenticar("duda", "senhaerrada");

        assertFalse(error);
    }
}



