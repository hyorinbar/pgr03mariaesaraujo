/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.validar;

public class ValidadorUsuario {

    public static boolean contemPalavraProibida(String texto) {

        String[] palavrasProibidas = {"admin", "teste", "root", "administrador", "usuario",
            "12345678", "suport", "supporte", "senha", "password", "senha123"};

        for (String palavra : palavrasProibidas) {
            if (texto.contains(palavra)) {
                return true;
            }
        }

        return false;
    }

    public static boolean camposPreenchidos(
            String nome,
            String cpf,
            String dataNascimento,
            String telefone,
            String email,
            String senha,
            String confirmarSenha) {

        return !nome.trim().isEmpty() && !cpf.trim().isEmpty() && !dataNascimento.trim().isEmpty() && !telefone.trim().isEmpty()
                && !email.trim().isEmpty() && !senha.isEmpty() && !confirmarSenha.isEmpty();
    }

    public static boolean senhasConferem(
            String senha,
            String confirmarSenha) {

        return senha.equals(confirmarSenha);
    }

    public static boolean cpfValido(String cpf) {

        if (cpf == null || cpf.isEmpty()) {
            return false;
        }

        if (!cpf.matches("\\d{11}")) {
            return false;
        }

        return true;
    }

    public static boolean senhaForte(String senha) {

        if (senha == null || senha.length() < 8) {
            return false;
        }

        boolean possuiMaiuscula = false;
        boolean possuiMinuscula = false;
        boolean possuiNumero = false;

        for (char c : senha.toCharArray()) {

            if (Character.isUpperCase(c)) {
                possuiMaiuscula = true;
            }

            if (Character.isLowerCase(c)) {
                possuiMinuscula = true;
            }

            if (Character.isDigit(c)) {
                possuiNumero = true;
            }
        }

        return possuiMaiuscula
                && possuiMinuscula
                && possuiNumero;
    }
}