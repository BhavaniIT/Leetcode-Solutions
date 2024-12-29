class Solution {
    int numRows, numCols;
    String targetWord;
    char[][] wordBoard;
    public boolean exist(char[][] board, String word) {
        numRows = board.length;
        numCols = board[0].length;
        targetWord = word;
        wordBoard = board;
        for(int i=0; i<board.length; ++i){
            for(int j=0; j<board[0].length; ++j){
                if(findByDfs(i, j,0))
                    return true;
            }
        }
        return false;
    }

    private boolean findByDfs(int row, int col, int index){
      if(index == targetWord.length()-1) 
            return wordBoard[row][col] == targetWord.charAt(index);

      if(wordBoard[row][col] != targetWord.charAt(index)) return false;

      char tempChar = wordBoard[row][col];
      wordBoard[row][col] = '0';
    
      int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

      for(int[] d : directions){
        int x = row + d[0];
        int y = col + d[1];

        if(isValid(x,y)){
            if(findByDfs(x,y,index+1))
                return true;
        }
      }
      wordBoard[row][col] = tempChar;
      return false;
    }

    private boolean isValid(int row, int col){
        return (row >= 0 && row < numRows) &&
            (col >= 0 && col < numCols) &&
            wordBoard[row][col] != '0';
    }
}