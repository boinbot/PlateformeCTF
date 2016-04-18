package eu.telecomsudparis.CTFPlatform.epreuve.generator;

import java.io.*;

public class Stegano2 extends EpreuveGenerator {

    public void create (){

        runSteganoAudio();
        creerEpreuve();
    }

    public void runSteganoAudio () {

        String codeMorse[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
                "...","-","..-","...-",".--","-..-","-.--","--..",
                ".-.-.-","-----",".----","..---","...--","....-",".....",
                "-...","--...","---..","----"};
        String corespondance = "ABCDEFGHIJKLMNOPQRSTUVWXYZ.0123456789";
        System.out.print("\nEntrer le mot à traduire\n->" );
        String x;
        x = lireString();
        x = x.toUpperCase();
        for (int i = 0; i < x.length();i++){
            for (int t = 0;t < corespondance.length();t++){
                if (x.charAt(i) == corespondance.charAt(t)){
                    System.out.print(" " + codeMorse[t] + "  " );
                    break;}
            }
        }
    }

    /**
     *  lecture d'une chaine
     */

    public static String lireString () {
        String ligne_lue = null ;
        try {
            InputStreamReader lecteur = new InputStreamReader (System.in) ;
            BufferedReader entree = new BufferedReader (lecteur) ;
            ligne_lue = entree.readLine() ;
        }
        catch (IOException err) {
            System.exit(0) ;
        }
        return ligne_lue ;
    }
}

