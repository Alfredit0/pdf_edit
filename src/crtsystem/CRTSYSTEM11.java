/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crtsystem;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.util.List;

/**
 *
 * @author unsis informatica
 */
public class CRTSYSTEM11 {
 
    public void editAndGeneratePDF(String pdfName,List<String[]> datesChangeData, 
            List<String[]> examsChangeData,
            List<String[]> gradesChangeData) throws IOException, DocumentException 
    {
        String SRC = "C:\\CRTSYS\\PLAN_2012.pdf";
        String DEST = "C:\\CRTSYS\\OUTPUT\\"+pdfName.trim().replace(" ", "_")+".pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        processPDF(SRC, DEST, datesChangeData, examsChangeData, gradesChangeData);
    }
	
    public static void processPDF(String src, String dest, List<String[]> datesChangeData,
            List<String[]> examsChangeData,
            List<String[]> gradesChangeData) throws IOException, DocumentException 
    {
        PdfReader reader = new PdfReader(src);
        PdfDictionary dict = reader.getPageN(1);
        PdfObject object = dict.getDirectObject(PdfName.CONTENTS);
        
        if (object instanceof PRStream) 
        {
            PRStream stream = (PRStream)object;
            byte[] data = PdfReader.getStreamBytes(stream);
            String dd = new String(data,"utf-8");
            
            for(String[] row: datesChangeData){
                 dd = dd.replaceFirst(row[0], row[1]);
            }      
           
            for(String[] row: examsChangeData){
                dd = dd.replaceFirst(row[0], row[1]);                
            } 
            
            for(String[] row: gradesChangeData){
                dd = dd.replaceFirst(row[0], row[1]);                
            }
            stream.setData(dd.getBytes("utf-8"));
        }        
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.close();
        reader.close();
    }
    
}