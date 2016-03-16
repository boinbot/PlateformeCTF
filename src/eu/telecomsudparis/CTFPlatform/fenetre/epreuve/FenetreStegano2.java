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

/**
 *  Classe de la fenêtre de l'épreuve Stegano2
 */
public class FenetreStegano2 extends FenetreEpreuve {
    /**
     * Génère la fenêtre de l'épreuve Stegano2
     */
    public FenetreStegano2() {
        super();
        _epreuve = new Stegano2();
        setTitle("Création d'une épreuve de stéganographie");
        label = new JLabel("<html><br><center><U>Description de l'épreuve</U><br><br>Cette épreuve de "
                + "stéganographie consiste à dissimuler un mot de passe de 8 lettres dans 8 trames IP.<br><br>"
                + "Afin de résoudre cette épreuve, le joueur devra comprendre à partir de l'indice "
                + "que la position de la lettre cachée dans la trame IP correspond à la valeur décimale du \"Time to live\" qui est en hexadécimale.<br><br> "
                + "Une fois que la position a été trouvée, il devra juste de convertir les deux caractères ASCII pour trouver chacune "
                + "des lettres du mot de passe. Il faudra refaire cela pour chacune des 8 trames. <br><br>"
                + "Le joueur devra rentrer ce mot de passe pour valider l'épreuve.<br><br>"
                + "Le créateur de l'épreuve doit choisir un mot de passe à trouver de 8 lettres obligatoirement .<br><br><center></html>");

        generateWindow();
    }
}