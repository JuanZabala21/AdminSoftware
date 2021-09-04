package com.depilartebe.depilarteBackend.be.entities;


import javax.persistence.*;

@Entity
@Table(name="depilarte_tipotratamientos")
public class TreatmentType {

    @Id
    @Column(name="id_tipo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo;

    @Column(name="id_tratamientos")
    private Long id_tratamientos;

    @Column(name="nombreTipo")
    private String nombreTipo;

    public Long getId_tipo() {
        return id_tipo;
    }

    public Long getId_tratamientos() {
        return id_tratamientos;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public void setId_tratamientos(Long id_tratamientos) {
        this.id_tratamientos = id_tratamientos;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}
