
package br.com.ifba.usuario.controller;

import br.com.ifba.usuario.entity.Usuario;
import java.util.List;

public interface UsuarioIController {

    void save(Usuario usuario);

    void update(Usuario usuario);

    void delete(Usuario usuario);

    Usuario findById(String cpf);

    List<Usuario> findAll();

    Usuario findByLogin(String login);

    void save(Usuario usuario, String confirmarSenha);
    
    boolean autenticar(String login, String senha);
}

