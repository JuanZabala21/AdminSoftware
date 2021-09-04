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


}
