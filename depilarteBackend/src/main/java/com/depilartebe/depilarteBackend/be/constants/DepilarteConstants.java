package com.depilartebe.depilarteBackend.be.constants;

public interface DepilarteConstants {

    // Controladores
    String REGISTER_CLIENT_URI = "registerClient";
    String REGISTER_CLIENT_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los clientes </span></u></h3>"
                    + "Método que genera registros de clientes. </div>";

    String REGISTER_EMPLEADO_URI = "registerEmpleado";
    String REGISTER_EMPLEADO_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los empleados </span></u></h3>"
                    + "Método que genera registros de empleados. </div>";
    String TREATMENT_URI = "registerTreatment";
    String TREATMENT_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los tratamientos </span></u></h3>"
                    + "Método que genera registros de tratamientos. </div>";

    String PRODUCTS_URI = "registerProduct";
    String PRODUCT_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los Productos </span></u></h3>"
                    + "Método que genera registros de Productos. </div>";

    String SEARCH_REGISTER_URI = "searchRegister";
    String SEARCH_REGISTER_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los Registros </span></u></h3>"
                    + "Método que genera Registros. </div>";

    //Constantes de Variables
    String CLIENT_ID = "id";
    String CLIENT_NAME = "name";
    String DATE_ATTENTION = "dateAttention";
    String CLIENT_LASTNAME = "lastName";
    String IDENTIFICATION = "identification";
    String CLIENT_AGE = "age";
    String CLIENT_EMAIL = "email";
    String CLIENT_BIRTHDAY = "birthday";
    String CLIENT_ADDRESS = "address";
    String CLIENT_TREATMENT = "treatment";
    String CLIENT_TREATMENTTYPE = "treatmentType";
    String CLIENT_TREATMENTZONE = "treatmentZone";
    String CLIENT_SESSIONS = "sessions";
    String CLIENT_ASSISTENT = "assistent";
    String CLIENT_PRODUCT = "product";
    String CLIENT_SHOTBEFORE = "shotBefore";
    String CLIENT_SHOTAFTER = "shotAfter";
    String CLIENT_SHOTDIFERENTIAL = "shotDiferential";
    String CLIENT_OPERATOR = "operator";
    String CLIENT_DOCTOR = "doctor";
    String CLIENT_FORMPAY = "formPay";
    String CLIENT_SUBSCRIBER = "bono";
    String CLIENT_PRICETOTAL = "totalPrice";
    String CLIENT_COMISSION = "comission";
    String CLIENT_NOTE = "note";
    String CLIENT_PHONE = "phone";

    String EMPLEADO_ID = "id";
    String EMPLEADO_REGISTER = "userRegister";
    String EMPLEADO_NAME = "name";
    String EMPLEADO_LASTNAME = "lastName";
    String EMPLEADO_AGE = "age";
    String EMPLEADO_EMAIL = "email";
    String EMPLEADO_BIRTHDAY = "birthday";
    String EMPLEADO_ADDRESS = "address";
    String CARGO = "cargo";
    String EMPLEADO_TELEFONO= "phone";

    String TREATMENT_ID = "id";
    String TREATMENT_NAME = "treatmentName";
    String TREATMENT_TYPE = "typeTreatment";
    String TREATMENT_ZONE = "zoneTreatment";
    String TREATMENT_SPECIALIST = "specialist";
    String TREATMENT_SESSIONS = "sessions";
    String TREATMENT_PRICE = "price";
    String TREATMENT_COMISSION = "comission";
    String TREATMENT_DESC = "description";

    String PRODUCT_ID = "id";
    String PRODUCT_TREATMENT = "treatment";
    String PRODUCT_PROVIDER = "proveedor";
    String PRODUCT_COUNT = "cantidad";
    String PRODUCT_SPECIALIST = "specialist";
    String PRODUCT_PRECIO = "price";
    String PRODUCT_DESCRIPCION = "description";

    String SEARCH_NAME = "clientName";
    String SEARCH_LASTNAME = "clientLastName";
    String SEARCH_IDENTIFICATION = "identification";
    String SEARCH_USERATT = "userAtteption";
    String SEARCH_NAMEUSER = "userName";
    String INITIAL_DATE = "initialDate";
    String FINAL_DATE = "finalDate";


}
