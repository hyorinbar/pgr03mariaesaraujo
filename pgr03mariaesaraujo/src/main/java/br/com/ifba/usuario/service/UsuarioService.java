
package br.com.ifba.usuario.service;

import br.com.ifba.usuario.dao.UsuarioIDao;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.exception.NegocioException;
import br.com.ifba.usuario.validar.ValidadorUsuario;
import java.util.List;

public class UsuarioService implements UsuarioIService {

    private final UsuarioIDao dao;

    // Injeção de dependência pelo construtor
    public UsuarioService(UsuarioIDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Usuario usuario) {

        // Verifica campos obrigatórios
        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()
                || usuario.getCpf() == null || usuario.getCpf().trim().isEmpty()
                || usuario.getDataNascimento() == null || usuario.getDataNascimento().trim().isEmpty()
                || usuario.getTel() == null || usuario.getTel().trim().isEmpty()
                || usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()
                || usuario.getSenha() == null || usuario.getSenha().isEmpty()) {

            throw new NegocioException("Preencha todos os campos.");
        }

        // Verifica palavras proibidas no login
        if (ValidadorUsuario.contemPalavraProibida(usuario.getLogin())) {
            throw new NegocioException(
                    "O nome de usuário contém uma palavra proibida."
            );
        }

        // Verifica CPF
        if (!ValidadorUsuario.cpfValido(usuario.getCpf())) {
            throw new NegocioException("CPF inválido.");
        }

        // Verifica força da senha
        if (!ValidadorUsuario.senhaForte(usuario.getSenha())) {
            throw new NegocioException(
                    "A senha deve possuir pelo menos 8 caracteres, "
                    + "uma letra maiúscula, uma letra minúscula e um número."
            );
        }

        // Verifica se o login já existe
        if (dao.findByLogin(usuario.getLogin()) != null) {
            throw new NegocioException("Este login já está cadastrado.");
        }

        // Se todas as regras forem respeitadas, salva
        dao.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        dao.update(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        dao.delete(usuario);
    }

    @Override
    public Usuario findById(String cpf) {
        return dao.findById(cpf);
    }

    @Override
    public List<Usuario> findAll() {
        return dao.findAll();
    }

    @Override
    public Usuario findByLogin(String login) {
        return dao.findByLogin(login);
    }
}
