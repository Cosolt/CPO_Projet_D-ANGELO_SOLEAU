/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_dangelo_soleau_version_console;

/**
 *
 * @author colin
 */
public class CelluleLumineuse {
    private boolean etat ;

    
    /**
     * Constructeur par défaut de la classe
     * initialise la cellule à l'état false donc éteint
     */
    public CelluleLumineuse() {
        this.etat = false;
        
    }
    
    
    /**
     * Permet d'inverser l'état actuel de la cellule
     * Si éteint alors devient allumée, et vice-versa
     */
    public void activerCellule(){
        this.etat = !this.etat;
        System.out.println("La cellule est allumee");
    }
    
    
    /**
     * Permet de mettre la cellule à l'état éteint
     * Quelque soit l'état de la cellule, elle permet d'éteindre celle-ci
     */
    public void eteindreCellule(){
        this.etat = false;
        System.out.println("La cellule est eteinte");
    }
    
    
    /**
     * Vérifie si la cellule est éteinte ou non
     * @return
     */
    public boolean estEteint(){
        return !this.etat;
    }

    
    /**
     * Retourne l'état actuel de la cellule
     * @return
     */
    public boolean getEtat() {
        return this.etat;
    }

    
      
    
    
}
