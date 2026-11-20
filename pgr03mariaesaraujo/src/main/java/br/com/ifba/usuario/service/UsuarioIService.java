
package br.com.ifba.usuario.service;

import br.com.ifba.usuario.entity.Usuario;
import java.util.List;

public interface UsuarioIService {

    void save(Usuario usuario);

    void update(Usuario usuario);

    void delete(Usuario usuario);

    Usuario findById(String cpf);

    List<Usuario> findAll();

    Usuario findByLogin(String login);
    
    void save(Usuario usuario, String confirmarSenha);
    
    boolean autenticar(String login, String senha);
}
