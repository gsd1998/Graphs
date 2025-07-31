package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Node>> adjacencyList = new ArrayList<>();
        int modulo = (int) (1e9 + 7);

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int price = roads[i][2];
            adjacencyList.get(u).add(new Node(price, v));
            adjacencyList.get(v).add(new Node(price, u));
        }

        int[] ways = new int[n];
        long[] destination = new long[n];
        Arrays.fill(destination, Integer.MAX_VALUE);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((x, y) -> Long.compare(x.weight, y.weight));
        priorityQueue.add(new Node((long) 0, 0));
        ways[0] = 1;
        destination[0] = 0;

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            long weight = current.weight;
            int vertex = current.vertex;

            if (vertex == n - 1) {
                continue;
            }

            for (int i = 0; i < adjacencyList.get(vertex).size(); i++) {
                int neighbor = adjacencyList.get(vertex).get(i).vertex;
                long neighborWeight = adjacencyList.get(vertex).get(i).weight;

                if (neighborWeight + weight < destination[neighbor]) {
                    destination[neighbor] = neighborWeight + weight;
                    priorityQueue.add(new Node(neighborWeight + weight, neighbor));
                    ways[neighbor] = ways[vertex];
                } else {
                    if (neighborWeight + weight == destination[neighbor]) {
                        ways[neighbor] = (ways[neighbor] + ways[vertex]) % modulo;
                    }
                }
            }
        }

        return ways[n - 1] % modulo;
    }
}


class Node {
    long weight;
    int vertex;

    Node(long weight, int vertex) {
        this.weight = weight;
        this.vertex = vertex;
    }
}

