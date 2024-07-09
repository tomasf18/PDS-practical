package lab01;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class PuzzleGenerator {

    public ArrayList<String> readTargetWords(File file, int size) throws FileNotFoundException{

        ArrayList<String> targetWords = new ArrayList<String>();

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {

            String line = sc.nextLine();

            if (!isValidLine(line)) {
                System.exit(1);
            }
            
            addWords(targetWords, line, size);
        }
        sc.close();


        return targetWords;
    }

    public Character[][] generatePuzzle(ArrayList<String> targetWords, int size) {

        Character randomSoup[][] = generateRandomSoup(size);

        Character soup[][] = putWordsOnSoup(targetWords, size, randomSoup);

        return soup;
    }

    private Character[][] generateRandomSoup(int size) {
        Character soup[][] = new Character[size][size];

        for (int i = 0; i < soup.length; i++) {
            for (int j = 0; j < soup.length; j++) {

                // geração de um número ASCII aleatório entre 65 e 90 corresnpondendo a um caracter maiúsculo
                char randomChar = (char) (Math.random() * 26 + 'A'); 
                soup[i][j] = randomChar;
            }
        }

        return soup;
    }

    private Character [][] putWordsOnSoup(ArrayList<String> targetWords, int size, Character[][] soup) {

        Character booleanSoup[][] = GenerateBooleanSoup(size);

        for (String word : targetWords) {

            boolean wordPlaced = false;
            int soupLimit = size - 1;

            while (!wordPlaced) {

                boolean canPlaceWord = true;
                Direction randomDirection = getRandomDirection();
                int x;
                int y;

                switch (randomDirection) {
                    case DIR:
                        // x pode ter qualquer valor entre 0 e soupLimit e y pode ter qualquer valor entre 0 e size - word.length()
                        // se a palavra for colocada na posição (x, y) então a palavra vai de (x, y) até (x, y + word.length())

                        x = (int) (Math.random() * soupLimit);
                        y = (int) (Math.random() * (size - word.length()));

                        for (int i = 0; i < word.length(); i++) {
                            if (booleanSoup[x][y + i] == '1') {
                                canPlaceWord = false;
                                break;
                            }
                        }

                        if (!canPlaceWord) {
                            break;
                        }

                        for (int i = 0; i < word.length(); i++) {
                            soup[x][y + i] = word.charAt(i);
                            booleanSoup[x][y + i] = '1';
                        }
                        wordPlaced = true;

                        break;
                    case ESQ:
                        // x pode ter qualquer valor entre 0 e soupLimit e y pode ter qualquer valor entre word.length() - 1 e soupLimit
                        // se a palavra for colocada na posição (x, y) então a palavra vai de (x, y) até (x, y - word.length())

                        x = (int) (Math.random() * soupLimit);
                        y = (int) (Math.random() * (soupLimit - (word.length() - 1)) + word.length() - 1);

                        for (int i = 0; i < word.length(); i++) {
                            if (booleanSoup[x][y - i] == '1') {
                                canPlaceWord = false;
                                break;
                            }
                        }

                        if (!canPlaceWord) {
                            break;
                        }

                        for (int i = 0; i < word.length(); i++) {
                            soup[x][y - i] = word.charAt(i);
                            booleanSoup[x][y - i] = '1';
                        }
                        wordPlaced = true;

                        break;
                    case CIMA:
                        // x pode ter qualquer valor entre word.length() - 1 e soupLimit e y pode ter qualquer valor entre 0 e soupLimit
                        // se a palavra for colocada na posição (x, y) então a palavra vai de (x, y) até (x - word.length(), y)

                        x = (int) (Math.random() * (soupLimit - (word.length() - 1)) + word.length() - 1);
                        y = (int) (Math.random() * soupLimit);

                        for (int i = 0; i < word.length(); i++) {
                            if (booleanSoup[x - i][y] == '1') {
                                canPlaceWord = false;
                                break;
                            }
                        }

                        if (!canPlaceWord) {
                            break;
                        }

                        for (int i = 0; i < word.length(); i++) {
                            soup[x - i][y] = word.charAt(i);
                            booleanSoup[x - i][y] = '1';
                        }
                        wordPlaced = true;

                        break;
                    case BAIXO:
                        // x pode ter qualquer valor entre 0 e size - word.length() e y pode ter qualquer valor entre 0 e soupLimit
                        // se a palavra for colocada na posição (x, y) então a palavra vai de (x, y) até (x + word.length(), y)

                        x = (int) (Math.random() * (size - word.length()));
                        y = (int) (Math.random() * soupLimit);

                        for (int i = 0; i < word.length(); i++) {
                            if (booleanSoup[x + i][y] == '1') {
                                canPlaceWord = false;
                                break;
                            }
                        }

                        if (!canPlaceWord) {
                            break;
                        }

                        for (int i = 0; i < word.length(); i++) {
                            soup[x + i][y] = word.charAt(i);
                            booleanSoup[x + i][y] = '1';
                        }
                        wordPlaced = true;

                        break;
                    case DIRCIMA:
                        // x pode ter qualquer valor entre word.length() - 1 e soupLimit e y pode ter qualquer valor entre 0 e size - word.length()
                        // se a palavra for colocada na posição (x, y) então a palavra vai de (x, y) até (x - word.length(), y + word.length())

                        x = (int) (Math.random() * (soupLimit - (word.length() - 1)) + word.length() - 1);
                        y = (int) (Math.random() * (size - word.length()));

                        for (int i = 0; i < word.length(); i++) {
                            if (booleanSoup[x - i][y + i] == '1') {
                                canPlaceWord = false;
                                break;
                            }
                        }

                        if (!canPlaceWord) {
                            break;
                        }

                        for (int i = 0; i < word.length(); i++) {
                            soup[x - i][y + i] = word.charAt(i);
                            booleanSoup[x - i][y + i] = '1';
                        }
                        wordPlaced = true;

                        break;
                    case DIRBAIXO:
                        // x pode ter qualquer valor entre 0 e size - word.length() e y pode ter qualquer valor entre 0 e size - word.length()
                        // se a palavra for colocada na posição (x, y) então a palavra vai de (x, y) até (x + word.length(), y + word.length())

                        x = (int) (Math.random() * (size - word.length()));
                        y = (int) (Math.random() * (size - word.length()));

                        for (int i = 0; i < word.length(); i++) {
                            if (booleanSoup[x + i][y + i] == '1') {
                                canPlaceWord = false;
                                break;
                            }
                        }

                        if (!canPlaceWord) {
                            break;
                        }

                        for (int i = 0; i < word.length(); i++) {
                            soup[x + i][y + i] = word.charAt(i);
                            booleanSoup[x + i][y + i] = '1';
                        }
                        wordPlaced = true;

                        break;
                    case ESQCIMA:
                        // x pode ter qualquer valor entre word.length() - 1 e soupLimit e y pode ter qualquer valor entre word.length() - 1 e soupLimit
                        // se a palavra for colocada na posição (x, y) então a palavra vai de (x, y) até (x - word.length(), y - word.length())

                        x = (int) (Math.random() * (soupLimit - (word.length() - 1)) + word.length() - 1);
                        y = (int) (Math.random() * (soupLimit - (word.length() - 1)) + word.length() - 1);

                        for (int i = 0; i < word.length(); i++) {
                            if (booleanSoup[x - i][y - i] == '1') {
                                canPlaceWord = false;
                                break;
                            }
                        }

                        if (!canPlaceWord) {
                            break;
                        }

                        for (int i = 0; i < word.length(); i++) {
                            soup[x - i][y - i] = word.charAt(i);
                            booleanSoup[x - i][y - i] = '1';
                        }
                        wordPlaced = true;

                        break;
                    case ESQBAIXO:
                        // x pode ter qualquer valor entre 0 e size - word.length() e y pode ter qualquer valor entre word.length() - 1 e soupLimit
                        // se a palavra for colocada na posição (x, y) então a palavra vai de (x, y) até (x + word.length(), y - word.length())

                        x = (int) (Math.random() * (size - word.length()));
                        y = (int) (Math.random() * (soupLimit - (word.length() - 1)) + word.length() - 1);
                        
                        for (int i = 0; i < word.length(); i++) {
                            if (booleanSoup[x + i][y - i] == '1') {
                                canPlaceWord = false;
                                break;
                            }
                        }

                        if (!canPlaceWord) {
                            break;
                        }

                        for (int i = 0; i < word.length(); i++) {
                            soup[x + i][y - i] = word.charAt(i);
                            booleanSoup[x + i][y - i] = '1';
                        }
                        wordPlaced = true;

                        break;
                }
            }
        }

        return soup;
    }

    public static Direction getRandomDirection() {
        Random random = new Random();
        return Direction.values()[random.nextInt(Direction.values().length)];
    }

    private Character[][] GenerateBooleanSoup(int size) {
        Character booleanSoup[][] = new Character[size][size];

        for (int i = 0; i < booleanSoup.length; i++) {
            for (int j = 0; j < booleanSoup[i].length; j++) {
                booleanSoup[i][j] = '0';
            }
        }

        return booleanSoup;
    }

    private boolean isValidLine(String line) {
        if (line.length() == 0) {
            System.out.println("Invalid file: empty line");
            return false;
        }

        if (line.equals(line.toUpperCase())) {
            System.out.println("Invalid file: line is all uppercase");
            return false;
        }
        return true;
    }

    private void addWords(ArrayList<String> targetWords, String line, int size) {

        String[] lineWords = line.split("[; ,]");

        for (String word : lineWords) {

            if (!isValidWord(word, size)) {
                System.exit(1);
            }
            targetWords.add(word.toUpperCase());
        }
    }

    private boolean isValidWord(String word, int size) {
        if (word.length() > size) {
            System.out.println("Invalid word on file (word size > puzzle size)");
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (!Character.isAlphabetic(word.charAt(i))) {
                System.out.println("Invalid word on file");
                return false;
            }
        }
        return true;
    }

    public void writeSoupOnFile(File inputFile, Character[][] soup, String outputFileName) throws IOException {

        PrintWriter writer = null;

        try {
            FileWriter fileWriter = new FileWriter(outputFileName);
            writer = new PrintWriter(fileWriter);

            // Escreve a sopa de letras no ficheiro
            for (int i = 0; i < soup.length; i++) {
                for (int j = 0; j < soup[i].length; j++) {
                    writer.print(soup[i][j]);
                }
                writer.println();
            }

            // Escreve as palavras a serem encontradas no ficheiro
            Scanner sc = new Scanner(inputFile);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                writer.println(line);
            }

            sc.close();

            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("ould not create file: " + outputFileName);
            System.exit(1);
        }
    }

    public void printOutput(Character[][] soup, File inputFile) throws FileNotFoundException{

        for (int i = 0; i < soup.length; i++) {
            for (int j = 0; j < soup[i].length; j++) {
                System.out.print(soup[i][j]);
            }
            System.out.println();
        }

        Scanner sc = new Scanner(inputFile);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
        }

        sc.close();
    }
}
