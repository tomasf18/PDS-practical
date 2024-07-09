/**
 * @ File name: OStar.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:36:48
 */

package startypes;
import java.awt.Color;

public class OStar extends StarType{
    private static OStar instance = null;
    
    public OStar() {
        super(5, new Color(225, 250, 250));
        this.description = "This is a long description of the O type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static OStar getInstance() {
        if (instance == null) {
            instance = new OStar();
        }
        return instance;
    }
}
