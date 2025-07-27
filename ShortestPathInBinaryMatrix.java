package interviewQA.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];

        if((grid[0][0] != 0) || (grid[n-1][n-1] != 0)){
            return -1;
        }

        Queue<DistancesPair> pq = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0] = 1;
        pq.add(new DistancesPair(1,0,0));
        while(!pq.isEmpty()){
            DistancesPair distancePair = pq.poll();
            int distance = distancePair.distance;
            int row = distancePair.row;
            int col = distancePair.col;
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    int delRow = row + i;
                    int delCol = col + j;
                    int totalDistance = distance + 1;
                    if(delRow >= 0 && delRow < n && delCol >= 0 && delCol < n && grid[delRow][delCol] == 0 && totalDistance < dist[delRow][delCol]){
                        System.out.println(totalDistance);
                        dist[delRow][delCol] = totalDistance;
                        pq.add(new DistancesPair(totalDistance, delRow, delCol));
                    }
                }
            }
        }
        if(dist[n-1][n-1] != 1e9)
            return dist[n-1][n-1];
        return -1;
    }
}

class DistancesPair{
    int row;
    int col;
    int distance;

    DistancesPair(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
