package com.depilartebe.depilarteBackend.be.controllers;

import com.depilartebe.depilarteBackend.be.constants.GlobalConstants;
import com.depilartebe.depilarteBackend.be.services.GlobalServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.scopedpool.SoftValueHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Api(name = "Servicio para consultas generales",
            description = "Consultar", group = "Globales")
@ApiVersion(since = "1.0")
@CrossOrigin("*")
@RestController
@RequestMapping("/global")
public class GlobalController implements GlobalConstants {

    static Logger log = LogManager.getLogger(GlobalController.class);

    @Autowired
    GlobalServices globalServices;

    @ApiMethod(consumes = CONTENT_TYPE, produces = ACCEPT, description = METHODS_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = METHODSPAY_URI, produces = ACCEPT)
    public Map<String, Object> getMethodsPay(){
        Map<String, Object> mapResponse = new HashMap<String, Object>();
        try {
            mapResponse = globalServices.getPayMethods();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResponse.put(MESSAGE, MESSAGE_ERROR);
            return mapResponse;
        }

        return mapResponse;
    }
 
    @ApiMethod(consumes = CONTENT_TYPE, produces = ACCEPT, description = REFERENCE_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = REFERENCE_URI, produces = ACCEPT)
    public Map<String, Object> getReferences(){
        Map<String, Object> mapResponse = new HashMap<String, Object>();
        try {
            mapResponse = globalServices.getReferences();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResponse.put(MESSAGE, MESSAGE_ERROR);
            return mapResponse;
        }

        return mapResponse;
    }

    @ApiMethod(consumes = CONTENT_TYPE, produces = ACCEPT, description = TREATMENTSLIST_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = TREATMENTSS_URI, produces = ACCEPT)
    public Map<String, Object> getTreatments(){
        Map<String, Object> mapResponse = new HashMap<String, Object>();
        try {
            mapResponse = globalServices.getTreatments();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResponse.put(MESSAGE, MESSAGE_ERROR);
            return mapResponse;
        }

        return mapResponse;
    }

    @ApiMethod(consumes = CONTENT_TYPE, produces = ACCEPT, description = CHAARGER_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = CHARGER_URI, produces = ACCEPT)
    public Map<String, Object> getUsersByCargo(@ApiBodyObject(clazz = String.class) @RequestBody String json){
        Map<String, Object> mapResponse = new HashMap<String, Object>();
        try {
            Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

            String chargers =  (params.containsKey(CHARGERS) && params.get(CHARGERS) != null && !params.get(CHARGERS).toString().isEmpty()) ? params.get(CHARGERS).toString() : null;
            if(chargers != null){
                mapResponse = globalServices.getChargers(chargers);
            }else{
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResponse.put(MESSAGE, MESSAGE_ERROR);
            return mapResponse;
        }

        return mapResponse;
    }


    @ApiMethod(consumes = CONTENT_TYPE, produces = ACCEPT, description = TREATMENTTYPE_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = TREATMENTTYPE_URI, produces = ACCEPT)
    public Map<String, Object> getTreatmentType(@ApiBodyObject(clazz = String.class) @RequestBody String json){
        Map<String, Object> mapResponse = new HashMap<String, Object>();
        try {
            Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

            String treatment =  (params.containsKey(TREATMENTTYPE) && params.get(TREATMENTTYPE) != null && !params.get(TREATMENTTYPE).toString().isEmpty()) ? params.get(TREATMENTTYPE).toString() : null;
            if(treatment != null){
                mapResponse = globalServices.getTreamentType(treatment);
            }else{
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResponse.put(MESSAGE, MESSAGE_ERROR);
            return mapResponse;
        }

        return mapResponse;
    }

    @ApiMethod(consumes = CONTENT_TYPE, produces = ACCEPT, description = PRICE_COMISION_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = PRICE_COMISION_URI, produces = ACCEPT)
    public Map<String, Object> getPriceAndComision(@ApiBodyObject(clazz = String.class) @RequestBody String json){
        Map<String, Object> mapResponse = new HashMap<String, Object>();
        try {
            Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

            String treatment =  (params.containsKey(PRINCE_AND_COMISION) && params.get(PRINCE_AND_COMISION) != null && !params.get(PRINCE_AND_COMISION).toString().isEmpty()) ? params.get(PRINCE_AND_COMISION).toString() : null;
            if(treatment != null){
                mapResponse = globalServices.getPriceAndComision(treatment);
            }else{
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResponse.put(MESSAGE, MESSAGE_ERROR);
            return mapResponse;
        }

        return mapResponse;
    }

    @ApiMethod(consumes = CONTENT_TYPE, produces = ACCEPT, description = TREATMENTZONE_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = TREATMENTZONE_URI, produces = ACCEPT)
    public Map<String, Object> getTreatmentZone(@ApiBodyObject(clazz = String.class) @RequestBody String json){
        Map<String, Object> mapResponse = new HashMap<String, Object>();
        try {
            Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

            String treatment =  (params.containsKey(TREATMENTZONE) && params.get(TREATMENTZONE) != null && !params.get(TREATMENTZONE).toString().isEmpty()) ? params.get(TREATMENTZONE).toString() : null;
            if(treatment != null){
                mapResponse = globalServices.getTreatmentZone(treatment);
            }else{
                mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResponse.put(MESSAGE, MESSAGE_ERROR);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResponse.put(MESSAGE, MESSAGE_ERROR);
            return mapResponse;
        }

        return mapResponse;
    }

    @ApiMethod(consumes = CONTENT_TYPE, produces = ACCEPT, description = PRODUCT_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = PRODUCT, produces = ACCEPT)
    public Map<String, Object> getProducst(){
        Map<String, Object> mapResponse = new HashMap<String, Object>();
        try {
            mapResponse = globalServices.getProducts();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResponse.put(MESSAGE, MESSAGE_ERROR);
            return mapResponse;
        }

        return mapResponse;
    }


    @ApiMethod(consumes = TEXT_JSON, produces = ACCEPT, description = DASHBOARD_DESCRIPTION)
    @ApiResponseObject
    @RequestMapping(method = RequestMethod.POST, value = DASHBOARD, produces = ACCEPT)
    public Map<String, Object> getDashboard(){
        Map<String, Object> mapResponse = new HashMap<String, Object>();
        try {
            mapResponse = globalServices.getDashboard();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResponse.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResponse.put(MESSAGE, MESSAGE_ERROR);
            return mapResponse;
        }

        return mapResponse;
    }
}
