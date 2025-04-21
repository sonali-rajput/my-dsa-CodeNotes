package graphs;

public class MaxAreaofIslands {
public static void main(String[] args) {
    int[][] grid = {
        { 1, 1, 1, 1, 0 },
        { 1, 1, 0, 1, 0 },
        { 1, 1, 0, 0, 0 },
        { 0, 0, 0, 0, 0 }
    };

    MaxAreaofIslands obj = new MaxAreaofIslands();
    int ans = obj.maxAreaOfIsland(grid);
    System.out.println(ans);
}


    public int maxAreaOfIsland(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        if (grid == null || grid.length == 0)
            return 0;
        int maxArea = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;

    }

    private int dfs(int row, int col, int[][] grid) {

        int newRow = grid.length;
        int newCol = grid[0].length;
        // check for out of bounds
        if (row < 0 || col < 0 || row >= newRow || col >= newCol || grid[row][col] == 0) {
            return 0;
        }
        // we mark the current cell as visited
        grid[row][col] = 0;
        int area = 1; // current cell

        // explore in 4 directions
        area += dfs(row + 1, col, grid);
        area += dfs(row - 1, col, grid);
        area += dfs(row, col + 1, grid);
        area += dfs(row, col - 1, grid);

        return area;
    }
}
