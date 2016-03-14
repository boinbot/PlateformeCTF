package eu.telecomsudparis.CTFPlatform.fenetre.epreuve;

import eu.telecomsudparis.CTFPlatform.epreuve.generator.EpreuveGenerator;
import eu.telecomsudparis.CTFPlatform.epreuve.generator.Logique;
import eu.telecomsudparis.CTFPlatform.fenetre.Fenetre;
import eu.telecomsudparis.CTFPlatform.fenetre.epreuve.common.ButtonCreateEpreuve;
import eu.telecomsudparis.CTFPlatform.fenetre.epreuve.common.ButtonReturnToMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JOptionPane;

public class FenetreLogique extends FenetreEpreuve {
    public FenetreLogique() {
        super();
        _epreuve = new Logique();
        setTitle("Cr�ation d'une �preuve de logique");
        label = new JLabel("<html><br><center><U>Description de l'�preuve</U><br><br>Cette �preuve de "
                + "logique repose sur la c�l�bre suite de eu.telecomsudparis.CTFPlatform.epreuve.generator.Fibonacci.<br><br>Il s'agit d'une suite lin�aire d'ordre 2 qui "
                + "fonctionne de la mani�re suivante : <br>U(n+2) = U(n+1) + U(n)<br><br>"
                + "Le joueur disposera du d�but de la suite et devra trouver l'�l�ment suivant.<br><br>"
                + "Le joueur devra rentrer cet �l�ment pour valider l'�preuve.<br><br>"
                + "Le cr�ateur de l'�preuve doit choisir les deux premiers �l�ments de la suite et le nombre d'�l�ments souhait�s.<br><br><center></html>");

        generateWindow();
    }
}