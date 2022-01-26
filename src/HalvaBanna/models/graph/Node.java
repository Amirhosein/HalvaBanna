package HalvaBanna.models.graph;

import java.util.Comparator;

public class Node implements Comparator<Node> {

    public int node;
    public int cost;

    public Node() {
    }

    public Node(int node, int cost) {

        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {

        return Integer.compare(node1.cost, node2.cost);

    }
}
