package com.depilartebe.depilarteBackend.be.entities;

public class TreatmentExcel {

    private String nameTreatment;

    private String typeTreatment;

    private String specialist;

    private String sessions;

    private String price;

    private String comission;

    public String getNameTreatment() {
        return nameTreatment;
    }

    public String getTypeTreatment() {
        return typeTreatment;
    }

    public String getSpecialist() {
        return specialist;
    }

    public String getSessions() {
        return sessions;
    }

    public String getPrice() {
        return price;
    }

    public String getComission() {
        return comission;
    }

    public void setNameTreatment(String nameTreatment) {
        this.nameTreatment = nameTreatment;
    }

    public void setTypeTreatment(String typeTreatment) {
        this.typeTreatment = typeTreatment;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public void setSessions(String sessions) {
        this.sessions = sessions;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setComission(String comission) {
        this.comission = comission;
    }
}
