package interviewQA.Graphs;

import java.util.ArrayList;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<Integer>());
        }
        int count = 0;
        int[] vis = new int[n+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                count++;
                dfs(i,vis, adjList);
            }
        }
        return count;
    }

    public void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adjList){
        vis[node] = 1;
        for(Integer nei : adjList.get(node)){
            if(vis[nei] == 0){
                dfs(nei, vis, adjList);
            }
        }
    }
}
