package ImprovedVersion;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WSGenerator {

    private static int MAX_SIZE = 40;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        if (args.length < 4 || args.length > 6) {
            System.out.println("Usage: java WSGenerator -i <input_file> -s <size> optional(-o <output_file>)");
            return;
        }

        ReadGeneratorArguments readGeneratorArguments = new ReadGeneratorArguments();
        HashMap<String, String> options = readGeneratorArguments.readArguments(args);

        String nameInputFile = options.get("-i");
        String size = options.get("-s");
        String nameOutputFile = options.get("-o");

        File inputFile = null;
        int soupSize = 0;

        try {
            soupSize = Integer.parseInt(size);
            if (soupSize > MAX_SIZE) {
                System.out.println("Invalid size: " + size + "(>" + MAX_SIZE + ")");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid size: " + size);
            return;
        }

        inputFile = new File(nameInputFile);

        if (!inputFile.exists()) {
            System.out.println("File not found: " + nameInputFile);
            return;
        }

        PuzzleGenerator generator = new PuzzleGenerator();

        ArrayList<String> words = generator.readTargetWords(inputFile, soupSize);

        Character[][] soup = generator.generatePuzzle(words, soupSize);

        if (nameOutputFile == null) {
            generator.printOutput(soup, inputFile);
        } else {
            generator.writeSoupOnFile(inputFile, soup, nameOutputFile);
        }
    }
}
