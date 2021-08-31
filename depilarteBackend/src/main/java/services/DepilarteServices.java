package services;

import constants.DepilarteConstants;
import constants.GlobalConstants;
import entities.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.RegisterRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.SimpleFormatter;

@Service
public class DepilarteServices implements DepilarteConstants, GlobalConstants {
    static Logger log = LogManager.getLogger(DepilarteServices.class);

    @Autowired
    RegisterRepository registerRepository;

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
        String note

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

            Date dateBirth = new SimpleDateFormat(DATE_FORMAT).parse(birthday);

            /** Registrando **/
            register.setNombre(clientName);
            register.setApellido(clientLastName);
            register.setCedula(identification);
            register.setEdad(age);
            register.setCorreo(email);
            register.setFechaCumple(dateBirth);
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
            register.setFechaAtendido(today);
            registerRepository.save(register);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se prudujo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
    }
}
