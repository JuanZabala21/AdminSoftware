package com.depilartebe.depilarteBackend.be.entities;


import javax.persistence.*;

@Entity
@Table(name = "depilarte_disparos")
public class GunValue {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private String cantidadDisparos;

    public Long getId() {
        return id;
    }

    public String getCantidadDisparos() {
        return cantidadDisparos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCantidadDisparos(String cantidadDisparos) {
        this.cantidadDisparos = cantidadDisparos;
    }
}
