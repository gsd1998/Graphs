package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<FlightDet>> adj = new ArrayList<>();
        int[] priceArr = new int[n];
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int price = flights[i][2];
            adj.get(u).add(new FlightDet(price, v));
        }
        for(int i = 0; i < n; i++){
            priceArr[i] = (int)(1e9);
        }
        priceArr[src] = 0;
        Queue<FlightDet> q = new LinkedList<>();
        q.offer(new FlightDet(0,src,0));

        while (!q.isEmpty()) {
            FlightDet current = q.poll();
            int priceSoFar = current.price;
            int currentNode = current.node;
            int stopsLeft = current.stopsLeft;

            if(stopsLeft > k)
                continue;

            for(FlightDet neighbor : adj.get(currentNode)) {
                int priceOfNeigh = neighbor.price;
                int neighNode = neighbor.node;
                if(priceSoFar + priceOfNeigh < priceArr[neighNode]){
                    priceArr[neighNode] = priceSoFar + priceOfNeigh;
                    q.offer(new FlightDet(stopsLeft+1, neighNode, priceArr[neighNode]));
                }
            }
        }
        if(priceArr[dst] == 1e9){
            return -1;
        }
        return priceArr[dst];
    }
}

class FlightDet{
    int price;
    int node;
    int stopsLeft;

    FlightDet(int price, int node){
        this.price = price;
        this.node = node;
    }

    FlightDet(int stopsLeft, int node, int price){
        this.stopsLeft = stopsLeft;
        this.node = node;
        this.price = price;
    }
}
