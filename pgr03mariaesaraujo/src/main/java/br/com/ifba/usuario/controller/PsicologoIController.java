
package br.com.ifba.usuario.controller;

import br.com.ifba.usuario.entity.Psicologo;
import java.util.List;

public interface PsicologoIController {

    void save(Psicologo psicologo);

    void update(Psicologo psicologo);

    void delete(Psicologo psicologo);

    Psicologo findById(String cpf);

    List<Psicologo> findAll();

    Psicologo findByCrp(String crp);

}

