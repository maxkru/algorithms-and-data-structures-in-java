package lesson7.util;

import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.MAX_VALUE;

public class GraphHashMapImpl implements Graph {

    private class Vertex {

        private String name;

        private Vertex(String name) {
            this.name = name;
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
//        throw new NoSuchElementException();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Vertex v1 : linkMap.keySet()) {
            sb.append(v1.name);
            sb.append(":");
            linkMap.get(v1).forEach((v2, value) -> sb.append("(").append(v2.name).append(", ").append(value).append(")"));
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    public Integer getShortestPathValue(String sourceName, String destName) {
        Vertex vSource = new Vertex(sourceName);
        Vertex vDest = new Vertex(destName);

        if (!linkMap.containsKey(vSource))
            throw new NoSuchElementException(sourceName + " - vertex not found");
        if (!linkMap.containsKey(vDest))
            throw new NoSuchElementException(destName + " - vertex not found");

        // реализация алгоритма Дейкстры

        LinkedHashMap<Vertex, Integer> all = new LinkedHashMap<>();
        for (Vertex v : linkMap.keySet()) {
            all.put(v, MAX_VALUE);
        }
        Set<Vertex> visited = new HashSet<>();
        all.put(vSource, 0);

        while (visited.size() < all.size()) {
            Vertex v1 = lowestValueUnvisitedVertex(all, visited);
            for (Vertex v2 : linkMap.get(v1).keySet()) {
                if (visited.contains(v2))
                    continue;
                all.put(v2, Math.min(all.get(v2), all.get(v1) + linkMap.get(v1).get(v2)));
            }
            visited.add(v1);
        }
        Integer result = all.get(vDest);
        if (result == MAX_VALUE)
            throw new PathNotFoundException();
        return result;
    }

    private Vertex lowestValueUnvisitedVertex(Map<Vertex, Integer> map, Set<Vertex> visited) {
        int min = MAX_VALUE;
        Vertex result = null;
        for (Map.Entry<Vertex, Integer> entry : map.entrySet()) {
            if (entry.getValue() < min && !visited.contains(entry.getKey())) {
                min = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
