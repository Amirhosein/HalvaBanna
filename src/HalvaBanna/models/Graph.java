package HalvaBanna.models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Vector;

public class Graph {
    private int V;
    private Vector<Node>[] adj;

    public HashMap<Integer, Integer> getVerticesMap() {
        return verticesMap;
    }

    public void setVerticesMap(HashMap<Integer, Integer> verticesMap) {
        this.verticesMap = verticesMap;
    }

    public Vector<Node>[] getAdj() {
        return adj;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
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
        Node temp = new Node(v, weight);
        this.adj[u].add(temp);
        temp = new Node(u, weight);
        this.adj[v].add(temp);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        int key = getKey(v);
        System.out.print(key + " ");

        for (Node node : adj[v]) {
            if (!visited[node.node])
                DFSUtil(node.node, visited);
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

    public static class Node implements Comparator<Node> {

        // Member variables of this class
        public int node;
        public int cost;

        // Constructors of this class

        // Constructor 1
        public Node() {}

        // Constructor 2
        public Node(int node, int cost)
        {

            // This keyword refers to current instance itself
            this.node = node;
            this.cost = cost;
        }

        // Method 1
        @Override public int compare(Node node1, Node node2)
        {

            return Integer.compare(node1.cost, node2.cost);

        }
    }
}
