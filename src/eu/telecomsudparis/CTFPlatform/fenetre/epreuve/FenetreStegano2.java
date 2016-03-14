package eu.telecomsudparis.CTFPlatform.fenetre.epreuve;

import eu.telecomsudparis.CTFPlatform.epreuve.generator.Stegano2;
import eu.telecomsudparis.CTFPlatform.fenetre.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JOptionPane;

public class FenetreStegano2 extends FenetreEpreuve {

    public FenetreStegano2() {
        super();
        _epreuve = new Stegano2();
        setTitle("Cr�ation d'une �preuve de st�ganographie");
        label = new JLabel("<html><br><center><U>Description de l'�preuve</U><br><br>Cette �preuve de "
                + "st�ganographie consiste � dissimuler un mot de passe de 8 lettres dans 8 trames IP.<br><br>"
                + "Afin de r�soudre cette �preuve, le joueur devra comprendre � partir de l�indice "
                + "que la position de la lettre cach�e dans la trame IP correspond � la valeur d�cimale du \"Time to live\" qui est en hexad�cimale.<br><br> "
                + "Une fois que la position a �t� trouv�e, il devra juste de convertir les deux caract�res ASCII pour trouver chacune "
                + "des lettres du mot de passe. Il faudra refaire cela pour chacune des 8 trames. <br><br>"
                + "Le joueur devra rentrer ce mot de passe pour valider l'�preuve.<br><br>"
                + "Le cr�ateur de l'�preuve doit choisir un mot de passe � trouver de 8 lettres obligatoirement .<br><br><center></html>");

        generateWindow();
    }
}