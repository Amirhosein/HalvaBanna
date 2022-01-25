package HalvaBanna;

import HalvaBanna.models.Graph;

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
        command = sc.next();
        while (!Objects.equals(command, "exit")) {
            if (Objects.equals(command, "test")) {
                // use dfs from first index
                graph.DFS(0);
                System.out.println();
            }
            command = sc.next();
        }
    }
}
