
package br.com.ifba.usuario.controller;

import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.service.UsuarioIService;
import java.util.List;

public class UsuarioController implements UsuarioIController {

    private final UsuarioIService service;

    // Injeção de dependência pelo construtor
    public UsuarioController(UsuarioIService service) {
        this.service = service;
    }
    
    @Override
    public void save(Usuario usuario, String confirmarSenha) {
        service.save(usuario, confirmarSenha);
    }
    
    @Override
    public boolean autenticar(String login, String senha) {
        return service.autenticar(login, senha);
    }

    @Override
    public void save(Usuario usuario) {
        service.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        service.update(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        service.delete(usuario);
    }

    @Override
    public Usuario findById(String cpf) {
        return service.findById(cpf);
    }

    @Override
    public List<Usuario> findAll() {
        return service.findAll();
    }

    @Override
    public Usuario findByLogin(String login) {
        return service.findByLogin(login);
    }
}

