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
   private static final String VOICENAME_KEVIN = "kevin";
 
 private String text; // string to speech
 
 Voice voice;
 VoiceManager voiceManager ;
 public Speech(String voices){
voiceManager = VoiceManager.getInstance();  //make the required hanges here like rate,speed
  voice = voiceManager.getVoice(voices);
  voice.allocate();
 
  }
 public long speak(String text) throws InterruptedException {                  //returns the elapsed time in nano seconds
  
/* voiceManager = VoiceManager.getInstance();
  voice = voiceManager.getVoice("kevin");
  voice.allocate();*/
  //voice.
     long t1=System.nanoTime();
       voice.speak(text);
    
       long t2=System.nanoTime();
       
 return t2-t1;
 }
 
 
 
}
