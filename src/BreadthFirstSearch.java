import java.util.*;

public class BreadthFirstSearch<T> implements Search<T> {
    private Map<Vertex<T>, Vertex<T>> parentMap;

    @Override
    public List<Vertex<T>> getPath(Vertex<T> source, Vertex<T> destination) {
        parentMap = new HashMap<>();
        bfs(source);

        List<Vertex<T>> path = new ArrayList<>();
        Vertex<T> current = destination;

        while (current != null && !current.equals(source)) {
            path.add(current);
            current = parentMap.get(current);
        }

        if (current == null) return Collections.emptyList(); // No path

        path.add(source);
        Collections.reverse(path);
        return path;
    }

    private void bfs(Vertex<T> start) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        Set<Vertex<T>> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        parentMap.put(start, null);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();

            for (Vertex<T> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}
