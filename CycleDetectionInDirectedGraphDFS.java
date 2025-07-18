package interviewQA.Graphs;

import java.util.List;

public class CycleDetectionInDirectedGraphDFS {

    public boolean eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        for(int i = 0; i < n ; i++){
            if(vis[i] == 0){
                if(dfs(i, graph, vis, pathVis)){
                    return true;
                }
            }
        }
        return false;
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
