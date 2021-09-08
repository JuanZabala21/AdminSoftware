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
    TreatmentZoneRepository treatmentZoneRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RegisterRepository registerRepository;

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
            List<Integer> resultados= new ArrayList<>();

         
            for(int i=1; i<13; i++){
                 resultados.add(0);
                for(int j=0; j<registerPerMonth.size(); j++){
                    if(i==registerPerMonth.get(j).get(0)){
                        resultados.set(i-1, registerPerMonth.get(j).get(1));
                    }
                }
            }
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

}
