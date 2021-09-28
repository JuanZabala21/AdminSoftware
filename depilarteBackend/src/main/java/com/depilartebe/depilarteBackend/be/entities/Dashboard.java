package com.depilartebe.depilarteBackend.be.entities;

import java.util.List;

public class Dashboard {
    
    private  Integer  registerCount;
    
    private  Integer  empleadosCount;
    
    private  Integer  tratamientosCount;

    private Integer productosCount;

    private List<Integer> registerPerMonth; 
    private List<Integer> registerPerMonthInstagram; 
    private List<Integer> registerPerMonthAmigos; 
    private List<Integer> registerPerMonthOtros; 




    public List<Integer> getRegisterPerMonthInstagram() {
        return registerPerMonthInstagram;
    }

    public List<Integer> getRegisterPerMonthAmigos() {
        return registerPerMonthAmigos;
    }

    public List<Integer> getRegisterPerMonthOtros() {
        return registerPerMonthOtros;
    }

    public void setRegisterPerInstagram(List<Integer> registerPerMonthInstagram) {
        this.registerPerMonthInstagram = registerPerMonthInstagram;
    }
    public void serRegisterPerMonthAmigos(List<Integer> registerPerMonthAmigos) {
        this.registerPerMonthAmigos = registerPerMonthAmigos;
    }
    public void setRegisterPerMonthOtros(List<Integer> registerPerMonthOtros) {
        this.registerPerMonthOtros = registerPerMonthOtros;
    }

    public Integer getRegisterCount() {
        return registerCount;
    }

    public List<Integer> getRegisterPerMonth() {
        return registerPerMonth;
    }

    public void setRegisterPerMonth(List<Integer> registerPerMonth) {
        this.registerPerMonth = registerPerMonth;
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
