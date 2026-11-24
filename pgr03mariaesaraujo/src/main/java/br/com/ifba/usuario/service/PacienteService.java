
package br.com.ifba.usuario.service;

import br.com.ifba.usuario.dao.PacienteIDao;
import br.com.ifba.usuario.entity.Paciente;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PacienteService implements PacienteIService {

    private final PacienteIDao dao;

    // Injeção de dependência pelo construtor
    public PacienteService(PacienteIDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Paciente paciente) {
        dao.save(paciente);
    }

    @Override
    public void update(Paciente paciente) {
        dao.update(paciente);
    }

    @Override
    public void delete(Paciente paciente) {
        dao.delete(paciente);
    }

    @Override
    public Paciente findById(String cpf) {
        return dao.findById(cpf);
    }

    @Override
    public List<Paciente> findAll() {
        return dao.findAll();
    }

    @Override
    public Paciente findByEmail(String email) {
        return dao.findByEmail(email);
    }
}

