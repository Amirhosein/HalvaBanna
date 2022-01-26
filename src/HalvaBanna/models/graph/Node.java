package HalvaBanna.models.graph;

import java.util.Comparator;

public class Node implements Comparator<Node> {

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
