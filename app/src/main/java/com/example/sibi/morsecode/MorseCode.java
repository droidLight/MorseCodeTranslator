package com.example.sibi.morsecode;


public class MorseCode{
    //Attributes

    public String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..",".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", "|" };//for checking

    private String[] morseTwo = { ".- ", "-... ", "-.-. ", "-.. ", ".  ", "..-. ", "--. ",
            ".... ", ".. ",".--- ", "-.- ", ".-.. ", "-- ", "-. ", "--- ", ".--. ",
            "--.- ", ".-. ", "... ", "- ", "..- ", "...- ", ".-- ", "-..- ",
            "-.-- ", "--.. ", ".---- ", "..--- ", "...-- ", "....- ", "..... ",
            "-.... ", "--... ", "---.. ", "----. ", "----- ", "| " };//for printing
    public String[] alpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0", " " };
    private String inText;
    private StringBuilder res = new StringBuilder();



    //methods

    public MorseCode(String inText){
        //1 for english to morse
        //2 for morse to english
        this.inText = inText;
    }
    public MorseCode(){

    }

    public String morseToEng(){
        String[] morseArray = this.inText.split(" ");
        for(String s: morseArray){
            for(int i=0; i<morse.length;i++){
                if(morse[i].equals(s)){
                    res.append(alpha[i]);
                }
            }
        }
        return res.toString();
    }
    public String engToMorse(){
        String[] alphaArray;
        alphaArray = this.inText.toUpperCase().split("");
        for(String a: alphaArray){
            for(int i=0; i<alpha.length; i++){
                if(alpha[i].equals(a)){
                    res.append(morseTwo[i]);
                }
            }
        }
        return res.toString();
    }



}