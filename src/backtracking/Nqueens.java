package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Nqueens {

    public static void main(String[] args) {
        Nqueens obj = new Nqueens();

        List<List<String>> ans = obj.solveNQueens(4);
        System.out.println(ans);
    }


    public List<List<String>> solveNQueens(int n) {
     char[][] board = new char[n][n];
     
     // mark each place in the board with '.'
     for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            board[i][j] = '.';
        }
     }

     List<List<String>> result = new ArrayList<>();
     backtrack(board, 0, result);
     return result;

    }

    private void backtrack(char[][] board, int col, List<List<String>> result){

        // base case
        if(col == board.length) { // reached the end column
            result.add(construct(board));
            return;
        }

        for (int i=0; i<board.length; i++) {
            if (isValid(board, i, col)){
                board[i][col] = 'Q';
                backtrack(board, col+1, result);
                board[i][col] = '.'; // backtracking
            }
        }

    }

    // To check based on the previous paths we calculated do we have any particular Queen placed in all directions ( row, col, diagnol)
    private boolean isValid(char[][] board, int row, int col){
        for(int i=0; i < col; i++) {
            if(board[row][i] == 'Q') { // checking for rows
                return false;
            }
        }

        for(int i = row, j = col; i>=0 && j>=0; i--,j--){ // checking for columns
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        for(int i=row, j=col; i<board.length && j>=0; i++, j--) { // checking for diagnols
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }


    // simply for getting a list with the result of the queens placed on the board for ex: [".Q..","...Q" and so on]
    private List<String> construct(char[][] board){
        List<String> result = new ArrayList<>();
        for (int i=0;i<board.length;i++){
            String row = new String(board[i]);
            result.add(row);
        }
        return result;
    }
}
