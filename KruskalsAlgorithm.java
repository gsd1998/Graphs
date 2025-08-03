package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgorithm {
    public static void main (String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);
            tmp2.add(u);
            tmp2.add(w);
            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }
        int mstWt = spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + mstWt);

    }

    private static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        DisjointSet djs = new DisjointSet(v);
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < v; i++){
            for(ArrayList<Integer> list : adj.get(i)){
                int u = list.get(0);
                int wt = list.get(1);
                int node = i;
                edges.add(new Edge(wt, node, u));
            }
        }

        Collections.sort(edges);
        int sumSize = 0;
        for(Edge edge : edges){
            int src = edge.src;
            int dest = edge.dest;
            int weight = edge.weight;

            if(djs.findParent(src) != djs.findParent(dest)){
                sumSize += weight;
                djs.unionBySize(src, dest);
            }
        }
        return sumSize;
    }
}

class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int weight;
    Edge(int weight, int src, int dest){
        this.weight = weight;
        this.src = src;
        this.dest = dest;
    }

    @Override
    public int compareTo(Edge v) {
        return this.weight - v.weight;
    }
}
