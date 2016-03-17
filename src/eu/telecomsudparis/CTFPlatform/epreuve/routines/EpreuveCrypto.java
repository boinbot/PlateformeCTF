package eu.telecomsudparis.CTFPlatform.epreuve.routines;

import javax.swing.JOptionPane;

/**
 * Afficher l'épreuve de crypto pour l'utilisateur
 */

public class EpreuveCrypto {
    /**
     * Afficher une fenetre adaptée de l'épreuve selon la réponse de l'utilisateur
     * @param clue1 Premier indice fourni par le créateur d'épreuve
     * @param clue2 Deuxième indice, calculé en fonction du premier par Playfair
     * @param keyword Mot de passe à trouver par l'utilisateur
     */

    public void creationEpreuve(String clue1, String clue2, String keyword) {

        Boolean b1 = false;

        while (!b1) {

            String reponse = JOptionPane.showInputDialog(null, "Le mariage nihiliste de Blaise !" + "\n\n"
                    + "Le nom de la liste contenant les num�ros de chaque invit� russe est (sachant qu'Ingrid est en couple avec Joris) : "
                    + "" + clue1 + "\n"
                    + "Cherchez les invit�s russes portant les num�ros suivants : " + clue2 + "\n"
                    + "Apr�s avoir plac� ces invit�s, un seul mot rentre en t�te de Blaise : EPREUVE" + "\n\n"
                    + "Entrez votre r�ponse : ", "Epreuve de cryptographie", JOptionPane.QUESTION_MESSAGE);

            reponse = reponse.toUpperCase();

            while (!reponse.matches("[A-Z]+")) {
                JOptionPane.showMessageDialog(null, "Valeur entr�e invalide. Veuillez r�essayer.", "Epreuve de cryptographie"
                        + "", JOptionPane.ERROR_MESSAGE);
                reponse = JOptionPane.showInputDialog(null, "Le mariage nihiliste de Blaise !" + "\n\n"
                        + "Le nom de la liste contenant les num�ros de chaque invit� russe est (sachant qu'Ingrid est en couple avec Joris) : "
                        + clue1 + "\n" + "Cherchez les invit�s russes portant les num�ros suivants : " + clue2 + "\n"
                        + "Apr�s avoir plac� ces invit�s, un seul mot rentre en t�te de Blaise : EPREUVE" + "\n\n"
                        + "Entrez votre r�ponse : ", "Epreuve de cryptographie", JOptionPane.QUESTION_MESSAGE);
            }

            if (reponse.equals(keyword)) {
                JOptionPane.showMessageDialog(null, "Epreuve r�ussie !", "Epreuve de cryptographie", JOptionPane.INFORMATION_MESSAGE);
                b1 = true;
            } else {
                JOptionPane.showMessageDialog(null, "Mauvaise r�ponse. Essayez encore.", "Epreuve de cryptographie"
                        + "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
