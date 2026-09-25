 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

import br.com.ifba.usuario.interfaces.Autenticavel;

import java.util.ArrayList;
import java.util.List;

public class Usuario implements Autenticavel {

    private String login;
    private String cpf;
    private String genero;
    private String dataNascimento;
    private String tel;
    private String email;
    private String senha;
    private List<Perfil> perfis;
    private List<Vinculo> vinculos;

    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    public Usuario() {
        this.perfis = new ArrayList<>();
        this.vinculos = new ArrayList<>();
    }

    public Usuario(String login, String cpf, String genero, String dataNascimento,
                   String tel, String email, String senha) {

        this.login = login;
        this.cpf = cpf;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.tel = tel;
        this.email = email;
        this.senha = senha;
        this.perfis = new ArrayList<>();
        this.vinculos = new ArrayList<>();
    }

    public Usuario(String login, String cpf, String genero, String dataNascimento,
                   String tel, String email, String senha,
                   List<Perfil> perfis, List<Vinculo> vinculos) {

        this.login = login;
        this.cpf = cpf;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.tel = tel;
        this.email = email;
        this.senha = senha;
        this.perfis = perfis;
        this.vinculos = vinculos;
    }
    
    public String getTipo() {
    return "Usuario";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
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

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }

    public void adicionarPerfil(Perfil perfil) {
        perfis.add(perfil);
    }

    public List<Vinculo> getVinculos() {
        return vinculos;
    }

    public void setVinculos(List<Vinculo> vinculos) {
        this.vinculos = vinculos;
    }

    public void adicionarVinculo(Vinculo vinculo) {
        vinculos.add(vinculo);
    }
}
