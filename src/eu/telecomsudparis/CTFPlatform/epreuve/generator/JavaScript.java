package eu.telecomsudparis.CTFPlatform.epreuve.generator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.swing.JOptionPane;

/**
 * Générer l'epreuve Stegano 3
 *
 */
public class JavaScript extends EpreuveGenerator {
    /**
     * Crée l'épreuve Stegano3
     */
    public void create() {
        try {
            String mdp = mdp();
            int n1 = valeur1();
            int n2 = valeur2(n1);
            int c = colonne();
            int l = ligne();
            ecrireHtml();
            String[] tableau = liretxt();
            ecriretxt(tableau, mdp, n1, n2, c, l);
            File f = new File("./Ressources/eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano3/CandideV2.txt");
            String txt = loadFile(f);
            ecrireEpreuve(txt);
            creerJava(mdp);
            creerEpreuve();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Insert chaque ligne du texte Candide dans une case d'un tableau
     * @return le tableau avec les lignes du Candide
     * @throws IOException
     */
    public String[] liretxt() throws IOException {
        BufferedReader lecteurAvecBuffer = null;
        String ligne;
        String[] tableau = new String[123];
        int i = 0;

        try {
            lecteurAvecBuffer = new BufferedReader(new FileReader("./Ressources/eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano3/Candide.txt"));
        } catch (FileNotFoundException exc) {
            System.out.println("Erreur d'ouverture");
        }

        while ((ligne = lecteurAvecBuffer.readLine()) != null) {
            tableau[i] = ligne;
            i++;
        }
        lecteurAvecBuffer.close();
        return tableau;
    }

    /**
     *Crée le fichier texte avec le mot de passe ainsi que les indices concernant son emplacement
     * @param tableau
     *              contient le texte, le mot de passe et les indices
     * @param mdp
     *              mot de passe caché dans le texte
     * @param n1
     *              Position de l'indice ligne
     * @param n2
     *              Position de l'indice colonne
     * @param c
     *              n° de colonne du mot de passe
     * @param l
     *              n° de ligne du mot de passe
     * @throws IOException
     */
    public void ecriretxt(String[] tableau, String mdp, int n1, int n2, int c, int l) throws IOException {

        File f = new File("./Ressources/eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano3/CandideV2.txt");

        try {
            FileWriter fw = new FileWriter(f);

            tableau[0] = "<p></p>" + tableau[0];

            for (int i = 1; i < 123; i++) {

                if (i == n1) {
                    tableau[n1] = " <p style = \\\"display:none;\\\"> L i g n e =" + l + "</p> " + tableau[n1];
                } else if (i == n2) {
                    tableau[n2] = " <p style =\\\"display:none;\\\"> C o l o n n e =" + c + "</p><p></p>" + tableau[n2];
                } else {
                    tableau[i] = " <p></p>" + tableau[i];
                }
            }

            String[] phrase = tableau[l - 1].split(" ");
            phrase[c] = mdp;
            System.out.println(tableau[l - 1]);

            tableau[l - 1] = "";

            int longueur = phrase.length;
            for (int i = 0; i < longueur; i++) {
                if (i == c) {
                    tableau[l - 1] = tableau[l - 1] + " " + mdp;
                } else {
                    if (i == 0) {
                        tableau[l - 1] = tableau[l - 1] + phrase[i];
                    } else {
                        tableau[l - 1] = tableau[l - 1] + " " + phrase[i];
                    }
                }
            }

            //tableau[l] = phrase.join(" ");

            System.out.println(tableau[l - 1]);

            for (int i = 0; i < 123; i++) {
                fw.write(tableau[i]);
                //fw.write('"');
                //fw.write(String.valueOf(System.getProperty("line.separator")));
            }

            fw.close();

        } catch (IOException exception)

        {
            System.out.println("Erreur lors de la lecture :" + exception.getMessage());
        }
    }

    /**
     * Charge le fichier
     * @param f
     *              fichier a charger
     * @return
     */
    public String loadFile(File f) {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
            StringWriter out = new StringWriter();
            int b;
            while ((b = in.read()) != -1)
                out.write(b);
            out.flush();
            out.close();
            in.close();
            return out.toString();
        } catch (IOException ie) {
            ie.printStackTrace();
            return "Erreur";
        }
    }

    /**
     * Transforme un fichier texte en un fichier javascript
     * @param txt
     *
     */
    public void ecrireEpreuve(String txt) {
        File f = new File("eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano3.js");

        try {
            FileWriter fw = new FileWriter(f);

            fw.write("var paragraphe = new Array(10000);\n\n");

            fw.write("document.writeln(\"\");\n\n");

            fw.write("paragraphe[0] = \"");
            fw.write(txt);
            fw.write('"');
            fw.write(";\n\n");

            fw.write("paragraphe[0] = paragraphe[0].split(\" \");\n\n");
            fw.write("var n = paragraphe[0].length;\n\n");
            fw.write("var m = Math.floor(n/10);\n\n");
            fw.write("var d = n%10;\n\n");
            fw.write("var conteneur = new Array();\n");
            fw.write("var ligne = new Array();\n\n");
            fw.write("for (var k=0; k<m; k++){\n");
            fw.write("conteneur = paragraphe[0].slice(k*10, (k+1)*10);\n");
            fw.write("ligne[k] = conteneur.join(\" \");}\n\n");

            fw.write("conteneur = paragraphe[0].slice(m*10, m*10+d+1);\n");
            fw.write("ligne[m] = conteneur.join(\" \");\n\n");

            fw.write("for (var j=0; j<m+1; j++){\n");
            fw.write("document.writeln(ligne[j]);}\n");

            fw.close();

        } catch (IOException exception)

        {
            System.out.println("Erreur lors de la lecture :" + exception.getMessage());
        }
    }

    /**
     * Ecrit une page HTML à partir du fichier javascript
     */
    public void ecrireHtml() {
        File f = new File("eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano3.html");

        try {
            FileWriter fw = new FileWriter(f);

            fw.write("<html>\n\n");

            fw.write("<head>\n\n");

            fw.write("  <meta charset=\"iso-8859-1\" />\n");
            fw.write("  <title>eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano3</title>\n\n");
            fw.write("</head>\n\n\n");
            fw.write("<body>\n\n");

            fw.write("  <PRE>\n\n");
            fw.write("    <script src=\"eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano3.js\"></script>\n\n");
            fw.write("  </PRE>\n\n");
            fw.write("</body>\n\n");
            fw.write("</html>");

            fw.close();

        } catch (IOException exception)

        {
            System.out.println("Erreur lors de la lecture :" + exception.getMessage());
        }
    }

    /**
     * Saisir le mot de passe à retrouver
     * @return le mot de passe saisie
     */
    public String mdp() {
        String mdp = JOptionPane.showInputDialog(null, "Entrez le mot de passe que vous désirez (composé de "
                + "lettres OBLIGATOIREMENT) : ", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);


        while ((!mdp.matches("[a-zA-Z]+"))) {
            JOptionPane.showMessageDialog(null, "Valeur entrée invalide. Veuillez entrer un mot composé de lettres "
                    + "", "Epreuve de Stéganographie n°3", JOptionPane.ERROR_MESSAGE);
            mdp = JOptionPane.showInputDialog(null, "Entrez le mot de passe que vous désirez (composé de "
                    + "lettres OBLIGATOIREMENT) : ", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);
        }

        return mdp;
    }

    /**
     * Saisir la valeur de la position de l'indice ligne
     * @return la valeur de l'indice ligne
     */
    public int valeur1() {

        boolean b1 = false;
        int n1 = 0;
        String valeur1 = JOptionPane.showInputDialog(null, "Veuillez entrer un premier nombre entre 0 et 122 : "
                + "", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);

        if (valeur1 == null) {
            System.exit(0);
        }

        while (!b1) {
            try {
                n1 = Integer.parseInt(valeur1);
                b1 = true;
                while (n1 < 0 || n1 > 122) {
                    JOptionPane.showMessageDialog(null, "Valeur entrée invalide. Veuillez réessayer."
                            + "", "Epreuve de Stéganographie n°3", JOptionPane.ERROR_MESSAGE);
                    valeur1 = JOptionPane.showInputDialog(null, "Veuillez entrer un premier nombre entre 0 et 122 : "
                            + "", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);
                    try {
                        n1 = Integer.parseInt(valeur1);
                    } catch (NumberFormatException e) {
                    }

                }
            } catch (NumberFormatException e) {
                if (valeur1 == null) {
                    System.exit(0);
                }
                JOptionPane.showMessageDialog(null, "Valeur entrée invalide. Veuillez réessayer."
                        + "", "Epreuve de Stéganographie n°3", JOptionPane.ERROR_MESSAGE);
                valeur1 = JOptionPane.showInputDialog(null, "Veuillez entrer un premier nombre entre 0 et 122 : "
                        + "", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);
            }
        }
        return n1;
    }

    /**
     * Saisir la valeur de la position de l'indice colonne différent de la position de l'indice ligne
     * @param n2
     *              valeur de l'indice ligne
     * @return la valeur de l'indice colonne
     */
    public int valeur2(int n2) {

        boolean b1 = false;
        int n1 = 0;
        String valeur1 = JOptionPane.showInputDialog(null, "Veuillez entrer un second nombre entre 0 et 122 différent de " + n2 + " : "
                + "", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);

        if (valeur1 == null) {
            System.exit(0);
        }

        while (!b1) {
            try {
                n1 = Integer.parseInt(valeur1);
                b1 = true;
                while (n1 < 0 || n1 > 122 || n1 == n2) {
                    JOptionPane.showMessageDialog(null, "Valeur entrée invalide. Veuillez réessayer."
                            + "", "Epreuve de Stéganographie n°3", JOptionPane.ERROR_MESSAGE);
                    valeur1 = JOptionPane.showInputDialog(null, "Veuillez entrer un second nombre entre 0 et 122 différent de " + n2 + " : "
                            + "", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);
                    try {
                        n1 = Integer.parseInt(valeur1);
                    } catch (NumberFormatException e) {
                    }

                }
            } catch (NumberFormatException e) {
                if (valeur1 == null) {
                    System.exit(0);
                }
                JOptionPane.showMessageDialog(null, "Valeur entrée invalide. Veuillez réessayer."
                        + "", "Epreuve de Stéganographie né3", JOptionPane.ERROR_MESSAGE);
                valeur1 = JOptionPane.showInputDialog(null, "Veuillez entrer un second nombre entre 0 et 122 : "
                        + "", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);
            }
        }
        return n1;
    }

    /**
     * Saisir la colonne dans laquelle positionner le mot de passe
     * @return la valeur de la colonne où sera placé le mot de passe
     */
    public int colonne() {

        boolean b1 = false;
        int n1 = 0;
        String valeur1 = JOptionPane.showInputDialog(null, "Veuillez entrer le numéro de colonne désiré entre 1 et 10 : "
                + "", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);

        if (valeur1 == null) {
            System.exit(0);
        }

        while (!b1) {
            try {
                n1 = Integer.parseInt(valeur1);
                b1 = true;
                while (n1 < 1 || n1 > 10) {
                    JOptionPane.showMessageDialog(null, "Valeur entr�e invalide. Veuillez réessayer."
                            + "", "Epreuve de Stéganographie n°3", JOptionPane.ERROR_MESSAGE);
                    valeur1 = JOptionPane.showInputDialog(null, "Veuillez entrer le numéro de colonne désiré entre 1 et 10 : "
                            + "", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);
                    try {
                        n1 = Integer.parseInt(valeur1);
                    } catch (NumberFormatException e) {
                    }
                }
            } catch (NumberFormatException e) {
                if (valeur1 == null) {
                    System.exit(0);
                }
                JOptionPane.showMessageDialog(null, "Valeur entrée invalide. Veuillez réessayer."
                        + "", "Epreuve de Stéganographie n°3", JOptionPane.ERROR_MESSAGE);
                valeur1 = JOptionPane.showInputDialog(null, "Veuillez entrer le numéro de colonne désiré entre 1 et 10 : "
                        + "", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);
            }
        }
        return n1;
    }

    /**
     * Saisir la ligne dans laquelle positionner le mot de passe
     * @return la valeur de la ligne où sera placé le mot de passe
     */
    public int ligne() {

        boolean b1 = false;
        int n1 = 0;
        String valeur1 = JOptionPane.showInputDialog(null, "Veuillez entrer le numéro de ligne désiré entre 1 et 123 : "
                + "", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);

        if (valeur1 == null) {
            System.exit(0);
        }

        while (!b1) {
            try {
                n1 = Integer.parseInt(valeur1);
                b1 = true;
                while (n1 < 1 || n1 > 123) {
                    JOptionPane.showMessageDialog(null, "Valeur entrée invalide. Veuillez réessayer."
                            + "", "Epreuve de Stéganographie n°3", JOptionPane.ERROR_MESSAGE);
                    valeur1 = JOptionPane.showInputDialog(null, "Veuillez entrer le numéro de ligne désiré entre 1 et 123 : "
                            + "", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);
                    try {
                        n1 = Integer.parseInt(valeur1);
                    } catch (NumberFormatException e) {
                    }
                }
            } catch (NumberFormatException e) {
                if (valeur1 == null) {
                    System.exit(0);
                }
                JOptionPane.showMessageDialog(null, "Valeur entrée invalide. Veuillez réessayer."
                        + "", "Epreuve de Stéganographie n°3", JOptionPane.ERROR_MESSAGE);
                valeur1 = JOptionPane.showInputDialog(null, "Veuillez entrer le numéro de ligne désiré entre 1 et 123 : "
                        + "", "Epreuve de Stéganographie n°3", JOptionPane.QUESTION_MESSAGE);
            }
        }
        return n1;
    }

    /**
     * Créer le fichier LanceurStegano3.java
     * @param keyword
     *                  Mot de passe à trouver
     */
    public void creerJava(String keyword) {
        File f = new File("./Ressources/eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano3/LanceurStegano3.java");

        try {
            FileWriter fw = new FileWriter(f);

            fw.write("public class LanceurStegano3 {");
            fw.write(String.valueOf(System.getProperty("line.separator")));

            fw.write("public static void main(String[] args) {");
            fw.write(String.valueOf(System.getProperty("line.separator")));

            fw.write("eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano3 epreuve = new eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano3();");
            fw.write(String.valueOf(System.getProperty("line.separator")));


            fw.write("String keyword = ");
            fw.write("\"");
            fw.write(keyword);
            fw.write("\";");
            fw.write(String.valueOf(System.getProperty("line.separator")));

            fw.write("epreuve.creationEpreuve(keyword);}}");

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

        File f = new File(".\\Ressources\\eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano3\\Executable.bat");
        if (f.exists()) {
            try {
                Runtime.getRuntime().exec("cmd /c start .\\Ressources\\eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveStegano3\\Executable.bat");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "L'épreuve a bien été créée !", "Confirmation de création"
                        + "", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Impossible de créer l'épreuve. Réessayez", "Problème de création"
                    + "", JOptionPane.ERROR_MESSAGE);
        }
    }

}