package eu.telecomsudparis.CTFPlatform.epreuve.generator;

import java.io.*;

import javax.swing.JOptionPane;

/**
 * SteganoAudio est la classe représentant une épreuve de steganographie audio
 * Cette épreuve de stéganographie cosiste à dissimuler un mot de passe de 8 lettres dans une chanson.
 *
 */
public class SteganoAudio extends EpreuveGenerator {

    /**
     * Crée une nouvelle épreuve SteganoAudio
     * @see runSteganoAudio
     * @see creerEpreuve
     */
    public void create() {
        runSteganoAudio();
        creerEpreuve();
    }

    /**
     *  Saisir un mot de 8 lettres
     *  Traduire ce mot de passe en morse
     *  Créer le fichier audio associé au code morse
     *  Concaténer le fichier audio dans une chanson
     */
    public void runSteganoAudio() {

        String str = JOptionPane.showInputDialog(null, "Entrez le mot de passe que vous désirez (8 caractères OBLIGATOIREMENT) : "
                + "", "Epreuve de stéganographie", JOptionPane.QUESTION_MESSAGE);


        while ((!str.matches("[a-zA-Z]+")) || (str.length() != 8)) {
            JOptionPane.showMessageDialog(null, "Valeur entrée invalide. Veuillez entrer un mot de 8 lettres.",
                    "Epreuve de stéganographie", JOptionPane.ERROR_MESSAGE);
            str = JOptionPane.showInputDialog(null, "Entrez le mot de passe que vous d�sirez (8 lettres OBLIGATOIREMENT) : ",
                    "Epreuve de stéganographie", JOptionPane.QUESTION_MESSAGE);
        }


         function creerMatrice(num) {
             for (var i = 1; i <= num; i++) {
                 this[i] = "";
                 this.length = num;
             }
         }

         var MORSE = new creerMatrice(30);
         var AVIATION = new creerMatrice(30);

         MORSE[01] = ".-"
         MORSE[02] = "-..."
         MORSE[03] = "-.-."
         MORSE[04] = "-.."
         MORSE[05] = "."
         MORSE[06] = "..-."
         MORSE[07] = "--."
         MORSE[08] = "...."
         MORSE[09] = ".."
         MORSE[10] = ".---"
         MORSE[11] = "-.-"
         MORSE[12] = ".-.."
         MORSE[13] = "--"
         MORSE[14] = "-."
         MORSE[15] = "---"
         MORSE[16] = ".--."
         MORSE[17] = "--.-"
         MORSE[18] = ".-."
         MORSE[19] = "..."
         MORSE[20] = "-"
         MORSE[21] = "..-"
         MORSE[22] = "...-"
         MORSE[23] = ".--"
         MORSE[24] = "-..-"
         MORSE[25] = "-.--"
         MORSE[26] = "--.."
         MORSE[27] = "."
         MORSE[28] = "."
         MORSE[29] = "."
         MORSE[30] = "."

         CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ����"

         function CODE(LETTRE){
             if(LETTRE == " "){
                return " "
             }
            for(tg=0; tg<31; tg++) {

                var LT = CARACTERES.charAt(tg)
                if(LT == LETTRE){
                    return MORSE[tg +1]
                }
             }
         return ""
         }

         function GO() {
             var text = document.entree.valeur.value
             text = " " + text.toUpperCase()
             var MSG = ""
             NUM = text.length
             for(t = 0; t <= NUM-1; t++){
                MSG = MSG + ( CODE(text.charAt(t)) + " ") ;
             }
             document.entree.OUTPUT.value = MSG
         }
    }

    /**
     * Création de l'exécutable de l'épreuve dans un nouveau fichier
     */
    public void creerEpreuve() {

        File f = new File(".\\Ressources\\eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveSteganoAudio\\Executable.bat");
        if (f.exists()) {
            try {
                Runtime.getRuntime().exec("cmd /c start .\\Ressources\\eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveSteganoAudio\\Executable.bat");
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "L'épreuve a bien été créée !", "Confirmation de création",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Impossible de créer l'épreuve. Réessayez", "Problème de création",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}