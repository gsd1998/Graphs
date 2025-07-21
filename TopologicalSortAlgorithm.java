package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortAlgorithm {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println(""); //5 4 2 3 1 0
    }

    private static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[v];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                dfsTopo(i, adj, vis, st);
            }
        }
        int[] ans = new int[v];
        int index = 0;
        while(!st.isEmpty()){
            ans[index++] = st.pop();
        }
        return ans;
    }

    private static void dfsTopo(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for(int a : adj.get(node)){
            if(vis[a] == 0){
                dfsTopo(a, adj, vis, st);
            }
        }
        st.push(node);
    }
}

/*
    Can be done to get the linear ordering in DAG - Directed Acyclic Graphs only
 */