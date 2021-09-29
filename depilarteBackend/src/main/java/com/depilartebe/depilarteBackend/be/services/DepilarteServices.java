package com.depilartebe.depilarteBackend.be.services;

import com.depilartebe.depilarteBackend.be.constants.DepilarteConstants;
import com.depilartebe.depilarteBackend.be.constants.GlobalConstants;
import com.depilartebe.depilarteBackend.be.entities.*;
import com.depilartebe.depilarteBackend.be.repository.*;
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
    GlobalServices globalServices;

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
    ChargersRepository chargersRepository;


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
            String phone,
            Long reference
            

    ) {
        Map<String, Object> mapResult = new HashMap<>();
        try {
            Register register = null;
            Date today = new Date();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

            if (id == null) {
                register = new Register();
            } else {
                register = registerRepository.findRegisterById(id);
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
            register.setTratamiento(treatment.toString());
            register.setTipoTratamiento(treatmentType.toString());
            register.setZonaTratamiento(treatmentZone);
            register.setCantidadSesiones(countSessions);
            register.setAsistencia(assistent);
            register.setProductoUtilizado(String.valueOf(product));
            register.setDisparosAntes(shotBefore);
            register.setDisparosDespues(shotAfter);
            register.setDiferenciaDisparos(shotDiferential);
            if (registerWorker == 1) {
                register.setUserAtendio(String.valueOf(doctor));
            } else {
                register.setUserAtendio(String.valueOf(operator));
            }
            register.setFormaPago(formPay.toString());
            register.setAbonado(abonado);
            register.setPrecioTotal(priceTotal);
            register.setComision(comission);
            register.setNota(note);
            register.setTelefono(phone);
            register.setReference(reference);
            register.setFechaAtendido(dt.format(today));
            registerRepository.save(register);

        } catch (Exception e) {
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

    ) {
        Map<String, Object> mapResult = new HashMap<>();
        Empleado empleado;
        try {
            Date today = new Date();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");


            if (id == null) {
                empleado = new Empleado();
            } else {
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
            empleado.setFechaIngreso(dt.format(today));
            empleadoRepository.save(empleado);

        } catch (Exception e) {
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
            String comission,
            String description
    ) {
        Map<String, Object> mapResult = new HashMap<>();

        try {
            Treatment treatment = null;

            if (id == null) {
                treatment = new Treatment();
            } else {
               treatment = treatmentRepository.findTreatmentById(id);
            }

            /** Registrando **/
            treatment.setNameTreatment(name);
            treatment.setEspecialista(String.valueOf(specialist));
            treatment.setCantidadSesiones(sessions);
            treatment.setComisionOperadora(comission);
            treatment.setDescripcionTratamiento(description);
            treatmentRepository.save(treatment);

            if(id != null){
                 List<TreatmentType> item = treatmentTypeRepository.findTypeTreatmentByIdForEdit(id);
                            for (int i = 0; i < type.size(); i++) {
                                    if(i < item.size()){
                                        String jsonString = type.get(i).toString().replace(" ", "-");
                                        String typex = jsonString;
                                        JSONObject obj = new JSONObject(typex);
                                        TreatmentType newType = treatmentTypeRepository.findTreatmentName(item.get(i).getNombreTipo());
                                        newType.setId_tratamientos(treatment.getId_tratamientos());
                                        newType.setNombreTipo(obj.get("typeTreatment").toString().replace("-", " "));
                                        newType.setPrecioTratamiento(obj.get("-typePrice").toString());
                                        treatmentTypeRepository.save(newType);
                                    }else{
                                        String jsonString = type.get(i).toString().replace(" ", "-");
                                        String typex = jsonString;
                                        JSONObject obj = new JSONObject(typex);
                                        TreatmentType typeT = new TreatmentType();
                                        typeT.setId_tratamientos(treatment.getId_tratamientos());
                                        typeT.setNombreTipo(obj.get("typeTreatment").toString().replace("-", " "));
                                        typeT.setPrecioTratamiento(obj.get("-typePrice").toString());
                                        treatmentTypeRepository.save(typeT);
                                    }
                            }

            }else{
                for (int i = 0; i < type.size(); i++) {
                    String jsonString = type.get(i).toString().replace(" ", "-");
                    String typex = jsonString;
                    JSONObject obj = new JSONObject(typex);
                    TreatmentType typeTre = new TreatmentType();
                    typeTre.setId_tratamientos(treatment.getId_tratamientos());
                    typeTre.setNombreTipo(obj.get("typeTreatment").toString().replace("-", " "));
                    typeTre.setPrecioTratamiento(obj.get("-typePrice").toString());
                    treatmentTypeRepository.save(typeTre);
                }
            }



        } catch (Exception e) {
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

    ) {
        Map<String, Object> mapResult = new HashMap<>();
        Products products;
        try {


            if (id == null) {
                products = new Products();
            } else {
                products = productRepository.findProductsById(id);
            }

            products.setNombre(product);
            products.setProveedor(proveedor);
            products.setCantidad(cantidad);
            products.setPrecio(precio);
            products.setSpecialist(specialist.toString());
            products.setDescripcion(description);
            productRepository.save(products);

        } catch (Exception e) {
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

    ) {
        Map<String, Object> mapResult = new HashMap<>();
        List<Map<String, Object>> mapList = new ArrayList<>();
        List<Register> registerList = new ArrayList<>();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");


        try {
            Treatment treatment = new Treatment();
            TreatmentType treatmentType = new TreatmentType();
            Users users = new Users();
            Products products = new Products();
            formaPay formPay = new formaPay();
            if (initialDate != null && finalDate != null) {
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                String initial = dt.format(dateInitial);
                registerList = registerRepository.findRegister(nameClient, lastNameClient, cedula, user, nameUser, initial, finale);
            } else if (initialDate != null) {
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                String initial = dt.format(dateInitial);
                registerList = registerRepository.findRegister(nameClient, lastNameClient, cedula, user, nameUser, initial, finalDate);
            } else if (finalDate != null) {
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                registerList = registerRepository.findRegister(nameClient, lastNameClient, cedula, user, nameUser, initialDate, finale);
            } else {
                registerList = registerRepository.findRegister(nameClient, lastNameClient, cedula, user, nameUser, initialDate, finalDate);
            }
            if (registerList != null) {
                for (Register register : registerList) {
                    Map<String, Object> result = new HashMap<>();
                    result.put("id", register.getId());
                    result.put("fechaAttemption", register.getFechaAtendido());
                    result.put("name", register.getNombre());
                    result.put("lastName", register.getApellido());
                    result.put("identification", register.getCedula());
                    result.put("birthday", register.getFechaCumple());
                    result.put("age", register.getEdad());
                    result.put("phone", register.getTelefono());
                    treatment = treatmentRepository.findTreatmentById(Long.valueOf(register.getTratamiento()));
                    result.put("treatment", treatment.getNameTreatment());
                    treatmentType = treatmentTypeRepository.findTreatmentTypeById(Long.valueOf(register.getTipoTratamiento()));
                    result.put("treatmentType", treatmentType.getNombreTipo());
                    result.put("shotsBefore", register.getDisparosAntes());
                    result.put("shotsAfter", register.getDisparosDespues());
                    result.put("shotsDifferential", register.getDiferenciaDisparos());
                    result.put("sessions", register.getCantidadSesiones());
                    result.put("assistents", register.getAsistencia());
                    if(register.getProductoUtilizado() != null){
                        products = productRepository.findProductsById(Long.valueOf(register.getProductoUtilizado()));
                        result.put("product", products.getNombre());
                    }else{
                        products = null;
                        result.put("product", products);
                    }
                    users = usersRepository.findUsernameById(Long.valueOf(register.getUserAtendio()));
                    result.put("userAttemption", users.getName());
                    formPay = formaPayRepository.findformaPayById(Long.valueOf(register.getFormaPago()));
                    result.put("formpay", formPay.getMetodoPago());
                    result.put("abonado", register.getAbonado());
                    result.put("comission", register.getComision());
                    result.put("price", register.getPrecioTotal());
                    mapList.add(result);
                }
                mapResult.put(RESULT_LIST_MAP, mapList);
            }


        } catch (Exception e) {
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
    ) {
        Map<String, Object> mapResult = new HashMap<>();
        List<Map<String, Object>> mapList = new ArrayList<>();
        List<Empleado> empleadoList = new ArrayList<>();
        Chargers chargers = new Chargers();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (initialDate != null && finalDate != null) {
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                String initial = dt.format(dateInitial);
                empleadoList = empleadoRepository.findWorkers(nameWorker, identification, charge, initial, finale);
            } else if (initialDate != null) {
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                String initial = dt.format(dateInitial);
                empleadoList = empleadoRepository.findWorkers(nameWorker, identification, charge, initial, finalDate);
            } else if (finalDate != null) {
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                empleadoList = empleadoRepository.findWorkers(nameWorker, identification, charge, initialDate, finale);
            } else {
                empleadoList = empleadoRepository.findWorkers(nameWorker, identification, charge, initialDate, finalDate);
            }
            if (empleadoList != null) {
                for (Empleado empleado : empleadoList) {
                    Map<String, Object> result = new HashMap<>();
                    result.put("id", empleado.getId());
                    result.put("fechaAttemption", empleado.getFechaIngresoo());
                    result.put("name", empleado.getNombre());
                    result.put("lastName", empleado.getApellido());
                    result.put("identification", empleado.getCedula());
                    result.put("age", empleado.getEdad());
                    result.put("email", empleado.getCorreo());
                    result.put("phone", empleado.getTelefono());
                    result.put("birthday", empleado.getNacimiento());
                    result.put("address", empleado.getDireccion());
                    chargers = chargersRepository.findNameById(empleado.getCargo());
                    result.put("charge", chargers.getNameCharge());
                    mapList.add(result);
                }
                mapResult.put(RESULT_LIST_MAP, mapList);
            }

        } catch (Exception e) {
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
    ) {
        Map<String, Object> mapResult = new HashMap<>();
        List<Map<String, Object>> mapList = new ArrayList<>();
        List<Treatment> treatmentList = new ArrayList<>();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if (initialDate != null && finalDate != null) {
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                String initial = dt.format(dateInitial);
                treatmentList = treatmentRepository.findTreatment(nameTreatment, specialistTreatment, initial, finale);
            } else if (initialDate != null) {
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                String initial = dt.format(dateInitial);
                treatmentList = treatmentRepository.findTreatment(nameTreatment, specialistTreatment, initial, finalDate);
            } else if (finalDate != null) {
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                treatmentList = treatmentRepository.findTreatment(nameTreatment, specialistTreatment, initialDate, finale);
            } else {
                treatmentList = treatmentRepository.findTreatment(nameTreatment, specialistTreatment, initialDate, finalDate);
            }
            if (treatmentList != null) {
                for (Treatment treatment : treatmentList) {

                    List<TreatmentType> treatmentTypeList = treatmentTypeRepository.finbTypeTreat(treatment.getId_tratamientos());
                    for (TreatmentType treatmentType : treatmentTypeList) {
                        Chargers chargers = new Chargers();
                        Map<String, Object> result = new HashMap<>();
                        result.put("id", treatment.getId_tratamientos());
                        result.put("name", treatment.getNameTreatment());
                        result.put("treatmentType", treatmentType.getNombreTipo());
                        chargers = chargersRepository.findNameById(String.valueOf(treatment.getEspecialista()));
                        result.put("specialist", chargers.getNameCharge());
                        result.put("sessions", treatment.getCantidadSesiones());
                        result.put("price", treatmentType.getPrecioTratamiento());
                        result.put("comission", treatment.getComisionOperadora());
                        mapList.add(result);
                    }
                }
                mapResult.put(RESULT_LIST_MAP, mapList);
            }

        } catch (Exception e) {
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

    ) {
        Map<String, Object> mapResult = new HashMap<>();
        List<Map<String, Object>> mapList = new ArrayList<>();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Chargers chargers = new Chargers();
            List<Products> productsList = new ArrayList<>();
            if (initialDate != null && finalDate != null) {
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                String initial = dt.format(dateInitial);
                productsList = productRepository.findProducts(product, specialist, initial, finale);
            } else if (initialDate != null) {
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateInitial = inputFormat.parse(initialDate);
                String initial = dt.format(dateInitial);
                productsList = productRepository.findProducts(product, specialist, initial, finalDate);
            } else if (finalDate != null) {
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dateFinal = inputFormat.parse(finalDate);
                String finale = dt.format(dateFinal);
                productsList = productRepository.findProducts(product, specialist, initialDate, finale);
            } else {
                productsList = productRepository.findProducts(product, specialist, initialDate, finalDate);
            }
            if (productsList != null) {
                for (Products products : productsList) {
                    Map<String, Object> result = new HashMap<>();
                    result.put("id", products.getId_productos());
                    result.put("nameProduct", products.getNombre());
                    result.put("proveedor", products.getProveedor());
                    result.put("cantidad", products.getCantidad());
                    chargers = chargersRepository.findNameById(products.getSpecialist());
                    result.put("specialist", chargers.getNameCharge());
                    result.put("price", products.getPrecio());
                    mapList.add(result);
                }
                mapResult.put(RESULT_LIST_MAP, mapList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;

    }

    public Map<String, Object> getEmpleados(
            Long id
    ) {
        Map<String, Object> mapResult = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        try {
            Empleado empleado = new Empleado();
            empleado = empleadoRepository.findWorkersById(id);

            result.put("id", empleado.getId());
            result.put("name", empleado.getNombre());
            result.put("lastName", empleado.getApellido());
            result.put("identification", empleado.getCedula());
            result.put("age", empleado.getEdad());
            result.put("email", empleado.getCorreo());
            result.put("phone", empleado.getNacimiento());
            result.put("birthday", empleado.getNacimiento());
            result.put("charge", Integer.valueOf(empleado.getCargo()));
            result.put("address", empleado.getDireccion());

        } catch (Exception e) {
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
    ) {
        Map<String, Object> mapResult = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        try {
            Products products = new Products();
            products = productRepository.findProductsById(id);

            result.put("id", products.getId_productos());
            result.put("product", products.getNombre());
            result.put("proveedor", products.getProveedor());
            result.put("cantidad", products.getCantidad());
            result.put("specialist", Long.valueOf(products.getSpecialist()));
            result.put("price", products.getPrecio());
            result.put("description", products.getDescripcion());

        } catch (Exception e) {
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
    ) {
        Map<String, Object> mapResult = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        try {
            Treatment treatment = new Treatment();
            treatment = treatmentRepository.findTreatmentById(id);
            List<TreatmentType> typeTreatmentList = new ArrayList<>();
            typeTreatmentList = treatmentTypeRepository.finbTypeTreat(id);

            result.put("id", treatment.getId_tratamientos());
            result.put("treatmentName", treatment.getNameTreatment());
            result.put("specialist", Long.valueOf(treatment.getEspecialista()));
            result.put("sessions", treatment.getCantidadSesiones());
            result.put("typePrice", typeTreatmentList);
            result.put("comission", treatment.getComisionOperadora());
            result.put("description", treatment.getDescripcionTratamiento());

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }

        return result;
    }

    public Map<String, Object> getPacientes(
            Long id
    ){
        Map<String, Object> mapResult = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        try {
            Register register = new Register();
            register = registerRepository.findRegisterById(id);

            result.put("id", id);
            result.put("userRegister", register.getRegisterUser());
            result.put("name", register.getNombre());
            result.put("lastName", register.getApellido());
            result.put("identification", register.getCedula());
            result.put("age", register.getEdad());
            result.put("email", register.getCorreo());
            result.put("birthday", register.getFechaCumple());
            result.put("address", register.getDireccion());
            result.put("treatment", Long.valueOf(register.getTratamiento()));
            result.put("treatmentType",Long.valueOf(register.getTipoTratamiento()));
            result.put("sessions", register.getCantidadSesiones());
            result.put("assistent", register.getAsistencia());
            result.put("product", Long.valueOf(register.getProductoUtilizado()));
            result.put("reference", Long.valueOf(register.getReference()));
            result.put("beforeShots", register.getDisparosAntes());
            result.put("afterShots", register.getDisparosDespues());
            result.put("diferents", register.getDiferenciaDisparos());
            if(register.getRegisterUser() == 1){
                result.put("userDoc", Long.valueOf(register.getUserAtendio()));
                result.put("userOp", EMPTY);
            }else{
                result.put("userOp",  Long.valueOf(register.getUserAtendio()));
                result.put("userDoc",EMPTY);
            }
            result.put("bono", register.getAbonado());
            result.put("formPay", Long.valueOf(register.getFormaPago()));
            result.put("totalPrice", register.getPrecioTotal());
            result.put("comission", register.getComision());
            result.put("phone", register.getTelefono());
            result.put("note", register.getNota());

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }

        return result;

    }

    public Map<String, Object> generateProductsExcel(
            String product,
            String specialist,
            String initialDate,
            String finalDate
    ) {
        Map<String, Object> mapResult = new HashMap<String, Object>();
        Map<String, Object> result = searchProducts(product, specialist, initialDate, finalDate);
        List<HashMap<String, Object>> map = (List<HashMap<String, Object>>) result.get(RESULT_LIST_MAP);
        List<String[]> values = new ArrayList<>();

        List<Products> productsList = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            Products products = new Products();
            HashMap<String, Object> elemnent = map.get(i);
            products.setId_productos((Long) elemnent.get("id"));
            products.setNombre((String) elemnent.get("nameProduct"));
            products.setProveedor((String) elemnent.get("proveedor"));
            products.setCantidad((String) elemnent.get("cantidad"));
            products.setSpecialist((String) elemnent.get("specialist"));
            products.setPrecio((String) elemnent.get("price"));
            productsList.add(products);
        }

        for (Products products : productsList) {
            String[] item = {
                    products.getNombre(),
                    products.getProveedor(),
                    products.getCantidad(),
                    products.getSpecialist(),
                    products.getPrecio(),
            };
            values.add(item);
        }

            try {
                String[] header = {PRODUCT_EXCEL_NAME,
                        PRODUCT_EXCEL_PROOVIDER,
                        PRODUCT_EXCEL_COUNT,
                        PRODUCT_EXCEL_ESPECIALISTA,
                        PRODUCT_EXCEL_PRECIO};

                SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_EXCEL);
                Date now = new Date();
                String date = formatter.format(now).replace(SPACE, EMPTY).replace(SLASH, EMPTY).replace(TWO_POINTS, EMPTY);
                String outputPath = PATH_EXCEL + date + EXCEL_EXTENSION;
                String encodeFile = globalServices.generateExcel(header, values, outputPath, EMPTY);
                mapResult.put(RESULT_ENCODED_STRING, encodeFile);
                mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);

            } catch (Exception e) {
                e.printStackTrace();
                result.put(MESSAGE, MESSAGE_ERROR);
                result.put(TYPE, MESSAGE_TYPE_ERROR);
                log.error("Se produjo un error getEstablishments (" + e.getMessage() + ")");

            }
            return mapResult;
    }


    public Map<String, Object> generateEmpleadosExcel(
            String nameWorker,
            String identification,
            Long charge,
            String initialDate,
            String finalDate
    ) {
        Map<String, Object> mapResult = new HashMap<String, Object>();
        Map<String, Object> result = searchWorkers(nameWorker, identification,charge, initialDate, finalDate);
        List<HashMap<String, Object>> map = (List<HashMap<String, Object>>) result.get(RESULT_LIST_MAP);
        List<String[]> values = new ArrayList<>();

        List<Empleado> empleadoList = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            Empleado empleado = new Empleado();
            HashMap<String, Object> elemnent = map.get(i);
            empleado.setFechaIngreso((String) elemnent.get("fechaAttemption"));
            empleado.setNombre((String) elemnent.get("name"));
            empleado.setApellido((String) elemnent.get("lastName"));
            empleado.setCedula((String) elemnent.get("identification"));
            empleado.setEdad((String) elemnent.get("age"));
            empleado.setCorreo((String) elemnent.get("email"));
            empleado.setTelefono((String) elemnent.get("phone"));
            empleado.setNacimiento((String) elemnent.get("birthday"));
            empleado.setDireccion((String) elemnent.get("address"));
            empleado.setCargo((String) elemnent.get("charge"));
            empleadoList.add(empleado);
        }

        for (Empleado empleado : empleadoList) {
            String[] item = {
                    empleado.getFechaIngresoo().toString(),
                    empleado.getNombre(),
                    empleado.getApellido(),
                    empleado.getCedula(),
                    empleado.getEdad(),
                    empleado.getCorreo(),
                    empleado.getTelefono(),
                    empleado.getNacimiento(),
                    empleado.getDireccion(),
                    empleado.getCargo()
            };
            values.add(item);
        }

        try {
            String[] header = {
                    WORKER_EXCEL_DATE,
                    WORKER_EXCEL_NAME,
                    WORKER_EXCEL_LASTNAME,
                    WORKER_EXCEL_IDENTIFICATION,
                    WORKER_EXCEL_AGE,
                    WORKER_EXCEL_EMAIL,
                    WORKER_EXCEL_PHONE,
                    WORKER_EXCEL_BIRTHDAY,
                    WORKER_EXCEL_ADDRESS,
                    WORKER_EXCEL_CHARGE};

            SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_EXCEL);
            Date now = new Date();
            String date = formatter.format(now).replace(SPACE, EMPTY).replace(SLASH, EMPTY).replace(TWO_POINTS, EMPTY);
            String outputPath = PATH_EXCEL + date + EXCEL_EXTENSION;
            String encodeFile = globalServices.generateExcel(header, values, outputPath, EMPTY);
            mapResult.put(RESULT_ENCODED_STRING, encodeFile);
            mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            result.put(MESSAGE, MESSAGE_ERROR);
            result.put(TYPE, MESSAGE_TYPE_ERROR);
            log.error("Se produjo un error getEstablishments (" + e.getMessage() + ")");
        }
        return mapResult;
    }

    public Map<String, Object> generateTreatmentsExcel(
            String nameTreatment,
            String specialistTreatment,
            String initialDate,
            String finalDate
    ) {
        Map<String, Object> mapResult = new HashMap<String, Object>();
        Map<String, Object> result = searchTreatment(nameTreatment, specialistTreatment,initialDate, finalDate);
        List<HashMap<String, Object>> map = (List<HashMap<String, Object>>) result.get(RESULT_LIST_MAP);
        List<String[]> values = new ArrayList<>();

        List<TreatmentExcel> treatmentList = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            TreatmentExcel treatment = new TreatmentExcel();
            HashMap<String, Object> elemnent = map.get(i);
            treatment.setNameTreatment((String) elemnent.get("name"));
            treatment.setTypeTreatment((String) elemnent.get("treatmentType"));
            treatment.setSpecialist((String) elemnent.get("specialist"));
            treatment.setSessions((String) elemnent.get("sessions"));
            treatment.setPrice((String) elemnent.get("price"));
            treatment.setComission((String) elemnent.get("comission"));
            treatmentList.add(treatment);
        }

        for (TreatmentExcel treatment : treatmentList) {
            String[] item = {
                    treatment.getNameTreatment(),
                    treatment.getTypeTreatment(),
                    treatment.getSpecialist(),
                    treatment.getSessions(),
                    treatment.getPrice() + DOLLAR,
                    treatment.getComission() + PERCENTAGE
            };
            values.add(item);
        }

        try {
            String[] header = {
                    TREATMENT_EXCEL_NAME,
                    TREATMENT_EXCEL_TYPE,
                    TREATMENT_EXCEL_SPECIALIST,
                    TREATMENT_EXCEL_CANTIDAD,
                    TREATMENT_EXCEL_PRICE,
                    TREATMENT_EXCEL_COMISSION,
          };

            SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_EXCEL);
            Date now = new Date();
            String date = formatter.format(now).replace(SPACE, EMPTY).replace(SLASH, EMPTY).replace(TWO_POINTS, EMPTY);
            String outputPath = PATH_EXCEL + date + EXCEL_EXTENSION;
            String encodeFile = globalServices.generateExcel(header, values, outputPath, EMPTY);
            mapResult.put(RESULT_ENCODED_STRING, encodeFile);
            mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            result.put(MESSAGE, MESSAGE_ERROR);
            result.put(TYPE, MESSAGE_TYPE_ERROR);
            log.error("Se produjo un error getEstablishments (" + e.getMessage() + ")");
        }
        return mapResult;
    }

    public Map<String, Object> generatePacientesExcel(
            String nameClient,
            String lastNameClient,
            String cedula,
            Long user,
            Long nameUser,
            String initialDate,
            String finalDate
    ) {
        Map<String, Object> mapResult = new HashMap<String, Object>();
        Map<String, Object> result = searchRegister(nameClient, lastNameClient,cedula, user,nameUser,initialDate,finalDate);
        List<HashMap<String, Object>> map = (List<HashMap<String, Object>>) result.get(RESULT_LIST_MAP);
        List<String[]> values = new ArrayList<>();

        List<Register> registerList = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            Register register = new Register();
            HashMap<String, Object> elemnent = map.get(i);
            register.setFechaAtendido((String) elemnent.get("fechaAttemption"));
            register.setNombre((String) elemnent.get("name"));
            register.setApellido((String) elemnent.get("lastName"));
            register.setCedula((String) elemnent.get("identification"));
            register.setFechaCumple((String) elemnent.get("birthday"));
            register.setEdad((String) elemnent.get("age"));
            register.setTelefono((String) elemnent.get("phone"));
            register.setEdad((String) elemnent.get("age"));
            register.setTelefono((String) elemnent.get("phone"));
            register.setTratamiento((String) elemnent.get("treatment"));
            register.setTipoTratamiento((String) elemnent.get("treatmentType"));
            register.setDisparosAntes((String) elemnent.get("shotsBefore"));
            register.setDisparosDespues((String) elemnent.get("shotsAfter"));
            register.setDiferenciaDisparos((String) elemnent.get("shotsDifferential"));
            register.setUserAtendio((String) elemnent.get("userAttemption"));
            register.setProductoUtilizado((String) elemnent.get("product"));
            register.setFormaPago((String) elemnent.get("formpay"));
            register.setAbonado((String) elemnent.get("abonado"));
            register.setComision((String) elemnent.get("comission"));
            register.setPrecioTotal((String) elemnent.get("price"));
            registerList.add(register);
        }

        for (Register register : registerList) {
            String[] item = {
                    register.getFechaAtendido(),
                    register.getNombre(),
                    register.getApellido(),
                    register.getCedula(),
                    register.getFechaCumple(),
                    register.getEdad(),
                    register.getTelefono(),
                    register.getTratamiento(),
                    register.getTipoTratamiento(),
                    register.getDisparosAntes(),
                    register.getDisparosDespues(),
                    register.getDiferenciaDisparos(),
                    register.getUserAtendio(),
                    register.getProductoUtilizado(),
                    register.getFormaPago(),
                    register.getAbonado() + DOLLAR,
                    register.getComision() + PERCENTAGE,
                    register.getPrecioTotal() + DOLLAR
            };
            values.add(item);
        }

        try {
            String[] header = {
                    REGISTER_EXCEL_DATE_ATT,
                    REGISTER_EXCEL_NAME,
                    REGISTER_EXCEL_LASTNAME,
                    REGISTER_EXCEL_CEDULA,
                    REGISTER_EXCEL_BIRTHDAY,
                    REGISTER_EXCEL_EDAD,
                    REGISTER_EXCEL_PHONE,
                    REGISTER_EXCEL_TREATMENT,
                    REGISTER_EXCEL_TYPE_TREATMENT,
                    REGISTER_EXCEL_DISPAROS_BEFORE,
                    REGISTER_EXCEL_DISPAROS_AFTER,
                    REGISTER_EXCEL_DISPAROS_DIFFERENTIAL,
                    REGISTER_EXCEL_PERSONAL,
                    REGISTER_EXCEL_PRODUCT,
                    REGISTER_EXCEL_FORMPAY,
                    REGISTER_EXCEL_ABONADO,
                    REGISTER_EXCEL_COMISSION,
                    REGISTER_EXCEL_PRICETOTAL
            };

            SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_EXCEL);
            Date now = new Date();
            String date = formatter.format(now).replace(SPACE, EMPTY).replace(SLASH, EMPTY).replace(TWO_POINTS, EMPTY);
            String outputPath = PATH_EXCEL + date + EXCEL_EXTENSION;
            String encodeFile = globalServices.generateExcel(header, values, outputPath, EMPTY);
            mapResult.put(RESULT_ENCODED_STRING, encodeFile);
            mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            result.put(MESSAGE, MESSAGE_ERROR);
            result.put(TYPE, MESSAGE_TYPE_ERROR);
            log.error("Se produjo un error getEstablishments (" + e.getMessage() + ")");
        }
        return mapResult;
    }


}







