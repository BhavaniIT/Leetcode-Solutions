class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] b : board)
            Arrays.fill(b, '.');
        List<List<String>> result = new ArrayList<>();
        dfs(0, board, result);
        return result;
    }

    private void dfs(int col, char[][] board, List<List<String>> result) {
        if (col == board.length) {
            result.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int row, int col) {
        int rowCopy = row;
        int colCopy = col;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        row = rowCopy;
        col = colCopy;

        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }

        row = rowCopy;
        col = colCopy;

        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            String s = new String(row);
            res.add(s);
        }

        return res;
    }
}