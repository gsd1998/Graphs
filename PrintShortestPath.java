package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PrintShortestPath {

    public static void main(String[] args) {
        int n = 5;
        int m= 6;
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        List<Integer> list = shortestPath(n,m,edges);
        System.out.print(list); // [1, 4, 3, 5]
    }

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {

        if (edges == null || edges.length == 0) {
            System.out.println("No edges provided.");
            return new ArrayList<>();
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
        int[] parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dist[i] = (int) (1e9);
            parent[i] = i;
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
                    parent[no] = node;
                    dist[no] = distance + w;
                    pq.add(new DistancePair(dist[no], no));
                }
            }
        }

        List<Integer> temp = new ArrayList<>();
        if(dist[n] == 1e9){
            temp.add(-1);
            return temp;
        }

        int pathNode = n;
        while(parent[pathNode] != pathNode){
            temp.add(pathNode);
            pathNode = parent[pathNode];
        }
        temp.add(pathNode);
        Collections.reverse(temp);
        return temp;
    }
}

/*
1 -> (2,2) , (4,1)
2 -> (1,2) , (3,4) , (5,5)
3 -> (2,4) , (4,3) , (5,1)
4 -> (1,1) , (3,3)
5 -> (2,5) , (3,1)

PQ -> (0,1) x| (2,2) x| (1,4) x| (4,3) x| (7,5) x| (5,5) x|

dist[] =>   0   2   4   1   5
            1   2   3   4   5
*/