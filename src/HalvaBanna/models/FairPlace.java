package HalvaBanna.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class FairPlace {
    public static void findFairPlace() {
        Double[] fairScores = new Double[ShortestPath.getGraph().getV()];
        for (int i = 0; i < ShortestPath.getGraph().getV(); i++) {
            fairScores[i] = (double) 0;
            for (int j = 0; j < ShortestPath.getGraph().getV(); j++) {
                for (int k = j; k < ShortestPath.getGraph().getV(); k++) {
                    fairScores[i] += Math.abs(ShortestPath.getGraph().getAdj().get(i).getDijkstraResult().get(j)
                            - ShortestPath.getGraph().getAdj().get(i).getDijkstraResult().get(k));

                }
            }
            fairScores[i] /= (double) ShortestPath.getGraph().getV() * (ShortestPath.getGraph().getV() - 1) / 2;
        }
        // print fair scores
        for (int i = 0; i < ShortestPath.getGraph().getV(); i++) {
            System.out.println("Vertex " + ShortestPath.getGraph().getKey(i) + " fair score: " + fairScores[i]);
        }
    }

    public static void findFairPlace(HashSet<Integer> attendees) {
        ArrayList<Integer> vertices = hashSetToArrayList(attendees);
        Double[] fairScores = new Double[ShortestPath.getGraph().getV()];
        for (int i = 0; i < ShortestPath.getGraph().getV(); i++) {
            fairScores[i] = (double) 0;
            for (int j = 0; j < vertices.size(); j++) {
                for (int k = j; k < vertices.size(); k++) {
                    fairScores[i] += Math.abs(ShortestPath.getGraph().getAdj().get(i).getDijkstraResult().get(ShortestPath.getGraph().getName(vertices.get(j)))
                            - ShortestPath.getGraph().getAdj().get(i).getDijkstraResult().get(ShortestPath.getGraph().getName(vertices.get(k))));

                }
            }
            fairScores[i] /= (double) vertices.size() * (vertices.size() - 1) / 2;
        }

        // find minimum fair score
        Double minFairScore = Double.MAX_VALUE;
        for (int i = 0; i < ShortestPath.getGraph().getV(); i++) {
            if (fairScores[i] < minFairScore) {
                minFairScore = fairScores[i];
            }
        }

        System.out.println("FairPlaces:");
        for (int i = 0; i < ShortestPath.getGraph().getV(); i++) {
            if (Objects.equals(fairScores[i], minFairScore)) {
                System.out.println("Vertex " + ShortestPath.getGraph().getKey(i) + " fair score: " + fairScores[i]);
            }
        }
        System.out.println("Other vertices:");
        for (int i = 0; i < ShortestPath.getGraph().getV(); i++) {
            if (!Objects.equals(fairScores[i], minFairScore)) {
                System.out.println("Vertex " + ShortestPath.getGraph().getKey(i) + " fair score: " + fairScores[i]);
            }
        }
    }

    private static ArrayList<Integer> hashSetToArrayList(HashSet<Integer> hashSet) {
        return new ArrayList<>(hashSet);
    }
}

