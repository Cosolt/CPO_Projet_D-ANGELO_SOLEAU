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
     *
     * @param etat
     */
    public CelluleLumineuse(boolean etat) {
        this.etat = true;
    }
    
    /**
     *
     */
    public void activerCellule(){
        this.etat = !this.etat;
    }
    
    /**
     *
     */
    public void eteindreCellule(){
        this.etat = false;
    }
    
    /**
     *
     * @return
     */
    public boolean estEteint(){
        return !this.etat;
    }

    /**
     *
     * @return
     */
    public boolean getEtat() {
        return this.etat;
    }

    @Override
    public String toString() {
        return this.etat ? "X" : "O";
    }

      
}
