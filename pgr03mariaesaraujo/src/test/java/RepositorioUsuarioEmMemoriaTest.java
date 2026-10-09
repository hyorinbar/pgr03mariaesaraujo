import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.repository.RepositorioUsuarioEmMemoria;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioUsuarioEmMemoriaTest {

    private Usuario criarUsuario(String login, String cpf) {
        return new Usuario(login, cpf, "M", "2000-01-01", "7199999999", login + "@email.com","123");
    }

    @Test
    void deveCadastrarEListarUsuario() {
        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();

        Usuario usuario = criarUsuario("joao", "11122233344");

        repositorio.cadastrar(usuario);

        List<Usuario> usuarios = repositorio.listarTodos();

        assertEquals(1, usuarios.size());
        assertEquals("joao", usuarios.get(0).getLogin());
    }

    @Test
    void deveBuscarUsuarioCorretoPorLogin() {
        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();

        Usuario usuario1 = criarUsuario("joao", "11122233344");
        Usuario usuario2 = criarUsuario("maria", "55566677788");

        repositorio.cadastrar(usuario1);
        repositorio.cadastrar(usuario2);

        assertSame(usuario2, repositorio.buscarPorLogin("maria"));
    }

    @Test
    void deveRetornarNullQuandoLoginNaoExiste() {
        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();

        repositorio.cadastrar(
            criarUsuario("joao", "11122233344")
        );

        assertNull(repositorio.buscarPorLogin("pedro"));
    }

    @Test
    void usuariosComMesmoLoginDevemSerIguais() {
        Usuario usuario1 = criarUsuario("joao", "11122233344");
        Usuario usuario2 = criarUsuario("joao", "55566677788");

        List<Usuario> lista = new java.util.ArrayList<>();
        lista.add(usuario1);

        assertEquals(usuario1, usuario2);
        assertTrue(lista.contains(usuario2));
    }
}

