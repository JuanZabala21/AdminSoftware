package com.depilartebe.depilarteBackend.be.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.depilartebe.depilarteBackend.be.constants.DepilarteConstants;
import com.depilartebe.depilarteBackend.be.constants.GlobalConstants;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.depilartebe.depilarteBackend.be.services.DepilarteServices;
import java.util.HashMap;
import java.util.Map;


@Api(name = "Servicio de Depilarte" , description = "Destinado a modulos de Depilarte", group = "Depilarte")
@ApiVersion(since = "1.0")
@CrossOrigin("*")
@RestController
@RequestMapping("/depilarte")

public class DepilarteController implements GlobalConstants, DepilarteConstants {
        static Logger log = LogManager.getLogger(DepilarteController.class);

     @Autowired
     DepilarteServices depilarteServices;

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REGISTER_CLIENT_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = REGISTER_CLIENT_URI)
    public Map<String, Object> getRegisterClients(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);
                Long id = (params.containsKey(CLIENT_ID) &&
                        params.get(CLIENT_ID) != null &&
                        !params.get(CLIENT_ID).toString().isEmpty() )
                        ? Long.valueOf(params.get(CLIENT_TREATMENTTYPE).toString()) : null;
                String clientName = (params.containsKey(CLIENT_NAME) && params.get(CLIENT_NAME) != null
                        && !params.get(CLIENT_NAME).toString().isEmpty()) ?
                        params.get(CLIENT_NAME).toString() : null;
                String clientLastName = (params.containsKey(CLIENT_LASTNAME) && params.get(CLIENT_LASTNAME) != null
                        && !params.get(CLIENT_LASTNAME).toString().isEmpty()) ?
                        params.get(CLIENT_LASTNAME).toString() : null;
                String identification = (params.containsKey(IDENTIFICATION) && params.get(IDENTIFICATION) != null
                        && !params.get(IDENTIFICATION).toString().isEmpty()) ?
                        params.get(IDENTIFICATION).toString() : null;
               String age = (params.containsKey(CLIENT_AGE) && params.get(CLIENT_AGE) != null
                       && !params.get(CLIENT_AGE).toString().isEmpty()) ?
                       params.get(CLIENT_AGE).toString() : null;
               String email = (params.containsKey(CLIENT_EMAIL) && params.get(CLIENT_EMAIL) != null
                       && !params.get(CLIENT_EMAIL).toString().isEmpty()) ?
                       params.get(CLIENT_EMAIL).toString() : null;
               String birthday = (params.containsKey(CLIENT_BIRTHDAY) && params.get(CLIENT_BIRTHDAY) != null
                       && !params.get(CLIENT_BIRTHDAY).toString().isEmpty()) ?
                       params.get(CLIENT_BIRTHDAY).toString() : null;
               String address = (params.containsKey(CLIENT_ADDRESS) && params.get(CLIENT_ADDRESS) != null
                       && !params.get(CLIENT_ADDRESS).toString().isEmpty()) ?
                       params.get(CLIENT_ADDRESS).toString() : null;
               Long treatment = (params.containsKey(CLIENT_TREATMENT) &&
                       params.get(CLIENT_TREATMENT) != null &&
                       !params.get(CLIENT_TREATMENT).toString().isEmpty() )
                       ? Long.valueOf(params.get(CLIENT_TREATMENT).toString()) : null;
               Long treatmentType = (params.containsKey(CLIENT_TREATMENTTYPE) &&
                       params.get(CLIENT_TREATMENTTYPE) != null &&
                       !params.get(CLIENT_TREATMENTTYPE).toString().isEmpty() )
                       ? Long.valueOf(params.get(CLIENT_TREATMENTTYPE).toString()) : null;
               Long treatmentZone = (params.containsKey(CLIENT_TREATMENTZONE) &&
                       params.get(CLIENT_TREATMENTZONE) != null &&
                       !params.get(CLIENT_TREATMENTZONE).toString().isEmpty() )
                       ? Long.valueOf(params.get(CLIENT_TREATMENTZONE).toString()) : null;
               String countSessions =  (params.containsKey(CLIENT_SESSIONS) && params.get(CLIENT_SESSIONS) != null
                       && !params.get(CLIENT_SESSIONS).toString().isEmpty()) ?
                       params.get(CLIENT_SESSIONS).toString() : null;
               String assistent = (params.containsKey(CLIENT_ASSISTENT) && params.get(CLIENT_ASSISTENT) != null
                       && !params.get(CLIENT_ASSISTENT).toString().isEmpty()) ?
                       params.get(CLIENT_ASSISTENT).toString() : null;
               Long product = (params.containsKey(CLIENT_PRODUCT) &&
                       params.get(CLIENT_PRODUCT) != null &&
                       !params.get(CLIENT_PRODUCT).toString().isEmpty() )
                       ? Long.valueOf(params.get(CLIENT_PRODUCT).toString()) : null;
               String shotBefore = (params.containsKey(CLIENT_SHOTBEFORE) && params.get(CLIENT_SHOTBEFORE) != null
                       && !params.get(CLIENT_SHOTBEFORE).toString().isEmpty()) ?
                       params.get(CLIENT_SHOTBEFORE).toString() : null;
               String shotAfter = (params.containsKey(CLIENT_SHOTAFTER) && params.get(CLIENT_SHOTAFTER) != null
                       && !params.get(CLIENT_SHOTAFTER).toString().isEmpty()) ?
                       params.get(CLIENT_SHOTAFTER).toString() : null;
               String shotDiferencial = (params.containsKey(CLIENT_SHOTDIFERENTIAL) && params.get(CLIENT_SHOTDIFERENTIAL) != null
                       && !params.get(CLIENT_SHOTDIFERENTIAL).toString().isEmpty()) ?
                       params.get(CLIENT_SHOTDIFERENTIAL).toString() : null;
               Long operator = (params.containsKey(CLIENT_OPERATOR) &&
                       params.get(CLIENT_OPERATOR) != null &&
                       !params.get(CLIENT_OPERATOR).toString().isEmpty() )
                       ? Long.valueOf(params.get(CLIENT_OPERATOR).toString()) : null;
               Long doctor = (params.containsKey(CLIENT_DOCTOR) &&
                       params.get(CLIENT_DOCTOR) != null &&
                       !params.get(CLIENT_DOCTOR).toString().isEmpty() )
                       ? Long.valueOf(params.get(CLIENT_DOCTOR).toString()) : null;
               Long formPay = (params.containsKey(CLIENT_FORMPAY) &&
                       params.get(CLIENT_FORMPAY) != null &&
                       !params.get(CLIENT_FORMPAY).toString().isEmpty() )
                       ? Long.valueOf(params.get(CLIENT_FORMPAY).toString()) : null;
               String abonado = (params.containsKey(CLIENT_SUBSCRIBER) && params.get(CLIENT_SUBSCRIBER) != null
                       && !params.get(CLIENT_SUBSCRIBER).toString().isEmpty()) ?
                       params.get(CLIENT_SUBSCRIBER).toString() : null;
               String priceTotal =  (params.containsKey(CLIENT_PRICETOTAL) && params.get(CLIENT_PRICETOTAL) != null
                       && !params.get(CLIENT_PRICETOTAL).toString().isEmpty()) ?
                       params.get(CLIENT_PRICETOTAL).toString() : null;
               String comission = (params.containsKey(CLIENT_COMISSION) && params.get(CLIENT_COMISSION) != null
                       && !params.get(CLIENT_COMISSION).toString().isEmpty()) ?
                       params.get(CLIENT_COMISSION).toString() : null;
               String note = (params.containsKey(CLIENT_NOTE) && params.get(CLIENT_NOTE) != null
                       && !params.get(CLIENT_NOTE).toString().isEmpty()) ?
                       params.get(CLIENT_NOTE).toString() : null;


                mapResponse = depilarteServices.registerClients(id,clientName,clientLastName,identification,age,
                                                               email,birthday,address,treatment,treatmentType,treatmentZone,countSessions,
                                                               assistent,product,shotBefore,shotAfter,shotDiferencial,operator,doctor,formPay,
                                                                abonado,priceTotal,comission,note);

            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }

        }
        return mapResponse;
    }


    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REGISTER_EMPLEADO_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = REGISTER_EMPLEADO_URI)
    public Map<String, Object> getRegisterEmpleados(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);
                Long id = (params.containsKey(EMPLEADO_ID) &&
                        params.get(EMPLEADO_ID) != null &&
                        !params.get(EMPLEADO_ID).toString().isEmpty() )
                        ? Long.valueOf(params.get(CLIENT_TREATMENTTYPE).toString()) : null;
                String empleadoName = (params.containsKey(EMPLEADO_NAME) && params.get(EMPLEADO_NAME) != null
                        && !params.get(EMPLEADO_NAME).toString().isEmpty()) ?
                        params.get(EMPLEADO_NAME).toString() : null;
                String empleadoLastName = (params.containsKey(EMPLEADO_LASTNAME) && params.get(EMPLEADO_LASTNAME) != null
                        && !params.get(EMPLEADO_LASTNAME).toString().isEmpty()) ?
                        params.get(EMPLEADO_LASTNAME).toString() : null;
                String identification = (params.containsKey(IDENTIFICATION) && params.get(IDENTIFICATION) != null
                        && !params.get(IDENTIFICATION).toString().isEmpty()) ?
                        params.get(IDENTIFICATION).toString() : null;
                String telefono =(params.containsKey(EMPLEADO_TELEFONO) && params.get(EMPLEADO_TELEFONO) != null
                        && !params.get(EMPLEADO_TELEFONO).toString().isEmpty()) ?
                        params.get(EMPLEADO_TELEFONO).toString() : null;
                String age = (params.containsKey(EMPLEADO_AGE) && params.get(EMPLEADO_AGE) != null
                        && !params.get(EMPLEADO_AGE).toString().isEmpty()) ?
                        params.get(EMPLEADO_AGE).toString() : null;
                String email = (params.containsKey(EMPLEADO_EMAIL) && params.get(EMPLEADO_EMAIL) != null
                        && !params.get(EMPLEADO_EMAIL).toString().isEmpty()) ?
                        params.get(EMPLEADO_EMAIL).toString() : null;
                String birthday = (params.containsKey(EMPLEADO_BIRTHDAY) && params.get(EMPLEADO_BIRTHDAY) != null
                        && !params.get(EMPLEADO_BIRTHDAY).toString().isEmpty()) ?
                        params.get(EMPLEADO_BIRTHDAY).toString() : null;
                String address = (params.containsKey(EMPLEADO_ADDRESS) && params.get(EMPLEADO_ADDRESS) != null
                        && !params.get(EMPLEADO_ADDRESS).toString().isEmpty()) ?
                        params.get(EMPLEADO_ADDRESS).toString() : null;
               String cargo = (params.containsKey(CARGO) && params.get(CARGO) != null
                       && !params.get(CARGO).toString().isEmpty()) ?
                       params.get(CARGO).toString() : null;


                mapResponse = depilarteServices.registerEmpleados(id,empleadoName,empleadoLastName,identification,telefono, age,
                        email,birthday,address,cargo);

            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }

        }
        return mapResponse;
    }


}
