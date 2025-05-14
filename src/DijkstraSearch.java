import java.util.*;

public class DijkstraSearch<T> implements Search<T> {
    private Map<Vertex<T>, Double> distances;
    private Map<Vertex<T>, Vertex<T>> previous;

    @Override
    public List<Vertex<T>> getPath(Vertex<T> source, Vertex<T> destination) {
        distances = new HashMap<>();
        previous = new HashMap<>();

        PriorityQueue<Vertex<T>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        for (Vertex<T> vertex : source.getAdjacentVertices().keySet()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(source, 0.0);

        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();

            for (Map.Entry<Vertex<T>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<T> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                double newDist = distances.getOrDefault(current, Double.POSITIVE_INFINITY) + weight;

                if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        List<Vertex<T>> path = new ArrayList<>();
        Vertex<T> step = destination;

        if (!previous.containsKey(step) && !step.equals(source)) return Collections.emptyList();

        while (step != null) {
            path.add(step);
            step = previous.get(step);
        }

        Collections.reverse(path);
        return path;
    }
}
