import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> karaganda = new Vertex<>("Karaganda");
        Vertex<String> balkash = new Vertex<>("Balkash");
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> pavlodar = new Vertex<>("Pavlodar");
        Vertex<String> semey = new Vertex<>("Semey");
        Vertex<String> taldykorgan = new Vertex<>("Taldykorgan");
        Vertex<String> kokshetau = new Vertex<>("Kokshetau");
        Vertex<String> taraz = new Vertex<>("Taraz");

        graph.addEdge(astana, karaganda, 2);
        graph.addEdge(karaganda, balkash, 4);
        graph.addEdge(balkash, almaty, 3);
        graph.addEdge(balkash, taraz, 5);
        graph.addEdge(almaty, taraz, 2);
        graph.addEdge(almaty, taldykorgan, 3);
        graph.addEdge(taldykorgan, semey, 6);
        graph.addEdge(astana, pavlodar, 4);
        graph.addEdge(pavlodar, semey, 2);
        graph.addEdge(astana, kokshetau, 1);

        System.out.println("BFS path from Astana to Semey:");
        Search<String> bfs = new BreadthFirstSearch<>();
        List<Vertex<String>> bfsPath = bfs.getPath(astana, semey);
        for (Vertex<String> v : bfsPath) {
            System.out.print(v + " -> ");
        }

        System.out.println("\n\nDijkstra path from Astana to Semey:");
        Search<String> dijkstra = new DijkstraSearch<>();
        List<Vertex<String>> dijkstraPath = dijkstra.getPath(astana, semey);
        for (Vertex<String> v : dijkstraPath) {
            System.out.print(v + " -> ");
        }
    }
}
