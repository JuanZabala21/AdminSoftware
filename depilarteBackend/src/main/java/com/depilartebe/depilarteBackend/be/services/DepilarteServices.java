package com.depilartebe.depilarteBackend.be.services;

import com.depilartebe.depilarteBackend.be.constants.DepilarteConstants;
import com.depilartebe.depilarteBackend.be.constants.GlobalConstants;
import com.depilartebe.depilarteBackend.be.entities.*;
import com.depilartebe.depilarteBackend.be.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

@Service
public class DepilarteServices implements DepilarteConstants, GlobalConstants {
    static Logger log = LogManager.getLogger(DepilarteServices.class);

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    TreatmentRepository treatmentRepository;

    @Autowired
    TreatmentTypeRepository treatmentTypeRepository;

    @Autowired
    TreatmentZoneRepository treatmentZoneRepository;

    @Autowired
    ProductRepository productRepository;

    public Map<String, Object> registerClients(
        Long id,
        Long registerWorker,
        String clientName,
        String clientLastName,
        String identification,
        String age,
        String email,
        String birthday,
        String address,
        Long treatment,
        Long treatmentType,
        Long treatmentZone,
        String countSessions,
        String assistent,
        Long product,
        String shotBefore,
        String shotAfter,
        String shotDiferential,
        Long operator,
        Long doctor,
        Long formPay,
        String abonado,
        String priceTotal,
        String comission,
        String note,
        String phone

    ){
        Map<String, Object> mapResult = new HashMap<>();
        try{
           Register register = null;
           Date today = new Date();

            if(id == null){
                register = new Register();
            }else{
                registerRepository.findById(id);
            }

            /** Registrando **/
            register.setNombre(clientName);
            register.setRegisterUser(registerWorker);
            register.setApellido(clientLastName);
            register.setCedula(identification);
            register.setEdad(age);
            register.setCorreo(email);
            register.setFechaCumple(birthday);
            register.setDireccion(address);
            register.setTratamiento(treatment);
            register.setTipoTratamiento(treatmentType);
            register.setZonaTratamiento(treatmentZone);
            register.setCantidadSesiones(countSessions);
            register.setAsistencia(assistent);
            register.setProductoUtilizado(product);
            register.setDisparosAntes(shotBefore);
            register.setDisparosDespues(shotAfter);
            register.setDiferenciaDisparos(shotDiferential);
            if(registerWorker == 1){
                register.setUserAtendio(doctor);
            } else{
                register.setUserAtendio(operator);
            }
            register.setFormaPago(formPay);
            register.setAbonado(abonado);
            register.setPrecioTotal(priceTotal);
            register.setComision(comission);
            register.setNota(note);
            register.setTelefono(phone);
            register.setFechaAtendido(today);
            registerRepository.save(register);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
    }

    public Map<String, Object> registerEmpleados(
            Long id,
            String empleadoName,
            String empleadoLastName,
            String identification,
            String telefono,
            String age,
            String email,
            String birthday,
            String address,
            String cargo

    ){
        Map<String, Object> mapResult = new HashMap<>();
        try{
            Empleado empleado = null;
            Date today = new Date();

            if(id == null){
                empleado = new Empleado();
            }else{
                registerRepository.findById(id);
            }

            /** Registrando **/
            empleado.setNombre(empleadoName);
            empleado.setApellido(empleadoLastName);
            empleado.setCedula(identification);
            empleado.setEdad(age);
            empleado.setCorreo(email);
            empleado.setNacimiento(birthday);
            empleado.setDireccion(address);
            empleado.setTelefono(telefono);
            empleado.setCargo(cargo);
            empleado.setFechaIngreso(today);
            empleadoRepository.save(empleado);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
    }

    public Map<String, Object> registerTreatments(
        Long id,
        String name,
        String type,
        String zone,
        Long specialist,
        String sessions,
        String precio,
        String comission,
        String description
    ){
        Map<String, Object> mapResult = new HashMap<>();

        try{
            Treatment treatment = null;

            if(id == null){
                treatment = new Treatment();
            }else{
                treatmentRepository.findById(id);
            }

            /** Registrando **/
            treatment.setNameTreatment(name);
            treatment.setEspecialista(specialist);
            treatment.setCantidadSesiones(sessions);
            treatment.setPrecioTratamiento(precio);
            treatment.setComisionOperadora(comission);
            treatment.setDescripcionTratamiento(description);
            treatmentRepository.save(treatment);

            if(id != null){
                String [] typeTreatments = type.split(",");
                List<String> typeTreatmentsList = treatmentTypeRepository.findTypeTreatmentById(id);

                for(int i = 0; i < typeTreatments.length; i++) {
                    if(!typeTreatmentsList.contains(typeTreatments[i].trim())){
                        if(typeTreatmentsList.size() <= i){
                            TreatmentType item = new TreatmentType();
                            item.setId_tratamientos(id);
                            item.setNombreTipo(typeTreatments[i].trim());
                            treatmentTypeRepository.save(item);
                        } else {
                            TreatmentType item = treatmentTypeRepository.findByTreatmentType(typeTreatmentsList.get(i).trim());
                            item.setNombreTipo(typeTreatments[i].trim());
                            treatmentTypeRepository.save(item);
                        }
                    }
                }
            }else{
                String [] typeTreatments = type.split(",");
                for (int i = 0; i < typeTreatments.length; i++) {
                    TreatmentType item = new TreatmentType();
                    item.setId_tratamientos(treatment.getId_tratamientos());
                    item.setNombreTipo(typeTreatments[i].trim());
                    treatmentTypeRepository.save(item);
                }
            }

            if(id != null){
                String [] zoneTreatments = zone.split(",");
                List<String> zoneTreatmentList = treatmentZoneRepository.findZoneTreatmentById(id);

                for(int i = 0; i < zoneTreatments.length; i++) {
                    if(!zoneTreatmentList.contains(zoneTreatments[i].trim())){
                        if(zoneTreatmentList.size() <= i){
                            TreatmentZone item = new TreatmentZone();
                            item.setId_tratamientos(id);
                            item.setZonaNombre(zoneTreatments[i].trim());
                            treatmentZoneRepository.save(item);
                        } else {
                            TreatmentZone item = treatmentZoneRepository.findByTreatmentZone(zoneTreatmentList.get(i).trim());
                            item.setZonaNombre(zoneTreatments[i].trim());
                            treatmentZoneRepository.save(item);
                        }
                    }
                }
            }else{
                String [] zoneTreatments = zone.split(",");
                for (int i = 0; i < zoneTreatments.length; i++) {
                    TreatmentZone item = new TreatmentZone();
                    item.setId_tratamientos(treatment.getId_tratamientos());
                    item.setZonaNombre(zoneTreatments[i].trim());
                    treatmentZoneRepository.save(item);
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
    }

    public Map<String, Object> registerProduct(
          Long id,
          Long treatment,
          String proveedor,
          String cantidad,
          String precio,
          Long specialist,
          String description

    ){
        Map<String, Object> mapResult = new HashMap<>();
        try{
            Products products = null;

            if(id == null){
                products = new Products();
            }else{
                productRepository.findById(id);
            }

            products.setId_tratamientos(treatment);
            products.setProveedor(proveedor);
            products.setCantidad(cantidad);
            products.setPrecio(precio);
            products.setSpecialist(specialist);
            products.setDescripcion(description);
            productRepository.save(products);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
    }

    public Map<String, Object> searchRegister(
         String name,
         String lastNameClient,
         String cedula,
         Long user,
         Long nameUser,
         String initialDate,
         String finalDate

    ){
        Map<String, Object> mapResult = new HashMap<>();
        List<Map<String, Object>> mapList = new ArrayList<>();
        List<Register> registerList = new ArrayList<>();


        try{
            registerList = registerRepository.findRegister(name,lastNameClient,cedula,user,nameUser,initialDate,finalDate);
            if(registerList != null){
                for(Register register : registerList){
                    Map<String, Object> result = new HashMap<>();
                    result.put("fechaAttemption", register.getFechaAtendido());
                    result.put("name", register.getNombre());
                    result.put("lastName", register.getApellido());
                    result.put("identification", register.getCedula());
                    result.put("age", register.getEdad());
                    result.put("phone", register.getTelefono());
                    result.put("treatment", register.getTratamiento());
                    result.put("treatmentType", register.getTipoTratamiento());
                    result.put("treatmentZone", register.getZonaTratamiento());
                    result.put("shotsBefore", register.getDisparosAntes());
                    result.put("shotsAfter", register.getDisparosDespues());
                    result.put("shotDifferential", register.getDiferenciaDisparos());
                    result.put("sessions", register.getCantidadSesiones());
                    result.put("assistents", register.getAsistencia());
                    result.put("product", register.getProductoUtilizado());
                    result.put("userAttemption", register.getUserAtendio());
                    result.put("formpay", register.getFormaPago());
                    result.put("abonado", register.getAbonado());
                    result.put("comission", register.getComision());
                    result.put("price", register.getPrecioTotal());
                    mapList.add(result);
                }
                mapResult.put(RESULT_LIST_MAP, mapList);
            }
        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
       }
    }







