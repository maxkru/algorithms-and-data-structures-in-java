package lesson3;

import lesson3.util.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Stack");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        try {
            for (; ; )
                System.out.print(stack.pop() + " ");
        } catch (Throwable e) {
            System.out.println();
            e.printStackTrace(System.out);
        }
        System.out.println();

        System.out.println("Queue");
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        try {
            for (; ; )
                System.out.print(queue.remove() + " ");
        } catch (Throwable e) {
            System.out.println();
            e.printStackTrace(System.out);
        }
        System.out.println();

        System.out.println("Deque addFirst removeFirst");
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 10; i++) {
            deque.addFirst(i);
        }
        try {
            for (; ; )
                System.out.print(deque.removeFirst() + " ");
        } catch (Throwable e) {
            System.out.println();
            e.printStackTrace(System.out);
        }
        System.out.println();

        System.out.println("Deque addLast removeFirst");
        for (int i = 0; i < 10; i++) {
            deque.addLast(i);
        }
        try {
            for (; ; )
                System.out.print(deque.removeFirst() + " ");
        } catch (Throwable e) {
            System.out.println();
            e.printStackTrace(System.out);
        }
        System.out.println();

        System.out.println("Deque addFirst removeLast");
        for (int i = 0; i < 10; i++) {
            deque.addFirst(i);
        }
        try {
            for (; ; )
                System.out.print(deque.removeLast() + " ");
        } catch (Throwable e) {
            System.out.println();
            e.printStackTrace(System.out);
        }
        System.out.println();

        System.out.println("Deque addLast removeLast");
        for (int i = 0; i < 10; i++) {
            deque.addLast(i);
        }
        try {
            for (; ; )
                System.out.print(deque.removeLast() + " ");
        } catch (Throwable e) {
            System.out.println();
            e.printStackTrace(System.out);
        }
        System.out.println();

        System.out.println("PriorityQueue");
        Random random = new Random();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            priorityQueue.add(random.nextInt(20));
        }
        try {
            for (; ; )
                System.out.print(priorityQueue.remove() + " ");
        } catch (Throwable e) {
            System.out.println();
            e.printStackTrace(System.out);
        }
        System.out.println();

        String string = "abcdefg hjklmno";
        System.out.println(string);
        System.out.println(StringUtil.reverse(string));
    }
}
