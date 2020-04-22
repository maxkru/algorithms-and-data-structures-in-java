package lesson7.util;

public interface Graph {

    void addVertex(String name);

    void addLink(String vertex1Name, String vertex2Name, Integer value);

    Integer getShortestPathValue(String sourceName, String destName);
}
