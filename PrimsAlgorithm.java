package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public int spanningTree(int V, int[][] edges) {
        ArrayList<ArrayList<PairNodeWeight>> adj = new ArrayList<>();
        int[] vis = new int[V];
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new PairNodeWeight(wt,v));
            adj.get(v).add(new PairNodeWeight(wt,u));
        }

        PriorityQueue<PairNodeWeight> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        pq.add(new PairNodeWeight(0,0));
        int sum = 0;
        while(!pq.isEmpty()){
            PairNodeWeight pair = pq.poll();
            int node = pair.node;
            int wt = pair.wt;
            if(vis[node] == 1){
                continue;
            }
            sum = sum + wt;
            vis[node] = 1;
            for(PairNodeWeight neigh : adj.get(node)){
                int adjNode = neigh.node;
                int adjNodeWt = neigh.wt;
                if(vis[adjNode] == 0){
                    pq.add(new PairNodeWeight(adjNodeWt, adjNode));
                }
            }
        }
        return sum;
    }
}

class PairNodeWeight{
    int wt;
    int node;
    PairNodeWeight(int wt, int node){
        this.wt = wt;
        this.node = node;
    }
}
