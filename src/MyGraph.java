import java.util.*;

public class MyGraph<T> {
    private Map<Vertex<T>, List<Edge<T>>> adjList;
    private boolean directed;

    public MyGraph() {
        this(false);
    }

    public MyGraph(boolean directed) {
        adjList = new HashMap<>();
        this.directed = directed;
    }

    public void addVertex(Vertex<T> vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination) {
        addVertex(source);
        addVertex(destination);
        adjList.get(source).add(new Edge<>(source, destination));
        if (!directed) {
            adjList.get(destination).add(new Edge<>(destination, source));
        }
    }

    public List<Edge<T>> getEdges(Vertex<T> vertex) {
        return adjList.getOrDefault(vertex, new ArrayList<>());
    }

    public Set<Vertex<T>> getVertices() {
        return adjList.keySet();
    }

    public void printGraph() {
        for (Vertex<T> vertex : adjList.keySet()) {
            System.out.print(vertex + ": ");
            for (Edge<T> edge : adjList.get(vertex)) {
                System.out.print(edge.getDestination() + " ");
            }
            System.out.println();
        }
    }
}

