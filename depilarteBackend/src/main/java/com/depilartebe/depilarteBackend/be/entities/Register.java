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
    private Date fechaAtendido;

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
    private Long Tratamiento;

    @Column(name = "TipoTratamiento")
    private Long TipoTratamiento;

    @Column(name = "ZonaTratamiento")
    private Long ZonaTratamiento;

    @Column(name = "CantidadSesiones")
    private String CantidadSesiones;

    @Column(name = "Asistencia")
    private String Asistencia;

    @Column(name = "ProductoUtilizado")
    private Long ProductoUtilizado;

    @Column(name = "DisparosAntes")
    private String DisparosAntes;

    @Column(name = "DisparosDespues")
    private String DisparosDespues;

    @Column(name = "DiferenciaDisparos")
    private String DiferenciaDisparos;

    @Column(name = "Operadora")
    private Long Operadora;

    @Column(name = "Doctora")
    private Long Doctora;

    @Column(name = "FormaPago")
    private Long FormaPago;

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

        public Long getId() {
            return id;
        }

    public Date getFechaAtendido() {
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

    public Long getTratamiento() {
        return Tratamiento;
    }

    public Long getTipoTratamiento() {
        return TipoTratamiento;
    }

    public Long getZonaTratamiento() {
        return ZonaTratamiento;
    }

    public String getCantidadSesiones() {
        return CantidadSesiones;
    }

    public String getAsistencia() {
        return Asistencia;
    }

    public Long getProductoUtilizado() {
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

    public Long getOperadora() {
        return Operadora;
    }

    public Long getDoctora() {
        return Doctora;
    }

    public Long getFormaPago() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaAtendido(Date fechaAtendido) {
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

    public void setTratamiento(Long tratamiento) {
        Tratamiento = tratamiento;
    }

    public void setTipoTratamiento(Long tipoTratamiento) {
        TipoTratamiento = tipoTratamiento;
    }

    public void setZonaTratamiento(Long zonaTratamiento) {
        ZonaTratamiento = zonaTratamiento;
    }

    public void setCantidadSesiones(String cantidadSesiones) {
        CantidadSesiones = cantidadSesiones;
    }

    public void setAsistencia(String asistencia) {
        Asistencia = asistencia;
    }

    public void setProductoUtilizado(Long productoUtilizado) {
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

    public void setOperadora(Long operadora) {
        Operadora = operadora;
    }

    public void setDoctora(Long doctora) {
        Doctora = doctora;
    }

    public void setFormaPago(Long formaPago) {
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

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }
    }
