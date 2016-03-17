package eu.telecomsudparis.CTFPlatform.epreuve.generator.helper;

import java.util.Arrays;

/**
 * Gestion du tableau de Vigenère utilisée par l'épreuve de crypto
 */

public class Vigenere {
    /**
     * @param args Argument fourni en ligne de commande
     */
    public static void main(String[] args) {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
                "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        //System.out.println(alphabet.length);
        createTable(alphabet);
        //printTable(array);
        String a = "BONJOUR";
        String b = correspondEpreuve(a);
        System.out.println(b);
    }

    /**
     * @param alphabet String contenant l'aphabet
     * @return la table de Vigenère (alphabet décalé de 1 vers la droite à chaque ligne)
     */

    private static String[][] createTable(String[] alphabet) {
        String[][] table = new String[alphabet.length][alphabet.length];
        int a;
        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                a = i + j;
                if (a >= alphabet.length) {
                    a = a - alphabet.length;
                }
                table[i][j] = alphabet[a];
            }
        }
        return table;
    }

    /**
     * Affichage de la table
     */
/*private static void printTable(String[][] table) {
    for(int i = 0; i < table.length; i++){
		for(int j = 0; j < table.length; j++){
			System.out.print(table[i][j]);
		}
		System.out.println();
	}
}*/

    /**
     * @param motDePasse Mot fourni par le créateur
     * @return String contenant les lettres du mot de passe séparées
     */

    public static String motCode(String motDePasse) {

        String[] splitArray = motDePasse.split("");
        System.out.println(Arrays.toString(splitArray));
        return ("yes");
    }

    /**
     * @param lettre lettre cherchée
     * @param ligne ligne voulue
     * @param tableau Table de vigenère
     * @return le numéro de la colonne voulue
     */
    public static int retournerColonne(String lettre, int ligne, String[][] tableau) {

        int j = 0;
        for (int i = 0; i < 26; i++)
            if (tableau[ligne][i].equals(lettre)) {
                j = i;
            }
        return j;
    }

    /**
     * Crypte le mot de passe avec la table
     * @param motDePasse mot de passe fourni par le créateur
     * @return Mot de passe crypté par la table de Vigenère
     */
    public static String correspondEpreuve(String motDePasse) {

        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
                "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int lmot = motDePasse.length();
        String[] indice = new String[50];
        String b = "";
        String[][] tableau = createTable(alphabet);
        String[] splitArray = motDePasse.split("");
        int[] Epreuve = {4, 16, 18, 4, 21, 22, 4};
        int longueur = Epreuve.length;
        int a;

        for (int i = 0; i < lmot; i++) {
            int c = Epreuve[i % longueur];
            String d = splitArray[i % longueur];
            a = retournerColonne(d, c, tableau);
            //System.out.println(a);
            indice[i % longueur] = alphabet[a];
            b = b + indice[i % longueur];
        }
        return b;
    }

}