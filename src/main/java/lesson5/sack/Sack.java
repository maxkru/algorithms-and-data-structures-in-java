package lesson5.sack;

import java.util.LinkedList;
import java.util.List;

public class Sack {

    private int maxWeight;

    public Sack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int bestValue(List<Item> items) {
        return bestValueRec(0, 0, new LinkedList<>(items));
    }

    public int bestValueRec(int currValue, int currWeight, LinkedList<Item> items) {
        if (currWeight > maxWeight) {
            return 0;
        }
        if (items.isEmpty())
            return currValue;
        Item item = items.getFirst();
        LinkedList<Item> ll = new LinkedList<>(items);
        ll.removeFirst();
        int bestValue = bestValueRec(currValue + item.getValue(), currWeight + item.getWeight(), ll);
        bestValue = Math.max(bestValue, bestValueRec(currValue, currWeight, ll));
        return bestValue;
    }
}
