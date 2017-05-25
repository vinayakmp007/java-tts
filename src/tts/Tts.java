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
    
    Speech b=new Speech(voice);
         long time;
    Engine a=new Engine(input);
    while(a.hasNext()){
        try {
            caller.setStatus("Playing");
            time=b.speak(a.next());
            caller.setStatus("Waiting");
            java.lang.Thread.sleep(0, ((int) (time/100000))*2);        //waits two time the elapsed time
            
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
