package ImprovedVersion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PuzzleElements {

    // Método que lê a sopa de letras e devolve a matriz de caracteres
    public Character[][] readSoup(File file, int size) throws FileNotFoundException{

        Character[][] soup = new Character[size][size];
        
        Scanner sc = new Scanner(file);
    
        for (int i = 0; i < size; i++) {
                
        String line = sc.nextLine();
            
            for (int j = 0; j < size; j++) {
                soup[i][j] = line.charAt(j);
            }
        }

        sc.close();
        
        return soup;
    }
    
    // Método que lê o ficheiro e devolve as palavras a serem encontradas
    public ArrayList<String> readTargetWords(File file, int size) throws FileNotFoundException{

        ArrayList<String> targetWords = new ArrayList<String>();

        Scanner sc = new Scanner(file);

        skipFirstLines(sc, size);
            
        while (sc.hasNextLine()) {
            String line = sc.nextLine();  
            addWords(targetWords, line);
        }

        sc.close();

        return targetWords;
    }

    // método para saltar as primeiras size linhas
    private void skipFirstLines(Scanner sc, int size) {
        for (int i = 0; i < size; i++) {
            sc.nextLine();
        }
    }

    // método para adicionar as palavras a serem encontradas
    private void addWords(ArrayList<String> targetWords, String line) {

        String[] lineWords = line.split("[; ,]");

        for (String word : lineWords) {

            if (!isValidWord(word)) {
                System.exit(1);
            }
            targetWords.add(word.toLowerCase());
        }
    }

    private boolean isValidWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isAlphabetic(word.charAt(i))) {
                System.out.println("Invalid file: invalid word");
                return false;
            }
        }
        return true;
    }
}
