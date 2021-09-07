package com.depilartebe.depilarteBackend.be.entities;

public class Dashboard {
    
    private  Integer  registerCount;
    
    private  Integer  empleadosCount;
    
    private  Integer  tratamientosCount;

    public Integer getRegisterCount() {
        return registerCount;
    }

    public void setRegisterCount(Integer registerCount) {
        this.registerCount = registerCount;
    }
    
    public Integer getEmpleadoCount() {
        return empleadosCount;
    }

    public void setEmpleadosCount(Integer empleadosCount) {
        this.empleadosCount = empleadosCount;
    }
    
    public Integer getTratamientorCount() {
        return tratamientosCount;
    }

    public void setTratamientosCount(Integer tratamientosCount) {
        this.tratamientosCount = tratamientosCount;
    }
    
}
