/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

/**
 *
 * @author guest
 */
public class Psicologo extends Usuario {
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
}
