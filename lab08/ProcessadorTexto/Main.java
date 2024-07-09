/**
 * @ File name: Main.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-22 16:31:28
 */

package lab08.ProcessadorTexto;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        File file = new File("file.txt");
        
        TextReader reader = new TextReader(file);
        System.out.println("\nText Reader:");
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
        
        TermFilter termFilter = new TermFilter(new TextReader(file));
        System.out.println("\nTerm Filter:");
        while (termFilter.hasNext()) {
            System.out.println(termFilter.next());
        }

        NormalizationFilter normalizationFilter = new NormalizationFilter(new TextReader(file));
        System.out.println("\nNormalization Filter:");
        while (normalizationFilter.hasNext()) {
            System.out.println(normalizationFilter.next());
        }

        VowelFilter vowelFilter = new VowelFilter(new TextReader(file));
        System.out.println("\nVowel Filter:");
        while (vowelFilter.hasNext()) {
            System.out.println(vowelFilter.next());
        }

        CapitalizationFilter capitalizationFilter = new CapitalizationFilter(new TextReader(file));
        System.out.println("\nCapitalization Filter:");
        while (capitalizationFilter.hasNext()) {
            System.out.println(capitalizationFilter.next());
        }
    }
}
