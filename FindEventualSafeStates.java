package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        List<Integer> ans= new ArrayList<>();
        for(int i = 0; i < n ; i++){
            if(vis[i] == 0){
                dfs(i, graph, vis, pathVis);
            }
        }
        for(int j = 0; j < n ; j++){
            if(pathVis[j] == 0)
                ans.add(j);
        }
        return ans;
    }

    public boolean dfs(int node, int[][] graph, int[] vis, int[] pathVis){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int adj : graph[node]){
            if(vis[adj] == 0){
                if(dfs(adj, graph, vis, pathVis)){
                    return true;
                }
            }else if(pathVis[adj] == 1){
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
}
