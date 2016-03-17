package eu.telecomsudparis.CTFPlatform.fenetre.epreuve;

import eu.telecomsudparis.CTFPlatform.epreuve.generator.EpreuveGenerator;
import eu.telecomsudparis.CTFPlatform.fenetre.epreuve.common.ButtonCreateEpreuve;
import eu.telecomsudparis.CTFPlatform.fenetre.epreuve.common.ButtonReturnToMenu;

import javax.swing.*;

/**
 *
 * @param <T> Précise le type de générateur pris en compte par la fenêtre
 */
abstract public class FenetreEpreuve<T extends EpreuveGenerator> extends JFrame {
    private static final long serialVersionUID = 1L;
    protected T _epreuve;
    //private eu.telecomsudparis.CTFPlatform.epreuve.generator.helper.Panneau panneau = new eu.telecomsudparis.CTFPlatform.epreuve.generator.helper.Panneau();
    private JPanel pan = new JPanel();
    private JButton bouton = new JButton("Cr�er l'�preuve");
    private JButton bouton2 = new JButton("Retour au choix d'�preuve");

    protected JLabel label;
    protected String title;

    protected JPanel pan2 = new JPanel();
    private JPanel pan3 = new JPanel();

    /**
     * Constructeur
     */
    public FenetreEpreuve() {
        setSize(500, 315);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setAlwaysOnTop(true);
    }

    /**
     * Création de la fenetre
     */
    protected void generateWindow() {
        bouton.addActionListener(new ButtonCreateEpreuve<>(_epreuve, this));
        bouton2.addActionListener(new ButtonReturnToMenu(this));

        //Création d'un panneau
        //Ajout des boutons "créer épreuve" et "retour au menu", liés à la fenetre créée

        pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
        pan.add(bouton);
        pan.add(bouton2);
        //pan.add(panneau, BorderLayout.CENTER);

        label.setHorizontalAlignment(JLabel.CENTER);

        //Création d'un autre panneau
        //Ajout de la description de l'épreuve

        pan2.setLayout(new BoxLayout(pan2, BoxLayout.LINE_AXIS));
        pan2.add(label);

        //Création d'un panneau combinant les 2 précédents

        pan3.setLayout(new BoxLayout(pan3, BoxLayout.PAGE_AXIS));
        pan3.add(pan2);
        pan3.add(pan);

        //La fenetre contiendra ce dernier panneau

        this.setContentPane(pan3);

        this.setVisible(true);
    }
}
