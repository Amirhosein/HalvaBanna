package HalvaBanna.models;

import java.util.HashMap;
import java.util.Vector;

public class Graph {
    private int V, level;
    private Vector<Integer>[] adj;

    public HashMap<Integer, Integer> getVerticesMap() {
        return verticesMap;
    }

    public void setVerticesMap(HashMap<Integer, Integer> verticesMap) {
        this.verticesMap = verticesMap;
    }

    private HashMap<Integer, Integer> verticesMap;

    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        this.adj = new Vector[2 * V];
        this.verticesMap = new HashMap<>();

        for (int i = 0; i < 2 * V; i++) {
            this.adj[i] = new Vector<>();
        }
    }

    public void addEdge(int u, int v, int weight) {
        v = getName(v);
        u = getName(u);

        this.adj[u].add(v);
        this.adj[v].add(u);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        // get key of value v
        int key = getKey(v);
        System.out.print(key + " ");

        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[V];

        DFSUtil(v, visited);
    }

    private int getName(int v) {
        return this.verticesMap.get(v);
    }

    private int getKey(int v) {
        for (int key : this.verticesMap.keySet()) {
            if (this.verticesMap.get(key) == v) {
                return key;
            }
        }
        return -1;
    }
}
