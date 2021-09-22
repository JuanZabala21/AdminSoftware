package com.depilartebe.depilarteBackend.be.entities;
import javax.persistence.*;
   

@Entity
@Table(name = "depilarte_referencia")
public class References {

    @Id
    @Column(name = "id_ref")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_ref")
    private String reference;

    public Long getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
