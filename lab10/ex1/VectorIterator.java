/**
 * @ File name: VectorIterator.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-13 15:04:17
 */

package ex1;

import java.util.Iterator;

public class VectorIterator<T> implements Iterator<T>{
    private VectorGeneric<T> vector;
    private int index;

    public VectorIterator(VectorGeneric<T> vector) {
        this.vector = vector;
        this.index = 0;
    }

    public boolean hasNext() {
        return index < vector.totalElem();
    }

    public T next() {
        return vector.getElem(index++);
    }
}
