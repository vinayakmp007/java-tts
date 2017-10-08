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
public class Speech {
  
 
 private String text; // string to speech
 
 Voice voice;
 VoiceManager voiceManager ;
 public Speech(String voices){
voiceManager = VoiceManager.getInstance();  //make the required hanges here like rate,speed
  voice = voiceManager.getVoice(voices);
  voice.allocate();
 
  }
 public long speak(String text) throws InterruptedException {                  //returns the elapsed time in nano seconds
  

     long t1=System.nanoTime();
       voice.speak(text);
    
       long t2=System.nanoTime();
       System.out.println("Duration:"+(t2-t1));
       
 return t2-t1;
 }
 
 
 
}
