package lab01;

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

        HashMap<String, String> options = readArguments(args);

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

    public static HashMap<String, String> readArguments(String[] args) {
        
        HashMap<String, String> options = new HashMap<>();

        boolean inputFound = false;
        boolean sizeFound = false;

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "-i":
                    if (inputFound) {
                        System.out.println("Option -i appears more than once.");
                        System.exit(1);
                    }
                    // Verifica se o próximo argumento não começa com '-'
                    if (i + 1 >= args.length || args[i + 1].startsWith("-")) {
                        System.out.println("Missing argument for option -i.");
                        System.exit(1);
                    }
                    options.put("-i", args[i + 1]);
                    inputFound = true;
                    i++; // Incrementa o índice para ignorar o argumento associado a '-i'
                    break;
                case "-s":
                    if (sizeFound) {
                        System.out.println("Option -s appears more than once.");
                        System.exit(1);
                    }
                    // Verifica se o próximo argumento não começa com '-'
                    if (i + 1 >= args.length || args[i + 1].startsWith("-")) {
                        System.out.println("Missing argument for option -s.");
                        System.exit(1);
                    }
                    options.put("-s", args[i + 1]);
                    sizeFound = true;
                    i++; // Incrementa o índice para ignorar o argumento associado a '-s'
                    break;
                case "-o":
                    // Verifica se o próximo argumento não começa com '-'
                    if (i + 1 >= args.length || args[i + 1].startsWith("-")) {
                        System.out.println("Missing argument for option -o.");
                        System.exit(1);
                    }
                    options.put("-o", args[i + 1]);
                    i++; // Incrementa o índice para ignorar o argumento associado a '-o'
                    break;
                default:
                    System.out.println("Invalid option: " + arg);
                    System.exit(1);
            }
        }

        if (!inputFound || !sizeFound) {
            System.out.println("Options -i and -s are mandatory.");
            System.exit(1);
        }

        return options;
    }
}
