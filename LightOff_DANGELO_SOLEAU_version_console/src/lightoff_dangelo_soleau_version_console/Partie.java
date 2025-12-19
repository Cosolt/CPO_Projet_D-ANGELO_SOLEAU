/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_dangelo_soleau_version_console;

import java.util.Scanner;

/**
 *
 * @author colin
 */
public class Partie {
    private int nbCoups;
    private int maxCoups;
    private GrilleDeCellules grille;
    
    
    
    /**
     * Initialise les variables d'état de la partie
     * @param grille
     * @param maxCoups
     */
    public Partie(GrilleDeCellules grille, int maxCoups) {
        this.nbCoups = 0;
        this.grille = grille;
        this.maxCoups = maxCoups;
    }
    
    
    
    /**
     * Initialise la partie en mélengeant la grille de manière aléatoire 
     * en s'assurant qu'il n'y est pas de cellules allumées
     */
    public void initialiserPartie() {
        grille.melangerMatriceAleatoirement(10);
        while (grille.cellulesToutesEteintes()) {
            grille.melangerMatriceAleatoirement(10);
        }
    }
    
    
    
    /**
    * Active la cellule spécifiée et ses voisines directes
    */
    private void activerCelluleEtVoisines(int ligne, int colonne) {
        grille.matriceCellules[ligne][colonne].activerCellule();

        // Activer les voisins si dans les limites
        if (ligne > 0) {
            grille.matriceCellules[ligne - 1][colonne].activerCellule(); // Haut
        }
        if (ligne < grille.nbLignes - 1) {
            grille.matriceCellules[ligne + 1][colonne].activerCellule(); // Bas
        }
        if (colonne > 0) {
            grille.matriceCellules[ligne][colonne - 1].activerCellule(); // Gauche
        }
        if (colonne < grille.nbColonnes - 1) {
            grille.matriceCellules[ligne][colonne + 1].activerCellule(); // Droite
        }
    }
    
    
    
    /**
     * Lance la partie interactive
     * Active la cellule renseignée par le joueur ainsi que les voisines à celle-ci
     * Affiche l'état actuel de la grille après chaque coup
     * La partie se termine lorsque toutes les cellules sont éteintes ou que le nombre maximal de coups est atteint
     */
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Debut de la partie ! Voici l'etat initial de la grille :");
        System.out.println(grille);

        // Boucle de jeu tant que des cellules sont encore allumées
        while (!grille.cellulesToutesEteintes() && nbCoups < maxCoups) {
            // Demander au joueur une ligne et une colonne
            System.out.print("Entrez le numero de la ligne : ");
            int ligne = scanner.nextInt();
            System.out.print("Entrez le numero de la colonne : ");
            int colonne = scanner.nextInt();

            // Vérifier si les coordonnées sont valides
            if (ligne >= 0 && ligne < grille.nbLignes && colonne >= 0 && colonne < grille.nbColonnes) {
                // Activer la cellule et ses voisines
                activerCelluleEtVoisines(ligne, colonne);
                // Incrémenter le compteur de coups
                nbCoups++;
                // Afficher l'état actuel de la grille
                System.out.println("Grille apres votre coup :");
                System.out.println(grille);
                System.out.println("Nombre de coups joues : " + nbCoups + "/" + maxCoups);
                
            } else {
                System.out.println("Coordonnees invalides. Réessayez.");
            }
        }

        // Fin de la partie
        if (grille.cellulesToutesEteintes()) {
            System.out.println("Felicitations ! Vous avez eteint toutes les cellules !");
        } else {
            System.out.println("Dommage ! Vous avez atteint la limite de coups.");
        }
        System.out.println("Nombre total de coups joues : " + nbCoups);
        scanner.close();
    }

    
     
    /**
    * Active uniquement la cellule spécifiée
    */
    private void activerCellule(int ligne, int colonne) {
        grille.matriceCellules[ligne][colonne].activerCellule();
    }
     
    
    
    
}
