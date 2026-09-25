/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

/**
 *
 * @author guest
 */
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
}
