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
 private final String voice_s; //voice name
 Voice voice;
 VoiceManager voiceManager ;
 public Speech(String voice){

 voice_s=voice;
  }
 public void speak(String text) {
  
 voiceManager = VoiceManager.getInstance();
  voice = voiceManager.getVoice("kevin");
  voice.allocate();
  //voice.
  voice.speak(text);
 }
 
 
}
