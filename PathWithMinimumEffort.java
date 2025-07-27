package interviewQA.Graphs;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = (int)(1e9);
            }
        }

        PriorityQueue<DistancesPair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.add(new DistancesPair(0,0,0));
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            DistancesPair pair = pq.poll();
            int distance = pair.distance;
            int row = pair.row;
            int col = pair.col;

            if(row == n-1 && col == m-1){
                return distance;
            }

            int[] delRow = {-1,0,1,0};
            int[] delCol = {0,1,0,-1};

            for(int i = 0; i < 4 ; i++){
                int nRow = delRow[i] + row;
                int nCol = delCol[i] + col;

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    int height = Math.abs(heights[row][col] - heights[nRow][nCol]);
                    int newEfforts = Math.max(height, distance);

                    if(newEfforts < dist[nRow][nCol]){
                        dist[nRow][nCol] = newEfforts;
                        pq.add(new DistancesPair(newEfforts, nRow, nCol));
                    }
                }
            }
        }
        return 0;
    }
}
