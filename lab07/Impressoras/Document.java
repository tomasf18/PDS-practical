
/**
 * @ File name: Document.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 19:30:23
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Document {
    private String name;

    public Document(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        File file = new File(this.name);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext() && sb.length() < 20) {
                sb.append(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred reading the file.");
            e.printStackTrace();
        }
        return sb.toString().substring(0, Math.min(20, sb.toString().length() - 1)) + "...";
    }
}
