
package br.com.ifba.usuario.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(String login) {
        super("Não foi encontrado nenhum usuário com o login: " + login);
    }
}

