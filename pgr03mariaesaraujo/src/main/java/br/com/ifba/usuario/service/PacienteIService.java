
package br.com.ifba.usuario.service;

import br.com.ifba.usuario.entity.Paciente;
import java.util.List;

public interface PacienteIService {

    void save(Paciente paciente);

    void update(Paciente paciente);

    void delete(Paciente paciente);

    Paciente findById(String cpf);

    List<Paciente> findAll();

    Paciente findByEmail(String email);

}

