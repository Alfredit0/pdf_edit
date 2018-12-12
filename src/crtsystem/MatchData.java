/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crtsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Impresion Fast
 */
public final class MatchData {
        /*public static final  String[][] DATES_MATCH_DATA = new String[][]{
            {"F/CH1","N20"},
            {"F/CH2","N21"},
            {"F/CH3","N22"},
            {"F/CH4","N23"},
            {"F/CH5","N24"},

            {"F/CH6","N28"},
            {"F/CH7","N29"},
            {"F/CH8","N30"},
            {"F/CH9","N31"},
            {"F/CH10","N32"},
            {"E/XC3","N33"},

            {"F/CH12","N37"},
            {"F/CH13","N38"},
            {"F/CH14","N39"},
            {"F/CH15","N40"},
            {"F/CH16","N41"},
            {"F/CH17","N42"},

            {"F/CH18","N46"},
            {"F/CH19","N47"},
            {"F/CH20","N48"},
            {"F/CH21","N49"},
            {"F/CH22","N50"},
            {"F/CH23","N51"},
            {"F/CH24","N52"},

            {"F/CH25","N56"},
            {"F/CH26","N57"},
            {"F/CH27","N58"},
            {"F/CH28","N59"},
            {"F/CH29","N60"},
            {"F/CH30","N61"},

            {"F/CH31","N80"},
            {"F/CH32","N81"},
            {"F/CH33","N82"},
            {"F/CH34","N83"},
            {"F/CH35","N84"},
            {"F/CH36","N85"},
            {"F/CH37","N86"},

            {"F/CH38","N90"},
            {"F/CH39","N91"},
            {"F/CH40","N92"},
            {"F/CH41","N93"},
            {"F/CH42","N94"},
            {"F/CH43","N95"},

            {"F/CH44","N99"},
            {"F/CH45","N100"},
            {"F/CH46","N101"},
            {"F/CH47","N102"},
            {"F/CH48","N103"},
            {"F/CH49","N104"},
            {"F/CH50","N105"},

            {"F/CH51","N109"},
            {"F/CH52","N110"},
            {"F/CH53","N111"},
            {"F/CH54","N112"},
            {"F/CH55","N113"},

            {"F/CH56","N117"},
            {"F/CH57","N118"},
            {"F/CH58","N119"}
      };

    public static final  String[][] EXAMS_MATCH_DATA = new String[][]{
        {"TEX1","L20"},
        {"TEX2","L21"},
        {"TEX3","L22"},
        {"TEX4","L23"},
        {"TEX5","L24"},

        {"TEX6","L28"},
        {"TEX7","L29"},
        {"TEX8","L30"},
        {"TEX9","L31"},
        {"TEX10","L32"},
        {"EXC1","L33"},

        {"TEX12","L37"},
        {"TEX13","L38"},
        {"TEX14","L39"},
        {"TEX15","L40"},
        {"TEX16","L41"},
        {"TEX17","L42"},

        {"TEX18","L46"},
        {"TEX19","L47"},
        {"TEX20","L48"},
        {"TEX21","L49"},
        {"TEX22","L50"},
        {"TEX23","L51"},
        {"TEX24","L52"},

        {"TEX25","L56"},
        {"TEX26","L57"},
        {"TEX27","L58"},
        {"TEX28","L59"},
        {"TEX29","L60"},
        {"TEX30","L61"},

        {"TEX31","L80"},
        {"TEX32","L81"},
        {"TEX33","L82"},
        {"TEX34","L83"},
        {"TEX35","L84"},
        {"TEX36","L85"},
        {"TEX37","L86"},

        {"TEX38","L90"},
        {"TEX39","L91"},
        {"TEX40","L92"},
        {"TEX41","L93"},
        {"TEX42","L94"},
        {"TEX43","L95"},

        {"TEX44","L99"},
        {"TEX45","L100"},
        {"TEX46","L101"},
        {"TEX47","L102"},
        {"TEX48","L103"},
        {"TEX49","L104"},
        {"TEX50","L105"},

        {"TEX51","L109"},
        {"TEX52","L110"},
        {"TEX53","L111"},
        {"TEX54","L112"},
        {"TEX55","L113"},

        {"TEX56","L117"},
        {"TEX57","L118"},
        {"TEX58","L119"}
        };
    public static final  String[][] GRADES_MATCH_DATA = new String[][]{
        {"CF1","K20", "M20"},
        {"CF2","K21", "M21"},
        {"CF3","K22", "M22"},
        {"CF4","K23", "M23"},
        {"CF5","K24", "M24"},

        {"CF6","K28", "M28"},
        {"CF7","K29", "M29"},
        {"CF8","K30", "M30"},
        {"CF9","K31", "M31"},
        {"CF10","K32", "M32"},
        {"EXC2","K33", "M33"},

        {"CF12","K37", "M37"},
        {"CF13","K38", "M38"},
        {"CF14","K39", "M39"},
        {"CF15","K40", "M40"},
        {"CF16","K41", "M41"},
        {"CF17","K42", "M42"},

        {"CF18","K46", "M46"},
        {"CF19","K47", "M47"},
        {"CF20","K48", "M48"},
        {"CF21","K49", "M49"},
        {"CF22","K50", "M50"},
        {"CF23","K51", "M51"},
        {"CF24","K52", "M52"},

        {"CF25","K56", "M56"},
        {"CF26","K57", "M57"},
        {"CF27","K58", "M58"},
        {"CF28","K59", "M59"},
        {"CF29","K60", "M60"},
        {"CF30","K61", "M61"},

        {"CF31","K80", "M80"},
        {"CF32","K81", "M81"},
        {"CF33","K82", "M82"},
        {"CF34","K83", "M83"},
        {"CF35","K84", "M84"},
        {"CF36","K85", "M85"},
        {"CF37","K86", "M86"},

        {"CF38","K90", "M90"},
        {"CF39","K91", "M91"},
        {"CF40","K92", "M92"},
        {"CF41","K93", "M93"},
        {"CF42","K94", "M94"},
        {"CF43","K95", "M95"},

        {"CF44","K99", "M99"},
        {"CF45","K100", "M100"},
        {"CF46","K101", "M101"},
        {"CF47","K102", "M102"},
        {"CF48","K103", "M103"},
        {"CF49","K104", "M104"},
        {"CF50","K105", "M105"},

        {"CF51","K109", "M109"},
        {"CF52","K110", "M110"},
        {"CF53","K111", "M111"},
        {"CF54","K112", "M112"},
        {"CF55","K113", "M113"},

        {"CF56","K117", "M117"},
        {"CF57","K118", "M118"},
        {"CF58","K119", "M119"},
        
        {"C.0123456789","O122", "O123"}         
    };*/
        public static  String DATEDDMMYYYY = "dd/MM/yyyy";
        public static  String DATEDAY = "dd";        
        public static  String DATEMONTH = "MMMM";
        public static  String DATEYEAR = "yyyy";
        
