package com.depilartebe.depilarteBackend.be.controllers;

import com.depilartebe.depilarteBackend.be.constants.GlobalConstants;
import com.depilartebe.depilarteBackend.be.services.GlobalServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.annotation.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
