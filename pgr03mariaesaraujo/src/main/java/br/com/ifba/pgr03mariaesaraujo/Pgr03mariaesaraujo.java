
package br.com.ifba.pgr03mariaesaraujo;

import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.repositorio.RepositorioUsuarioEmMemoria;
import java.util.ArrayList;
import java.util.List;

public class Pgr03mariaesaraujo {

    public static void main(String[] args) {

        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();

        Usuario usuario1 = new Usuario();
        usuario1.setLogin("joao");

        Usuario usuario2 = new Usuario();
        usuario2.setLogin("maria");

        repositorio.cadastrar(usuario1);
        repositorio.cadastrar(usuario2);

        Usuario resultadoLista = repositorio.buscarPorLoginLinear("maria");

        Usuario resultadoMap = repositorio.buscarPorLogin("maria");

        System.out.println(resultadoLista.getLogin());
        System.out.println(resultadoMap.getLogin());

        System.out.println(repositorio.buscarPorLogin("pedro"));
    }
}

