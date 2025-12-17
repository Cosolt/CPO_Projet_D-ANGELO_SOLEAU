/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_dangelo_soleau_version_console;

/**
 *
 * @author evada
 */
public class GrilleDeCellules {
    // Création des attributs
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
        
        for (int i = 0; i<nbLignes; i++) {
            for (int j = 0; j<nbColonnes; j++) {
                this.matriceCellules[i][j] = new CelluleLumineuse(true);
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
    
    
    
    
    
}


