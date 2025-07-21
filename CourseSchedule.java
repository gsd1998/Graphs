package interviewQA.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(int i = 0 ; i < numCourses; i++){
            for(int a : adj.get(i)){
                inDegree[a]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int j = 0; j < numCourses; j++){
            if(inDegree[j] == 0)
                q.offer(j);
        }

        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int a : adj.get(node)){
                inDegree[a]--;
                if(inDegree[a] == 0){
                    q.offer(a);
                }
            }
        }
        if(count == numCourses){
            return true;
        }
        return false;
    }
}
