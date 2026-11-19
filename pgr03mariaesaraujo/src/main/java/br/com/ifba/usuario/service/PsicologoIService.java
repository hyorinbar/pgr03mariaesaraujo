
package br.com.ifba.usuario.service;

import br.com.ifba.usuario.entity.Psicologo;
import java.util.List;

public interface PsicologoIService {

    void save(Psicologo psicologo);

    void update(Psicologo psicologo);

    void delete(Psicologo psicologo);

    Psicologo findById(String cpf);

    List<Psicologo> findAll();

    Psicologo findByCrp(String crp);

}
