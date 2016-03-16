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

/**
 *  Classe de la fenêtre de l'épreuve Stegano3
 */
public class FenetreJavaScript extends FenetreEpreuve {
    /**
     * Génère la fenêtre de l'épreuve Stegano3
     */
    public FenetreJavaScript() {
        super();
        _epreuve = new JavaScript();
            setTitle("Création d'une épreuve de stéganographie");
        label =  new JLabel("<html><br><center><U>Description de l'épreuve</U><br><br>Cette épreuve de "
                + "st�ganographie repose sur la capacité à ne pas afficher des éléments du code grâce à l'option \"style=\"display:none;\".<br><br>"
                + "Le joueur disposera d'une page HTML qui affichera un texte. <br><br>"
                + "Il devra analyser le code pour trouver deux balises contenant l'option \"style=\"display:none;\" qui contiendront "
                + "un numéro de ligne et un numéro de colonne.<br><br> Il suffira de trouver le mot correspondant à ces numéros dans le texte, "
                + "qui correspondra au mot de passe.<br><br>"
                + "Le joueur devra rentrer ce mot de passe pour valider l'épreuve.<br><br>"
                + "Le créateur de l'épreuve doit choisir un mot de passe à trouver composé de lettre(s) "
                + "obligatoirement .<br><br><center></html>");

        generateWindow();
    }
}