package lab01;

import java.util.*;
import java.io.*;

public class WSSolver {
    public static void main(String[] args) throws FileNotFoundException {
        
        // Verifica se o número de argumentos é válido
        if (args.length != 1) {
            System.out.println("Usage: java WSSolver <input_file>");
            return;
        }

        int size = 0;
        File file = null;

        file = new File(args[0]);


        Scanner sc = new Scanner(file);
        size = sc.nextLine().length();
        sc.close();

        // Verifica se o ficheiro é válido
        if (size > 40) {
            System.out.println("Invalid size: " + size + "(>40)");
            return;
        }

        PuzzleValidator validator = new PuzzleValidator();

        if (!validator.isValidPuzzle(file, size)) {
            return;
        }

        PuzzleElements elements = new PuzzleElements();

        // matriz de caracteres
        Character[][] soup = elements.readSoup(file, size);

        // palavras a serem encontradas
        ArrayList<String> words = elements.readTargetWords(file, size);

        
        PuzzleSolver solver = new PuzzleSolver(soup);

        //System.out.println(solver.findTarget(words));

        boolean[][] booleanSolvedSoup = solver.findTarget(words);

        Map<String, List<Pair>> wordsPositions = solver.getWordsPositionsMap();
        Map<String, Direction> wordsDirections = solver.getWordsDirectionsMap();

        SolvedSoup solvedSoup = new SolvedSoup(soup, words, booleanSolvedSoup, wordsPositions, wordsDirections);

        System.out.println(solvedSoup.solvedSoupToString());

    }
}
