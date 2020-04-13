import java.util.*;

public class Kruskals {
    public static class Edge implements Comparable<Edge> {
        public int u, v;
        public double weight;

        public Edge(int u, int v, double weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int compareTo(Edge that) {
            return Double.compare(this.weight, that.weight);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d, %f)", u, v, weight);
        }


    }

    public static class Graph {
        private ArrayList<ArrayList<Edge>> adjacencyLists;

        public Graph(int V) {
            adjacencyLists = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adjacencyLists.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, double weight) {
            Edge newEdge = new Edge(u, v, weight);
            adjacencyLists.get(u).add(newEdge);
            adjacencyLists.get(v).add(newEdge);
        }

        public ArrayList<Edge> getEdges() {
            HashSet<Edge> edges = new HashSet<>();

            for (int i = 0; i < adjacencyLists.size(); i++) {
                edges.addAll(adjacencyLists.get(i));
            }

            return new ArrayList<>(edges);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 6);
        g.addEdge(1, 3, 5);
        g.addEdge(1, 4, 1);
        g.addEdge(3, 4, 7);

        ArrayList<Edge> edgesSorted = g.getEdges();
        Collections.sort(edgesSorted);

        for (int i = 0; i < edgesSorted.size(); i++) {
            // TODO
            System.out.println(edgesSorted.get(i));
        }
    }
}
