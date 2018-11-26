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

/**
 *
 * @author unsis informatica
 */
public class CRTSYSTEM {
	public static final String SRC = "C:\\CRTSYS\\PLAN_2012.pdf";
    public static final String DEST = "C:\\CRTSYS\\OUTPUT\\PLAN_2012.pdf";
 
    public static void main(String[] args) throws IOException, DocumentException 
    {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        processPDF(SRC, DEST);
    }
	
    public static void processPDF(String src, String dest) throws IOException, DocumentException 
    {
        PdfReader reader = new PdfReader(src);
        PdfDictionary dict = reader.getPageN(1);
        PdfObject object = dict.getDirectObject(PdfName.CONTENTS);
        
        if (object instanceof PRStream) 
        {
            PRStream stream = (PRStream)object;
            byte[] data = PdfReader.getStreamBytes(stream);
            String dd = new String(data,"utf-8");
            //code to set initial variables configuration
            //Setting exam type vars
            
            for(int i=1;i<3;i++){
            String name = "CRS"+i;
            dd = dd.replaceFirst("C1", name );
            }                    
            //System.out.println(dd);
            String name = "C1";
            dd = dd.replaceFirst("CRS2", name );
           
            /*name = "C54";
            dd = dd.replace("CR4", name );
            name = "C55";
            dd = dd.replace("CR5", name );
            name = "C58";
            dd = dd.replace("CR6", name );
         */
           
            stream.setData(dd.getBytes("utf-8"));
        }        
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.close();
        reader.close();
    }
    
}
