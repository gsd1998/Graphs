package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithm {
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

        int[] ans = topoSortBfs(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println(""); //5 4 2 3 1 0 // 4 5 0 2 3 1
    }

    private static int[] topoSortBfs(int v, ArrayList<ArrayList<Integer>> adj) {

        Queue<Integer> q = new LinkedList<>();
        int[] topo = new int[v];
        int[] inDegree = new int[v];
        for(int i = 0; i < v; i++){
            for(int a : adj.get(i)){
                inDegree[a]++;
            }
        }

        for(int j = 0; j < v; j++){
            if(inDegree[j] == 0)
                q.offer(j);
        }
        int i = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[i++] = node;
            for(int a : adj.get(node)){
                inDegree[a]--;
                if(inDegree[a] == 0){
                    q.offer(a);
                }
            }
        }
        return topo;
    }
}
