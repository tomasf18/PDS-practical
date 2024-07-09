

import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort extends Algorithm {

    public SelectionSort(Attribute attr, Order order, ArrayList<Phone> phones) {
        super(attr, order, phones);
    }

    public static <T> void selectionSort(ArrayList<T> list, Comparator<? super T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

    @Override
    public void sort() {
        switch (super.getAttributeFilter()) {
            case Attribute.MEMORY:
                selectionSort(getPhones(), Comparator.comparingInt(Phone::getMemory));
            case Attribute.PRICE:
                selectionSort(getPhones(), Comparator.comparingDouble(Phone::getPrice));
            case Attribute.CAMERA:
                selectionSort(getPhones(), Comparator.comparing(Phone::getCamera));
            case Attribute.PROCESSOR:
                selectionSort(getPhones(), Comparator.comparing(Phone::getProcessor));

        }
    }
}
