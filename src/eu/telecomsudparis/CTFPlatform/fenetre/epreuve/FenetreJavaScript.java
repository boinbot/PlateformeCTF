package eu.telecomsudparis.CTFPlatform.fenetre.epreuve;

import eu.telecomsudparis.CTFPlatform.epreuve.generator.JavaScript;
import eu.telecomsudparis.CTFPlatform.fenetre.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JOptionPane;

public class FenetreJavaScript extends FenetreEpreuve {

    public FenetreJavaScript() {
        super();
        _epreuve = new JavaScript();
            setTitle("Cr�ation d'une �preuve de st�ganographie");
        label =  new JLabel("<html><br><center><U>Description de l'�preuve</U><br><br>Cette �preuve de "
                + "st�ganographie repose sur la capacit� � ne pas afficher des �l�ments du code gr�ce � l'option \"style=\"display:none;\".<br><br>"
                + "Le joueur disposera d'une page HTML qui affichera un texte. <br><br>"
                + "Il devra analyser le code pour trouver deux balises contenant l'option \"style=\"display:none;\" qui contiendront "
                + "un num�ro de ligne et un num�ro de colonne.<br><br> Il suffira de trouver le mot correspondant � ces num�ros dans le texte, "
                + "qui correspondra au mot de passe.<br><br>"
                + "Le joueur devra rentrer ce mot de passe pour valider l'�preuve.<br><br>"
                + "Le cr�ateur de l'�preuve doit choisir un mot de passe � trouver compos� de lettre(s) "
                + "obligatoirement .<br><br><center></html>");

        generateWindow();
    }
}