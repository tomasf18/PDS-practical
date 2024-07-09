/**
 * @ File name: CapitalizationFilter.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-22 16:34:57
 */

package lab08.ProcessadorTexto;

import java.util.ArrayList;

public class CapitalizationFilter extends Decorator {
    
    private ArrayList<String> words;

    public CapitalizationFilter(ReaderInterface reader) {
        super(reader);
        this.words = new ArrayList<>();
    }

    @Override
    public boolean hasNext() {
        if (words.size() != 0) {
            return true;
        }
        if (super.hasNext()) {
            String[] linewords = super.next().split(" ");
            for (String word : linewords) {
                words.add(word);
            }
            return true;
        }
        return false;
    }

    @Override
    public String next() {
        String word = words.remove(0);
        // Convert first and last letter to uppercase
        if (word.length() > 2) {
            word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length() - 1) + word.substring(word.length() - 1).toUpperCase();
        } else {
            word = word.toUpperCase();
        }

        return word;
    }
}
