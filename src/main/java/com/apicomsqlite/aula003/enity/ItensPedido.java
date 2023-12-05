package com.apicomsqlite.aula003.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItensPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String quantidade;

    private String nome;

    private String id_produto;

    private String id_sabor_pizza;

    private String id_sabor_lanche;

    private String id_sabor_borda;

    private String mesa;

    public ItensPedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getId_produto() {
        return id_produto;
    }

    public void setId_produto(String id_produto) {
        this.id_produto = id_produto;
    }

    public String getId_sabor_pizza() {
        return id_sabor_pizza;
    }

    public void setId_sabor_pizza(String id_sabor_pizza) {
        this.id_sabor_pizza = id_sabor_pizza;
    }

    public String getId_sabor_lanche() {
        return id_sabor_lanche;
    }

    public void setId_sabor_lanche(String id_sabor_lanche) {
        this.id_sabor_lanche = id_sabor_lanche;
    }

    public String getId_sabor_borda() {
        return id_sabor_borda;
    }

    public void setId_sabor_borda(String id_sabor_borda) {
        this.id_sabor_borda = id_sabor_borda;
    }

    @Override
    public String toString() {
        return "ItensPedido{" +
                ", mesa='" + mesa + '\'' +
                ", quantidade='" + quantidade + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}