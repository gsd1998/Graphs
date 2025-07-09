package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void main(String args[]) {

        List<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        ArrayList <Integer> ans = bfsOfGraph(5, adj);
        int n = ans.size();
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }

    //Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.
    //Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list
    private static ArrayList<Integer> bfsOfGraph(int n, List<ArrayList<Integer>> adj) {
        int[] vis = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0]=1;
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(Integer neighbour : adj.get(node)){
                if(vis[neighbour] == 0){
                    vis[neighbour] = 1;
                    q.offer(neighbour);
                }
            }
        }
        return ans;
    }
}

