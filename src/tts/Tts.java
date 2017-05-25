/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
/**
 *
 * @author vinayak
 */
public class Tts {
  /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    Tts tssob=new Tts();     
    tssob.executeWithWait("Hello/hai this is/was me/him,when vinayak was/this,also this is/will be (working)","kevin");
    }
    
    public void executeWithWait(String input,String voice){
    
    Speech b=new Speech(voice);
         long time;
    Engine a=new Engine(input);
    while(a.hasNext()){
   time=b.speak(a.next());
    
    }
   
    
    
    
    }
}
