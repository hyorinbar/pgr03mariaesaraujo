/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.validar;

public class ValidadorUsuario {
    
    public static boolean contemPalavraProibida(String texto) {
        String[] palavrasProibidas = {"admin", "teste", "root", "administrador", "usuario", "12345678", "suport", "supporte", "senha", "password", "senha123"};
        
        for (String palavra : palavrasProibidas) {
            if (texto.contains(palavra)) {
                return true;
            }
        }
        return false;
    }
}
