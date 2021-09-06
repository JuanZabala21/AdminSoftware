package com.depilartebe.depilarteBackend.be.entities;


import javax.persistence.*;

@Entity
@Table(name="depilarte_productos")
public class Products {

    @Id
    @Column(name="id_productos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_productos;

    @Column(name="Nombre")
    private String nombre;

    @Column(name="Proveedor")
    private String proveedor;

    @Column(name="Cantidad")
    private String cantidad;

    @Column(name="Especialista")
    private Long specialist;

    @Column(name="Precio")
    private String precio;

    @Column(name="Descripcion")
    private String descripcion;

    public Long getId_productos() {
        return id_productos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId_productos(Long id_productos) {
        this.id_productos = id_productos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Long specialist) {
        this.specialist = specialist;
    }
}
