package com.depilartebe.depilarteBackend.be.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "depilarte_registros")
public class Register {

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
    private Long Tratamiento;

    @Column
    private Long TipoTratamiento;

    @Column
    private Long ZonaTratamiento;

    @Column
    private String CantidadSesiones;

    @Column
    private String Asistencia;

    @Column
    private Long ProductoUtilizado;

    @Column
    private String DisparosAntes;

    @Column
    private String DisparosDespues;

    @Column
    private String DiferenciaDisparos;

    @Column
    private Long Operadora;

    @Column
    private Long Doctora;

    @Column
    private Long FormaPago;

    @Column
    private String Abonado;

    @Column
    private String precioTotal;

    @Column
    private String Comision;

    @Column
    private String Nota;

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

    public Date getFechaCumple() {
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

    public void setFechaCumple(Date fechaCumple) {
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
}
