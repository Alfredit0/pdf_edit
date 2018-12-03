/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crtsystem;

import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JTextArea;

/**
 *
 * @author unsis informatica
 */
/**
	105.	  This thread modifies a combo box by randomly adding
	106.	  and removing numbers. In order to ensure that the
	107.	  combo box is not corrupted, the editing operations are
	108.	  forwarded to the event dispatch thread.
	109.	*/ 
	class GoodWorkerThread extends Thread
	{ 
	  public GoodWorkerThread(JTextArea aCombo)
	  { 
	   combo = aCombo;
	   generator = new Random();
	  }
	
	  public void run()
	 { 
	   try
	   {
            while (!interrupted())
	     { 
                 	           int i =1;
		      EventQueue.invokeLater(new 
		        Runnable()
		        { 
	         public void run()
	         {                     
	           combo.setText(combo.getText()+"\n" + i);                   
		         }
		        });
                      
		      Thread.sleep(1); 
		     }
		   }
		   catch (InterruptedException exception) {} 
		  }
		
	private JTextArea combo;
	private Random generator;
	}