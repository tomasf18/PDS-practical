/**
 * @ File name: BStar.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:36:18
 */

package startypes;
import java.awt.Color;

public class BStar extends StarType{
    private static BStar instance = null;
    
    public BStar() {
        super(5, new Color(230, 252, 252));
        this.description = "This is a long description of the B type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static BStar getInstance() {
        if (instance == null) {
            instance = new BStar();
        }
        return instance;
    }
}
