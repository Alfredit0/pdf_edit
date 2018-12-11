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

/**
 *
 * @author unsis informatica
 */
public class CsvFileReader {
    public static void main(String[] args) {
        String csvPathTest="/CRTSYS/CONFIG/GRADES_PLAN_LE_2012.csv";
    }
    public String[][] getCsvContent (String csvPath){
        String [][] result = {};
                        
        File file= new File(csvPath);

        // this gives you a 2-dimensional array of strings
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;

        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(",");
                // this adds the currently parsed line to the 2-dimensional string array
                lines.add(Arrays.asList(values));
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
        return result;
    }
}
