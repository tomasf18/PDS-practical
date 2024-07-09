/**
 * @ File name: VectorListIterator.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-13 15:04:10
 */

package ex1;

import java.util.ListIterator;

public class VectorListIterator<T> implements ListIterator<T> {
    private VectorGeneric<T> vector;
    private int index;

    public VectorListIterator(VectorGeneric<T> vector) {
        this.vector = vector;
        this.index = 0;
    }

    public VectorListIterator(VectorGeneric<T> vector, int index) {
        this.vector = vector;
        this.index = index;
    }

    public boolean hasNext() {
        return index < vector.totalElem();
    }

    public T next() {
        return vector.getElem(index++);
    }

    public boolean hasPrevious() {
        return index > 0;
    }

    public T previous() {
        return vector.getElem(--index);
    }

    public int nextIndex() {
        return index + 1;
    }

    public int previousIndex() {
        return index - 1;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void set(T e) {
        throw new UnsupportedOperationException();
    }

    public void add(T e) {
        throw new UnsupportedOperationException();
    }
}
