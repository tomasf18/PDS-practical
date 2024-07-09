import java.util.HashMap;
import java.util.Map;

import startypes.*;

public class StarTypeFactory {
    private Map<Character, StarType> starTypes = new HashMap<>();

    public StarType getStarType(char type) {
        StarType starType = starTypes.get(type);
        if (starType == null) {
            switch (type) {
                case 'O':
                    starType = new OStar();
                    break;
                case 'A':
                    starType = new AStar();
                    break;
                case 'B':
                    starType = new BStar();
                    break;
                case 'F':
                    starType = new FStar();
                    break;
                case 'G':
                    starType = new GStar();
                    break;
                case 'K':
                    starType = new KStar();
                    break;
                case 'M':
                    starType = new MStar();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid star type: " + type);
            }
            starTypes.put(type, starType);
        }
        return starType;
    }
}
