
package br.com.ifba.usuario.controller;

import br.com.ifba.usuario.entity.Psicologo;
import br.com.ifba.usuario.service.PsicologoIService;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
public class PsicologoController implements PsicologoIController {

    private final PsicologoIService service;

    // Injeção de dependência pelo construtor
    public PsicologoController(PsicologoIService service) {
        this.service = service;
    }

    @Override
    public void save(Psicologo psicologo) {
        service.save(psicologo);
    }

    @Override
    public void update(Psicologo psicologo) {
        service.update(psicologo);
    }

    @Override
    public void delete(Psicologo psicologo) {
        service.delete(psicologo);
    }

    @Override
    public Psicologo findById(String cpf) {
        return service.findById(cpf);
    }

    @Override
    public List<Psicologo> findAll() {
        return service.findAll();
    }

    @Override
    public Psicologo findByCrp(String crp) {
        return service.findByCrp(crp);
    }
}

