
package br.com.ifba.usuario.service;

import br.com.ifba.usuario.dao.PsicologoIDao;
import br.com.ifba.usuario.entity.Psicologo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PsicologoService implements PsicologoIService {

    private final PsicologoIDao dao;

    // Injeção de dependência pelo construtor
    public PsicologoService(PsicologoIDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Psicologo psicologo) {
        dao.save(psicologo);
    }

    @Override
    public void update(Psicologo psicologo) {
        dao.update(psicologo);
    }

    @Override
    public void delete(Psicologo psicologo) {
        dao.delete(psicologo);
    }

    @Override
    public Psicologo findById(String cpf) {
        return dao.findById(cpf);
    }

    @Override
    public List<Psicologo> findAll() {
        return dao.findAll();
    }

    @Override
    public Psicologo findByCrp(String crp) {
        return dao.findByCrp(crp);
    }
}
