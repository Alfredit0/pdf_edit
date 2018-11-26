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
import java.util.List;
import org.apache.poi.hssf.util.CellReference;

public class ExcelReader {
    public static final String SAMPLE_XLSX_FILE_PATH = "C:\\CRTSYS\\KARDEX_1003A.xlsx";
    
    public static void main(String[] args) throws IOException, InvalidFormatException, DocumentException {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        /*
           =============================================================
           Iterating over all the sheets in the workbook (Multiple ways)
           =============================================================
        */

        // Retrieving Sheets using for-each loop
        for(Sheet sheet: workbook) {
            System.out.println("=> " + sheet.getSheetName());
        

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
        
        System.out.println("NOMBRE: "+name);

        //Getting dates
        
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
                        gradeR[1]=""+c.getNumericCellValue();
                    }
                }

            }
            finalGrades.add(gradeR);
        }
        /*finalExams.forEach((row) -> {
            System.out.println(row[0]+" :: "+row[1]);
        });*/
        CRTSYSTEM11 pdfCreator = new CRTSYSTEM11();
        pdfCreator.editAndGeneratePDF(name, finalDates, finalExams, finalGrades);
        }
        // Closing the workbook
        workbook.close();
    }
}
