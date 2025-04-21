package graphs;

public class NoOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
    };

    NoOfIslands obj = new NoOfIslands();
    int ans = obj.numIslands(grid);
    System.out.println(ans);

    }
    
    public int numIslands(char[][] grid) {
    
        int row = grid.length;
        int col = grid[0].length;

        int island = 0;

        for(int i =0;i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == '1') {
                    island++; // make current island as 1
                    dfs(i, j, grid);
                }
            }
        }
        return island;

    }

    public void dfs(int row, int col, char[][] grid) {
        int newRow = grid.length;
        int newCol = grid[0].length;

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        // checking for outof bounds
        if(row<0 || col<0 || row>=newRow || col>=newCol || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0'; // chaning the current 1 to 0 to mark as visited
        for(int[] dir: directions){
            dfs(row+dir[0], col+dir[1], grid); // checking in all the directions
        }
    }
}
