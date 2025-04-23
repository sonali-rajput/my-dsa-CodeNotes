package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 4; int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        CourseScheduleII obj = new CourseScheduleII();
        int[] ans = obj.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(ans));
    }

    static int white = 1; // node not been visited
    static int gray = 2; // during current dfs current visited node
    static int black = 3; // node going to be final visited set and also stack

    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder; // stack

    private void init(int numCourses){

        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();

        // by default all nodes are white
        for (int i = 0; i < numCourses; i++){
            this.color.put(i, white);
        }


    }

    private void dfs(int node){

        // check for cycle
        if (!this.isPossible){
            return;
        }

        // start the recursion
        this.color.put(node, gray);

        // Traverse on neighbouring nodes
        for(Integer neighbour: this.adjList.getOrDefault(node, new ArrayList<Integer>())) {

            // not visited node
            if (this.color.get(neighbour) == white){
                this.dfs(neighbour);
            } else if (this.color.get(neighbour) == gray){ // current dfs already visited -> that means cycle
                this.isPossible = false;

            }
        }

        // recursion ends we mark it as black
        this.color.put(node, black); // final visited
        this.topologicalOrder.add(node);


    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
    
        this.init(numCourses);

        // Create the adjacency list represtation of a directed graph
        for(int i=0; i < prerequisites.length; i++){
            int dest = prerequisites[i][0]; // ex; {1,0} 0 is src of 1 0 --> 1
            int src = prerequisites[i][1];

            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src,lst);

        }

        // if node in unprocessed then call dfs on it
        for(int i = 0; i < numCourses; i++){
            if (this.color.get(i) == white) {
                this.dfs(i);
            }
        }

        int[] order;
        if (this.isPossible) {
            order = new int[numCourses];
            for(int i=0; i<numCourses; i++){
                order[i] = this.topologicalOrder.get(numCourses - i - 1); // stack taking values in reverse LIFO
            }
        } else {
            order = new int[0];
        }

        return order;

    }

}
