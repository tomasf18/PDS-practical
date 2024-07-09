/**
 * @ File name: Main.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-13 15:24:51
 */

package ex1;

public class Main {
    public static void main(String[] args) {
        VectorGeneric<String> vector = new VectorGeneric<>();
        for (int i = 0; i < 20; i++) {
            // Add 20 alphabetic letters to the vector
            vector.addElem(String.valueOf((char) (i + 65)));
        }

        // Print the vector using an iterator
        System.out.println("\n");
        System.out.println("Print the vector using an iterator:");
        VectorIterator<String> iterator = new VectorIterator<>(vector);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        // Print the vector using a list iterator
        System.out.println("\n");
        System.out.println("Print the vector using a list iterator:");
        VectorListIterator<String> listIterator = new VectorListIterator<>(vector);
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }

        // Print the vector using a list iterator starting from the end
        System.out.println("\n");
        System.out.println("Print the vector using a list iterator starting from the end:");
        listIterator = new VectorListIterator<>(vector, vector.totalElem());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }

        // Print the vector using a list iterator starting from the middle
        System.out.println("\n");
        System.out.println("Print the vector using a list iterator starting from the middle:");
        listIterator = new VectorListIterator<>(vector, vector.totalElem() / 2);
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }

        System.out.println("\n");
        System.out.println("=========================== In this section the different iterators will be used dinamically ===========================");
        System.out.println("\n");

        // Print half of the vector using an iterator, then entire vector using a list iterator and finally the other half of the vector using the iterator
        System.out.println("Print half of the vector using an iterator: ");
        iterator = new VectorIterator<>(vector);
        listIterator = new VectorListIterator<>(vector);
        for (int i = 0; i < vector.totalElem() / 2; i++) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n");
        System.out.println("Print the entire vector using a list iterator: ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println("\n");
        System.out.println("Print the other half of the vector using the first iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n");
    }
}
