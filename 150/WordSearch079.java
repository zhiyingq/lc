class WordSearch079 {
	public boolean exist(char[][] board, String word) {
		// put the chars into the map
        if (word == "") return true;
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (hasWord(board, word, 0, i, j)) return true;
        	}
        }
       	return false;
    }

    private boolean hasWord(char[][] board, String word, int index, int i, int j) {
    	// 如果不符合条件，直接跳过
    	if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) return false;
    	
    	// if the board[i][j] == words[index]
    	// 若符合条件
    	if (board[i][j] == word.charAt(index)) {
    		// 判断是否已经走到了word的底部
    		if (index == word.length() - 1) return true;   
    		// 把board[i][j]改成问号，这样回溯的时候就会不匹配
    		// 但是很有可能导致bug 
    		char temp = board[i][j];
            board[i][j] = '?';
            // 主要后续可以找到，即返回true
    		if (hasWord(board, word, index + 1, i, j - 1)) return true;
    		if (hasWord(board, word, index + 1, i, j + 1)) return true;
    		if (hasWord(board, word, index + 1, i - 1, j)) return true;
    		if (hasWord(board, word, index + 1, i + 1, j)) return true;
    		// 把board[i][j]返回原值
    		board[i][j] = temp;
    	}
    	return false;
    }
}

















