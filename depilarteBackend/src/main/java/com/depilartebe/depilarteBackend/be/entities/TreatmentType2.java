package com.depilartebe.depilarteBackend.be.entities;
import javax.persistence.*;

@Entity
@Table(name="depilarte_tipotratamientos")
public class TreatmentType2 {

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

    public Long getId_tipo() {
        return id_tipo;
    }

    public Long getId_tratamientos() {
        return id_tratamientos;
    }

    public String getTypeTreatment() {
        return typeTreatment;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public void setId_tratamientos(Long id_tratamientos) {
        this.id_tratamientos = id_tratamientos;
    }

    public void setTypeTreatment(String typeTreatment) {
        this.typeTreatment = typeTreatment;
    }

    public String getTypePrice() {
        return typePrice;
    }
    public void setTypePrice(String typePrice) {
        this.typePrice = typePrice;
    }
}
