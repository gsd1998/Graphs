package interviewQA.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<PairWithSteps> q = new LinkedList<>();

        for(int r1 = 0; r1 < n; r1++){
            for(int c1 = 0; c1 < m; c1++){
                if(mat[r1][c1] == 0){
                    q.offer(new PairWithSteps(r1, c1, 0));
                    vis[r1][c1] = 1;
                }
            }
        }

        while(!q.isEmpty()){
            PairWithSteps cell = q.poll();
            int row = cell.row;
            int col = cell.col;
            int step = cell.step;
            dist[row][col] = step;

            int[] delRow = {-1,0,1,0};
            int[] delCol = {0,1,0,-1};
            for(int i = 0; i < 4; i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && mat[nRow][nCol] == 1 && vis[nRow][nCol] == 0){
                    q.offer(new PairWithSteps(nRow, nCol, step+1));
                    vis[nRow][nCol] = 1;
                }
            }
        }
        return dist;
    }
}


class PairWithSteps{
    int row;
    int col;
    int step;

    public PairWithSteps(int row, int col, int step){
        this.row = row;
        this.col = col;
        this.step = step;
    }
}
