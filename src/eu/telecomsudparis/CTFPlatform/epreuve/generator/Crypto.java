package eu.telecomsudparis.CTFPlatform.epreuve.generator;

import eu.telecomsudparis.CTFPlatform.epreuve.generator.helper.Playfair;
import eu.telecomsudparis.CTFPlatform.epreuve.generator.helper.Vigenere;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.Scanner;


import javax.swing.JOptionPane;

/**
 * Générer l'épreuve de cryptographie
 */

public class Crypto extends EpreuveGenerator {
    /**
     * Créer l'épreuve
     */
    public void create() {
        runCrypto();
        creerEpreuve();
    }

    /**
     * Saisir le mot de passe et l'indice
     * Ecrire la classe LanceurLog
     */
    public void runCrypto() {
        //Choix d'un mot de passe qui n'est composé que de lettres
        String keyword = JOptionPane.showInputDialog(null, "Entrez le mot de passe que vous d�sirez (uniquement des lettres) : "
                + "", "Epreuve de cryptographie", JOptionPane.QUESTION_MESSAGE);

        while (!keyword.matches("[A-Za-z]+")) {
            JOptionPane.showMessageDialog(null, "Valeur entr�e invalide. Veuillez r�essayer.", "Epreuve de cryptographie"
                    + "", JOptionPane.ERROR_MESSAGE);
            keyword = JOptionPane.showInputDialog(null, "Entrez le mot de passe que vous d�sirez (uniquement des lettres) : "
                    + "", "Epreuve de cryptographie", JOptionPane.QUESTION_MESSAGE);
        }
        //Passage du mot de passe en majuscules

        keyword = keyword.toUpperCase();
        //eu.telecomsudparis.CTFPlatform.epreuve.generator.helper.Vigenere.motCode(keyword);

        // Le mot cl� pour eu.telecomsudparis.CTFPlatform.epreuve.generator.helper.Vigenere est EPREUVE
        String st = Vigenere.correspondEpreuve(keyword);
        String s = Playfair.CorrectString(st);

        //Choix d'un indice (composé uniquement de lettres) puis passage en majuscules

        String clue1 = JOptionPane.showInputDialog(null, "Veuillez entrer votre premier indice (uniquement des lettres)"
                + "", "Epreuve de cryptographie", JOptionPane.QUESTION_MESSAGE);

        while (!clue1.matches("[A-Za-z]+")) {
            JOptionPane.showMessageDialog(null, "Valeur entr�e invalide. Veuillez r�essayer.", "Epreuve de cryptographie"
                    + "", JOptionPane.ERROR_MESSAGE);
            clue1 = JOptionPane.showInputDialog(null, "Veuillez entrer votre premier indice (uniquement des lettres)"
                    + "", "Epreuve de cryptographie", JOptionPane.QUESTION_MESSAGE);
        }

        clue1 = clue1.toUpperCase();
        //Création du deuxième indice
        String clue2 = Playfair.deuxiemeIndice(clue1, s);

        //Ecriture dans un fichier de la classe LanceurCrypto
        //Permet de conserver les indices et le mot de passe

        File f = new File("./Ressources/eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveCrypto/LanceurCrypto.java");

        try {
            FileWriter fw = new FileWriter(f);

            fw.write("public class LanceurCrypto {");
            fw.write(String.valueOf(System.getProperty("line.separator")));

            fw.write("public static void main(String[] args) {");
            fw.write(String.valueOf(System.getProperty("line.separator")));

            fw.write("eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveCrypto epreuve = new eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveCrypto();");
            fw.write(String.valueOf(System.getProperty("line.separator")));

            fw.write("String clue1 = ");
            fw.write("\"");
            fw.write(clue1);
            fw.write("\";");
            fw.write(String.valueOf(System.getProperty("line.separator")));

            fw.write("clue1 = clue1.toUpperCase();");

            fw.write("String clue2 = ");
            fw.write("\"");
            fw.write(clue2);
            fw.write("\";");
            fw.write(String.valueOf(System.getProperty("line.separator")));

            fw.write("String keyword = ");
            fw.write("\"");
            fw.write(keyword);
            fw.write("\";");
            fw.write(String.valueOf(System.getProperty("line.separator")));

            fw.write("keyword.toUpperCase();");
            fw.write(String.valueOf(System.getProperty("line.separator")));

            fw.write("epreuve.creationEpreuve(clue1, clue2, keyword);}}");

            fw.close();

        } catch (IOException exception)

        {
            System.out.println("Erreur lors de la lecture :" + exception.getMessage());
        }


    }

    /**
     * Création de l'exécutable de l'épreuve dans un nouveau fichier
     */
    public void creerEpreuve() {

        File f = new File(".\\Ressources\\eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveCrypto\\Executable.bat");
        if (f.exists()) {
            try {
                Runtime.getRuntime().exec("cmd /c start .\\Ressources\\eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveCrypto\\Executable.bat");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "L'�preuve a bien �t� cr��e !", "Confirmation de cr�ation"
                        + "", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Impossible de cr�er l'�preuve. R�essayez", "Probl�me de cr�ation"
                    + "", JOptionPane.ERROR_MESSAGE);
        }
    }
}

