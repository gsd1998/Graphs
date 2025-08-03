package interviewQA.Graphs;

public class NumberOfOperationsToMakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {
        int totalConnections = connections.length;
        if(n - totalConnections > 1){
            return -1;
        }
        DisjointSet djs = new DisjointSet(n);
        int connectionEstablished = 0;
        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];
            if(djs.findParent(u) != djs.findParent(v)){
                djs.unionBySize(u, v);
                connectionEstablished++;
            }
        }
        int noOfConnectionRem = totalConnections - connectionEstablished;
        int noOfNodesConnected = connectionEstablished + 1;
        if(n - noOfNodesConnected <= noOfConnectionRem){
            return n - noOfNodesConnected;
        }
        return 0;
    }
}
