package eu.telecomsudparis.CTFPlatform.fenetre.epreuve;

import eu.telecomsudparis.CTFPlatform.epreuve.generator.Crypto;
import javax.swing.JLabel;

public class FenetreCrypto extends FenetreEpreuve {
    public FenetreCrypto() {
        super();
        _epreuve = new Crypto();
        setTitle("Cr�ation d'une �preuve de cryptographie");
        label = new JLabel("<html><br><center><U>Description de l'�preuve</U><br><br>Cette �preuve de "
                + "cryptographie repose sur une combinaison du carr� de Polybe et de la table de Vigen�re.<br><br>"
                + "Le joueur disposera de trois indices.<br><br>Le premier est le mot-cl� pour remplir le carr� de Polybe.<br>"
                + "Le second est le message cod� par ce carr�.<br>Le message d�cod� et le troisi�me indice sont les deux "
                + "mots-cl�s � utiliser dans la table de Vigen�re pour obtenir le mot de passe.<br><br>"
                + "Le joueur devra rentrer ce mot de passe pour valider l'�preuve.<br><br>"
                + "Le cr�ateur de l'�preuve doit choisir le premier indice et le mot de passe � trouver.<br><br><center></html>");

        generateWindow();
    }
}