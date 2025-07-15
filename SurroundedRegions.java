package interviewQA.Graphs;

public class SurroundedRegions {
    public void solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];

        //rows
        for(int j = 0; j < m ; j++){
            if(mat[0][j] == 'O' && vis[0][j] == 0){
                dfs(0, j, mat, vis);
            }
            if(mat[n-1][j] == 'O' && vis[n-1][j] == 0){
                dfs(n-1, j, mat, vis);
            }
        }
        //columns
        for(int i = 0; i < n; i++){
            if(mat[i][0] == 'O' && vis[i][0] == 0){
                dfs(i, 0, mat, vis);
            }
            if(mat[i][m-1] == 'O' && vis[i][m-1] == 0){
                dfs(i, m-1, mat, vis);
            }
        }

        for(int r1 = 1; r1 < n-1; r1++){
            for(int c1 = 1; c1 < m-1; c1++){
                if(mat[r1][c1] == 'O' && vis[r1][c1] == 0){
                    mat[r1][c1] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] mat, int[][] vis){
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && mat[nRow][nCol] == 'O' && vis[nRow][nCol] == 0){
                dfs(nRow, nCol, mat, vis);
            }
        }
    }
}
