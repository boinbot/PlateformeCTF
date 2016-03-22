package eu.telecomsudparis.CTFPlatform.fenetre.epreuve;

import eu.telecomsudparis.CTFPlatform.epreuve.CrackMe;
import javax.swing.JLabel;

/**
 * Fenêtre de l'épreuve crack me pour le créateur de l'épreuve
 * @author Mr X
 * @version 2.0
 */
public class FenetreCrack extends FenetreEpreuve {

    /**
     * Création et affichage de la fenêtre de l'épreuve contenant les indications pour le créateur.
     */
    public FenetreCrack() {
        super();
        _epreuve = new CrackMe();
        setTitle("Cr�ation d'une �preuve de eu.telecomsudparis.CTFPlatform.epreuve.CrackMe");
        label = new JLabel("<html><br><center><U>Description de l'�preuve</U><br><br>Cette �preuve de "
                + "eu.telecomsudparis.CTFPlatform.epreuve.CrackMe est bas�e sur une analyse du code assembleur.<br><br> "
                + "Une liste de mots quelconques contenant toutes les lettres de l'alphabet a �t� mis dans une liste. "
                + "Pour �crire le mot de passe dans le code, nous avons copi� les caract�res correspondant au mot de passe � "
                + "partir de cette liste de mots.<br>"
                + "Cela permettra d'emp�cher au joueur de lire le mot de passe en clair avec un strings par exemple.<br><br>"
                + "Le joueur devra trouver ce mot de passe pour valider l'�preuve. "
                + "Il disposera pour cela d'un ex�cutable.<br><br>"
                + "Il devra tout d'abord d�sassembler cet ex�cutable pour obtenir le code assembleur.<br><br>"
                + "Il devra ensuite trouver les lignes correspondant � cr�ation du mot du passe pour connaitre les mots quelconques "
                + "utilis�s pour �crire le mot de passe.<br><br>"
                + "Il devra enfin trouver les lignes correspondant � la d�claration de chacun de ces mots et utiliser un convertisseur "
                + "hexad�cimal pour obtenir les caract�res de ces mots.<br><br>"
                + "Il obtiendra de cette fa�on le mot de passe.<br><br>"
                + "La difficult� vient du fait que tous les �l�ments sont mis dans le registre ESP et qu'il faudra voir � quel endroit "
                + "de ce registre les �l�ments ont �t� mis.<br><br>"
                + "Le joueur devra rentrer le mot de passe dans l'ex�cutable pour valider l'�preuve.<br><br>"
                + "Le cr�ateur de l'�preuve doit choisir le mot de passe souhait�.<br><br><center></html>");

        generateWindow();
    }
}