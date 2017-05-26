/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts;



/**
 *
 * @author vinayak
 */
public class Engine {
protected String strings[];   
protected int pointer;
private void convert(String a){
String sentens[]=a.split("[,.]");                        //Splits the string at comas and fullstops 
String arr[];
int size;

size=sentens.length;
for(int i=0;i<size;i++){
    //System.out.println(sentens[i]);    
    arr=makeString(sentens[i]);                //creates the sentences and returns the array of all possible sentences
    addToStrings(arr);                          //copies all  the strings in array to the queue
//for(String ar:arr)System.out.println(ar);
}
}
    
public Engine(String s){
        this.strings = new String[1];
this.convert(s);
this.reset();
strings[0]="";
}   
public Engine(){
        this.strings = new String[1];
strings[0]="";

}  
private String [] makeString(String s){
String a[]=new String[1];                  //atmost 1 strings
a[0]="";
s=s.trim();                                       //trims s
s=s.replaceAll("\\([A-Za-z0-9 ]*\\)", "");                     //replace open and close bracket
System.out.println(s);
if(s.contains("/"))
{
String tem[];
tem=s.split(" ");
for(int i=0;i<tem.length;i++){
if(!tem[i].contains("/")){

    for(int k=0;k<a.length;k++){
    a[k]=a[k]+" "+tem[i];
    a[k]=a[k].trim();                   //removes extra space
        }

}
else {
String words[]=tem[i].split("/");
String pp[];
String tem_a[]=new String[a.length*words.length];
int k=0;
    for (String word : words) {
    for (int m=0;m<a.length;m++) {
     tem_a[k++]=a[m]+" "+word;   
      
    }
    
    }
pp=a;
a=tem_a;
}

}



}
else a[0]=s;
return a;
}

private void addToStrings(String s[]){
    String ss[]=new String[strings.length+s.length];
 System.arraycopy(strings, 0, ss,0, strings.length);
 System.arraycopy(s, 0, ss,strings.length, s.length); 
    
strings=ss;
}
public void reset(){
pointer=0;
}

public void setPointer(int a){
if(a>=0&&a<=strings.length)pointer=a;
else throw new NullPointerException();
}

public int getPointer(int a){
return pointer;
}

public boolean hasNext(){
if(pointer>=strings.length)return false;
else return true;
}

public boolean hasPrev(){
if(pointer<=0)return false;
else return true;
}
public String next(){

if (hasNext())return strings[pointer++];
else throw new NullPointerException();
}

public String prev(){

if (hasPrev())return strings[--pointer];
else throw new NullPointerException();
}

}
