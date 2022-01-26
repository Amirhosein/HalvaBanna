package HalvaBanna.models.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private int V;
    private boolean isCalculated;
    private final ArrayList<Vertex> adj;
    private HashMap<Integer, Integer> verticesMap;

    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        this.adj = new ArrayList<>();
        this.verticesMap = new HashMap<>();

        for (int i = 0; i < 2 * V; i++) {
            this.adj.add(new Vertex());
        }
        this.isCalculated = false;
    }

    public HashMap<Integer, Integer> getVerticesMap() {
        return verticesMap;
    }

    public void setVerticesMap(HashMap<Integer, Integer> verticesMap) {
        this.verticesMap = verticesMap;
    }

    public ArrayList<Vertex> getAdj() {
        return adj;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public void addVertex(Vertex vertex) {
        this.adj.add(vertex);
        this.V++;
        this.isCalculated = false;
    }

    public void removeVertex(Vertex vertex) {
        this.adj.remove(vertex);
        this.V--;

        this.isCalculated = false;
    }

    public void addEdge(int u, int v, int weight) {
        Node temp = new Node(v, weight);
        this.adj.get(getName(u)).getAdj().add(temp);
        temp = new Node(u, weight);
        this.adj.get(getName(v)).getAdj().add(temp);
        this.isCalculated = false;
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(getKey(v) + " ");

        for (Node node : adj.get(v).getAdj()) {
            int temp = getName(node.node);
            if (!visited[temp])
                DFSUtil(temp, visited);
        }
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[V];
        v = getName(v);
        DFSUtil(v, visited);
    }

    public boolean isCalculated() {
        return isCalculated;
    }

    public void setCalculated(boolean calculated) {
        isCalculated = calculated;
    }

    public int getName(int v) {
        return this.verticesMap.get(v);
    }

    public int getKey(int v) {
        for (int key : this.verticesMap.keySet()) {
            if (this.verticesMap.get(key) == v) {
                return key;
            }
        }
        return -1;
    }

}
