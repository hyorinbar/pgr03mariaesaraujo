
package br.com.ifba.usuario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pacientes")
public class Paciente extends Usuario {
    public Paciente() {
        super();
    }

    public Paciente(String login, String cpf, String genero,
                    String dataNascimento, String telefone,
                    String email, String senha) {

        super(login, cpf, genero, dataNascimento,
              telefone, email, senha);
    }
    
    @Override
    public String getTipo() {
    return "Paciente";
    }
    
    @Override
    public boolean autenticar(String login, String senha) {
       return super.autenticar(login, senha);
    }
}
