
package br.com.ifba.usuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "Psicologos")
public class Psicologo extends Usuario {
    
    @Column(name = "crp", nullable = false)
    private String crp;

    public Psicologo() {
        super();
    }

    public Psicologo(String login, String cpf, String genero,
                     String dataNascimento, String telefone,
                     String email, String senha, String crp) {

        super(login, cpf, genero, dataNascimento,
              telefone, email, senha);

        this.crp = crp;
    }

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }
    
    @Override
    public String getTipo() {
    return "Psicologo";
    }
    
    @Override
    public boolean autenticar(String login, String senha) {
        return super.autenticar(login, senha);
    }
}
