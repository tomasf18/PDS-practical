package ImprovedVersion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolvedSoup {
    private Character[][] solvedSoup;
    private Map<String, List<Pair>> wordsPositions;
    private Map<String, Direction> wordsDirections;
    private ArrayList<String> words;

    public SolvedSoup(Character[][] soup, ArrayList<String> words, boolean[][] solvedSoupBoolean, Map<String, List<Pair>> wordsPositions, Map<String, Direction> wordsDirections) {
        this.solvedSoup = soup;
        this.words = words;
        this.wordsPositions = wordsPositions;
        this.wordsDirections = wordsDirections;

        for (int i = 0; i < soup.length; i++) {
            for (int j = 0; j < soup.length; j++) {
                if (solvedSoupBoolean[i][j] == false) {
                    solvedSoup[i][j] = '.';
                }
            }
        }

    }

    public String solvedSoupToString() {
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(String.format("%-15s %-7d %-7s %s\n", word, word.length(), String.format("%d,%d", wordsPositions.get(word.toUpperCase()).get(0).getX()+1, wordsPositions.get(word.toUpperCase()).get(0).getY()+1), directionToString(wordsDirections.get(word.toUpperCase()))));
        }

        sb.append("\n");

        for (int i = 0; i < solvedSoup.length; i++) {
            for (int j = 0; j < solvedSoup.length; j++) {
                sb.append(solvedSoup[i][j]);
                if (j == solvedSoup.length - 1)
                    sb.append("\n");
            }
        } 

        return sb.toString();
    }

    public String directionToString(Direction dir) {
        switch (dir) {
            case Direction.DIR:
                return "Right"; 
            case Direction.DIRBAIXO:
                return "DownRight";
            case Direction.DIRCIMA:
                return "UpRight";
            case Direction.CIMA:
                return "Up";
            case Direction.BAIXO:
                return "Down";
            case Direction.ESQ:
                return "Left";
            case Direction.ESQBAIXO:
                return "DownLeft"; 
            case Direction.ESQCIMA:
                return "UpLeft";
            default:
                return null;    
        }
    }

}
