package com.depilartebe.depilarteBackend.be.services;

import com.depilartebe.depilarteBackend.be.constants.DepilarteConstants;
import com.depilartebe.depilarteBackend.be.constants.GlobalConstants;
import com.depilartebe.depilarteBackend.be.entities.*;
import com.depilartebe.depilarteBackend.be.repository.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    @Autowired
    FormaPayRepository formaPayRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TreatmentType2Repository treatmentType2Repository;

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
        Empleado empleado;
        try{
            Date today = new Date();

            if(id == null){
                empleado = new Empleado();
            }else{
                empleado = empleadoRepository.findEmpleadosById(id);
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
        ArrayList type,
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

            Date today = new Date();

            /** Registrando **/
            treatment.setNameTreatment(name);
            treatment.setEspecialista(specialist);
            treatment.setCantidadSesiones(sessions);
            treatment.setComisionOperadora(comission);
            treatment.setDescripcionTratamiento(description);
            treatmentRepository.save(treatment);

            if(id != null){

                List<TreatmentType> typeTreatmentsList = treatmentTypeRepository.findTypeTreatmentByIdForEdit(id);

                for(TreatmentType typ : typeTreatmentsList){
                    for (int i = 0; i < type.size(); i++) {
                        String jsonString = type.get(i).toString();
                        JSONObject obj = new JSONObject(jsonString);
                        typ.setNombreTipo(obj.get("typeTreatment").toString());
                        typ.setPrecioTratamiento(obj.get("typePrice").toString());
                        treatmentTypeRepository.save(typ);
                    }
                    typeTreatmentsList.add(typ);
                }

            }else{

                for (int i = 0; i < type.size(); i++) {
                    String jsonString = type.get(i).toString().replace(" ","-");
                    String typex = jsonString;
                    JSONObject obj = new JSONObject(typex);
                    TreatmentType item = new TreatmentType();
                    item.setId_tratamientos(treatment.getId_tratamientos());
                    item.setNombreTipo(obj.get("typeTreatment").toString().replace("-"," "));
                    item.setPrecioTratamiento(obj.get("-typePrice").toString());
                    treatmentTypeRepository.save(item);
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
          String product,
          String proveedor,
          String cantidad,
          String precio,
          Long specialist,
          String description

    ){
        Map<String, Object> mapResult = new HashMap<>();
        Products products;
        try{


            if(id == null){
                products = new Products();
            }else{
               products = productRepository.findProductsById(id);
            }

            products.setNombre(product);
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
         String nameClient,
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
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");


        try{
            Treatment treatment = new Treatment();
            TreatmentType treatmentType = new TreatmentType();
            Users users = new Users();
            Products products = new Products();
            formaPay formPay = new formaPay();
            if(initialDate != null && finalDate != null){
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                String initial = dt.format(dateInitial);
                registerList = registerRepository.findRegister(nameClient,lastNameClient,cedula,user,nameUser,initial,finale);
            }else if(initialDate != null){
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                String initial = dt.format(dateInitial);
                registerList = registerRepository.findRegister(nameClient,lastNameClient,cedula,user,nameUser,initial,finalDate);
            }else if(finalDate != null){
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                registerList = registerRepository.findRegister(nameClient,lastNameClient,cedula,user,nameUser,initialDate,finale);
            } else {
                registerList = registerRepository.findRegister(nameClient,lastNameClient,cedula,user,nameUser,initialDate,finalDate);
            }
                if(registerList != null){
                    for(Register register : registerList){
                        Map<String, Object> result = new HashMap<>();
                        result.put("id", register.getId());
                        result.put("fechaAttemption", dt.format(register.getFechaAtendido()));
                        result.put("name", register.getNombre());
                        result.put("lastName", register.getApellido());
                        result.put("identification", register.getCedula());
                        result.put("birthday", register.getFechaCumple());
                        result.put("age", register.getEdad());
                        result.put("phone", register.getTelefono());
                        treatment = treatmentRepository.findTreatmentById(register.getTratamiento());
                        result.put("treatment", treatment.getNameTreatment());
                        treatmentType = treatmentTypeRepository.findTreatmentTypeById(register.getTipoTratamiento());
                        result.put("treatmentType", treatmentType.getNombreTipo());
                        result.put("shotsBefore", register.getDisparosAntes());
                        result.put("shotsAfter", register.getDisparosDespues());
                        result.put("shotsDifferential", register.getDiferenciaDisparos());
                        result.put("sessions", register.getCantidadSesiones());
                        result.put("assistents", register.getAsistencia());
                        products = productRepository.findProductsById(register.getProductoUtilizado());
                        result.put("product", products.getNombre());
                        users = usersRepository.findUsernameById(register.getUserAtendio());
                        result.put("userAttemption", users.getName());
                        formPay = formaPayRepository.findformaPayById(register.getFormaPago());
                        result.put("formpay", formPay.getMetodoPago());
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

       public Map<String, Object> searchWorkers(
               String nameWorker,
               String identification,
               Long charge,
               String initialDate,
               String finalDate
       ){
           Map<String, Object> mapResult = new HashMap<>();
           List<Map<String, Object>> mapList = new ArrayList<>();
           List<Empleado> empleadoList = new ArrayList<>();
           SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        try{
            if(initialDate != null && finalDate != null){
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                String initial = dt.format(dateInitial);
                empleadoList = empleadoRepository.findWorkers(nameWorker,identification,charge,initial,finale);
            }else if(initialDate != null){
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                String initial = dt.format(dateInitial);
                empleadoList = empleadoRepository.findWorkers(nameWorker,identification,charge,initial,finalDate);
            }else if(finalDate != null){
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                empleadoList = empleadoRepository.findWorkers(nameWorker,identification,charge,initialDate,finale);
            }else{
                empleadoList = empleadoRepository.findWorkers(nameWorker,identification,charge,initialDate,finalDate);
            }
            if(empleadoList != null){
                for(Empleado empleado : empleadoList){
                    Map<String, Object> result = new HashMap<>();
                    result.put("id", empleado.getId());
                    result.put("fechaAttemption", dt.format(empleado.getFechaIngresoo()));
                    result.put("name", empleado.getNombre());
                    result.put("lastName", empleado.getApellido());
                    result.put("identification", empleado.getCedula());
                    result.put("age", empleado.getEdad());
                    result.put("email", empleado.getCorreo());
                    result.put("phone", empleado.getTelefono());
                    result.put("birthday", empleado.getNacimiento());
                    result.put("address", empleado.getDireccion());
                    result.put("charge", empleado.getCargo());
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

        public Map<String, Object> searchTreatment(
            String nameTreatment,
            String specialistTreatment,
            String initialDate,
            String finalDate
        ){
            Map<String, Object> mapResult = new HashMap<>();
            List<Map<String, Object>> mapList = new ArrayList<>();
            List<Treatment> treatmentList = new ArrayList<>();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

        try{
            if(initialDate != null && finalDate != null){
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                String initial = dt.format(dateInitial);
                treatmentList = treatmentRepository.findTreatment(nameTreatment,specialistTreatment,initial,finale);
            }else if(initialDate != null){
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                String initial = dt.format(dateInitial);
                treatmentList = treatmentRepository.findTreatment(nameTreatment,specialistTreatment,initial,finalDate);
            }else if(finalDate != null){
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                treatmentList = treatmentRepository.findTreatment(nameTreatment,specialistTreatment,initialDate,finale);
            }else{
                treatmentList = treatmentRepository.findTreatment(nameTreatment,specialistTreatment,initialDate,finalDate);
            }
            if(treatmentList != null){
                for(Treatment treatment : treatmentList){

                    List<TreatmentType> treatmentTypeList = treatmentTypeRepository.finbTypeTreat(treatment.getId_tratamientos());
                    for(TreatmentType treatmentType : treatmentTypeList){
                        Map<String, Object> result = new HashMap<>();
                        result.put("id", treatment.getId_tratamientos());
                        result.put("name",treatment.getNameTreatment());
                        result.put("treatmentType", treatmentType.getNombreTipo());
                        result.put("specialist", treatment.getEspecialista());
                        result.put("sessions", treatment.getCantidadSesiones());
                        result.put("price", treatmentType.getPrecioTratamiento());
                        result.put("comission", treatment.getComisionOperadora());
                        mapList.add(result);
                    }
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

        public Map<String, Object> searchProducts(
            String product,
            String specialist,
            String initialDate,
            String finalDate

        ){
            Map<String, Object> mapResult = new HashMap<>();
            List<Map<String, Object>> mapList = new ArrayList<>();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        try{
            List<Products> productsList = new ArrayList<>();
            if(initialDate != null && finalDate != null){
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                String initial = dt.format(dateInitial);
                productsList = productRepository.findProducts(product,specialist,initial,finale);
            }else if(initialDate != null){
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                String initial = dt.format(dateInitial);
                productsList = productRepository.findProducts(product,specialist,initial,finalDate);
            }else if(finalDate != null){
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                productsList = productRepository.findProducts(product,specialist,initialDate,finale);
            }else{
                productsList = productRepository.findProducts(product,specialist,initialDate,finalDate);
            }
            if(productsList != null){
                for(Products products : productsList){
                   Map<String, Object> result = new HashMap<>();
                   result.put("id", products.getId_productos());
                   result.put("nameProduct", products.getNombre());
                   result.put("proveedor", products.getProveedor());
                   result.put("cantidad",products.getCantidad());
                   result.put("specialist", products.getSpecialist());
                   result.put("price", products.getPrecio());
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

        public Map<String, Object> getEmpleados(
            Long id
        ){
            Map<String, Object> mapResult = new HashMap<>();
            Map<String, Object> result = new HashMap<>();
        try{
            Empleado empleado = new Empleado();
            empleado = empleadoRepository.findWorkersById(id);

            result.put("id", empleado.getId());
            result.put("name", empleado.getNombre());
            result.put("lastName", empleado.getApellido());
            result.put("identification", empleado.getCedula());
            result.put("age", empleado.getEdad());
            result.put("email", empleado.getCorreo());
            result.put("phone",empleado.getNacimiento());
            result.put("birthday", empleado.getNacimiento());
            result.put("charge", Integer.valueOf(empleado.getCargo()));
            result.put("address", empleado.getDireccion());

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
            mapResult.put(DATA, result);
            return result;

        }

        public Map<String, Object> getProduct(
                Long id
        ){
            Map<String, Object> mapResult = new HashMap<>();
            Map<String, Object> result = new HashMap<>();

            try{
                Products products = new Products();
                products = productRepository.findProductsById(id);

                result.put("id", products.getId_productos());
                result.put("product", products.getNombre());
                result.put("proveedor", products.getProveedor());
                result.put("cantidad", products.getCantidad());
                result.put("specialist", products.getSpecialist());
                result.put("price", products.getPrecio());
                result.put("description", products.getDescripcion());

            }catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResult.put(MESSAGE, MESSAGE_ERROR);
            }
            mapResult.put(DATA, result);
            return result;

        }

        public Map<String, Object> getTreatmentProducts(
                Long id
        ){
            Map<String, Object> mapResult = new HashMap<>();

            Map<String, Object> result = new HashMap<>();
            try{
                Treatment treatment = new Treatment();
                treatment = treatmentRepository.findTreatmentById(id);
                List<TreatmentType2> typeTreatmentList = new ArrayList<>();
                typeTreatmentList = treatmentType2Repository.finbTypeTreat2(id);

                result.put("id", treatment.getId_tratamientos());
                result.put("treatmentName", treatment.getNameTreatment());
                result.put("specialist", treatment.getEspecialista());
                result.put("sessions", treatment.getCantidadSesiones());
                result.put("typePrice", typeTreatmentList);
                result.put("comission", treatment.getComisionOperadora());
                result.put("description", treatment.getDescripcionTratamiento());

            }catch (Exception e) {
                e.printStackTrace();
                log.error("Se produjo un error: " + e.getMessage());
                mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
                mapResult.put(MESSAGE, MESSAGE_ERROR);
            }

            return result;
        }

    }







