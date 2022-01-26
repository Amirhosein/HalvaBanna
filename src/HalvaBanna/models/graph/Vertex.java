package HalvaBanna.models.graph;

import java.util.HashMap;
import java.util.Vector;

public class Vertex {
    private final Vector<Node> adj;
    private final HashMap<Integer, Integer> dijkstraResult;

    public Vertex() {
        this.adj = new Vector<>();
        this.dijkstraResult = new HashMap<>();
    }

    public Vector<Node> getAdj() {
        return adj;
    }

    public HashMap<Integer, Integer> getDijkstraResult() {
        return dijkstraResult;
    }

    public void setDijkstraResult(int[] dist) {
        for (int i = 0; i < dist.length; i++) {
            this.dijkstraResult.put(i, dist[i]);
        }
    }
}
