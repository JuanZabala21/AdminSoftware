package com.depilartebe.depilarteBackend.be.entities;

import javax.persistence.*;


@Entity
@Table(name = "depilarte_cargos")
public class Chargers {

    @Id
    @Column(name="id_cargo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombreCargo")
    private String nameCharge;

    public Long getId() {
        return id;
    }

    public String getNameCharge() {
        return nameCharge;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameCharge(String nameCharge) {
        this.nameCharge = nameCharge;
    }
}
