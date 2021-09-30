package com.depilartebe.depilarteBackend.be.entities;


import javax.persistence.*;

@Entity
@Table(name="depilarte_tratamientos")
public class Treatment {

    @Id
    @Column(name="id_tratamientos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tratamientos;

    @Column(name="Nombre")
    private String nameTreatment;

    @Column(name="Especialista")
    private String especialista;

    @Column(name="CantidadSesiones")
    private String cantidadSesiones;

    @Column(name="DescripcionTratamiento")
    private String descripcionTratamiento;

    public Long getId_tratamientos() {
        return id_tratamientos;
    }

    public String getNameTreatment() {
        return nameTreatment;
    }

    public String getEspecialista() {
        return especialista;
    }

    public String getCantidadSesiones() {
        return cantidadSesiones;
    }

    public String getDescripcionTratamiento() {
        return descripcionTratamiento;
    }

    public void setId_tratamientos(Long id_tratamientos) {
        this.id_tratamientos = id_tratamientos;
    }

    public void setNameTreatment(String nameTreatment) {
        this.nameTreatment = nameTreatment;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

    public void setCantidadSesiones(String cantidadSesiones) {
        this.cantidadSesiones = cantidadSesiones;
    }


    public void setDescripcionTratamiento(String descripcionTratamiento) {
        this.descripcionTratamiento = descripcionTratamiento;
    }
}
