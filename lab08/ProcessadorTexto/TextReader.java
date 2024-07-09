/**
 * @ File name: TextReader.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-22 14:57:35
 */

package lab08.ProcessadorTexto;

import java.util.*;
import java.io.*;

public class TextReader implements ReaderInterface {
    private Scanner scanner;

    public TextReader(File file) throws FileNotFoundException {
        this.scanner = new Scanner(file);
    }

    @Override
    public boolean hasNext() {
        return this.scanner.hasNextLine();
    }

    @Override
    public String next() {
        if (hasNext()) {
            return this.scanner.nextLine();
        }
        return null;
    }

}
