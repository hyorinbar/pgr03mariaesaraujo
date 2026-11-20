package br.com.ifba.usuario.service;

import br.com.ifba.usuario.dao.FakeUsuarioDao;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.exception.NegocioException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServiceTest {

    private FakeUsuarioDao fakeDao;
    private UsuarioService service;

    @BeforeEach
    public void setUp() {
        fakeDao = new FakeUsuarioDao();
        service = new UsuarioService(fakeDao);
    }

    private Usuario criarUsuario() {
        return new Usuario(
                "mariaedu",
                "12345678901",
                "Feminino",
                "2000-05-10",
                "71999999999",
                "maria@email.com",
                "Maria123"
        );
    }

    @Test
    public void deveSalvarUsuario() {
        Usuario usuario = criarUsuario();

        service.save(usuario);

        assertNotNull(fakeDao.findById("12345678901"));
    }

    @Test
    public void naoDeveSalvarComCamposVazios() {
        Usuario usuario = criarUsuario();
        usuario.setEmail("");

        assertThrows(NegocioException.class,
                () -> service.save(usuario));
    }

    @Test
    public void naoDeveSalvarComCpfInvalido() {
        Usuario usuario = criarUsuario();
        usuario.setCpf("123");

        assertThrows(NegocioException.class,
                () -> service.save(usuario));
    }

    @Test
    public void naoDeveSalvarComLoginDuplicado() {
        service.save(criarUsuario());

        Usuario segundo = new Usuario(
                "mariaedu",
                "98765432100",
                "Feminino",
                "2000-05-10",
                "71999999999",
                "outro@email.com",
                "Maria123"
        );

        assertThrows(NegocioException.class,
                () -> service.save(segundo));
    }

    @Test
    public void naoDeveSalvarComSenhasDiferentes() {
        Usuario usuario = criarUsuario();

        assertThrows(NegocioException.class,
                () -> service.save(usuario, "SenhaDiferente123"));
    }

    @Test
    public void deveAutenticarUsuario() {
        Usuario usuario = criarUsuario();
        service.save(usuario);

        assertTrue(service.autenticar("mariaedu", "Maria123"));
        assertFalse(service.autenticar("mariaedu", "senhaErrada"));
    }
}