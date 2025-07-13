package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class Helper{
    int currentNode;
    int parentNode;

    public Helper(int currentNode, int parentNode) {
        this.currentNode = currentNode;
        this.parentNode = parentNode;
    }
}

public class CycleDetectionUndirectedGraphBFS {
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] vis = new int[4];
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        /*adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(1);
        adj.get(1).add(3);*/

        boolean ans = detectCycle(adj, vis);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int[] vis) {
        for(int i = 0; i < 4; i++) {
            if (vis[i] == 0 && isCycle(i, adj, vis)) return true;
        }
        return false;
    }

    private static boolean isCycle(int sn, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        Queue<Helper> q = new LinkedList<>();
        q.offer(new Helper(sn, -1));
        vis[sn] = 1;
        while(!q.isEmpty()){
            Helper node = q.poll();
            int cn = node.currentNode;
            int pn = node.parentNode;
            for(Integer neigh : adj.get(cn)){
                if(vis[neigh] == 0){
                    vis[neigh] = 1;
                    q.offer(new Helper(neigh, cn));
                }else if(neigh != pn){
                    return true;
                }
            }
        }
        return false;
    }
}
