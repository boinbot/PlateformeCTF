package eu.telecomsudparis.CTFPlatform.epreuve.routines;

import javax.swing.JOptionPane;

public class EpreuveJavaScript {

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