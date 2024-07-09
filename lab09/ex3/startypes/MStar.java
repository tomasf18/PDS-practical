/**
 * @ File name: MStar.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:36:42
 */

package startypes;
import java.awt.Color;

public class MStar extends StarType{
    private static MStar instance = null;
    
    public MStar() {
        super(1, Color.RED);
        this.description = "This is a long description of the M type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static MStar getInstance() {
        if (instance == null) {
            instance = new MStar();
        }
        return instance;
    }
}
