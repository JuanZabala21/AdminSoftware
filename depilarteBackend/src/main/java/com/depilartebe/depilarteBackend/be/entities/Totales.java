package com.depilartebe.depilarteBackend.be.entities;

import javax.persistence.*;

@Entity
@Table(name = "depilarte_totales")
public class Totales {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="PagoMovil")
    private String pagoMovil;

    @Column(name="Zelle")
    private String zelle;

    @Column(name="Efectivo")
    private String efectivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPagoMovil() {
        return pagoMovil;
    }

    public void setPagoMovil(String pagoMovil) {
        this.pagoMovil = pagoMovil;
    }

    public String getZelle() {
        return zelle;
    }

    public void setZelle(String zelle) {
        this.zelle = zelle;
    }

    public String getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(String efectivo) {
        this.efectivo = efectivo;
    }
}
