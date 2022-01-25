package HalvaBanna.models;

import java.util.*;

public class ShortestPath {
    private int V;
    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<Graph.Node> pq;
    private Vector<Graph.Node>[] adj;

    public ShortestPath(Graph graph){
        this.V = graph.getV();
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Graph.Node>(V, new Graph.Node());
    }

    public void dijkstra(Vector<Graph.Node>[] adj, int src)
    {
        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Add source node to the priority queue
        pq.add(new Graph.Node(src, 0));

        // Distance to the source is 0
        dist[src] = 0;

        while (settled.size() != V) {

            // Terminating condition check when
            // the priority queue is empty, return
            if (pq.isEmpty())
                return;

            // Removing the minimum distance node
            // from the priority queue
            int u = pq.remove().node;

            // Adding the node whose distance is
            // finalized
            if (settled.contains(u))

                // Continue keyword skips execution for
                // following check
                continue;

            // We don't have to call e_Neighbors(u)
            // if u is already present in the settled set.
            settled.add(u);

            e_Neighbours(u);
        }
    }

    private void e_Neighbours(int u)
    {

        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adj[u].size(); i++) {
            Graph.Node v = adj[u].get(i);

            // If current node hasn't already been processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                // Add the current node to the queue
                pq.add(new Graph.Node(v.node, dist[v.node]));
            }
        }
    }

    public int[] getDist() {
        return dist;
    }
}
