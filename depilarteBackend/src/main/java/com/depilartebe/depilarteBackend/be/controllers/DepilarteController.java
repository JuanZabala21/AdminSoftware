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

import java.util.ArrayList;
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
                        ? Long.valueOf(params.get(CLIENT_ID).toString()) : null;
                Long registerWorker =(params.containsKey(EMPLEADO_REGISTER) &&
                        params.get(EMPLEADO_REGISTER) != null &&
                        !params.get(EMPLEADO_REGISTER).toString().isEmpty() )
                        ? Long.valueOf(params.get(EMPLEADO_REGISTER).toString()) : null;
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
               String phone = (params.containsKey(CLIENT_PHONE) && params.get(CLIENT_PHONE) != null
                       && !params.get(CLIENT_PHONE).toString().isEmpty()) ?
                       params.get(CLIENT_PHONE).toString() : null;
                Long reference = (params.containsKey(CLIENT_REFERENCE) &&
                        params.get(CLIENT_REFERENCE) != null &&
                        !params.get(CLIENT_REFERENCE).toString().isEmpty() )
                        ? Long.valueOf(params.get(CLIENT_REFERENCE).toString()) : null;

                mapResponse = depilarteServices.registerClients(id,registerWorker,clientName,clientLastName,identification,age,
                                                               email,birthday,address,treatment,treatmentType,treatmentZone,countSessions,
                                                               assistent,product,shotBefore,shotAfter,shotDiferencial,operator,doctor,formPay,
                                                                abonado,priceTotal,comission,note,phone, reference);

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

                Long id =  (params.containsKey(EMPLEADO_ID) &&
                        params.get(EMPLEADO_ID) != null &&
                        !params.get(EMPLEADO_ID).toString().isEmpty() )
                        ? Long.valueOf(params.get(EMPLEADO_ID).toString()) : null;
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


                mapResponse = depilarteServices.registerEmpleados(id,empleadoName,empleadoLastName,identification,telefono, age, email,birthday,address,cargo);

            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }

        }
        return mapResponse;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = TREATMENT_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = TREATMENT_URI)
    public Map<String, Object> getTratamientos(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);
                Long id = (params.containsKey(EMPLEADO_ID) &&
                        params.get(EMPLEADO_ID) != null &&
                        !params.get(EMPLEADO_ID).toString().isEmpty() )
                        ? Long.valueOf(params.get(EMPLEADO_ID).toString()) : null;
                String nameTreatment = (params.containsKey(TREATMENT_NAME) && params.get(TREATMENT_NAME) != null
                        && !params.get(TREATMENT_NAME).toString().isEmpty()) ?
                        params.get(TREATMENT_NAME).toString() : null;
                ArrayList typePrice = (params.containsKey(TYPE_PRICE) && params.get(TYPE_PRICE) != null
                        && !params.get(TYPE_PRICE).toString().isEmpty()) ?
                        (ArrayList) params.get(TYPE_PRICE) : null;
                Long specialist = (params.containsKey(TREATMENT_SPECIALIST) &&
                        params.get(TREATMENT_SPECIALIST) != null &&
                        !params.get(TREATMENT_SPECIALIST).toString().isEmpty() )
                        ? Long.valueOf(params.get(TREATMENT_SPECIALIST).toString()) : null;
                String sessions = (params.containsKey(TREATMENT_SESSIONS) && params.get(TREATMENT_SESSIONS) != null
                        && !params.get(TREATMENT_SESSIONS).toString().isEmpty()) ?
                        params.get(TREATMENT_SESSIONS).toString() : null;
                String comission = (params.containsKey(TREATMENT_COMISSION) && params.get(TREATMENT_COMISSION) != null
                        && !params.get(TREATMENT_COMISSION).toString().isEmpty()) ?
                        params.get(TREATMENT_COMISSION).toString() : null;
                String description = (params.containsKey(TREATMENT_DESC) && params.get(TREATMENT_DESC) != null
                        && !params.get(TREATMENT_DESC).toString().isEmpty()) ?
                        params.get(TREATMENT_DESC).toString() : null;

                mapResponse = depilarteServices.registerTreatments(id,nameTreatment,typePrice,specialist, sessions,comission,description);


            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }

        }
        return mapResponse;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = PRODUCT_DESCRIPCION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = PRODUCTS_URI)
    public Map<String, Object> getProducts(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);
                Long id = (params.containsKey(PRODUCT_ID) &&
                        params.get(PRODUCT_ID) != null &&
                        !params.get(PRODUCT_ID).toString().isEmpty())
                        ? Long.valueOf(params.get(PRODUCT_ID).toString()) : null;
                String product = (params.containsKey(NAME_PRODUCT) &&
                        params.get(NAME_PRODUCT) != null &&
                        !params.get(NAME_PRODUCT).toString().isEmpty())
                        ? params.get(NAME_PRODUCT).toString() : null;
                String proveedor = (params.containsKey(PRODUCT_PROVIDER) && params.get(PRODUCT_PROVIDER) != null
                        && !params.get(PRODUCT_PROVIDER).toString().isEmpty()) ?
                        params.get(PRODUCT_PROVIDER).toString() : null;
                String cantidad = (params.containsKey(PRODUCT_COUNT) && params.get(PRODUCT_COUNT) != null
                        && !params.get(PRODUCT_COUNT).toString().isEmpty()) ?
                        params.get(PRODUCT_COUNT).toString() : null;
                String precio = (params.containsKey(PRODUCT_PRECIO) && params.get(PRODUCT_PRECIO) != null
                        && !params.get(PRODUCT_PRECIO).toString().isEmpty()) ?
                        params.get(PRODUCT_PRECIO).toString() : null;
                Long specialist = (params.containsKey(PRODUCT_SPECIALIST) &&
                        params.get(PRODUCT_SPECIALIST) != null &&
                        !params.get(PRODUCT_SPECIALIST).toString().isEmpty())
                        ? Long.valueOf(params.get(PRODUCT_SPECIALIST).toString()) : null;
                String descripcion = (params.containsKey(PRODUCT_DESCRIPCION) && params.get(PRODUCT_DESCRIPCION) != null
                        && !params.get(PRODUCT_DESCRIPCION).toString().isEmpty()) ?
                        params.get(PRODUCT_DESCRIPCION).toString() : null;

                mapResponse = depilarteServices.registerProduct(id,product,proveedor,cantidad,precio,specialist,descripcion);


            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }
        }
        return mapResponse;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = SEARCH_REGISTER_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = SEARCH_REGISTER_URI)
    public Map<String, Object> searchRegister(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

                String nameClient = (params.containsKey(SEARCH_NAME) && params.get(SEARCH_NAME) != null
                        && !params.get(SEARCH_NAME).toString().isEmpty()) ?
                        params.get(SEARCH_NAME).toString() : null;
                String lastNameClient = (params.containsKey(SEARCH_LASTNAME) && params.get(SEARCH_LASTNAME) != null
                        && !params.get(SEARCH_LASTNAME).toString().isEmpty()) ?
                        params.get(SEARCH_LASTNAME).toString() : null;
                String cedula = (params.containsKey(SEARCH_IDENTIFICATION) && params.get(SEARCH_IDENTIFICATION) != null
                        && !params.get(SEARCH_IDENTIFICATION).toString().isEmpty()) ?
                        params.get(SEARCH_IDENTIFICATION).toString() : null;
                Long user = (params.containsKey(SEARCH_USERATT) &&
                        params.get(SEARCH_USERATT) != null &&
                        !params.get(SEARCH_USERATT).toString().isEmpty())
                        ? Long.valueOf(params.get(SEARCH_USERATT).toString()) : null;
                Long nameUser = (params.containsKey(SEARCH_NAMEUSER) &&
                        params.get(SEARCH_NAMEUSER) != null &&
                        !params.get(SEARCH_NAMEUSER).toString().isEmpty())
                        ? Long.valueOf(params.get(SEARCH_NAMEUSER).toString()) : null;
                String initialDate = (params.containsKey(INITIAL_DATE) && params.get(INITIAL_DATE) != null
                        && !params.get(INITIAL_DATE).toString().isEmpty()) ?
                        params.get(INITIAL_DATE).toString() : null;
                String finalDate = (params.containsKey(FINAL_DATE) && params.get(FINAL_DATE) != null
                        && !params.get(FINAL_DATE).toString().isEmpty()) ?
                        params.get(FINAL_DATE).toString() : null;

                mapResponse = depilarteServices.searchRegister(nameClient,lastNameClient,cedula,user,nameUser,initialDate,finalDate);



            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }
        }
        return mapResponse;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = SEARCH_EMPLEADOS_REGISTER)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = SEARCH_EMPLEADOS_URI)
    public Map<String, Object> searchEmpleados(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

                String nameWorker = (params.containsKey(WORKER_NAME) && params.get(WORKER_NAME) != null
                        && !params.get(WORKER_NAME).toString().isEmpty()) ?
                        params.get(WORKER_NAME).toString() : null;
                String identification = (params.containsKey(WORKER_IDENTIFICATION) && params.get(WORKER_IDENTIFICATION) != null
                        && !params.get(WORKER_IDENTIFICATION).toString().isEmpty()) ?
                        params.get(WORKER_IDENTIFICATION).toString() : null;
                Long charge = (params.containsKey(WORKER_CHARGE) &&
                        params.get(WORKER_CHARGE) != null &&
                        !params.get(WORKER_CHARGE).toString().isEmpty())
                        ? Long.valueOf(params.get(WORKER_CHARGE).toString()) : null;
                String initialDate = (params.containsKey(INITIAL_DATE) && params.get(INITIAL_DATE) != null
                        && !params.get(INITIAL_DATE).toString().isEmpty()) ?
                        params.get(INITIAL_DATE).toString() : null;
                String finalDate = (params.containsKey(FINAL_DATE) && params.get(FINAL_DATE) != null
                        && !params.get(FINAL_DATE).toString().isEmpty()) ?
                        params.get(FINAL_DATE).toString() : null;

                mapResponse = depilarteServices.searchWorkers(nameWorker,identification,charge,initialDate,finalDate);



            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }
        }
        return mapResponse;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = SEARCH_TREATMENTS_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = SEARCH_TREATMENTS_URI)
    public Map<String, Object> searchTreatments(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

                String nameTreatment = (params.containsKey(NAME_TREATMENT) && params.get(NAME_TREATMENT) != null
                        && !params.get(NAME_TREATMENT).toString().isEmpty()) ?
                        params.get(NAME_TREATMENT).toString() : null;
                String specialist = (params.containsKey(SPECIALIST_TREATMENT) && params.get(SPECIALIST_TREATMENT) != null
                        && !params.get(SPECIALIST_TREATMENT).toString().isEmpty()) ?
                        params.get(SPECIALIST_TREATMENT).toString() : null;
                String initialDate = (params.containsKey(INITIAL_DATE) && params.get(INITIAL_DATE) != null
                        && !params.get(INITIAL_DATE).toString().isEmpty()) ?
                        params.get(INITIAL_DATE).toString() : null;
                String finalDate = (params.containsKey(FINAL_DATE) && params.get(FINAL_DATE) != null
                        && !params.get(FINAL_DATE).toString().isEmpty()) ?
                        params.get(FINAL_DATE).toString() : null;

                mapResponse = depilarteServices.searchTreatment(nameTreatment,specialist,initialDate,finalDate);



            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }
        }
        return mapResponse;
    }



    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = SEARCH_PRODUCTS_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = SEARCH_PRODUCTS_URI)
    public Map<String, Object> searchProducts(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

                String productName = (params.containsKey(PRODUCT_NAME) && params.get(PRODUCT_NAME) != null
                        && !params.get(PRODUCT_NAME).toString().isEmpty()) ?
                        params.get(PRODUCT_NAME).toString() : null;
                String specialist = (params.containsKey(PRODUCTSPECIALIST) && params.get(PRODUCTSPECIALIST) != null
                        && !params.get(PRODUCTSPECIALIST).toString().isEmpty()) ?
                        params.get(PRODUCTSPECIALIST).toString() : null;
                String initialDate = (params.containsKey(INITIAL_DATE) && params.get(INITIAL_DATE) != null
                        && !params.get(INITIAL_DATE).toString().isEmpty()) ?
                        params.get(INITIAL_DATE).toString() : null;
                String finalDate = (params.containsKey(FINAL_DATE) && params.get(FINAL_DATE) != null
                        && !params.get(FINAL_DATE).toString().isEmpty()) ?
                        params.get(FINAL_DATE).toString() : null;

                mapResponse = depilarteServices.searchProducts(productName,specialist,initialDate,finalDate);


            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }
        }
        return mapResponse;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = GET_EMPLEADOS_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = GET_EMPLEADOS_URI)
    public Map<String, Object> getEmpleados(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

                Long idEmpleado = (params.containsKey(ID_EMPLEADO) &&
                        params.get(ID_EMPLEADO) != null &&
                        !params.get(ID_EMPLEADO).toString().isEmpty())
                        ? Long.valueOf(params.get(ID_EMPLEADO).toString()) : null;

                mapResponse = depilarteServices.getEmpleados(idEmpleado);


            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }
        }
        return mapResponse;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = GET_PRODUCTS_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = GET_PRODUCTS_URI)
    public Map<String, Object> getProduct(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

                Long idProduct = (params.containsKey(ID_EMPLEADO) &&
                        params.get(ID_EMPLEADO) != null &&
                        !params.get(ID_EMPLEADO).toString().isEmpty())
                        ? Long.valueOf(params.get(ID_EMPLEADO).toString()) : null;

                mapResponse = depilarteServices.getProduct(idProduct);


            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }
        }
        return mapResponse;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = GET_TREATMENT_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = GET_TREATMENT_ID)
    public Map<String, Object> getTreatmentData(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

                Long idTreatment = (params.containsKey(ID_TREATMENTS) &&
                        params.get(ID_TREATMENTS) != null &&
                        !params.get(ID_TREATMENTS).toString().isEmpty())
                        ? Long.valueOf(params.get(ID_TREATMENTS).toString()) : null;

                mapResponse = depilarteServices.getTreatmentProducts(idTreatment);


            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }
        }
        return mapResponse;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = GENERATE_PACIENTES_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = GET_PACIENTES_URI)
    public Map<String, Object> getPacientesData(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

                Long idPacientes = (params.containsKey(ID_PACIENTES) &&
                        params.get(ID_PACIENTES) != null &&
                        !params.get(ID_PACIENTES).toString().isEmpty())
                        ? Long.valueOf(params.get(ID_PACIENTES).toString()) : null;

                mapResponse = depilarteServices.getPacientes(idPacientes);


            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }
        }
        return mapResponse;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = GENERATE_PRODUCTS_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = GENERATE_PRODUCTS)
    public Map<String, Object> generateEmpleados(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

                String productName = (params.containsKey(PRODUCT_NAME) && params.get(PRODUCT_NAME) != null
                        && !params.get(PRODUCT_NAME).toString().isEmpty()) ?
                        params.get(PRODUCT_NAME).toString() : null;
                String specialist = (params.containsKey(PRODUCTSPECIALIST) && params.get(PRODUCTSPECIALIST) != null
                        && !params.get(PRODUCTSPECIALIST).toString().isEmpty()) ?
                        params.get(PRODUCTSPECIALIST).toString() : null;
                String initialDate = (params.containsKey(INITIAL_DATE) && params.get(INITIAL_DATE) != null
                        && !params.get(INITIAL_DATE).toString().isEmpty()) ?
                        params.get(INITIAL_DATE).toString() : null;
                String finalDate = (params.containsKey(FINAL_DATE) && params.get(FINAL_DATE) != null
                        && !params.get(FINAL_DATE).toString().isEmpty()) ?
                        params.get(FINAL_DATE).toString() : null;

                mapResponse = depilarteServices.generateProductsExcel(productName,specialist,initialDate,finalDate);


            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }
        }
        return mapResponse;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = GENERATE_EMPLEADOS_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = GENERATE_EMPLEADOS)
    public Map<String, Object> generateProducts(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

                String nameWorker = (params.containsKey(WORKER_NAME) && params.get(WORKER_NAME) != null
                        && !params.get(WORKER_NAME).toString().isEmpty()) ?
                        params.get(WORKER_NAME).toString() : null;
                String identification = (params.containsKey(WORKER_IDENTIFICATION) && params.get(WORKER_IDENTIFICATION) != null
                        && !params.get(WORKER_IDENTIFICATION).toString().isEmpty()) ?
                        params.get(WORKER_IDENTIFICATION).toString() : null;
                Long charge = (params.containsKey(WORKER_CHARGE) &&
                        params.get(WORKER_CHARGE) != null &&
                        !params.get(WORKER_CHARGE).toString().isEmpty())
                        ? Long.valueOf(params.get(WORKER_CHARGE).toString()) : null;
                String initialDate = (params.containsKey(INITIAL_DATE) && params.get(INITIAL_DATE) != null
                        && !params.get(INITIAL_DATE).toString().isEmpty()) ?
                        params.get(INITIAL_DATE).toString() : null;
                String finalDate = (params.containsKey(FINAL_DATE) && params.get(FINAL_DATE) != null
                        && !params.get(FINAL_DATE).toString().isEmpty()) ?
                        params.get(FINAL_DATE).toString() : null;

                mapResponse = depilarteServices.generateEmpleadosExcel(nameWorker,identification,charge,initialDate,finalDate);

            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }
        }
        return mapResponse;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = GENERATE_TREATMENTS_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = GENERATE_TREATMENTS)
    public Map<String, Object> generateTreatments(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

                String nameTreatment = (params.containsKey(NAME_TREATMENT) && params.get(NAME_TREATMENT) != null
                        && !params.get(NAME_TREATMENT).toString().isEmpty()) ?
                        params.get(NAME_TREATMENT).toString() : null;
                String specialist = (params.containsKey(SPECIALIST_TREATMENT) && params.get(SPECIALIST_TREATMENT) != null
                        && !params.get(SPECIALIST_TREATMENT).toString().isEmpty()) ?
                        params.get(SPECIALIST_TREATMENT).toString() : null;
                String initialDate = (params.containsKey(INITIAL_DATE) && params.get(INITIAL_DATE) != null
                        && !params.get(INITIAL_DATE).toString().isEmpty()) ?
                        params.get(INITIAL_DATE).toString() : null;
                String finalDate = (params.containsKey(FINAL_DATE) && params.get(FINAL_DATE) != null
                        && !params.get(FINAL_DATE).toString().isEmpty()) ?
                        params.get(FINAL_DATE).toString() : null;

                mapResponse = depilarteServices.generateTreatmentsExcel(nameTreatment,specialist,initialDate,finalDate);



            } catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }
        }
        return mapResponse;
    }


    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = GENERATE_REGISTER_EXCEL_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = GENERATE_REGISTER_EXCEL)
    public Map<String, Object> generateRegisterExcel(@ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

                String nameClient = (params.containsKey(SEARCH_NAME) && params.get(SEARCH_NAME) != null
                        && !params.get(SEARCH_NAME).toString().isEmpty()) ?
                        params.get(SEARCH_NAME).toString() : null;
                String lastNameClient = (params.containsKey(SEARCH_LASTNAME) && params.get(SEARCH_LASTNAME) != null
                        && !params.get(SEARCH_LASTNAME).toString().isEmpty()) ?
                        params.get(SEARCH_LASTNAME).toString() : null;
                String cedula = (params.containsKey(SEARCH_IDENTIFICATION) && params.get(SEARCH_IDENTIFICATION) != null
                        && !params.get(SEARCH_IDENTIFICATION).toString().isEmpty()) ?
                        params.get(SEARCH_IDENTIFICATION).toString() : null;
                Long user = (params.containsKey(SEARCH_USERATT) &&
                        params.get(SEARCH_USERATT) != null &&
                        !params.get(SEARCH_USERATT).toString().isEmpty())
                        ? Long.valueOf(params.get(SEARCH_USERATT).toString()) : null;
                Long nameUser = (params.containsKey(SEARCH_NAMEUSER) &&
                        params.get(SEARCH_NAMEUSER) != null &&
                        !params.get(SEARCH_NAMEUSER).toString().isEmpty())
                        ? Long.valueOf(params.get(SEARCH_NAMEUSER).toString()) : null;
                String initialDate = (params.containsKey(INITIAL_DATE) && params.get(INITIAL_DATE) != null
                        && !params.get(INITIAL_DATE).toString().isEmpty()) ?
                        params.get(INITIAL_DATE).toString() : null;
                String finalDate = (params.containsKey(FINAL_DATE) && params.get(FINAL_DATE) != null
                        && !params.get(FINAL_DATE).toString().isEmpty()) ?
                        params.get(FINAL_DATE).toString() : null;

                mapResponse = depilarteServices.generatePacientesExcel(nameClient,lastNameClient,cedula,user,nameUser,initialDate,finalDate);



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
