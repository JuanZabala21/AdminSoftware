package com.depilartebe.depilarteBackend.be.services;

import com.depilartebe.depilarteBackend.be.constants.DepilarteConstants;
import com.depilartebe.depilarteBackend.be.constants.GlobalConstants;
import com.depilartebe.depilarteBackend.be.entities.*;
import com.depilartebe.depilarteBackend.be.repository.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class GlobalServices implements GlobalConstants, DepilarteConstants {
    static Logger log = LogManager.getLogger(GlobalServices.class);

    @Autowired
    FormaPayRepository formaPayRepository;

    @Autowired
    TreatmentRepository treatmentRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    TreatmentTypeRepository treatmentTypeRepository;

    @Autowired
    TreatmentZoneRepository treatmentZoneRepository;


   public Map<String, Object> getPayMethods() {
       Map<String , Object> mapResult = new HashMap<>();

       try{
        List<formaPay> methodsPay = formaPayRepository.findAll();
        mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);
        mapResult.put(METHODSPAY, methodsPay);


       }catch (Exception e) {
           e.printStackTrace();
           log.error("Se produjo un error: " + e.getMessage());
           mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
           mapResult.put(MESSAGE, MESSAGE_ERROR);
       }
       return mapResult;
   }

   public Map<String, Object> getTreatments() {
       Map<String , Object> mapResult = new HashMap<>();

       try{
           List<Treatment> treatments = treatmentRepository.findAll();
           mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);
           mapResult.put(TREATMENTS, treatments);

       }catch (Exception e) {
           e.printStackTrace();
           log.error("Se produjo un error: " + e.getMessage());
           mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
           mapResult.put(MESSAGE, MESSAGE_ERROR);
       }
       return mapResult;

   }

   public Map<String, Object> getChargers(String charger) {
       Map<String, Object> mapResult = new HashMap<>();
       try {
           List<Empleado> empleados = empleadoRepository.findEmpleados(Long.parseLong(charger));
           mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);
           mapResult.put(CHARGERRESULT, empleados);

       }catch (Exception e) {
           e.printStackTrace();
           log.error("Se produjo un error: " + e.getMessage());
           mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
           mapResult.put(MESSAGE, MESSAGE_ERROR);
       }
       return mapResult;
   }

    public Map<String, Object> getTreamentType(String treament) {
        Map<String, Object> mapResult = new HashMap<>();
        try {
            List<TreatmentType> treatmentTypeList = treatmentTypeRepository.finbTypeTreat(Long.parseLong(treament));
            mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);
            mapResult.put(TREATMENTTYPERESULT, treatmentTypeList);


        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
    }

    public Map<String, Object> getTreatmentZone(String treament) {
        Map<String, Object> mapResult = new HashMap<>();
        try {
            List<TreatmentZone> treatmentZoneList = treatmentZoneRepository.finbTypeTreat(Long.parseLong(treament));
            mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);
            mapResult.put(TREATMENTZONERESULT, treatmentZoneList);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
    }







}
