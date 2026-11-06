/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.ifba.infrastructure.exception;

public class DAOException extends RuntimeException {

    public DAOException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
