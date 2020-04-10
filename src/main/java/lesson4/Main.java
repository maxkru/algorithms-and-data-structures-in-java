package lesson4;

import lesson4.util.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        System.out.println(list);
        System.out.println(list.contains(3));
        System.out.println(list.contains(5));
    }
}
