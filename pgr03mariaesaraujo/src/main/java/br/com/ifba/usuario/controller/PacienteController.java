
package br.com.ifba.usuario.controller;

import br.com.ifba.usuario.entity.Paciente;
import br.com.ifba.usuario.service.PacienteIService;
import java.util.List;

public class PacienteController implements PacienteIController {

    private final PacienteIService service;

    // Injeção de dependência pelo construtor
    public PacienteController(PacienteIService service) {
        this.service = service;
    }

    @Override
    public void save(Paciente paciente) {
        service.save(paciente);
    }

    @Override
    public void update(Paciente paciente) {
        service.update(paciente);
    }

    @Override
    public void delete(Paciente paciente) {
        service.delete(paciente);
    }

    @Override
    public Paciente findById(String cpf) {
        return service.findById(cpf);
    }

    @Override
    public List<Paciente> findAll() {
        return service.findAll();
    }

    @Override
    public Paciente findByEmail(String email) {
        return service.findByEmail(email);
    }
}
