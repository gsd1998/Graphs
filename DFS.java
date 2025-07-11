package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFS {
    public static void main(String args[]) {
        List<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);
        int[] vis = new int[adj.size()+1];

        dfsOfGraph(0, adj, list, vis);
        System.out.print(list);//[0, 2, 4, 1, 3]
    }

    //Time Complexity: For an undirected graph, O(N) + O(2E),
    // For a directed graph, O(N) + O(E), Because for every node we are calling the recursive function once,
    // the time taken is O(N) and 2E is for total degrees as we traverse for all adjacent nodes.

    //Space Complexity: O(3N) ~ O(N), Space for dfs stack space, visited array and an adjacency list.

    private static void dfsOfGraph(int node, List<ArrayList<Integer>> adj, ArrayList<Integer> list, int[] vis) {
        vis[node]=1;
        list.add(node);
        for(Integer neighbour : adj.get(node)){
            if(vis[neighbour] == 0){
                dfsOfGraph(neighbour, adj, list, vis);
            }
        }
    }
}
