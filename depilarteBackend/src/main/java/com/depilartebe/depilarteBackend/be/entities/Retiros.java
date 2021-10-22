package com.depilartebe.depilarteBackend.be.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "depilarte_retiros")
public class Retiros {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fechaRetiro")
    private Date dateRetirement;

    @Column(name="usuario")
    private Long userRetirement;

    @Column(name="cantidadDinero")
    private String moneyRetirement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateRetirement() {
        return dateRetirement;
    }

    public void setDateRetirement(Date dateRetirement) {
        this.dateRetirement = dateRetirement;
    }

    public Long getUserRetirement() {
        return userRetirement;
    }

    public void setUserRetirement(Long userRetirement) {
        this.userRetirement = userRetirement;
    }

    public String getMoneyRetirement() {
        return moneyRetirement;
    }

    public void setMoneyRetirement(String moneyRetirement) {
        this.moneyRetirement = moneyRetirement;
    }
}
