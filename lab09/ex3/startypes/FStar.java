/**
 * @ File name: FStar.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:36:24
 */

package startypes;
import java.awt.Color;

public class FStar extends StarType{
    private static FStar instance = null;
    
    public FStar() {
        super(2, new Color(255, 255, 245));
        this.description = "This is a long description of the F type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static FStar getInstance() {
        if (instance == null) {
            instance = new FStar();
        }
        return instance;
    }
}
