package interviewQA.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartiteBFS {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(!isCycle(i, graph, color))
                    return false;
            }
        }
        return true;
    }

    public boolean isCycle(int node, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = 0;
        while(!q.isEmpty()){
            int currNode = q.poll();
            for(int adj : graph[currNode]){
                if(color[adj] == -1){
                    color[adj] = color[currNode] == 1 ? 0 : 1;
                    q.offer(adj);
                }else if(color[adj] == color[currNode]){
                    return false;
                }
            }
        }
        return true;
    }
}
