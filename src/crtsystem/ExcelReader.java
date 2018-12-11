/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crtsystem;

/**
 *
 * @author Alfredo
 */
import com.itextpdf.text.DocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import org.apache.poi.hssf.util.CellReference;

public class ExcelReader {      
    /*public static void main(String[] args) throws IOException, InvalidFormatException, DocumentException {
        String testFilePath = "C:\\CRTSYS\\INPUT\\KARDEX_1003A_gen_12.xlsx";
        String result;
        result = readAndGenerate(testFilePath);
        System.err.println(result);
    }*/
    private int coutWorkBookPages;
    private int processPorcent;
    private String result="";
    public String readAndGenerate(String filePath) throws IOException, InvalidFormatException, DocumentException {
        String SAMPLE_XLSX_FILE_PATH = filePath;
        StringBuilder builder = new StringBuilder();
        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        builder.append("EL LIBRO TIENE ").append(workbook.getNumberOfSheets()).append(" HOJAS :");
        builder.append("\n");
        setCoutWorkBookPages(workbook.getNumberOfSheets());
        /*
           =============================================================
           Iterating over all the sheets in the workbook
           =============================================================
        */
        int i=0;
        // Retrieving Sheets using for-each loop
        for(Sheet sheet: workbook) {
            builder.append("\nHOJA => ").append(sheet.getSheetName());
            builder.append("\n");
            // Getting the Sheet at index zero
            //Sheet sheet = workbook.getSheetAt(0);
                        
            //Getting Full Name
            String name="";        
            CellReference ref;
            Row r;

            //Getting first name
            ref= new CellReference("K7");
            r = sheet.getRow(ref.getRow());
            if (r != null) {
               Cell c = r.getCell(ref.getCol());
               name=name+" "+c.getStringCellValue();
            } 
            //Getting second name
            ref= new CellReference("D7");
            r = sheet.getRow(ref.getRow());
            if (r != null) {
               Cell c = r.getCell(ref.getCol());
               name=name+" "+c.getStringCellValue();
            }      

            ref= new CellReference("E7");
            r = sheet.getRow(ref.getRow());
            if (r != null) {
               Cell c = r.getCell(ref.getCol());
               name=name+" "+c.getStringCellValue();
            } 

            builder.append("NOMBRE DEL ALUMNO: ").append(name);
            builder.append("\n");
            if(!"".equals(name)){
            int match_errors = 0;
            //Getting dates
            try{      
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");    
                List<String[]> finalDates = new ArrayList<String[]>();        
                for(String[] row:MatchData.DATES_MATCH_DATA){
                    String dateAux[]={"",""};
                    dateAux[0]=row[0];
                    ref= new CellReference(row[1]);
                    r = sheet.getRow(ref.getRow());
                    if (r != null) {
                       Cell c = r.getCell(ref.getCol());
                       dateAux[1]=format.format(c.getDateCellValue());
                    }
                    finalDates.add(dateAux);
                }

                //Getting Exams Type
                List<String[]> finalExams = new ArrayList<String[]>();        
                for(String[] row:MatchData.EXAMS_MATCH_DATA){
                    String examAux[]={"",""};
                    examAux[0]=row[0];
                    ref= new CellReference(row[1]);
                    r = sheet.getRow(ref.getRow());
                    if (r != null) {
                       Cell c = r.getCell(ref.getCol());
                       examAux[1]=c.getStringCellValue().toUpperCase().replace(" ","");
                    }
                    finalExams.add(examAux);
                }        

                //Getting Grades
                List<String[]> finalGrades = new ArrayList<String[]>();
                for(String[] row:MatchData.GRADES_MATCH_DATA){
                    String gradeR[]={"",""};
                    gradeR[0]=row[0];
                    ref= new CellReference(row[2]);
                    r = sheet.getRow(ref.getRow());
                    if (r != null) {
                       Cell c = r.getCell(ref.getCol());
                       if(c.getNumericCellValue()!=0){
                        gradeR[1]=""+c.getNumericCellValue();
                       }else{
                            ref= new CellReference(row[1]);
                            r = sheet.getRow(ref.getRow());
                            if (r != null) {
                                c = r.getCell(ref.getCol());
                                if(c.getNumericCellValue()!=0){
                                gradeR[1]=""+c.getNumericCellValue();
                                }else{                                    
                                    match_errors = match_errors+1;
                                }
                            }
                        }

                    }
                    finalGrades.add(gradeR);                    
                }
                if(match_errors==0){
                i=i+1;
                
                String auxFolio []= {"", ""};
                auxFolio[0]="FN0123456789";
                int folioNumber = MatchData.FOLIO_NUMBER+i;
                Formatter fmt = new Formatter();
                String strFinalFolioNumber = "C";
                strFinalFolioNumber = strFinalFolioNumber + fmt.format("%04d",folioNumber);
                auxFolio[1]= strFinalFolioNumber;
                //Improving Folio Number to replace
                finalGrades.add(auxFolio);
                builder.append("FOLIO => ").append(auxFolio[1]);
                                                    
                CRTSYSTEM11 pdfCreator = new CRTSYSTEM11();
                pdfCreator.editAndGeneratePDF(name, finalDates, finalExams, finalGrades);
                builder.append("\nARCHIVO GENERADO CORRECTAMENTE: ").append(name);
                builder.append("\n");
                }else{
                    builder.append("DATOS DEL ALUMNO INCOMPLETOS: ALGUNOS VALORES NO DEFINIDOS: ").append(name);
                    builder.append("\n");
                }
            }catch(Exception e){
                builder.append("NO SE GENERO ARCHIVO - DATOS INCOMPLETOS: ").append(name);
                builder.append("\n");
            }
            }else{
            builder.append("SIN NOMBRE DE HOJA");
            builder.append("\n");
            }
        }
        // Closing the workbook
        workbook.close();
        setResult(builder.toString());
        return builder.toString();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCoutWorkBookPages() {
        return coutWorkBookPages;
    }

    public void setCoutWorkBookPages(int coutWorkBookPages) {
        this.coutWorkBookPages = coutWorkBookPages;
    }

    public int getProcessPorcent() {
        return processPorcent;
    }

    public void setProcessPorcent(int processPorcent) {
        this.processPorcent = processPorcent;
    }
    
    
}
