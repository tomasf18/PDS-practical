/**
 * @ File name: GStar.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:36:30
 */

package startypes;
import java.awt.Color;

public class GStar extends StarType{
    private static GStar instance = null;
    
    public GStar() {
        super(1, new Color(245, 250, 250));
        this.description = "This is a long description of the G type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static GStar getInstance() {
        if (instance == null) {
            instance = new GStar();
        }
        return instance;
    }
}
