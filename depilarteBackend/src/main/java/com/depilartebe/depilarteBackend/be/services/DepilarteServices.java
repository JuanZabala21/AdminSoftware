package com.depilartebe.depilarteBackend.be.services;

import com.depilartebe.depilarteBackend.be.constants.DepilarteConstants;
import com.depilartebe.depilarteBackend.be.constants.GlobalConstants;
import com.depilartebe.depilarteBackend.be.entities.Empleado;
import com.depilartebe.depilarteBackend.be.entities.Register;
import com.depilartebe.depilarteBackend.be.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.depilartebe.depilarteBackend.be.repository.RegisterRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class DepilarteServices implements DepilarteConstants, GlobalConstants {
    static Logger log = LogManager.getLogger(DepilarteServices.class);

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    public Map<String, Object> registerClients(
        Long id,
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
            register.setOperadora(operator);
            register.setDoctora(doctor);
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
}
