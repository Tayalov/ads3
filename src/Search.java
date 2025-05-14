import java.util.List;

public interface Search<T> {
    List<Vertex<T>> getPath(Vertex<T> source, Vertex<T> destination);
}
