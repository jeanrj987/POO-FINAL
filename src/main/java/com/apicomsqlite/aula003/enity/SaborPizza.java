package com.apicomsqlite.aula003.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SaborPizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String nome;

    public SaborPizza() {
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

    @Override
    public String toString() {
        return "SaborPizza{" +
                ", nome='" + nome + '\'' +
                '}';
    }

    
}