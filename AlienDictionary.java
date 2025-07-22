package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] dict = {"baa","abcd","abca","cab","cad"};
        int n = 5;
        int k = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        findAdjList(dict, n, k, adj);
        topoSort(k, adj);//b d a c
    }
    public static void findAdjList(String [] dict, int n, int k, ArrayList<ArrayList<Integer>> adj) {
        for(int i = 0; i < k ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++){
            int p1 = 0;
            String w1 = dict[i];
            String w2 = dict[i+1];
            while(p1 < w1.length() && p1 < w2.length()){
                if(w1.charAt(p1) == w2.charAt(p1)){
                    p1++;
                }else{
                    char u = w1.charAt(p1);
                    char v = w2.charAt(p1);
                    adj.get(u - 'a').add(v -'a');
                    break;
                }
            }
        }
    }

    private static void topoSort(int k, ArrayList<ArrayList<Integer>> adj) {

        int[] inDegree = new int[k];
        for(int i = 0; i < k; i++){
            for(int a : adj.get(i)){
                inDegree[a]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < k; i++){
            if(inDegree[i] == 0)
                q.offer(i);
        }

        int[] topo = new int[k];
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[cnt++] = node;
            for(int a : adj.get(node)){
                inDegree[a]--;
                if(inDegree[a] == 0){
                    q.offer(a);
                }
            }
        }

        String ans = "";
        for(int i : topo){
            ans = ans + (char)(i + (int)('a')) + " ";
        }
        System.out.println(ans);
    }
}
