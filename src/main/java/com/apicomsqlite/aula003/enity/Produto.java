package com.apicomsqlite.aula003.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String preco;

    public Produto() {
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "produto{" +
                ", nome='" + nome + '\'' +
                ", preco='" + preco + '\'' +
                '}';
    }

    
}