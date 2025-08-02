package interviewQA.Graphs;

public class CityWithSmallestNumberOfNeighborsAtThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] mat = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = (int)(1e9);
                if(i == j){
                    mat[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            mat[u][v] = wt;
            mat[v][u] = wt;
        }

        for(int via = 0; via < n; via++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }

        int maxCount = Integer.MAX_VALUE;
        int count = 0;
        int city = 0;
        for(int i = 0; i < n; i++){
            count = 0;
            for(int j = 0; j < n; j++){
                if(i != j && mat[i][j] <= distanceThreshold){
                    count++;
                }
            }

            if(count <= maxCount){
                maxCount = count;
                city = i;
            }
        }
        return city;
    }
}
