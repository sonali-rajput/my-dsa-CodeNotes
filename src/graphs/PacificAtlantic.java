package graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {

    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 } };

        PacificAtlantic obj = new PacificAtlantic();

        List<List<Integer>> ans = obj.pacificAtlantic(heights);
        System.out.println(ans);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        if (heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }

        int row = heights.length;
        int col = heights[0].length;

        // we make seperate grid for pacific and atlantic cells which are reachable
        boolean[][] pacificReachable = new boolean[row][col];
        boolean[][] atlanticReachable = new boolean[row][col];

        // to fill the grid with reachable cells
        for (int i = 0; i < row; i++) {
            dfs(i, 0, pacificReachable, heights); // Left edge
            dfs(i, col - 1, atlanticReachable, heights); // Right edge
        }

        for (int j = 0; j < col; j++) {
            dfs(0, j, pacificReachable, heights); // Top edge
            dfs(row - 1, j, atlanticReachable, heights); // Bottom edge
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;

    }

    /* 🌊 Visualization
You can think of water starting from the Pacific/Atlantic edges, and "climbing uphill" into cells as long as heights increase or stay the same.

After the DFS from both sides, we collect the intersection: cells reachable from both oceans.

 */

    public void dfs(int row, int col, boolean[][] reachable, int[][] heights) {

        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        reachable[row][col] = true;

        // iterate over neighbours of the current cell
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // check for outof bounds
            if (newRow < 0 || newCol < 0 || newRow >= heights.length || newCol >= heights[0].length) {
                continue;
            }

            // If it has been visited.
            if (reachable[newRow][newCol]) {
                continue;
            }

            if (heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, reachable, heights);
            }
        }

    }
}
