 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

import br.com.ifba.usuario.interfaces.Autenticavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario implements Autenticavel {

    @Column(name = "login", nullable = false)
    private String login;
    
    @Id
    @Column(name = "cpf", nullable = false)
    private String cpf;
    
    @Column(name = "genero", nullable = false)
    private String genero;
    
    @Column(name = "data_nascimento", nullable = false)
    private String dataNascimento;
    
    @Column(name = "telefone")
    private String tel;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "senha", nullable = false)
    private String senha;
    
    //private List<Perfil> perfis;
    //private List<Vinculo> vinculos;

    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
    
    public boolean realizarLogin(Autenticavel usuario, String login, String senha) {
        return usuario.autenticar(login, senha);
    }
    
    // O login identifica o usuário no sistema e deve ser único.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Usuario outro = (Usuario) obj;

        return Objects.equals(this.login, outro.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    public Usuario() {
    //    this.perfis = new ArrayList<>();
    //    this.vinculos = new ArrayList<>();
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
    //    this.perfis = new ArrayList<>();
    //    this.vinculos = new ArrayList<>();
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
    //    this.perfis = perfis;
    //    this.vinculos = vinculos;
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

/*    public List<Perfil> getPerfis() {
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
    }*/
}
