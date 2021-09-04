package com.depilartebe.depilarteBackend.be.entities;

import javax.persistence.*;

@Entity
@Table(name="depilarte_zonatratamientos")
public class TreatmentZone {

    @Id
    @Column(name="id_zona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_zona;

    @Column(name="id_tratamiento")
    private Long id_tratamientos;

    @Column(name="ZonaNombre")
    private String zonaNombre;

    public Long getId_zona() {
        return id_zona;
    }

    public Long getId_tratamientos() {
        return id_tratamientos;
    }

    public String getZonaNombre() {
        return zonaNombre;
    }

    public void setId_zona(Long id_zona) {
        this.id_zona = id_zona;
    }

    public void setId_tratamientos(Long id_tratamientos) {
        this.id_tratamientos = id_tratamientos;
    }

    public void setZonaNombre(String zonaNombre) {
        this.zonaNombre = zonaNombre;
    }
}
