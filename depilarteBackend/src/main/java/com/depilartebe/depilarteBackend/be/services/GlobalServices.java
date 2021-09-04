package com.depilartebe.depilarteBackend.be.services;

import com.depilartebe.depilarteBackend.be.constants.DepilarteConstants;
import com.depilartebe.depilarteBackend.be.constants.GlobalConstants;
import com.depilartebe.depilarteBackend.be.entities.Treatment;
import com.depilartebe.depilarteBackend.be.entities.formaPay;
import com.depilartebe.depilarteBackend.be.repository.FormaPayRepository;
import com.depilartebe.depilarteBackend.be.repository.TreatmentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
