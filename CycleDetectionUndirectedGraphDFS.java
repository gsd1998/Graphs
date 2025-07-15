package interviewQA.Graphs;

import java.util.ArrayList;

public class CycleDetectionUndirectedGraphDFS {
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] vis = new int[4];
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        /*adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);*/

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(1);
        adj.get(1).add(3);

        boolean ans = detectCycle(adj, vis);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int[] vis) {
        for(int i = 0; i < 4; i++) {
            if (vis[i] == 0 && dfs(i, adj, vis, -1)) return true;
        }
        return false;
    }

    private static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int parentNode) {
        vis[node] = 1;
        for(Integer neigh : adj.get(node)){
            if(vis[neigh] == 0){
                return dfs(neigh, adj, vis, node);
            }else if(neigh != parentNode){
                return true;
            }
        }
        return false;
    }
}
