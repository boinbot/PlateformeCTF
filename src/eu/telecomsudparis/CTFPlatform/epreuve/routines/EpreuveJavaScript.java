package eu.telecomsudparis.CTFPlatform.epreuve.routines;

import javax.swing.JOptionPane;

/**
 * Cette classe permet de vérifier la conformité du mot de passe entré par l'utilisateur et de lui faire valider l'épreuve.
 * @author Mr X
 * @version 2.0
 */
public class EpreuveJavaScript {

	/**
	 * Vérifie la conformité et la validité ou non du mot de passe rentré par l'utilisateur pour réussir l'épreuve
	 * @param keyword string, mot de passe rentré par l'utilisateur.
	 */
	public void creationEpreuve(String keyword) {
		
		Boolean b1 = false;
		
		while (!b1) {
		
			String reponse = JOptionPane.showInputDialog(null, "Il vous faut changer votre condition !" 
			+ "\n\n" + "Entrez votre r�ponse : ", "Epreuve de eu.telecomsudparis.CTFPlatform.epreuve.generator.JavaScript", JOptionPane.QUESTION_MESSAGE);

			while (!reponse.matches("[a-zA-Z0-9]+")){
				JOptionPane.showMessageDialog(null, "Valeur entr�e invalide. Veuillez r�essayer.", "Epreuve de eu.telecomsudparis.CTFPlatform.epreuve.generator.JavaScript",
						JOptionPane.ERROR_MESSAGE);
				reponse = JOptionPane.showInputDialog(null, "Il vous faut changer votre condition !" 
						+ "Entrez votre r�ponse : ", "Epreuve de eu.telecomsudparis.CTFPlatform.epreuve.generator.JavaScript", JOptionPane.QUESTION_MESSAGE);
			}

			if(reponse.equals(keyword)) {
				JOptionPane.showMessageDialog(null, "Epreuve r�ussie !", "Epreuve de eu.telecomsudparis.CTFPlatform.epreuve.generator.JavaScript"
						+ "", JOptionPane.INFORMATION_MESSAGE);
				b1 = true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Mauvaise r�ponse. Essayez encore.", "Epreuve de eu.telecomsudparis.CTFPlatform.epreuve.generator.JavaScript"
						+ "", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}