package eu.telecomsudparis.CTFPlatform.epreuve.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;


public class Fibonacci {
	
	public int[] suite (int n1, int n2, int r) {
		int [] s = new int[r];
		s[0] = n1;
		s[1] = n2;
		for (int i=2; i<r; i++) {
			s[i] = s[i-1] + s[i-2];
		}
		return s;
	}
	
	public String afficherSuite (int[] s) {
		int n = s.length;
		String suite = "Votre �preuve est : "; 
		String m;
		for (int i=0; i<n-1; i++) {
			m = Integer.toString(s[i]);
			suite = suite + m + " ";
		}
		suite = suite + "?";
		return suite;
	}
	
	public String selectionnerNb1() {
		String nombre = JOptionPane.showInputDialog(null, "Veuillez entrer un entier pour la premi�re valeur de la suite", ""
				+ "Epreuve de logique", JOptionPane.QUESTION_MESSAGE);
		return nombre;
	}
	
	public String selectionnerNb2() {
		String nombre = JOptionPane.showInputDialog(null, "Veuillez entrer un entier > 0 pour la deuxi�me valeur de la suite", ""
				+ "Epreuve de logique", JOptionPane.QUESTION_MESSAGE);
		return nombre;
	}
	
	public String selectionnerRg() {
		String nombre = JOptionPane.showInputDialog(null, "Veuillez entrer le nombre d'�l�ments souhait�s (sup�rieur � 3) : ", ""
				+ "Epreuve de logique", JOptionPane.QUESTION_MESSAGE);
		return nombre;
	}	
	
	public void creerTxt(int[] liste) {
		File f = new File ("./Ressources/EpreuveLogique1/LanceurLog.java");
		
		try
		{
			FileWriter fw = new FileWriter(f);
			
			int n = liste.length;
			
			fw.write("public class LanceurLog {");
			fw.write(String.valueOf(System.getProperty("line.separator")));
			
			fw.write("public static void main(String[] args) {");
			fw.write(String.valueOf(System.getProperty("line.separator")));
			
			fw.write("eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveLog epreuve = new eu.telecomsudparis.CTFPlatform.epreuve.routines.EpreuveLog();");
			fw.write(String.valueOf(System.getProperty("line.separator")));
				
			fw.write("String suite = ");
			fw.write("\"");
			for (int i=0; i<n-1; i++) {
				fw.write(String.valueOf(liste[i]));
				fw.write(" ");
			}
			fw.write("?");
			fw.write("\";");
			fw.write(String.valueOf(System.getProperty("line.separator")));
			
			fw.write("int solution = ");
			fw.write(String.valueOf(liste[n-1]));
			fw.write(";");
			fw.write(String.valueOf(System.getProperty("line.separator")));
			
			fw.write("epreuve.creationEpreuve(suite, solution);}}");
			
			//String s = Integer.toString(liste[n-1]);
			
			
			
			//fw.write(String.valueOf("La solution est : "));
			//fw.write(String.valueOf(s));
			
			fw.close();
			
		}
		catch (IOException exception)
		
		{
			System.out.println("Erreur lors de la lecture :" + exception.getMessage());
		}
	}
		
	public void creerEpreuve() {
		
		File f = new File(".\\Ressources\\EpreuveLogique1\\Executable.bat");
		if (f.exists()){
			try {
				Runtime.getRuntime().exec("cmd /c start .\\Ressources\\EpreuveLogique1\\Executable.bat");
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
		}
		else {
			JOptionPane.showMessageDialog(null, "Impossible de cr�er l'�preuve. R�essayez", "Probl�me de cr�ation", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
		
}

