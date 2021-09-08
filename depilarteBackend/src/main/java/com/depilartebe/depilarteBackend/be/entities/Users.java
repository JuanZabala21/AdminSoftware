package com.depilartebe.depilarteBackend.be.entities;

import javax.persistence.*;

@Entity
@Table(name="depilarte_usuarios")
public class Users {

    @Id
    @Column(name="id_usuarios")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(name="Nombre")
    private String name;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Cedula")
    private String cedula;

    @Column(name = "Direccion")
    private String address;

    @Column(name = "Telefono")
    private String phone;

    @Column(name = "Cargo")
    private String charge;

    @Column(name = "Email")
    private String email;

    @Column(name="FechaNacimiento")
    private String birthday;

    @Column(name="Edad")
    private String age;

    public Long getId_usuario() {
        return id_usuario;
    }

    public String getName() {
        return name;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getCharge() {
        return charge;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAge() {
        return age;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
