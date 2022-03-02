package com.depilartebe.depilarteBackend.be.services;

import com.depilartebe.depilarteBackend.be.constants.DepilarteConstants;
import com.depilartebe.depilarteBackend.be.constants.GlobalConstants;
import com.depilartebe.depilarteBackend.be.entities.*;
import com.depilartebe.depilarteBackend.be.repository.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;


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
    ProductRepository productRepository;

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    ReferenceRepository referenceRepository;

    @Autowired
    GunValueRepository gunValueRepository;

    @Autowired
    TotalesRepository totalesRepository;

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

   public Map<String, Object> getReferences() {
    Map<String , Object> mapResult = new HashMap<>();
    try{
     List<References> reference = referenceRepository.findAll();
     mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);
     mapResult.put(REFERENCE, reference);


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
           Integer gunValue = gunValueRepository.getGunValue();
           mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);
           mapResult.put(GUNVALUERESULT, gunValue);
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

    public Map<String, Object> getPriceAndComision(String[] treatment) {
        Map<String, Object> mapResult = new HashMap<>();
        Integer comision = 0;
        Integer price = 0;

        try {
            TreatmentType treatmentType= new TreatmentType();
            if(!treatment[0].isEmpty()){
                for(String tratamiento: treatment){

                    treatmentType = treatmentTypeRepository.findPriceAndComision(Long.parseLong(tratamiento));
                    mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);
                    comision += Integer.valueOf(treatmentType.getComission());
                    price += Integer.valueOf(treatmentType.getPrecioTratamiento());
                }
                TreatmentType treatmentResult = new TreatmentType();
                treatmentResult.setComission(comision.toString());
                treatmentResult.setPrecioTratamiento(price.toString());

                mapResult.put(PRICE_RESULT, treatmentResult);

            }else{
                TreatmentType treatmentResult = new TreatmentType();
                treatmentResult.setComission("0");
                treatmentResult.setPrecioTratamiento("0");

                mapResult.put(PRICE_RESULT, treatmentResult);
            }

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
    }

    public Map<String, Object> getProducts() {
        Map<String , Object> mapResult = new HashMap<>();
 
        try{
            List<Products> products = productRepository.findAll();
            mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);
            mapResult.put(PRODUCT, products);
 
        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
 
    }

    public Map<String, Object> getDashboard() {
        Map<String , Object> mapResult = new HashMap<>();

        try{
            Dashboard dashboard= new Dashboard();

            Integer registerCount = registerRepository.findRegisterCount();
            Integer empleadosCount = empleadoRepository.findEmpleadosCount();
            Integer tratamientosCount = treatmentRepository.findTratamientosCount();
            Integer productosCount = productRepository.findProductosCount();
           
            List<List<Integer>> registerPerMonth = registerRepository.findRegisterByMonth();
            List<List<Integer>> registerPerMonthInstagram = registerRepository.findReferenceByMonthInstagram();
            List<List<Integer>> registerPerMonthAmigos = registerRepository.findReferenceByMonthAmigos();
            List<List<Integer>> registerPerMonthOtros = registerRepository.findReferenceByMonthOtros();
         
            List<Integer> resultados= new ArrayList<>();
            List<Integer> resultadosInstagram= new ArrayList<>();
            List<Integer> resultadosAmigos= new ArrayList<>();
            List<Integer> resultadosOtros= new ArrayList<>();


            for(int i=1; i<13; i++){
                resultadosInstagram.add(0);
               for(int j=0; j<registerPerMonthInstagram.size(); j++){
                   if(i==registerPerMonthInstagram.get(j).get(0)){
                       resultadosInstagram.set(i-1, registerPerMonthInstagram.get(j).get(1));
                   }
               }
           }
           for(int i=1; i<13; i++){
            resultadosAmigos.add(0);
           for(int j=0; j<registerPerMonthAmigos.size(); j++){
               if(i==registerPerMonthAmigos.get(j).get(0)){
                resultadosAmigos.set(i-1, registerPerMonthAmigos.get(j).get(1));
               }
           }
       }
        
        for(int i=1; i<13; i++){
            resultadosOtros.add(0);
        for(int j=0; j<registerPerMonthOtros.size(); j++){
            if(i==registerPerMonthOtros.get(j).get(0)){
                resultadosOtros.set(i-1, registerPerMonthOtros.get(j).get(1));
            }
        }
    }
    
         
            for(int i=1; i<13; i++){
                 resultados.add(0);
                for(int j=0; j<registerPerMonth.size(); j++){
                    if(i==registerPerMonth.get(j).get(0)){
                        resultados.set(i-1, registerPerMonth.get(j).get(1));
                    }
                }
            }
            
            dashboard.setRegisterPerInstagram(resultadosInstagram);
            dashboard.serRegisterPerMonthAmigos(resultadosAmigos);
            dashboard.setRegisterPerMonthOtros(resultadosOtros);
            dashboard.setRegisterPerMonth(resultados);
            dashboard.setRegisterCount(registerCount);
            dashboard.setEmpleadosCount(empleadosCount);
            dashboard.setTratamientosCount(tratamientosCount);
            dashboard.setProductosCount(productosCount);

            mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);
            mapResult.put(DASHBOARD, dashboard);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
 
    }

    public String generateExcel (String[] header,
                                      List<String[]> values,
                                      String outputPath,
                                      String filename) {
        try{
            int cont = ONE;
            Workbook workbook = new XSSFWorkbook();
            Sheet page = workbook.createSheet(TITLE_REPORT_DEPILARTE);
            CellStyle cellStyleHeader = workbook.createCellStyle();
            cellStyleHeader.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            cellStyleHeader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            cellStyleHeader.setAlignment(CellStyle.ALIGN_CENTER);
            Font font = workbook.createFont();
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setBold(true);
            cellStyleHeader.setFont(font);
            Row headerRow = page.createRow(ZERO);
            for (int i = ZERO; i < header.length; i++) {
                Cell headerCell = headerRow.createCell(i);
                headerCell.setCellValue(header[i]);
                headerCell.setCellStyle(cellStyleHeader);
                page.autoSizeColumn(i);
            }
            CellStyle cellStyleRow = workbook.createCellStyle();
            cellStyleRow.setAlignment(CellStyle.ALIGN_CENTER);
            for (String[] value : values) {
                Row valuesRow = page.createRow(cont);
                for (int j = ZERO; j < value.length; j++) {
                    Cell valuesCell = valuesRow.createCell(j);
                    valuesCell.setCellValue(value[j]);
                    valuesCell.setCellStyle(cellStyleRow);
                    page.autoSizeColumn(j);
                }
                cont++;
            }

            File file = new File(outputPath);
            FileOutputStream output = new FileOutputStream(file);
            workbook.write(output);
            File createdFile = new File(outputPath);
            byte[] fileContent = FileUtils.readFileToByteArray(createdFile);
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
            createdFile.delete();

            return encodedString;
        }catch (Exception e){
            e.printStackTrace();
            log.error("Se produjo un error generateExcel. (" + e.getMessage() + ")");
            return EMPTY_STRING;
        }

    }

    public Map<String, Object> updateGun(
            String gunValue
    ) {
        Map<String , Object> mapResult = new HashMap<>();

        try{
           GunValue values = gunValueRepository.findByIdUpdate();
           values.setCantidadDisparos(gunValue);
           gunValueRepository.save(values);
            mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;

    }

    public Map<String, Object> getWorkers() {
        Map<String , Object> mapResult = new HashMap<>();

        try{
            List<Empleado> empleadoList = empleadoRepository.findAll();
            mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);
            mapResult.put(EMPLEADORESULT, empleadoList);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
    }

    public Map<String, Object> getSaldo() {
        Map<String , Object> mapResult = new HashMap<>();

        try{
            Totales efectivo = totalesRepository.findByIdUpdate();
            mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);
            mapResult.put(EMPLEADORESULT, efectivo.getEfectivo());

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Se produjo un error: " + e.getMessage());
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
    }



}
