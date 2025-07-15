package interviewQA.Graphs;

public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] mat = new int[n][m];
        int[][] vis = new int[n][m];
        for(int p1 = 0; p1 < n; p1++){
            for(int p2 = 0; p2 < m; p2++){
                mat[p1][p2] = grid[p1][p2];
            }
        }
        //rows
        for(int j = 0; j < m ; j++){
            if(mat[0][j] == 1 && vis[0][j] == 0){
                dfs(0, j, mat, vis);
            }
            if(mat[n-1][j] == 1 && vis[n-1][j] == 0){
                dfs(n-1, j, mat, vis);
            }
        }
        //columns
        for(int i = 0; i < n; i++){
            if(mat[i][0] == 1 && vis[i][0] == 0){
                dfs(i, 0, mat, vis);
            }
            if(mat[i][m-1] == 1 && vis[i][m-1] == 0){
                dfs(i, m-1, mat, vis);
            }
        }
        int count = 0;
        for(int c1 = 1; c1 < n-1; c1++){
            for(int c2 = 1; c2 < m-1; c2++){
                if(mat[c1][c2] == 1 && vis[c1][c2] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, int[][] mat, int[][] vis){
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && mat[nRow][nCol] == 1 && vis[nRow][nCol] == 0){
                dfs(nRow, nCol, mat, vis);
            }
        }
    }
}
