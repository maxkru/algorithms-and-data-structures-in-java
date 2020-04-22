package lesson7;

import lesson7.util.Graph;
import lesson7.util.GraphHashMapImpl;

public class Main {

    public static void main(String[] args) {
        Graph graph = new GraphHashMapImpl();

        graph.addVertex("One");
        graph.addVertex("Two");
        graph.addVertex("Three");

        graph.addLink("One", "Two", 3);
        graph.addLink("Three", "Two", 4);
        graph.addLink("Three", "One", 5);

        System.out.println(graph.toString());
    }

}
