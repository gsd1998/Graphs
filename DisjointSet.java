package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisjointSet(int n){
        for(int i = 0; i <= n; i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int par = findParent(parent.get(node));
        parent.set(node, par);
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u == ulp_v){
            return;
        }
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }

    public static void main(String[] args) {
        DisjointSet djs = new DisjointSet(7);
        djs.unionBySize(1,2);
        djs.unionBySize(2,3);
        djs.unionBySize(4,5);
        djs.unionBySize(6,7);
        djs.unionBySize(5,6);

        if(djs.findParent(3) == djs.findParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }

        djs.unionBySize(3,7);

        if(djs.findParent(3) == djs.findParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }

    }


}
