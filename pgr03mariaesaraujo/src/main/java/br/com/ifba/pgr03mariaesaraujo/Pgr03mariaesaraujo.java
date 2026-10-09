
package br.com.ifba.pgr03mariaesaraujo;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Pgr03mariaesaraujo {

    public static void main(String[] args) {

        Usuario usuario1 = new Usuario();
        usuario1.setLogin("joao");

        Usuario usuario2 = new Usuario();
        usuario2.setLogin("joao");

        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(usuario1);

        System.out.println(usuarios.contains(usuario2));
    }
}

