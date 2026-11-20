
package br.com.ifba.usuario.dao;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.List;

public class FakeUsuarioDao implements UsuarioIDao {

    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void save(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCpf().equals(usuario.getCpf())) {
                usuarios.set(i, usuario);
                return;
            }
        }
    }

    @Override
    public void delete(Usuario usuario) {
        usuarios.removeIf(u -> u.getCpf().equals(usuario.getCpf()));
    }

    @Override
    public Usuario findById(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public Usuario findByLogin(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }
        return null;
    }
}
