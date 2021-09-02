package com.depilartebe.depilarteBackend.be.entities;


import javax.persistence.*;

@Entity
@Table(name = "depilarte_metodopagos")
public class formaPay {

    @Id
    @Column(name = "id_pagos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "metodoPago")
    private String metodoPago;

    public Long getId() {
        return id;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