        public static  int FOLIO_NUMBER = 0000;
        
        public static String ACTUAL_PLAN="";
        
        public static List<String[]> UNIVERSITY_PLANS = new ArrayList<String[]>();
        
        public static List<String[]> DATES_MATCH_DATA;
        
        public static List<String[]> EXAMS_MATCH_DATA;
        
        public static List<String[]> GRADES_MATCH_DATA;
        

        public static List<String[]> getUNIVERSITY_PLANS() {
            return CsvFileReader.getCsvContent("/CRTSYS/CONFIG/PLANS.csv");            
        }
        
        public static boolean setPlanDataInVars(){
            if("".equals(ACTUAL_PLAN)||null==ACTUAL_PLAN)
                return false;
            else{
                DATES_MATCH_DATA = new ArrayList<String[]>();
        
                EXAMS_MATCH_DATA = new ArrayList<String[]>();
        
                GRADES_MATCH_DATA = new ArrayList<String[]>();
                
                DATES_MATCH_DATA = CsvFileReader.getCsvContent("/CRTSYS/CONFIG/DATES_"+ACTUAL_PLAN+".csv");
                
                EXAMS_MATCH_DATA = CsvFileReader.getCsvContent("/CRTSYS/CONFIG/EXAMS_"+ACTUAL_PLAN+".csv");
                
                GRADES_MATCH_DATA= CsvFileReader.getCsvContent("/CRTSYS/CONFIG/GRADES_"+ACTUAL_PLAN+".csv");
                
                if(DATES_MATCH_DATA.isEmpty()||EXAMS_MATCH_DATA.isEmpty()||GRADES_MATCH_DATA.isEmpty())
                    return false;
                
            }
            return true;
        }
}
