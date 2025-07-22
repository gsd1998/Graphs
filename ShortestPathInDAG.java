package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.Stack;

class PairOfValueWeight{
    int val;
    int weight;

    public PairOfValueWeight(int val, int weight) {
        this.val = val;
        this.weight = weight;
    }
}

public class ShortestPathInDAG{
    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {
                {0, 1, 2},
                {0, 4, 1},
                {4, 5, 4},
                {4, 2, 2},
                {1, 2, 3},
                {2, 3, 6},
                {5, 3, 1}
        };
        int res[] = shortestPath(edge,n,m,0);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

    private static int[] shortestPath(int[][] edge, int n, int m, int src) {
        ArrayList<ArrayList<PairOfValueWeight>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ArrayList<PairOfValueWeight> list = new ArrayList<>();
            adj.add(list);
        }
        for(int i = 0; i < m; i++){
            int u = edge[i][0];
            int v = edge[i][1];
            int wt = edge[i][2];
            adj.get(u).add(new PairOfValueWeight(v,wt));
        }
        int[] vis =  new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(vis[i] == 0)
                dfsTopoDag(i, adj, st, vis);
        }
        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            for(PairOfValueWeight p : adj.get(node)){
                int wt = p.weight;
                int val = p.val;
                if(dist[node] + wt < dist[val]){
                    dist[val] = dist[node] + wt;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(dist[i] == 1e9)
                dist[i] = -1;
        }
        return dist;
    }

    private static void dfsTopoDag(int node, ArrayList<ArrayList<PairOfValueWeight>> adj, Stack<Integer> st, int[] vis) {
        vis[node] = 1;
        for(PairOfValueWeight a : adj.get(node)){
            int val = a.val;
            if(vis[val] == 0){
                dfsTopoDag(val, adj, st, vis);
            }
        }
        st.push(node);
    }
}

/*
    0 -> 1 (2), 4 (1)
    4 -> 2 (2), 5 (4)
    1 -> 2 (3)
    2 -> 3 (6)
    5 -> 3 (1)
*/