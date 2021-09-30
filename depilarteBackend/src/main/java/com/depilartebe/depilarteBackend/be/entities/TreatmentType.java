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

    @Column(name="typeTreatment")
    private String typeTreatment;

    @Column(name="typePrice")
    private String typePrice;

    @Column(name = "comission")
    private String comission;

    public Long getId_tipo() {
        return id_tipo;
    }

    public Long getId_tratamientos() {
        return id_tratamientos;
    }

    public String getNombreTipo() {
        return typeTreatment;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public void setId_tratamientos(Long id_tratamientos) {
        this.id_tratamientos = id_tratamientos;
    }

    public void setNombreTipo(String typeTreatment) {
        this.typeTreatment = typeTreatment;
    }

    public String getPrecioTratamiento() {
        return typePrice;
    }

    public void setPrecioTratamiento(String typePrice) {
        this.typePrice = typePrice;
    }

    public String getComission() {
        return comission;
    }

    public void setComission(String comission) {
        this.comission = comission;
    }
}
