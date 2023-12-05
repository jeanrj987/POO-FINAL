package com.apicomsqlite.aula003.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_pedido;

    private int id;

    private String nome;

    private String telefone;

    public Clientes() {
    }

   

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getTelefone() {
        return telefone;
    }



    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    @Override
    public String toString() {
        return "Clientes{" +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    
}