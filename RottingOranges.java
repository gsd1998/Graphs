package interviewQA.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean hasFresh = false;
        boolean hasRotten = false;
        Queue<PairOfRowCol> q = new LinkedList<>();
        int freshCount = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    freshCount++;
                }
                if(grid[i][j] == 2 && hasRotten == false){
                    hasRotten = true;
                }
                if(grid[i][j] == 2){
                    q.offer(new PairOfRowCol(i, j, 0));
                }
            }
        }
        if(freshCount == 0){
            return 0;
        }
        if(hasRotten == false){
            return -1;
        }

        int maxMinute = 0;
        int count = 0;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        while(!q.isEmpty()){
            PairOfRowCol cell = q.poll();
            int row = cell.row;
            int col = cell.col;
            int minute =  cell.minute;
            maxMinute = Math.max(maxMinute, minute);
            for(int i = 0; i < 4; i++){
                int neighRow = row + delRow[i];
                int neighCol = col + delCol[i];
                if(neighRow >= 0 && neighRow < n && neighCol >= 0 && neighCol < m && grid[neighRow][neighCol] == 1){
                    count++;
                    grid[neighRow][neighCol] = 2;
                    q.offer(new PairOfRowCol(neighRow, neighCol, minute+1));
                }
            }
        }

        if(freshCount != count){
            return -1;
        }
        return maxMinute;
    }
}
