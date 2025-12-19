/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_dangelo_soleau_version_console;

import java.util.Random;

/**
 *
 * @author evada
 */
public class GrilleDeCellules {
    int nbLignes;
    int nbColonnes;
    CelluleLumineuse[][] matriceCellules;
    
    
    
    /**
     * Constructeur de la classe GrilleDeJeu. Initialise une grille avec un nombre
     * de lignes et de colonnes spécifié, et crée une matrice de cellules lumineuses.
     * @param nbLignes le nombre de lignes de la grille.
     * @param nbColonnes le nombre de colonnes de la grille.
     */
    public GrilleDeCellules(int nbLignes, int nbColonnes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];
        
        for (int i = 0; i<nbLignes; i++) {
            for (int j = 0; j<nbColonnes; j++) {
                this.matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }
    
    
    
    /**
     * Éteint toutes les cellules de la grille en appelant la méthode
     * `eteindreCellule()` sur chaque cellule de la matrice.
     */
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                this.matriceCellules[i][j].eteindreCellule();
            }
        }
    }
    
    
    
    /**
     * Active une cellule donnée et ses voisines adjacentes en croix
     * (haut, bas, gauche, droite), si elles sont dans les limites de la grille.
     * @param ligne
     * @param colonne
     */
    public void activerCroix(int ligne, int colonne) {
        matriceCellules[ligne][colonne].activerCellule();

        if (ligne > 0) {
            matriceCellules[ligne - 1][colonne].activerCellule();
        }
        if (ligne < nbLignes - 1) {
            matriceCellules[ligne + 1][colonne].activerCellule();
        }
        if (colonne > 0) {
            matriceCellules[ligne][colonne - 1].activerCellule();
        }
        if (colonne < nbColonnes - 1) {
            matriceCellules[ligne][colonne + 1].activerCellule();
        }
    }
    
    public void activerLigneDeCellules(int idLigne){
        
    }
    
    
    
    /**
     * Mélange aléatoirement la grille en activant des motifs en croix à des positions aléatoires un nombre donné de fois.
     * @param nbTours le nombre d'itérations pour mélanger la grille.
     */
    public void melangerMatriceAleatoirement(int nbTours) {
        Random random = new Random();
        eteindreToutesLesCellules();
        for (int n = 0; n < nbTours; n++) {
            int ligne = (int) (Math.random() * nbLignes);
            int colonne = (int) (Math.random() * nbColonnes);
            activerCroix(ligne, colonne);
        }
    }
    
    
    
    /**
     * Vérifie si toutes les cellules de la grille sont éteintes.
     * Une cellule est considérée éteinte si son état est `false`.
     * @return `true` si toutes les cellules sont éteintes, sinon `false`.
     */
    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (matriceCellules[i][j].getEtat()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    
    /**
     * Retourne une représentation textuelle de la grille, affichant les indices
     * des lignes et colonnes ainsi que l'état de chaque cellule ('X' pour allumée,'O' pour éteinte).
     * @return une chaîne de caractères représentant la grille.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Ajouter les indices de colonnes
        sb.append("    ");
        for (int j = 0; j < nbColonnes; j++) {
            sb.append(String.format("| %d ", j));
        }
        sb.append("|\n");
        // Ligne de séparation
        sb.append("    ");
        sb.append("-".repeat(4 * nbColonnes));
        sb.append("\n");
         // Ajouter chaque ligne de la matrice
        for (int i = 0; i < nbLignes; i++) {
            sb.append(String.format("%d | ", i)); // Indice de ligne
            for (int j = 0; j < nbColonnes; j++) {
                sb.append(matriceCellules[i][j].getEtat() ? "X | " : "O | ");
            }
            sb.append("\n    ");
            sb.append("-".repeat(4 * nbColonnes));
            sb.append("\n");
        }

        return sb.toString();
    }   
    
    
    
    
}


