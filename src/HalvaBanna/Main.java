package HalvaBanna;

import HalvaBanna.models.FairPlace;
import HalvaBanna.models.ShortestPath;
import HalvaBanna.models.graph.Graph;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, m;
        String command;
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        Graph graph = new Graph(n);

        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt(), i);
        }
        graph.setVerticesMap(map);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.addEdge(u, v, w);
        }
        ShortestPath shortestPath = new ShortestPath(graph);

        command = sc.next();
        while (!Objects.equals(command, "exit")) {
            if (Objects.equals(command, "test")) {
                ShortestPath.getGraph().DFS(10);
                System.out.println();
            } else if (Objects.equals(command, "test1")) {
                if (!ShortestPath.getGraph().isCalculated())
                    shortestPath.dijkstra();
                shortestPath.printResult();
            } else if (Objects.equals(command, "test2")) {
                if (!ShortestPath.getGraph().isCalculated())
                    shortestPath.dijkstra();
                FairPlace.findFairPlace();
            }
            command = sc.next();
        }
    }
}
