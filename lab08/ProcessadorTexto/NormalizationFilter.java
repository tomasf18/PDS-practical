/**
 * @ File name: NormalizationFilter.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-22 16:24:22
 */

package lab08.ProcessadorTexto;

import java.util.ArrayList;

public class NormalizationFilter extends Decorator {

    private ArrayList<String> words;

    public NormalizationFilter(ReaderInterface reader) {
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

        // remove pontuation and acentuation
        String regex = "[^\\sa-zA-Z0-9}]";
        
        return word.replaceAll(regex, "");
    }

    
}
