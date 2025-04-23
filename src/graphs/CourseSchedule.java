package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {


    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
    
        CourseSchedule obj = new CourseSchedule();
    
        boolean ans = obj.canFinish(numCourses, prerequisites);
        System.out.println(ans);
    }
    


    public boolean canFinish(int numCourses, int[][] prerequisites) {
    
        HashMap<Integer,List<Integer>> courseGraph = new HashMap<>();

        for(int[] preq: prerequisites){

            // check prerequiste already in the graph
            if(courseGraph.containsKey(preq[1])){
                // append new prerequiste
                courseGraph.get(preq[1]).add(preq[0]);
            }
            else {
                // create new entry in courseGraph
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(preq[0]);
                courseGraph.put(preq[1], nextCourses);
            }
        }

        HashSet<Integer> visited = new HashSet<>();

        for(int currentCourse = 0; currentCourse<numCourses; currentCourse++){

            // check for cycle
            if(courseSchedule(currentCourse, visited, courseGraph) == false) {
                return false;
            }

        }
        return true;
    }

    public boolean courseSchedule(int currentCourse, HashSet<Integer> visited, HashMap<Integer, List<Integer>> courseGraph){

        if(visited.contains(currentCourse)) {
            return false;
        }

        if(courseGraph.get(currentCourse) == null) {
            return true;
        }

        visited.add(currentCourse); // add the currentCourse to the hashset 
        // iterate over all the prerequistes
        for(int pre: courseGraph.get(currentCourse)){
            if(courseSchedule(pre, visited, courseGraph) == false){
                return false;
            }
        }

        visited.remove(currentCourse);
        courseGraph.put(currentCourse, null); // emptying the prerequistes
        return true;

    }

}
