import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<T> {
    private Set<Vertex<T>> vertices;

    public WeightedGraph() {
        vertices = new HashSet<>();
    }

    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination, double weight) {
        addVertex(source);
        addVertex(destination);
        source.addAdjacentVertex(destination, weight);
    }

    public Set<Vertex<T>> getVertices() {
        return vertices;
    }
}

