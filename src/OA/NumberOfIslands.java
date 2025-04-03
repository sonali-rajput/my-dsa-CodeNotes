    package OA;

    public class NumberOfIslands {


        public static void main(String[] args) {
            char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
        }


        public static int numIslands(char[][] grid) {
            
            int count = 0;

            for (int i=0; i<grid.length; i++){
                for (int j=0; j<grid[i].length;j++){
                    if (grid[i][j] == '1') {
                        count +=1 ;
                        callDFS(grid, i, j);
                    }
                }
            }
            return count;
            
        }

        public static void callDFS(char[][] grid,int i, int j){
            if (i<0 || i>grid.length || j<0 || j>grid[i].length || grid[i][j] == '0'){
                return;
            }
            grid[i][j] = '0';
            callDFS(grid, i+1, j); //up
            callDFS(grid, i-1, j); //down
            callDFS(grid, i, j-1); //left
            callDFS(grid, i, j+1); //right

        }
    }
