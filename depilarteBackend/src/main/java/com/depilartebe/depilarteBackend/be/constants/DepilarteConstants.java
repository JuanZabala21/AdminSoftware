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

    String SEARCH_EMPLEADOS_URI = "searchWorker";
    String SEARCH_EMPLEADOS_REGISTER =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los Empleados </span></u></h3>"
                    + "Método que genera Empleados. </div>";

    String SEARCH_TREATMENTS_URI = "searchTreatments";
    String SEARCH_TREATMENTS_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los Tratamientos </span></u></h3>"
                    + "Método que genera Tratamientos. </div>";

    String SEARCH_PRODUCTS_URI = "searchProducts";
    String SEARCH_PRODUCTS_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los Tratamientos </span></u></h3>"
                    + "Método que genera Tratamientos. </div>";

    String GET_EMPLEADOS_URI = "getEmpleados";
    String GET_EMPLEADOS_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los Tratamientos </span></u></h3>"
                    + "Método que genera Tratamientos. </div>";

    String GET_PRODUCTS_URI = "getProducts";
    String GET_PRODUCTS_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los Tratamientos </span></u></h3>"
                    + "Método que genera Tratamientos. </div>";

    String GET_TREATMENT_ID = "getTreatment";
    String GET_TREATMENT_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los Tratamientos </span></u></h3>"
                    + "Método que genera Tratamientos. </div>";

    String GENERATE_PRODUCTS = "generateProducts";
    String GENERATE_PRODUCTS_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los Tratamientos </span></u></h3>"
                    + "Método que genera Tratamientos. </div>";

    String GENERATE_EMPLEADOS = "generateEmpleados";
    String GENERATE_EMPLEADOS_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los Tratamientos </span></u></h3>"
                    + "Método que genera Tratamientos. </div>";

    String GENERATE_TREATMENTS = "generateTreatments";
    String GENERATE_TREATMENTS_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los Tratamientos </span></u></h3>"
                    + "Método que genera Tratamientos. </div>";

    String GET_PACIENTES_URI = "getPacientes";
    String GENERATE_PACIENTES_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los Tratamientos </span></u></h3>"
                    + "Método que genera Tratamientos. </div>";

    String GENERATE_REGISTER_EXCEL = "generateRegister";
    String GENERATE_REGISTER_EXCEL_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener los registros de los Tratamientos </span></u></h3>"
                    + "Método que genera Tratamientos. </div>";


    //Excel
    static final String DATE_FORMAT_EXCEL                           = "dd/MM/yyyy HH:mm:ss";
    static final String EXCEL_EXTENSION                             = ".xlsx";
    static final String EMPTY		 			    	        	= "";
    static final String SPACE                                       = " ";
    static final String SLASH		 			    		        = "/";
    static final String TWO_POINTS                                  = ":";
    static final String PATH_EXCEL                                  = "/ExcelDepilarte/";
    String RESULT_ENCODED_STRING                                    = "resultEncodedString";

    //Products
    String PRODUCT_EXCEL_NAME = "Nombre del producto";
    String PRODUCT_EXCEL_PROOVIDER = "Proveedor";
    String PRODUCT_EXCEL_COUNT = "Cantidad Comprada";
    String PRODUCT_EXCEL_ESPECIALISTA = "Especialista encargada";
    String PRODUCT_EXCEL_PRECIO = "Precio unitario";

    //Empleados
    String WORKER_EXCEL_DATE = "Fecha de Ingreso";
    String WORKER_EXCEL_NAME = "Nombre";
    String WORKER_EXCEL_LASTNAME = "Apellido";
    String WORKER_EXCEL_AGE = "Edad";
    String WORKER_EXCEL_IDENTIFICATION = "Cedula de identidad";
    String WORKER_EXCEL_EMAIL = "Correo electronico";
    String WORKER_EXCEL_PHONE = "Telefono";
    String WORKER_EXCEL_BIRTHDAY = "Fecha de Nacimiento";
    String WORKER_EXCEL_ADDRESS = "Dirección";
    String WORKER_EXCEL_CHARGE = "Cargo";

    //Tratamientos
    String TREATMENT_EXCEL_NAME = "Nombre del Tratamiento";
    String TREATMENT_EXCEL_TYPE = "Tipo de Tratamiento";
    String TREATMENT_EXCEL_SPECIALIST = "Especialista encargada";
    String TREATMENT_EXCEL_CANTIDAD = "Cantidad de Sesiones";
    String TREATMENT_EXCEL_PRICE = "Precio del Tratamiento";
    String TREATMENT_EXCEL_COMISSION = "Comisión para la Operadora";

    //Pacientes Registrados
    String REGISTER_EXCEL_DATE_ATT = "Fecha de Atención";
    String REGISTER_EXCEL_NAME = "Nombre";
    String REGISTER_EXCEL_LASTNAME = "Apellido";
    String REGISTER_EXCEL_CEDULA = "Cedula de Identidad";
    String REGISTER_EXCEL_BIRTHDAY = "Fecha de Cumpleaños";
    String REGISTER_EXCEL_EDAD = "Edad";
    String REGISTER_EXCEL_PHONE = "Telefono";
    String REGISTER_EXCEL_TREATMENT = "Tratamiento realizado";
    String REGISTER_EXCEL_TYPE_TREATMENT = "Tipo de Tratamiento";
    String REGISTER_EXCEL_DISPAROS_BEFORE = "Disparos Iniciales";
    String REGISTER_EXCEL_DISPAROS_AFTER = "Disparos Despues";
    String REGISTER_EXCEL_DISPAROS_DIFFERENTIAL = "Disparos restantes";
    String REGISTER_EXCEL_PERSONAL = "Personal de Atención";
    String REGISTER_EXCEL_PRODUCT = "Producto Utilizado";
    String REGISTER_EXCEL_FORMPAY = "Forma de Pago";
    String REGISTER_EXCEL_ABONADO = "Pago Abonado";
    String REGISTER_EXCEL_COMISSION = "Comisión de Personal";
    String REGISTER_EXCEL_PRICETOTAL = "Precio Total";




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
    String CLIENT_SHOTBEFORE = "beforeShots";
    String CLIENT_SHOTAFTER = "afterShots";
    String CLIENT_SHOTDIFERENTIAL = "diferents";
    String CLIENT_OPERATOR = "userOp";
    String CLIENT_DOCTOR = "userDoc";
    String CLIENT_FORMPAY = "formPay";
    String CLIENT_SUBSCRIBER = "bono";
    String CLIENT_PRICETOTAL = "totalPrice";
    String CLIENT_COMISSION = "comission";
    String CLIENT_NOTE = "note";
    String CLIENT_PHONE = "phone";
    String CLIENT_REFERENCE = "reference";
    String CLIENT_IMAGE_AFTER = "imageFileAfter";
    String CLIENT_IMAGE_BEFORE = "imageFileBefore";

    String EMPLEADO_ID = "id";
    String EMPLEADO_REGISTER = "userRegister";
    String EMPLEADO_NAME = "name";
    String EMPLEADO_LASTNAME = "lastName";
    String EMPLEADO_AGE = "age";
    String EMPLEADO_EMAIL = "email";
    String EMPLEADO_BIRTHDAY = "birthday";
    String EMPLEADO_ADDRESS = "address";
    String CARGO = "charge";
    String EMPLEADO_TELEFONO = "phone";

    String TREATMENT_ID = "id";
    String TREATMENT_NAME = "treatmentName";
    String TREATMENT_TYPE = "typeTreatment";
    String TYPE_PRICE = "typePrice";
    String TREATMENT_ZONE = "zoneTreatment";
    String TREATMENT_SPECIALIST = "specialist";
    String TREATMENT_SESSIONS = "sessions";
    String TREATMENT_PRICE = "price";
    String TREATMENT_COMISSION = "comission";
    String TREATMENT_DESC = "description";

    String PRODUCT_ID = "id";
    String NAME_PRODUCT = "product";
    String PRODUCT_PROVIDER = "proveedor";
    String PRODUCT_COUNT = "cantidad";
    String PRODUCT_SPECIALIST = "specialist";
    String PRODUCT_PRECIO = "price";
    String PRODUCT_DESCRIPCION = "description";

    String SEARCH_NAME = "name";
    String SEARCH_LASTNAME = "lastName";
    String SEARCH_IDENTIFICATION = "identification";
    String SEARCH_USERATT = "user";
    String SEARCH_NAMEUSER = "userName";
    String INITIAL_DATE = "initialDate";
    String FINAL_DATE = "finalDate";

    String WORKER_NAME = "name";
    String WORKER_IDENTIFICATION = "identification";
    String WORKER_CHARGE = "charge";

    String NAME_TREATMENT = "name";
    String SPECIALIST_TREATMENT = "specialist";

    String PRODUCT_NAME = "name";
    String PRODUCTSPECIALIST = "specialist";

    String ID_EMPLEADO = "id";

    String ID_TREATMENTS = "id";

    String ID_PACIENTES = "id";



}
