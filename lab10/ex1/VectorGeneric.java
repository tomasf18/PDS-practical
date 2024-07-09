/**
 * @ File name: VectorGeneric.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-13 14:55:54
 */

package ex1;

public class VectorGeneric<T> {
	T[] vec;		
	private int nElem;	      
	private final static int ALLOC = 50;   
	private int dimVec = ALLOC;     

	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}
	
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}

	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}

	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}

	public int totalElem() {
		return nElem;
	}
	
	public T getElem(int i) {
		return (T) vec[i];
	}

	public java.util.Iterator<T> iterator() {
		return new VectorIterator<T>(this);
	}

	public java.util.ListIterator<T> listIterator() {
		return new VectorListIterator<T>(this);
	}

	public java.util.ListIterator<T> listIterator(int index) {
		return new VectorListIterator<T>(this, index);
	}
}
