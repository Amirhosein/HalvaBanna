package HalvaBanna.models.graph;

import java.util.HashMap;
import java.util.Vector;

public class Vertex {
    private int number;
    private Vector<Node> adj;
    private HashMap<Integer, Integer> dijkstraResult;

    public Vertex() {
        this.adj = new Vector<>();
        this.dijkstraResult = new HashMap<>();
    }

    public Vertex(int number) {
        this.number = number;
        this.adj = new Vector<>();
        this.dijkstraResult = new HashMap<>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Vector<Node> getAdj() {
        return adj;
    }

    public void setAdj(Vector<Node> adj) {
        this.adj = adj;
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
