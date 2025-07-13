package interviewQA.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int currColor = image[sr][sc];
        image[sr][sc] = color;
        Queue<PairOfRowCol> q = new LinkedList<>();
        q.offer(new PairOfRowCol(sr, sc));
        while(!q.isEmpty()){
            PairOfRowCol box = q.poll();
            int nRow = box.row;
            int nCol = box.col;
            for(int delRow = -1; delRow <= 1; delRow++){
                for(int delCol = -1; delCol <= 1; delCol++){

                    if((delRow == -1 && delCol == -1) || (delRow == -1 && delCol == 1) ||
                            (delRow == 1 && delCol == -1) || (delRow == 1 && delCol == 1)){
                        continue;
                    }
                    int neighRow = delRow + nRow;
                    int neighCol = delCol + nCol;
                    if(neighRow >=0 && neighRow < n && neighCol >= 0 && neighCol < m &&
                            image[neighRow][neighCol] == currColor && image[neighRow][neighCol] != color){
                        image[neighRow][neighCol] = color;
                        q.offer(new PairOfRowCol(neighRow, neighCol));
                    }
                }
            }
        }
        return image;
    }
}
