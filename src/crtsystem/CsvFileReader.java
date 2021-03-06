/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crtsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author unsis informatica
 */
public class CsvFileReader {
    public static List<String[]> getCsvContent (String csvPath){
      
                        
        File file= new File(csvPath);

        // this gives you a 2-dimensional array of strings
        List<String[]> lines = new ArrayList<>();
        Scanner inputStream;

        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(",");
                // this adds the currently parsed line to the string array
                lines.add(values);
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error en la configuración", 0);
            e.printStackTrace();
        }
        
        return lines;
    }
}
