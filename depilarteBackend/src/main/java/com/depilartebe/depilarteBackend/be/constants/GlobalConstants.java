package com.depilartebe.depilarteBackend.be.constants;

public interface GlobalConstants {

    String CONTENT_TYPE = "application/json";
    String APPLICATION_JSON 		= "application/json";
    String ACCEPT = "application/json";
    String TEXT_JSON = "text/json";
    String MESSAGE = "message";
    String TYPE = "type";
    String MESSAGE_TYPE_ERROR = "error";
    String MESSAGE_TYPE_SUCCESS = "success";
    String MESSAGE_ERROR = "Ocurrión un error, intente nuevamente.";
    String ERROR_404_MESSAGE = "Parámetros incompletos.";
    String MESSAGE_SUCCESS = "Operación exitosa";

    String DATE_FORMAT = "yyyy/MM/dd ";
    String METHODSPAY = "methodsPay";
    String TREATMENTS = "treatments";

    String METHODS_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener metodos de Pago </span></u></h3>"
            + "Método que retorna los metodos de Pago. </div>";

    String METHODSPAY_URI = "methodsPay";
    String TREATMENTSS_URI = "treatments";

    String TREATMENTSLIST_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'> Obtener Tratamientos </span></u></h3>"
            + "Método que retorna los Tratamientos. </div>";
}
