package lesson7;

import lesson7.util.Graph;
import lesson7.util.GraphHashMapImpl;

public class Main {

    public static void main(String[] args) {
        Graph graph = new GraphHashMapImpl();

        for (int i = 0; i < 10; i++) {
            graph.addVertex("Vertex " + (i + 1));
        }

        link(graph, 1, 2, 1);
        link(graph, 2, 3, 1);
        link(graph, 1, 3, 3);
        link(graph, 3, 4, 2);
        link(graph, 3, 5, 10);
        link(graph, 3, 6, 0);
        link(graph, 4, 7, 12);
        link(graph, 5, 8, 2);
        link(graph, 7, 9, 1);
        link(graph, 8, 9, 3);
        link(graph, 9, 10, 2);

        System.out.println(graph.toString());
        System.out.println(graph.getShortestPathValue("Vertex 1", "Vertex 10"));
    }

    private static void link(Graph graph, int i1, int i2, int value) {
        graph.addLink("Vertex " + i1, "Vertex " + i2, value);
    }

}
