import java.util.*;

/**
 * Assumes no self-loops and no parallel edges.
 */
public class SimpleGraph {
    public ArrayList<LinkedHashSet<Integer>> destinationNodes;

    private void assertValidNodeIndex(int u) {
        assert u >= 0;
        assert u < destinationNodes.size();
    }

    public SimpleGraph(int numberOfNodes) {
        for (int i = 0; i < numberOfNodes; i++) {
            destinationNodes.add(new LinkedHashSet<Integer>());
        }
    }

    public void addEdge(int u, int v) {
        assertValidNodeIndex(u);
        assertValidNodeIndex(v);

        destinationNodes.get(u).add(v);
        destinationNodes.get(v).add(u);
    }

    public boolean edgeExists(int u, int v) {
        assertValidNodeIndex(u);
        assertValidNodeIndex(v);

        return destinationNodes.get(u).contains(v);
    }

    public void removeEdge(int u, int v) {
        assertValidNodeIndex(u);
        assertValidNodeIndex(v);

        destinationNodes.get(u).remove(v);
        destinationNodes.get(v).remove(u);
    }

    public static void main(String[] args) {
    }
}
