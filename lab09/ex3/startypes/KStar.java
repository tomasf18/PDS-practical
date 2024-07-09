/**
 * @ File name: KStar.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:36:36
 */

package startypes;
import java.awt.Color;

public class KStar extends StarType{
    private static KStar instance = null;
    
    public KStar() {
        super(1, new Color(230, 160, 10));
        this.description = "This is a long description of the K type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static KStar getInstance() {
        if (instance == null) {
            instance = new KStar();
        }
        return instance;
    }
}
