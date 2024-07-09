

import java.util.ArrayList;
import java.util.Comparator;

public class BubbleSort extends Algorithm {

    public BubbleSort(Attribute attr, Order order, ArrayList<Phone> phones) {
        super(attr, order, phones);
    }

    public static <T> void bubbleSort(ArrayList<T> list, Comparator<? super T> comparator) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (comparator.compare(list.get(i), list.get(i + 1)) > 0) {
                    T temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    @Override
    public void sort() {
        switch (super.getAttributeFilter()) {
            case MEMORY:
                bubbleSort(getPhones(), Comparator.comparingInt(Phone::getMemory));
                break;
            case PRICE:
                bubbleSort(getPhones(), Comparator.comparingDouble(Phone::getPrice));
                break;
            case CAMERA:
                bubbleSort(getPhones(), Comparator.comparing(Phone::getCamera));
                break;
            case PROCESSOR:
                bubbleSort(getPhones(), Comparator.comparing(Phone::getProcessor));
                break;
            default:
                throw new IllegalArgumentException("Invalid attribute filter");
        }
    }
}
