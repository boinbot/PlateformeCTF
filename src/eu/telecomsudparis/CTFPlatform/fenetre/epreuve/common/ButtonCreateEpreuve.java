package eu.telecomsudparis.CTFPlatform.fenetre.epreuve.common;


import eu.telecomsudparis.CTFPlatform.epreuve.generator.EpreuveGenerator;
import eu.telecomsudparis.CTFPlatform.fenetre.Fenetre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Gestion des boutons "créer épreuve"
 * Created by Anthony on 08/03/2016.
 * @param <T> Permet de préciser le type de générateur pris en compte par le bouton
 */
public class ButtonCreateEpreuve<T extends EpreuveGenerator> implements ActionListener {

    private T _epreuve;

    private Window _attachedWindow;

    /**
     * Constructeur
     * @param ExtEpreuve Epreuve voulue
     * @param thisWindow Fenetre associée à la création d'épreuve
     */
    public ButtonCreateEpreuve(T ExtEpreuve, Window thisWindow) {
        _epreuve = ExtEpreuve;
        _attachedWindow = thisWindow;
    }

    /**
     * Action lancée par le bouton : fermeture de la fenetre attachée et création de l'épreuve
     * Puis ouverture de la fenetre de la plateforme
     * @param arg0
     */
    public void actionPerformed(ActionEvent arg0) {
        _attachedWindow.dispose();
        _epreuve.create();
        new Fenetre();
    }


}
