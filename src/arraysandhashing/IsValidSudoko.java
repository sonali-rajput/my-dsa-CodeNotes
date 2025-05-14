package arraysandhashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IsValidSudoko {

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        IsValidSudoko obj = new IsValidSudoko();

        boolean result = obj.isValidSudoku(board);
        System.out.println(result);
    }

    public boolean isValidSudoku(char[][] board) {

        int n = 9;

        List<HashSet<Character>> rows = new ArrayList<>();
        List<HashSet<Character>> cols = new ArrayList<>();
        List<HashSet<Character>> box = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            box.add(new HashSet<Character>());

        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                char val = board[r][c];

                if (val == '.') {
                    continue;
                }

                if (rows.get(r).contains(val)) {
                    return false;
                }
                rows.get(r).add(val);

                if (cols.get(c).contains(val)) {
                    return false;
                }
                cols.get(c).add(val);

                int idx = (r / 3) * 3 + c / 3;
                if (box.get(idx).contains(val)) {
                    return false;
                }
                box.get(idx).add(val);

            }
        }
        return true;

    }
}
