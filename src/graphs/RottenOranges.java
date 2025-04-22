package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        RottenOranges obj = new RottenOranges();
        int ans = obj.orangesRotting(grid);
        System.out.println(ans);
    }


    public int orangesRotting(int[][] grid) {
        
        // check for edge case
        if(grid.length == 0 || grid == null) return -1;

        int m = grid.length, n = grid[0].length;
        int freshCount = 0; // to keep track of all the oranges in the grid

        Queue<int[]> rottenQueue = new LinkedList<>();

        // Count fresh oranges and enqueue rotten oranges
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    freshCount++;
                } else if(grid[i][j] == 2) {
                    rottenQueue.offer(new int[]{i,j}); // add bad orange
                }
            }
        }

        if (freshCount == 0) return 0; // no fresh oranges

        int minutes = 0;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        // BFS
        while(!rottenQueue.isEmpty()){
            int size = rottenQueue.size();

            for(int i=0; i<size; i++){
                int[] rotten = rottenQueue.poll();
                for (int[] dir: directions){
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];
                    // check if not out of bounds
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                        grid[x][y] = 2; // turn fresh orange to rotten
                        freshCount--;
                        rottenQueue.offer(new int[]{x, y});
                    }
                }
            }
            minutes++; // after each bfs (level)
        }

        return freshCount == 0? minutes - 1: -1;


    }
}
