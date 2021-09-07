package com.depilartebe.depilarteBackend.be.entities;

public class Dashboard {
    
    private  Integer  registerCount;
    
    private  Integer  empleadosCount;
    
    private  Integer  tratamientosCount;

    private Integer productosCount;

    public Integer getRegisterCount() {
        return registerCount;
    }

    public void setRegisterCount(Integer registerCount) {
        this.registerCount = registerCount;
    }
    
    public Integer getEmpleadosCount() {
        return empleadosCount;
    }

    public void setEmpleadosCount(Integer empleadosCount) {
        this.empleadosCount = empleadosCount;
    }
    
    public Integer getTratamientosCount() {
        return tratamientosCount;
    }

    public void setTratamientosCount(Integer tratamientosCount) {
        this.tratamientosCount = tratamientosCount;
    }

    public Integer getProductosCount() {
        return productosCount;
    }

    public void setProductosCount(Integer productosCount) {
        this.productosCount = productosCount;
    }
    
}
