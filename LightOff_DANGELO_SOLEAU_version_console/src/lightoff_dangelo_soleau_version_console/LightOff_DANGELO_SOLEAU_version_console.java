/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightoff_dangelo_soleau_version_console;

import java.util.Scanner;

/**
 *
 * @author colin
 */
public class LightOff_DANGELO_SOLEAU_version_console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GrilleDeCellules grille = new GrilleDeCellules(5, 5) ;
        System.out.println(grille);
        
        int maxCoups = 10;
        
        Partie partie = new Partie(grille, maxCoups);
        partie.initialiserPartie();
        partie.lancerPartie();
        
        
        
        
    }
    
}
