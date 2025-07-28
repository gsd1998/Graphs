package interviewQA.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {

    int minimumMultiplications(int[] arr, int start, int end) {
        int[] vis = new int[100000];
        Queue<PairStepsNode> q = new LinkedList<>();
        q.offer(new PairStepsNode(0,start));
        vis[start] = 1;

        while(!q.isEmpty()){
            PairStepsNode pair = q.poll();
            int step = pair.steps;
            int node = pair.node;
            if(node == end){
                return step;
            }
            for(int i = 0; i < arr.length; i++){
                int newNode = (node * arr[i]) % 100000;
                if(vis[newNode] == 0){
                    vis[newNode] = 1;
                    q.offer(new PairStepsNode(step+1, newNode));
                }
            }
        }
        return -1;
    }
}

class PairStepsNode{
    int steps;
    int node;
    PairStepsNode(int steps, int node){
        this.steps = steps;
        this.node = node;
    }
}
