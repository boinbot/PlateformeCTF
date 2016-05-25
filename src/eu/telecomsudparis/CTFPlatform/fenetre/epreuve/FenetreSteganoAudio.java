package eu.telecomsudparis.CTFPlatform.fenetre.epreuve;

import eu.telecomsudparis.CTFPlatform.epreuve.generator.SteganoAudio;
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
 *  Classe de la fenêtre de l'épreuve SteganoAudio
 */
public class FenetreSteganoAudio extends FenetreEpreuve {
    /**
     * Génère la fenêtre de l'épreuve SteganoAudio
     */
    public FenetreSteganoAudio() {
        super();
        _epreuve = new SteganoAudio();
        setTitle("Création d'une épreuve de stéganographie audio");
        label = new JLabel("<html><br><center><U>Description de l'épreuve</U>"
                + "Cette épreuve de stéganographie consiste à dissimuler un mot de passe de 8 caractères dans une chanson.<br><br>"
                + "Ce mot de passe sera traduit en morse dans un fichier audio à une fréquence inaudible.<br><br>"
                + "Ce même fichier audio sera lui concaténé dans une chanson.<br><br>"
                + "Le joueur devra décomposer la musique afin d'en récupérer uniquement le fichier audio contenant le mot de passe<br><br>"
                + "Puis rentrer ce mot de passe afin de valider l'épreuve.<br><br>"
                + "Le créateur de l'épreuve devra obligatoirement choisir un mot de passe de 8 caractères.  <br><br><center></html>");

        generateWindow();
    }
}