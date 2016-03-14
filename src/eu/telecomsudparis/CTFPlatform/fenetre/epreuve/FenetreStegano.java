package eu.telecomsudparis.CTFPlatform.fenetre.epreuve;

import eu.telecomsudparis.CTFPlatform.epreuve.generator.Stegano;
import eu.telecomsudparis.CTFPlatform.fenetre.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JOptionPane;

public class FenetreStegano extends FenetreEpreuve {
    public FenetreStegano() {
        super();
        try {
            _epreuve = new Stegano();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTitle("Cr�ation d'une �preuve de st�ganographie");
        label = new JLabel("<html><br><center><U>Description de l'�preuve</U><br><br>Cette �preuve de "
                + "st�ganographie repose sur le codage ASCII.<br><br>"
                + "Le joueur disposera d'une image repr�sentant un arbre � 64 branches qui correspondent � 64 �l�ments binaires. "
                + "Le sens de lecture de l'arbre correspond au sens horaire en partant de la gauche de l'arbre. "
                + "Si une branche poss�de une feuille, l'�l�ment binaire est � 1, sinon il est � 0. <br><br>"
                + "Ainsi, ces 64 �l�ments binaires permettent d'obtenir le mot de passe de 8 caract�res. <br><br>"
                + "Le joueur devra rentrer ce mot de passe pour valider l'�preuve.<br><br>"
                + "Le cr�ateur de l'�preuve doit choisir un mot de passe � trouver compos� 8 lettre(s) et/ou chiffre(s) "
                + "obligatoirement .<brTe><br><center></html>");

        generateWindow();
    }

}