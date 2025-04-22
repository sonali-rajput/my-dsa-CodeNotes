package graphs;

public class SurroundedRegion {

    public static void main(String[] args) {
        char[][] board = {   {'X','X','X','X'},
        {'X','O','O','X'},
        {'X','X','O','X'},
        {'X','O','X','X'}};

        SurroundedRegion obj = new SurroundedRegion();
        obj.solve(board);
    }


    public void solve(char[][] board) {
     
        // check for edge case
        if(board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        // Mark boundary connected with 'O's with 'T' or any special char
        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                if((i==0 || i == m-1 || j == 0|| j == n-1) && board[i][j] == 'O') {
                    dfs(board,i,j);
                }
            }
        }

        // Capture surronded regions and revert 'T' to 'O'
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }


    }

    private void dfs(char[][] board, int i, int j) {

        // check for out of bounds
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T'; // visited

        // run dfs in all 4 directions
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);

    }
}
