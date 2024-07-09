/**
 * @ File name: VowelFilter.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-22 16:27:57
 */

package lab08.ProcessadorTexto;

import java.util.*;

public class VowelFilter extends Decorator {
    
    private ArrayList<String> words;

    public VowelFilter(ReaderInterface reader) {
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
        return word.replaceAll("[aeiouAEIOU]", "");
    }

}
