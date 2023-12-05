package com.apicomsqlite.aula003.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private int id_cliente;

    private int id_ItensPedido;

    private int id_ForPgto;
    
    private int id_Nf;

    private String data;

    private String status;

    private String total;

    private String taxa;

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_ItensPedido() {
        return id_ItensPedido;
    }

    public void setId_ItensPedido(int id_ItensPedido) {
        this.id_ItensPedido = id_ItensPedido;
    }

    public int getId_ForPgto() {
        return id_ForPgto;
    }

    public void setId_ForPgto(int id_ForPgto) {
        this.id_ForPgto = id_ForPgto;
    }

    public int getId_Nf() {
        return id_Nf;
    }

    public void setId_Nf(int id_Nf) {
        this.id_Nf = id_Nf;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

      public String getTaxa() {
        return taxa;
    }

    public void setTaxa(String taxa) {
        this.taxa = taxa;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                ", data='" + data + '\'' +
                ", status='" + status + '\'' +
                ", total='" + total + '\'' +
                ", taxa='" + taxa + '\'' +
                '}';
    }

  

    
}