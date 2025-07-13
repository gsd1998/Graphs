package interviewQA.Graphs;

import java.util.LinkedList;
import java.util.Queue;

class PairOfRowCol {
    int row;
    int col;
    int minute;

    PairOfRowCol(int row, int col){
        this.row = row;
        this.col = col;
    }
    PairOfRowCol(int row, int col, int minute){
        this.row = row;
        this.col = col;
        this.minute = minute;
    }
}

public class NumberOfIslands {

    public static void main(String[] args)
    {
        int[][] grid = new int[5][4];
        int n = grid.length;
        int m = grid[0].length;

        grid[0][1] = 1;
        grid[0][2] = 1;
        grid[1][1] = 1;
        grid[1][2] = 1;
        grid[2][2] = 1;
        grid[4][0] = 1;
        grid[4][1] = 1;
        grid[4][3] = 1;

        int count = numberOfIsl(grid);
        System.out.println(count);
    }

    public static int numberOfIsl(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    count++;
                    bfs(i, j, grid, vis);
                }
            }
        }
        return count;
    }

    private static void bfs(int row, int col, int[][] grid, int[][] vis) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        Queue<PairOfRowCol> q = new LinkedList<>();
        q.offer(new PairOfRowCol(row, col));

        while(!q.isEmpty()){
            PairOfRowCol box = q.poll();
            int nRow = box.row;
            int nCol = box.col;

            for(int delRow = -1; delRow <= 1; delRow++){
                for(int delCol = -1; delCol <= 1; delCol++){
                    int neighRow = delRow + nRow;
                    int neighCol = delCol + nCol;
                    if(neighRow >=0 && neighRow < n && neighCol >= 0 && neighCol < m && grid[neighRow][neighCol] == 1 &&
                            vis[neighRow][neighCol] == 0){
                        vis[neighRow][neighCol] = 1;
                        q.offer(new PairOfRowCol(neighRow, neighCol));

                    }
                }
            }
        }
    }
}
