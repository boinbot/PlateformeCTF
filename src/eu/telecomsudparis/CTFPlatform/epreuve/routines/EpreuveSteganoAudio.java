package eu.telecomsudparis.CTFPlatform.epreuve.routines;

import javax.swing.JOptionPane;

/**
 * EpreuveSteganoAudio est la classe contenant la dernière épreuve SteganoAudio
 */
public class EpreuveSteganoAudio {
    /**
     * Demande à l'utilisateur de saisir le mot de passe
     *
     * @param keyword mot de passe que l'utilisateur doit retrouver
     */
    public void creationEpreuve(String keyword) {

        Boolean b1 = false;

        while (!b1) {

            String reponse = JOptionPane.showInputDialog(null, "Ouvrez bien vos oreilles !"
                    + "\n\n" + "Entrez votre réponse : ", "Epreuve de Stéganographie n°4", JOptionPane.QUESTION_MESSAGE);

            while (!reponse.matches("[a-zA-Z]+")){
                JOptionPane.showMessageDialog(null, "Valeur entrée invalide. Veuillez réessayer.", "Epreuve de Stéganographie n°4",
                        JOptionPane.ERROR_MESSAGE);
                reponse = JOptionPane.showInputDialog(null, "Ouvrez bien vos oreilles !"
                        + "Entrez votre réponse : ", "Epreuve de Stéganographie n°4", JOptionPane.QUESTION_MESSAGE);
            }

            if(reponse.equals(keyword)) {
                JOptionPane.showMessageDialog(null, "Epreuve réussie !", "Epreuve de Stéganographie n°4"
                        + "", JOptionPane.INFORMATION_MESSAGE);
                b1 = true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Mauvaise réponse. Essayez encore.", "Epreuve de Stéganographie n°4"
                        + "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}