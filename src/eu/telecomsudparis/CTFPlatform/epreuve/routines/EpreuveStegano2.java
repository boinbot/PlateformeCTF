package eu.telecomsudparis.CTFPlatform.epreuve.routines;

import javax.swing.JOptionPane;

/**
 * EpreuveStegano2 est la classe contenant la dernière épreuve Stegano2
 */
public class EpreuveStegano2 {
	/**
	 * Demande à l'utilisateur de saisir le mot de 8 lettres qu'il aura trouver
	 *
	 * @param keyword mot de 8 lettres que l'utilisateur doit retrouver
     */
    public void creationEpreuve(String keyword) {
		
		Boolean b1 = false;
		
		while (!b1) {
		
			String reponse = JOptionPane.showInputDialog(null, "Combien de temps mettrez-vous ?" 
			+ "\n\n" + "Entrez votre réponse : ", "Epreuve de stéganographie n°2", JOptionPane.QUESTION_MESSAGE);

			while ((!reponse.matches("[a-zA-Z]+")) || (reponse.length() != 8)){
				JOptionPane.showMessageDialog(null, "Valeur entrée invalide. Veuillez réessayer.", "Epreuve de stéganographie n°2",
						JOptionPane.ERROR_MESSAGE);
				reponse = JOptionPane.showInputDialog(null, "Combien de temps mettrez-vous ?" 
						+ "\n\n" + "Entrez votre réponse : ", "Epreuve de stéganographie n°2", JOptionPane.QUESTION_MESSAGE);
			}

			if(reponse.equals(keyword)) {
				JOptionPane.showMessageDialog(null, "Epreuve réussie !", "Epreuve de stéganographie n°2"
						+ "", JOptionPane.INFORMATION_MESSAGE);
				b1 = true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Mauvaise réponse. Essayez encore.", "Epreuve de stéganographie n°2"
						+ "", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}