package eu.telecomsudparis.CTFPlatform.fenetre.epreuve;

import eu.telecomsudparis.CTFPlatform.epreuve.generator.Logique2;
import eu.telecomsudparis.CTFPlatform.fenetre.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JOptionPane;

public class FenetreLogique2 extends FenetreEpreuve {
    public FenetreLogique2() {
        super();
        _epreuve = new Logique2();
        setTitle("Cr�ation d'une �preuve de logique");
        label = new JLabel("<html><br><center><U>Description de l'�preuve</U><br><br>Cette �preuve de "
                + "logique repose sur la suite de eu.telecomsudparis.CTFPlatform.epreuve.generator.helper.Syracuse.<br><br> Cette suite fonctionne de la mani�re suivante :<br><br>"
                + "On choisit un entier strictement positif comme premier �l�ment de la suite.<br>"
                + "S'il est pair, on le divise par deux pour obtenir l'�l�ment suivant.<br>"
                + "S'il est impair, on le multiplie par trois et on ajoute un pour obtenir l'�l�ment suivant.<br>"
                + "On obtient la suite en r�it�rant cette op�ration<br><br>"
                + "Le joueur disposera du d�but de la suite et devra trouver l'�l�ment suivant.<br><br>"
                + "Le joueur devra rentrer cet �l�ment pour valider l'�preuve.<br><br>"
                + "Le cr�ateur de l'�preuve doit choisir le premier �l�ment de la suite et le nombre d'�l�ments souhait�s.<br><br><center></html>");

        generateWindow();
    }
}