/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinayak
 */
public class Tts extends Thread{
  /**
     * @param args the command line arguments
     */
    GuiForTTS caller;
    private String input,voice;
    public  Tts(String input,String voice,GuiForTTS caller){
    this.caller=caller;
    this.input=input;
    this.voice=voice;
    }
    public static void main(String args[]) {
    GuiForTTS.main(args);
    
    }
    
    public void executeWithWait(){
     caller.setSbutton("Stop");
    Speech b=new Speech(voice);
         long time;
    Engine a=new Engine(input);
    a.next();
    while(a.hasNext()){
        try {
            caller.setStatus("Playing");
            
            String sentence = a.next();
            System.out.println("Sentence:"+sentence);
            for (int j=0;j<3;j++) {
                time = 0;
                String to_Read[] = sentence.split("[+]");
                for (int i = 0; i < to_Read.length; i++) {
                    time += b.speak(to_Read[i]);
                    java.lang.Thread.sleep((int)500);
                }
                caller.setStatus("Waiting");
                java.lang.Thread.sleep(((int) (time/1000000)));        //waits two time the elapsed time
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Tts.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   
    
    caller.setSbutton("Start");
    caller.setStatus("Stopped");
    }
    
    @Override
    public void run(){
    executeWithWait();
    }
}
