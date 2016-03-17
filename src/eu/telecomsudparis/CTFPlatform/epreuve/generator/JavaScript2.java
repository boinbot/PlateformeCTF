package eu.telecomsudparis.CTFPlatform.epreuve.generator;

import java.io.*;

import javax.swing.JOptionPane;

public class JavaScript2 extends EpreuveGenerator {

    public void create() {
        creerHTML();
        creerEpreuve();
    }

    public void creerHTML() {

		/*Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un mot de passe :");
		String theExpression = sc.nextLine();*/

        String theExpression = JOptionPane.showInputDialog(null, "Entrez le mot de passe que vous d�sirez : ",
                "Epreuve de eu.telecomsudparis.CTFPlatform.epreuve.generator.JavaScript", JOptionPane.QUESTION_MESSAGE);

        while (!theExpression.matches("[a-zA-Z0-9]+")) {
            JOptionPane.showMessageDialog(null, "Valeur entr�e vide. Veuillez entrer un mot de passe valide",
                    "Epreuve de eu.telecomsudparis.CTFPlatform.epreuve.generator.JavaScript", JOptionPane.ERROR_MESSAGE);
            theExpression = JOptionPane.showInputDialog(null, "Entrez le mot de passe que vous d�sirez : ",
                    "Epreuve de eu.telecomsudparis.CTFPlatform.epreuve.generator.JavaScript", JOptionPane.QUESTION_MESSAGE);
        }

        String theSymbol = "[[[[[[";
        int StartIndex = -1;
        String myTmpStr = null;
        String myOutputString = "";
        @SuppressWarnings("unused")
        boolean found = false;

        RandomAccessFile myInputFile = null;
        RandomAccessFile myOutputFile = null;
        String myLine = null;

        try {
            // --- Open the file
            myInputFile = new RandomAccessFile("./Ressources/eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveJavaScript/File.txt", "r");
            myOutputFile = new RandomAccessFile("eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveJavaScript.html", "rw");

            // --- Read line per line
            while ((myLine = myInputFile.readLine()) != null) {

                // --- Init the index for the new line
                StartIndex = -1;
                found = false;
                myOutputString = "";

                myTmpStr = myLine;
                // --- And for each line, search the pattern 'theSymbol' and try to comment it
                while (myTmpStr != "" && (StartIndex = myTmpStr.indexOf(theSymbol)) != -1) {

                    found = true;
                    myOutputString = myTmpStr.substring(0, StartIndex).concat(theExpression);
                    myTmpStr = myTmpStr.substring(StartIndex + theSymbol.length(), myTmpStr.length());
                }

                // --- Add the end of the line
                if (myTmpStr != "")
                    myOutputString += myTmpStr + "\n";

                else
                    // --- No symbol found, so just write the same line
                    myOutputString = "\n".concat(myLine);

                // --- Finally add this new line to the output file
                myOutputFile.write(myOutputString.getBytes());
            }

        } catch (IOException e) {
            System.err.println("IOException : " + e.getMessage());
        } finally {
            // --- Close the opened files
            try {
                myInputFile.close();
                myOutputFile.close();
            } catch (Exception e) {
                ; // --- Do nothing
            }
        }

        File f = new File("./Ressources/eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveJavaScript/LanceurJavaScript.java");

        try {
            FileWriter fw = new FileWriter(f);

            fw.write("public class LanceurJavaScript {");
            fw.write(String.valueOf(System.getProperty("line.separator")));

            fw.write("public static void main(String[] args) {");
            fw.write(String.valueOf(System.getProperty("line.separator")));

            fw.write("eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveJavaScript epreuve = new eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveJavaScript();");
            fw.write(String.valueOf(System.getProperty("line.separator")));


            fw.write("String keyword = ");
            fw.write("\"");
            fw.write(theExpression);
            fw.write("\";");
            fw.write(String.valueOf(System.getProperty("line.separator")));

            fw.write("epreuve.creationEpreuve(keyword);}}");

            fw.close();

        } catch (IOException exception)

        {
            System.out.println("Erreur lors de la lecture :" + exception.getMessage());
        }

    }

    public void creerEpreuve() {

        File f = new File(".\\Ressources\\eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveJavaScript\\Executable.bat");
        if (f.exists()) {
            try {
                Runtime.getRuntime().exec("cmd /c start .\\Ressources\\eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveJavaScript\\Executable.bat");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "L'�preuve a bien �t� cr��e !", "Confirmation de cr�ation",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Impossible de cr�er l'�preuve. R�essayez", "Probl�me de cr�ation",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


}