/**
 * @ File name: Star.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-06 16:36:54
 */

package startypes;

import java.awt.*;

public class Star {

    private int x;
    private int y;
    private StarType type;
    
    public Star(int x, int y, StarType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        g.setColor(type.getColor());
        g.fillOval(x, y , type.getSize(), type.getSize());
    }
}
