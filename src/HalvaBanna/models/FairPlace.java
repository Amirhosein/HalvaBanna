package HalvaBanna.models;

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
            System.out.println("Vertex " + i + " fair score: " + fairScores[i]);
        }

    }
}
