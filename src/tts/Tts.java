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
    Engine a=new Engine("Hello/hai this is/was me/him");
    while(a.hasNext()){
    
    System.out.println(a.next());
    }
    
    
    
    }
}
