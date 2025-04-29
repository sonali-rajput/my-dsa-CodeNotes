package advanceGraph;

public class SwimRisingWater {

    public static void main(String[] args) {
        int[][] grid = {{0,2},{1,3}};

        SwimRisingWater obj = new SwimRisingWater();
        int ans = obj.swimInWater(grid);
        System.out.println(ans);
    }

    public int swimInWater(int[][] grid) {
     
        int n = grid.length;
        // t(time) will lie in between 0<t<=max(grid)
        int left = grid[0][0]; // smallest value
        int right = n*n-1;; // maximum value

        // Binary search
        while(left<right){
            int mid = left + (right - left)/2;

            if (canSwim(grid, mid)){
                right = mid;
            } else {
                left = mid +1;
            }
        }
        return left;

    }

    public boolean canSwim(int[][] grid, int t){
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        return dfs(grid, visited, 0,0,t);
    }

    private boolean dfs(int[][] grid, boolean[][] visited,int i, int j, int t){
        int n = grid.length;

        // check for out of bounds
        if(i<0 || i>=n || j<0 || j>=n || visited[i][j] || grid[i][j] > t){
            return false;
        }

        if (i == n-1 && j == n-1){ // bottom right position
            return true;
        }

        visited[i][j] = true;
        return dfs(grid, visited, i+1, j,t) ||
                dfs(grid, visited, i-1, j,t) || 
                dfs(grid, visited, i, j+1,t) ||
                dfs(grid, visited, i, j-1,t);
    }
}
