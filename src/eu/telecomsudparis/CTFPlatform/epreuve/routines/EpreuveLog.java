package eu.telecomsudparis.CTFPlatform.epreuve.routines;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EpreuveLog extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void creationEpreuve(String suite, int solution) {
		
		int n = 0;
		Boolean b1 = false;
		Boolean b2 = false;
		
		while (!b1) {
		
			String reponse = JOptionPane.showInputDialog(null, suite + "\n" + "Entrez votre r�ponse : ", "Epreuve de logique n�1"
					+ "", JOptionPane.QUESTION_MESSAGE);
			if(reponse == null) {
				System.exit(0);
			}
			while(!b2){
				try {
					n = Integer.parseInt(reponse);
					b2 = true;
				}
				catch (NumberFormatException e) {
					if(reponse == null) {
						System.exit(0);
					}
					JOptionPane.showMessageDialog(null, "Valeur entr�e invalide. Veuillez r�essayer.", "Epreuve de logique n�1"
							+ "", JOptionPane.ERROR_MESSAGE);
					reponse = JOptionPane.showInputDialog(null, "Voici votre �preuve :  " + suite, "Epreuve de logique n�1"
							+ "", JOptionPane.QUESTION_MESSAGE);
				}
			}
		
			if(n == solution) {
				JOptionPane.showMessageDialog(null, "Epreuve r�ussie !", "Epreuve de logique n�1", JOptionPane.INFORMATION_MESSAGE);
				b1 = true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Mauvaise r�ponse. Essayez encore.", "Epreuve de logique n�1"
						+ "", JOptionPane.ERROR_MESSAGE);
				b2 = false;
			}
		}
	}
}
