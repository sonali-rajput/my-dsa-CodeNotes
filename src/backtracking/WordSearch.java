package backtracking;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        String word = "ABCCED";
        WordSearch obj = new WordSearch();
        boolean ans = obj.exist(board, word);

        System.out.println(ans);
    }
    
    public char[][] board;
    public int rows;
    public int cols;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        for (int r=0;r<rows;r++) {
            for(int c=0;c<cols;c++) {
                if(backtrack(r,c,word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int row, int col, String word, int index) {

        //base case
        if(index >= word.length()){ // we found the word
            return true;
        }

        // check for out of bound of rows and cols + for the word present in the board or not
        if(row<0 || row >= rows || col<0 || col >= cols || this.board[row][col] != word.charAt(index)){
            return false;
        }

        // iterate over neighbours (our current index will be at that char for the word)
        int[] rowDir = {0,1,0,-1};
        int[] colDir = {1,0,-1,0};
        this.board[row][col] = '#'; // marking it as visited

        boolean ret = false; // a return var for all the four neighbours of current cell

        // iterate over all the directions
        for(int d=0; d<4;d++) {
            ret = backtrack(row + rowDir[d], col+colDir[d], word, index+1);
            if(ret){
                break; // so we dont have to check for all the other values
            }
        }
        board[row][col] = word.charAt(index); // update the board
        return ret;
 
    }
}
