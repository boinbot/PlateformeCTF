package eu.telecomsudparis.CTFPlatform.epreuve.routines;

import javax.swing.JOptionPane;

public class EpreuveStegano3 {

public void creationEpreuve(String keyword) {
		
		Boolean b1 = false;
		
		while (!b1) {
		
			String reponse = JOptionPane.showInputDialog(null, "Il ne faut pas se fier aux apparences !" 
			+ "\n\n" + "Entrez votre r�ponse : ", "Epreuve de St�ganographie n�3", JOptionPane.QUESTION_MESSAGE);

			while (!reponse.matches("[a-zA-Z]+")){
				JOptionPane.showMessageDialog(null, "Valeur entr�e invalide. Veuillez r�essayer.", "Epreuve de St�ganographie n�3",
						JOptionPane.ERROR_MESSAGE);
				reponse = JOptionPane.showInputDialog(null, "Il ne faut pas se fier aux apparences !" 
						+ "Entrez votre r�ponse : ", "Epreuve de St�ganographie n�3", JOptionPane.QUESTION_MESSAGE);
			}

			if(reponse.equals(keyword)) {
				JOptionPane.showMessageDialog(null, "Epreuve r�ussie !", "Epreuve de St�ganographie n�3"
						+ "", JOptionPane.INFORMATION_MESSAGE);
				b1 = true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Mauvaise r�ponse. Essayez encore.", "Epreuve de St�ganographie n�3"
						+ "", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}