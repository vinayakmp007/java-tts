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
    private static final String VOICENAME_kevin = "kevin";
 private String text; // string to speech
 
 public Tts(String text) {
  this.text = text;
 }
 
 public void speak() {
  Voice voice;
  VoiceManager voiceManager = VoiceManager.getInstance();
  voice = voiceManager.getVoice(VOICENAME_kevin);
   Voice[] voices = voiceManager.getVoices();
    for (int i = 0; i < voices.length; i++) {
        System.out.println("    " + voices[i].getName()
                           + " (" + voices[i].getDomain() + " domain)");
    }
  voice.allocate();
  voice.speak(text);
 }
 
 public static void main(String[] args) {
      System.setProperty("mbrola.base","/home/vinayak/Downloads/mbr301h");
  String text = "FreeTTS was written by the Sun Microsystems Laboratories "
    + "Speech Team and is based on CMU's Flite engine.";
  Tts freeTTS = new Tts(text);
  freeTTS.speak();
 }
}
