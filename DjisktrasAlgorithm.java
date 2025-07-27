package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DjisktrasAlgorithm {

    public static void main(String[] args) {
        int n = 5;
        int m= 6;
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        int[] distance = shortestPath(n,m,edges);
        for (int i = 1; i <= n; i++) {
            System.out.print(distance[i] + " "); // 0 2 4 1 5
        }
    }

    public static int[] shortestPath(int n, int m, int edges[][]) {

        if (edges == null || edges.length == 0) {
            System.out.println("No edges provided.");
            return null;
        }
        ArrayList<ArrayList<DistancePair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new DistancePair(wt, v));
            adj.get(v).add(new DistancePair(wt, u));
        }
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<DistancePair> pq = new PriorityQueue<DistancePair>((x, y) -> x.distance - y.distance);
        pq.add(new DistancePair(0, 1));
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = (int) (1e9);
        }
        dist[1] = 0;

        while (!pq.isEmpty()) {
            DistancePair pair = pq.poll();
            int distance = pair.distance;
            int node = pair.node;
            for (DistancePair dp : adj.get(node)) {
                int w = dp.distance;
                int no = dp.node;
                if (distance + w < dist[no]) {
                    dist[no] = distance + w;
                    pq.add(new DistancePair(dist[no], no));
                }
            }
        }
        return dist;
    }
}

class DistancePair{
    int distance;
    int node;
    DistancePair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}