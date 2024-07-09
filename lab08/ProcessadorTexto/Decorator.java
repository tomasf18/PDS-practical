/**
 * @ File name: Decorator.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-22 14:45:53
 */

package lab08.ProcessadorTexto;

public class Decorator implements ReaderInterface {
    ReaderInterface reader;

    public Decorator(ReaderInterface reader) {
        this.reader = reader;
    }

    @Override
    public boolean hasNext() {
        return reader.hasNext();
    }

    @Override
    public String next() {
        return reader.next();
    }
}
