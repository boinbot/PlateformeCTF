package eu.telecomsudparis.CTFPlatform.fenetre.epreuve.common;

import eu.telecomsudparis.CTFPlatform.fenetre.Fenetre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Gestion du bouton "retour au menu"
 * Created by Anthony on 08/03/2016.
 */
public class ButtonReturnToMenu implements ActionListener {
    private Window _attachedWindow;

    /**
     * Constructeur
     * @param attachedWindow Fenetre à lier au bouton
     */
    public ButtonReturnToMenu(Window attachedWindow) {
        _attachedWindow = attachedWindow;
    }

    /**
     * Action du bouton
     * Fermeture de la fenetre liée au bouton et ouverture de la fenetre de la plateforme
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        _attachedWindow.dispose();
        new Fenetre();
    }
}
