package com.depilartebe.depilarteBackend.be.entities;

import javax.persistence.*;
import java.util.Date;

    @Entity
    @Table(name = "depilarte_registros")
    public class Register {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaAtendido")
    private String fechaAtendido;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Apellido")
    private String Apellido;

    @Column(name = "Cedula")
    private String Cedula;

    @Column(name = "Edad")
    private String Edad;

    @Column(name = "Correo")
    private String Correo;

    @Column(name = "FechaCumple")
    private String FechaCumple;

    @Column(name = "Direccion")
    private String Direccion;

    @Column(name = "Tratamiento")
    private String Tratamiento;

    @Column(name = "TipoTratamiento")
    private String TipoTratamiento;

    @Column(name = "CantidadSesiones")
    private String CantidadSesiones;

    @Column(name = "ProductoUtilizado")
    private String ProductoUtilizado;

    @Column(name = "DisparosAntes")
    private String DisparosAntes;

    @Column(name = "DisparosDespues")
    private String DisparosDespues;

    @Column(name = "DiferenciaDisparos")
    private String DiferenciaDisparos;

   @Column(name = "UserAtendio")
   private String userAtendio;

    @Column(name = "FormaPago")
    private String FormaPago;

    @Column(name = "Abonado")
    private String Abonado;

    @Column(name = "precioTotal")
    private String precioTotal;

    @Column(name = "Comision")
    private String Comision;

    @Column(name = "Nota")
    private String Nota;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name= "Referencia")
    private Long reference;

    @Column(name = "RegisterUser")
    private Long registerUser;

        public Long getId() {
            return id;
        }

    public String getFechaAtendido() {
        return fechaAtendido;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getEdad() {
        return Edad;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getFechaCumple() {
        return FechaCumple;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public String getTipoTratamiento() {
        return TipoTratamiento;
    }

    public String getCantidadSesiones() {
        return CantidadSesiones;
    }

    public String getProductoUtilizado() {
        return ProductoUtilizado;
    }

    public String getDisparosAntes() {
        return DisparosAntes;
    }

    public String getDisparosDespues() {
        return DisparosDespues;
    }

    public String getDiferenciaDisparos() {
        return DiferenciaDisparos;
    }

    public String getFormaPago() {
        return FormaPago;
    }

    public String getAbonado() {
        return Abonado;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public String getComision() {
        return Comision;
    }

    public String getNota() {
        return Nota;
    }

    public Long getReference(){
        return reference;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaAtendido(String fechaAtendido) {
        this.fechaAtendido = fechaAtendido;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public void setFechaCumple(String fechaCumple) {
        FechaCumple = fechaCumple;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public void setTratamiento(String tratamiento) {
        Tratamiento = tratamiento;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        TipoTratamiento = tipoTratamiento;
    }

    public void setCantidadSesiones(String cantidadSesiones) {
        CantidadSesiones = cantidadSesiones;
    }

    public void setProductoUtilizado(String productoUtilizado) {
        ProductoUtilizado = productoUtilizado;
    }

    public void setDisparosAntes(String disparosAntes) {
        DisparosAntes = disparosAntes;
    }

    public void setDisparosDespues(String disparosDespues) {
        DisparosDespues = disparosDespues;
    }

    public void setDiferenciaDisparos(String diferenciaDisparos) {
        DiferenciaDisparos = diferenciaDisparos;
    }

    public void setFormaPago(String formaPago) {
        FormaPago = formaPago;
    }

    public void setAbonado(String abonado) {
        Abonado = abonado;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setComision(String comision) {
        Comision = comision;
    }

    public void setNota(String nota) {
        Nota = nota;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }
        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getUserAtendio() {
            return userAtendio;
        }

        public Long getRegisterUser() {
            return registerUser;
        }

        public void setUserAtendio(String userAtendio) {
            this.userAtendio = userAtendio;
        }

        public void setRegisterUser(Long registerUser) {
            this.registerUser = registerUser;
        }
    }
