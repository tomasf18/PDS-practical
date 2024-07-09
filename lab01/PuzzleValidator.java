package lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PuzzleValidator {

    // Método que verifica se o puzzle é válido
    public boolean isValidPuzzle(File file, int size) throws FileNotFoundException {

        try {

            // Ponteiro sc para início do ficheiro
            Scanner sc = new Scanner(file);
            
            // Verifica se as primeiras linhas (correspondentes à sopa de letras) são válidas
            if (!validateFirstLines(sc, size)) {
                return false;
            } 
            
            // Verifica se as linhas das palavras a serem encontradas são válidas
            // Ponteiro sc para a linha "size"
            if (!validateTargetWordsLines(sc)) {
                return false;
            }

            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file);
            return false;
        }
        return true;
    }

    private boolean validateFirstLines(Scanner sc, int size) {
        for (int i = 0; i < size; i++) {
            
            String line = sc.nextLine();
            
            // Verificar se a linha está vazia
            if (line.length() == 0) {
                System.out.println("Invalid file: empty line");
                return false;
            }

            // Verificar se a linha não tem o tamanho correto (!= size)
            if (line.length() != size) {
                System.out.println("Invalid file: wrong line size");
                return false;
            }

            for (int j = 0; j < size; j++) {

                // Verificar se a linha tem caracteres inválidos (caracteres que não são letras ou que não são maiúsculas)
                if (!Character.isAlphabetic(line.charAt(j)) || !Character.isUpperCase(line.charAt(j))) {
                    System.out.println("Invalid file: invalid character");
                    return false;
                }
            }  
        }
        return true;
    }

    private boolean validateTargetWordsLines(Scanner sc) {

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            // Verificar se a linha está vazia
            if (line.length() == 0) {
                System.out.println("Invalid file: empty line");
                return false;
            }
            
            // Verificar se a linha não tem todos os caracteres em maiúsculas (o que não pode acontecer)
            if (line.equals(line.toUpperCase())) {
                System.out.println("Invalid file: soup not quadratic");
                return false;
            }
        }
        return true;
    }

}
