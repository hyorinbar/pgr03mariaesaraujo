
package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioUsuarioEmMemoria {

    private final List<Usuario> usuarios = new ArrayList<>();

    private final Map<String, Usuario> porLogin = new HashMap<>();

    public void cadastrar(Usuario usuario) {
        usuarios.add(usuario);
        porLogin.put(usuario.getLogin(), usuario);
    }

    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    // Busca percorrendo a lista
    public Usuario buscarPorLoginLinear(String login) {
        for (Usuario usuario : usuarios) {
            if (login.equals(usuario.getLogin())) {
                return usuario;
            }
        }

        return null;
    }

    // Busca usando o Map
    public Usuario buscarPorLogin(String login) {
        return porLogin.get(login);
    }
}
