package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
     0 - 1, 2
     1 - 0, 3
     2 - 1, 6
     3 - 0, 4,
     4 - 3, 5
     5 - 4, 6
     6 - 2, 5, 7, 8
     7 - 6, 8
     8 - 6, 7
 */
public class ShortestPathInUGWithUnitWeights {
    public static void main(String[] args) {
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        int[] vis = new int[n];
        int src = 0;
        int res[] = shortestPathUG(n, m, edge, src, vis);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " "); // 0 1 2 1 2 3 3 4 4
        }
        System.out.println();
    }

    private static int[] shortestPathUG(int n, int m, int[][] edge, int src, int[] vis) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++){
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        vis[src] = 1;
        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int a : adj.get(node)){
                if(vis[a] == 0){
                    vis[a] = 1;
                    q.offer(a);
                }
                if(dist[node] + 1 < dist[a]){
                    dist[a] = dist[node] + 1;
                }
            }
        }
        for(int i = 0 ; i < n; i++){
            if(dist[i] == 1e9){
                dist[i] = -1;
            }
        }
        return dist;
    }


}
