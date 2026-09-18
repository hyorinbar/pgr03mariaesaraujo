/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

import br.com.ifba.usuario.interfaces.Autenticavel;
/**
 *
 * @author guest
 */
public class Usuario implements Autenticavel {
    //variaveis publicas sem metodos. 
    private String login;
    private String cpf;
    private String genero;
    private String dataNascimento;
    private String tel;
    private String email;
    private String senha;
    
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    public Usuario() {
    }

    public Usuario(String login, String cpf, String genero, String dataNascimento, String tel, String email, String senha) {
        this.login = login;
        this.cpf = cpf;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.tel = tel;
        this.email = email;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String nome) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
