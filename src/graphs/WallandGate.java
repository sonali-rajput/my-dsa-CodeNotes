package graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Question: we are given a 2D mxn grid where -1 is wall, 0 is gate and INF is infinity (that is empty room)
 * We need to find the shortest path ( fill up the space between gates and walls) between gates and walls.
 * If an empty room is surrounded by walls then keep it as INF. 
 */

public class WallandGate {

    public static void main(String[] args) {
        int INF = 2147483647;
    
        int[][] rooms = {
            {INF,  -1,   0,  INF},
            {INF, INF, INF,  -1},
            {INF,  -1, INF,  -1},
            {  0,  -1, INF, INF}
        };
    
        WallandGate wg = new WallandGate();
        wg.wallsAndGate(rooms);
    
        // Print the updated grid
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }
    

    private static final int INF = 2147483647;
    private static final int[] dirs = {0,1,0,-1,0}; // right(0,1) down(1,0) left(0,-1) up(-1,0)

    public void wallsAndGate(int[][] rooms){

        // edge case
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        int m = rooms.length, n = rooms[0].length;
        
        Queue<int[]> queue = new LinkedList<>();

        // Add gates to the queue
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // BFS from each gate
        while (!queue.isEmpty()){
            int[] gate = queue.poll();
            int row = gate[0];
            int col = gate[1];


            for(int i=0; i<4; i++){ // explore in 4 directions
                int newRow = row + dirs[i];
                int newCol = col + dirs[i+1];

                // check if not out of bounds and the cell is an empty room
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && rooms[newRow][newCol] == INF){
                    rooms[newRow][newCol] = rooms[row][col] + 1; // update distance
                    queue.offer(new int[]{newRow, newCol}); // add back to queue to keep on updating the distance
                }


            }
        }




    }



}
