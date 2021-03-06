package eu.telecomsudparis.CTFPlatform.epreuve.routines;

import javax.swing.JOptionPane;

/**
 * Afficher et gérer l'épreuve de stégano 1 pour l'utilisateur
 */
public class EpreuveStegano1 {
    /**
     * Afficher une fenetre adaptée de l'épreuve selon la réponse de l'utilisateur
     * @param keyword Mot de passe à trouver par l'utilisateur
     */
public void creationEpreuve(String keyword) {
		
		Boolean b1 = false;
		
		while (!b1) {
		
			String reponse = JOptionPane.showInputDialog(null, "Il faut aller au bout des choses !" 
			+ "\n\n" + "Entrez votre r�ponse : ", "Epreuve de st�ganographie n�1", JOptionPane.QUESTION_MESSAGE);

			while (!reponse.matches("[a-zA-Z0-9]+") || (reponse.length() != 8)){
				JOptionPane.showMessageDialog(null, "Valeur entr�e invalide. Veuillez r�essayer.", "Epreuve de st�ganographie n�1",
						JOptionPane.ERROR_MESSAGE);
				reponse = JOptionPane.showInputDialog(null, "Il faut aller au bout des choses !" 
						+ "Entrez votre r�ponse : ", "Epreuve de st�ganographie n�1", JOptionPane.QUESTION_MESSAGE);
			}

			if(reponse.equals(keyword)) {
				JOptionPane.showMessageDialog(null, "Epreuve r�ussie !", "Epreuve de st�ganographie n�1"
						+ "", JOptionPane.INFORMATION_MESSAGE);
				b1 = true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Mauvaise r�ponse. Essayez encore.", "Epreuve de st�ganographie n�1"
						+ "", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}