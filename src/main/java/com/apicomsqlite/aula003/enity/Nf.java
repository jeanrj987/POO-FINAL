// Nf.java
package com.apicomsqlite.aula003.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numNota;

    private int id_cliente;

    private int id_pedido;

    private int id_pagamento;

    public Nf() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumNota() {
        return numNota;
    }

    public void setNumNota(int numNota) {
        this.numNota = numNota;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    @Override
    public String toString() {
        return "Nf{" +
                "numNota='" + numNota + '\'' +
                '}';
    }
}
