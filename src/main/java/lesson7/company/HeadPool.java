package lesson7.company;

import java.util.HashMap;

public class HeadPool {

    private int id = 0;
    private HashMap<String, Head> heads = new HashMap<>();

    public void addSubsidiaryToHead(String headName, String subsidiaryName, double forecast, double actual) {
        if (!heads.containsKey(headName)) {
            heads.put(headName, new Head(nextId(), headName));
        }
        Head head = heads.get(headName);
        head.subsidiaryList.add(new Subsidiary(nextId(), head.id, subsidiaryName, actual, forecast));
    }

    public void printPlanCompletionPercent() {
        // Необходимо вывести информацию на консоль, процент выполнения от плана по каждой ДО.
        for (Head head : heads.values()) {
            // для компаний без дочек ничего не выводим
            if (head.subsidiaryList.isEmpty())
                continue;
            System.out.println(head.name);
            for (Subsidiary subsidiary : head.subsidiaryList) {
                System.out.printf("\t%s: %.1f%%\n", subsidiary.name, subsidiary.planCompletionPercent());
            }
        }
    }

    private int nextId() {
        id++;
        return id;
    }
}
