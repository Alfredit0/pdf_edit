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
import java.util.Formatter;

/**
 *
 * @author unsis informatica
 */
public class CRTSYSTEM {
	public static final String SRC = "C:\\CRTSYS\\INPUT\\PLAN_LE_2012.pdf";
    public static final String DEST = "C:\\CRTSYS\\PLAN_2012.pdf";
 
    public static void main(String[] args) throws IOException, DocumentException 
    {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        processPDF(SRC, DEST);
    }
	
    public static void processPDF(String src, String dest) throws IOException, DocumentException 
    {
        PdfReader reader = new PdfReader(src);
        PdfDictionary dict = reader.getPageN(2);
        PdfObject object = dict.getDirectObject(PdfName.CONTENTS);
        
        if (object instanceof PRStream) 
        {
            PRStream stream = (PRStream)object;
            byte[] data = PdfReader.getStreamBytes(stream);
            String dd = new String(data,"utf-8");
            //code to set initial variables configuration
            //Setting exam type vars
            
            /*for(int i=1;i<10;i++){
            String name = "(G1"+i+")Tj";
            dd = dd.replace("(7.9)Tj", name );
            }               
           
            String name = "Hardware";
            dd = dd.replace("Hadware", name );
            
            name="Enfermer\\355a";
            dd = dd.replace("Enfemer\\355a", name );
            
            name="Psiquiatr\\355a";
            dd = dd.replace("Psiqui\\341tria", name );
            //name = "7.7";
            //dd = dd.replace("P.G", name );
            //dd = dd.replaceFirst("CRS6", name );
           
            /*name = "C54";
            dd = dd.replace("CR4", name );
            name = "C55";
            dd = dd.replace("CR5", name );
            name = "C58";
            dd = dd.replace("CR6", name );
         */
          
            dd = dd.replaceFirst("D1", "31" );
            dd = dd.replaceFirst("D2", "agosto" );
            dd = dd.replaceFirst("D3", "2017" );            
            dd = dd.replaceFirst("D4", "31/12/2013" );
            int folioNumber = 875;
            Formatter fmt = new Formatter();
            String auxFolio = "C";
            auxFolio = auxFolio + fmt.format("%04d",folioNumber);
            dd = dd.replaceFirst("FN0123456789", auxFolio );
            
            stream.setData(dd.getBytes("utf-8"));
            System.err.println(dd);
        }        
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.close();
        reader.close();
    }
    
}
