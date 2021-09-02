package com.depilartebe.depilarteBackend.be.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "depilarte_registros_empleados")
public class Empleado {

        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private Date fechaAtendido;

        @Column
        private String Nombre;

        @Column
        private String Apellido;

        @Column
        private String Cedula;

        @Column
        private String Edad;

        @Column
        private String Correo;

        @Column
        private Date FechaCumple;

        @Column
        private String Direccion;

        @Column
        private String Telefono;

        @Column
        private String Cargo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaAtendido() {
        return fechaAtendido;
    }

    public void setFechaAtendido(Date fechaAtendido) {
        this.fechaAtendido = fechaAtendido;
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

    public Date getFechaCumple() {
        return FechaCumple;
    }

    public void setFechaCumple(Date fechaCumple) {
        FechaCumple = fechaCumple;
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
}
