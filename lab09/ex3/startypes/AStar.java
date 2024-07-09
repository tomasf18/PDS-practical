/**
 * @ File name: AStar.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:36:15
 */

package startypes;
import java.awt.Color;

public class AStar extends StarType{
    private static AStar instance = null;
    
    public AStar() {
        super(2, Color.WHITE);
        this.description = "This is a long description of the A type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static AStar getInstance() {
        if (instance == null) {
            instance = new AStar();
        }
        return instance;
    }
}
