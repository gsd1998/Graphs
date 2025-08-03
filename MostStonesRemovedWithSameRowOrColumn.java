package interviewQA.Graphs;

public class MostStonesRemovedWithSameRowOrColumn {

    public int removeStones(int[][] stones) {
        int[] vis = new int[stones.length];
        int noOfGroups = 0;
        for(int i = 0; i < stones.length; i++){
            if(vis[i] == 0){
                dfs(stones, vis, i);
                noOfGroups++;
            }
        }
        return stones.length - noOfGroups;
    }

    public void dfs(int[][] stones, int[] vis, int i){
        vis[i] = 1;
        for(int j = 0; j < stones.length; j++){
            int currRow = stones[i][0];
            int currCol = stones[i][1];
            int row = stones[j][0];
            int col = stones[j][1];
            if(vis[j] == 0 && (row == currRow || col == currCol)){
                dfs(stones, vis, j);
            }
        }
    }
}
