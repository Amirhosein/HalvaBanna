package HalvaBanna.models;

import HalvaBanna.models.graph.Graph;
import HalvaBanna.models.graph.Node;
import HalvaBanna.models.graph.Vertex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ShortestPath {
    private static Graph graph;
    private final int V;
    private int[] dist;
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    private ArrayList<Vertex> adj;

    public ShortestPath(Graph graph) {
        this.V = graph.getV();
        ShortestPath.graph = graph;
        this.adj = graph.getAdj();
        this.dist = new int[V];
        this.settled = new HashSet<>();
        this.pq = new PriorityQueue<>(V, new Node());
    }

    public static Graph getGraph() {
        return graph;
    }

    public void printResult() {
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex: " + graph.getKey(i));

            for (int j = 0; j < V; j++) {
                System.out.print("\t" + graph.getKey(j) + ": " + graph.getAdj().get(i).getDijkstraResult().get(j));

            }
            System.out.println();
        }
    }

    public void dijkstraUtil(ArrayList<Vertex> adj, int src) {
        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        pq.add(new Node(src, 0));

        dist[src] = 0;

        while (settled.size() != V) {
            if (pq.isEmpty())
                return;
            int u = pq.remove().node;

            if (settled.contains(u))
                continue;

            settled.add(u);

            e_Neighbours(u);
        }
    }

    public void dijkstra() {
        for (int i = 0; i < V; i++) {
            dijkstraUtil(adj, i);
            adj.get(i).setDijkstraResult(dist);
            this.dist = new int[V];
            this.settled = new HashSet<>();
            this.pq = new PriorityQueue<>(V, new Node());
        }
        graph.setCalculated(true);
    }

    private void e_Neighbours(int u) {

        int edgeDistance;
        int newDistance;
        for (int i = 0; i < adj.get(u).getAdj().size(); i++) {
            Node v = adj.get(u).getAdj().get(i);

            if (!settled.contains(graph.getName(v.node))) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;
                if (newDistance < dist[graph.getName(v.node)]) {
                    dist[graph.getName(v.node)] = newDistance;
                }

                pq.add(new Node(graph.getName(v.node), dist[graph.getName(v.node)]));
            }
        }
    }

}
