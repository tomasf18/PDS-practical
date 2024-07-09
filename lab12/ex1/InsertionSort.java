

import java.util.ArrayList;
import java.util.Comparator;

public class InsertionSort extends Algorithm {

    public InsertionSort(Attribute attr, Order order, ArrayList<Phone> phones) {
        super(attr, order, phones);
    }

    public static <T> void insertionSort(ArrayList<T> list, Comparator<? super T> comparator) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    @Override
    public void sort() {
        switch (super.getAttributeFilter()) {
            case MEMORY:
                insertionSort(getPhones(), Comparator.comparingInt(Phone::getMemory));
                break;
            case PRICE:
                insertionSort(getPhones(), Comparator.comparingDouble(Phone::getPrice));
                break;
            case CAMERA:
                insertionSort(getPhones(), Comparator.comparing(Phone::getCamera));
                break;
            case PROCESSOR:
                insertionSort(getPhones(), Comparator.comparing(Phone::getProcessor));
                break;
            default:
                throw new IllegalArgumentException("Invalid attribute filter");
        }
    }
}
