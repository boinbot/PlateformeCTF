package eu.telecomsudparis.CTFPlatform.fenetre.epreuve;

import eu.telecomsudparis.CTFPlatform.epreuve.generator.JavaScript2;
import eu.telecomsudparis.CTFPlatform.fenetre.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JOptionPane;

/**
 * Fenetre de création de l'épreuve de javascript
 * @author Mr X
 * @version 2.0
 */
public class FenetreJavaScript2 extends FenetreEpreuve {
    public FenetreJavaScript2() {
        super();
        _epreuve = new JavaScript2();
        setTitle("Cr�ation d'une �preuve de eu.telecomsudparis.CTFPlatform.epreuve.generator.JavaScript");
        label = new JLabel("<html><br><center><U>Description de l'�preuve</U><br><br>Cette �preuve de "
                + "eu.telecomsudparis.CTFPlatform.epreuve.generator.JavaScript repose sur l'utilisation des \"checkboxes\".<br><br>"
                + "Le joueur disposera d'une page HTML. <br><br>"
                + "Il devra analyser la page et trouver la partie du code � modifier pour que le mot de passe s'affiche. "
                + "En effet, une condition \"if\" initialement impossible (1==2) n'est pas pass� lorsque l'on coche trois \"checkboxes\" "
                + "afin d'obtenir le mot de passe.<br><br> "
                + "Le joueur devra rentrer ce mot de passe pour valider l'�preuve.<br><br>"
                + "Le cr�ateur de l'�preuve doit choisir un mot de passe � trouver. <br><br><center></html>");

        generateWindow();
    }
}