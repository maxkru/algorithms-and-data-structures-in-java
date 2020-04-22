package lesson7.util;

import com.sun.istack.internal.NotNull;

import java.util.*;

public class GraphHashMapImpl implements Graph {

    private class Vertex {

        private String name;
        private boolean visited;

        private Vertex(String name) {
            this.name = name;
            this.visited = false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(name, vertex.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

    }

    private Map<Vertex, Map<Vertex, Integer>> linkMap;

    public GraphHashMapImpl() {
        linkMap = new HashMap<>();
    }

    public void addVertex(String name) {
        linkMap.put(new Vertex(name), new HashMap<>());
    }

    public void addLink(String vertex1Name, String vertex2Name, Integer linkValue) {
        if (linkValue == null)
            throw new NullPointerException();

        Vertex vertex1 = new Vertex(vertex1Name);
        Vertex vertex2 = new Vertex(vertex2Name);
        if (linkMap.containsKey(vertex1) && linkMap.containsKey(vertex2)) {
            linkMap.get(vertex1).put(vertex2, linkValue);
            linkMap.get(vertex2).put(vertex1, linkValue);
        }
    }

    public void resetVisited() {
        linkMap.keySet().forEach(vertex -> vertex.visited = false);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Vertex v1 : linkMap.keySet()) {
            sb.append(v1.name);
            sb.append(":");
            linkMap.get(v1).forEach((vertex, value) -> sb.append("(").append(vertex.name).append(", ").append(value).append(")"));
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
