package com.depilartebe.depilarteBackend.be.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "depilarte_usuarios")
public class Empleado {

        @Id
        @Column(name="id_usuarios")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="FechaIngreso")
        private Date fechaIngreso;

        @Column(name="Nombre")
        private String Nombre;

        @Column(name="Apellido")
        private String Apellido;

        @Column(name="Cedula")
        private String Cedula;

        @Column(name="Edad")
        private String Edad;

        @Column(name="Email")
        private String Correo;

        @Column(name="Direccion")
        private String Direccion;

        @Column(name="Telefono")
        private String Telefono;

        @Column(name="Cargo")
        private String Cargo;

        @Column(name="FechaNacimiento")
        private String nacimiento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaIngresoo() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaAtendido) {
        this.fechaIngreso = fechaAtendido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }
}
