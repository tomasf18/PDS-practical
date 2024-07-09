/**
 * @ File name: TermFilter.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-22 15:49:52
 */

package lab08.ProcessadorTexto;

import java.util.*;

public class TermFilter extends Decorator {

    private ArrayList<String> words;

    public TermFilter(ReaderInterface reader) {
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
        return words.remove(0);
    }
    
}
