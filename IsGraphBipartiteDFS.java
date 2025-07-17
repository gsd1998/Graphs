package interviewQA.Graphs;

import java.util.Arrays;

public class IsGraphBipartiteDFS {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(!isCycleDfs(i, graph, color, 0))
                    return false;
            }
        }
        return true;
    }

    public boolean isCycleDfs(int node, int[][] graph, int[] color, int currColor) {
        color[node] = currColor;
        for(int adj : graph[node]){
            if(color[adj] == -1){
                currColor = color[node] == 1 ? 0 : 1; //we can also use 1 - currColor here
                if(!isCycleDfs(adj, graph, color, currColor)){
                    return false;
                }
            }else if(color[adj] == color[node]){
                return false;
            }
        }
        return true;
    }
}
