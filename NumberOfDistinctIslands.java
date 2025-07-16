package interviewQA.Graphs;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    static String direction = "";
    public static void main(String[] args)
    {
        int[][] grid = new int[4][5];
        int n = grid.length;
        int m = grid[0].length;

        grid[0][0] = 1;
        grid[0][1] = 1;
        grid[0][2] = 0;
        grid[0][3] = 1;
        grid[0][4] = 1;
        grid[1][0] = 1;
        grid[1][1] = 0;
        grid[1][2] = 0;
        grid[1][3] = 0;
        grid[1][4] = 0;
        grid[2][0] = 0;
        grid[2][1] = 0;
        grid[2][2] = 0;
        grid[2][3] = 1;
        grid[2][4] = 1;
        grid[3][0] = 1;
        grid[3][1] = 1;
        grid[3][2] = 0;
        grid[3][3] = 0;
        grid[3][4] = 1;

        int count = numberOfDistinctIsl(grid);
        System.out.println(count);
    }

    private static int  numberOfDistinctIsl(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    direction = "";
                    dfsIsland(i, j, grid, vis , "");
                    set.add(direction);
                }
            }
        }
        return set.size();
    }

    private static void dfsIsland(int row, int col, int[][] grid, int[][] vis, String dir) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        char[] ahead = {'U', 'R', 'D', 'L'};
        char[] back = {'D', 'L', 'U', 'R'};
        direction = direction + dir;
        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && vis[nRow][nCol] == 0){
                dfsIsland(nRow, nCol, grid, vis, String.valueOf(ahead[i]));
                direction = direction + back[i];
            }
        }
    }
}
