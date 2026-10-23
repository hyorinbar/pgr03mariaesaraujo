package br.com.ifba.usuario.repositorio;

import br.com.ifba.infrastructure.util.JPAUtil;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.exception.UsuarioNaoEncontradoException;
import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepositorioUsuarioEmMemoriaTest {

    @Test
    void deveLancarExcecaoQuandoLoginNaoExiste() {

        RepositorioUsuarioEmMemoria repositorio
                = new RepositorioUsuarioEmMemoria();

        String loginInexistente
                = "inexistente-" + java.util.UUID.randomUUID();

        assertThrows(
                UsuarioNaoEncontradoException.class,
                () -> repositorio.buscarPorLogin(loginInexistente)
        );
    }

    @Test
    void naoDeveLancarExcecaoQuandoUsuarioExiste() {

        String login = "teste-" + java.util.UUID.randomUUID();

        String cpf = java.util.UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 11);

        Usuario usuario = new Usuario(
                login,
                cpf,
                "feminino",
                "18/01/2005",
                "74991070780",
                login + "@teste.com",
                "Duda1234"
        );

        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();

            RepositorioUsuarioEmMemoria repositorio
                    = new RepositorioUsuarioEmMemoria();

            Usuario encontrado = assertDoesNotThrow(
                    () -> repositorio.buscarPorLogin(login)
            );

            assertEquals(login, encontrado.getLogin());

        } finally {
            try {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }

                Usuario cadastrado = em.find(Usuario.class, cpf);

                if (cadastrado != null) {
                    em.getTransaction().begin();
                    em.remove(cadastrado);
                    em.getTransaction().commit();
                }

            } finally {
                em.close();
            }
        }
    }
}
