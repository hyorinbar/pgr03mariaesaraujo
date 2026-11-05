/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  guest
 * Created: Nov 4, 2026
 */

CREATE TABLE usuario (
    cpf varchar (255) NOT NULL,
    data_nascimento varchar (255) NOT NULL,
    email varchar (255) NOT NULL,
    genero varchar (255) NOT NULL,
    login varchar (255) NOT NULL,
    senha varchar (255) NOT NULL,
    telefone varchar (255),
    CONSTRAINT pk_cpf PRIMARY KEY (cpf)
);

