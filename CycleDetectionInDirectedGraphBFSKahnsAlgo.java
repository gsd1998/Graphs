package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionInDirectedGraphBFSKahnsAlgo {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(2).add(0);
        adj.get(3).add(2);
        boolean ans = topoSortBfs(V, adj);
        System.out.println(ans); //true
    }

    private static boolean topoSortBfs(int v, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
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
        int sizeOfTopo = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            sizeOfTopo++;
            for(int a : adj.get(node)){
                inDegree[a]--;
                if(inDegree[a] == 0){
                    q.offer(a);
                }
            }
        }
        if(sizeOfTopo == v)
                return false;
        return true;
    }
}
