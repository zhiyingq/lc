class ValidSudoku036 {
	public boolean isValidSudoku(char[][] board) {
		/* BASIC IDEA
		每个元素需要加入三个hashset中，每个都要记录元素的数值，同时也要记录行数和列数
		以及block. 比如r50 指的是在第0行有一个5， c50指的是0列有一个5，
		我们对9个block进行0-8的编号，编号由3 * row / 3 + col / 3生成
		那么一旦发现有任意重复，直接返回false；
		*/

        Set<String> count = new HashSet<String>();
        for (int row = 0; row < 9; row++) {
        	for (int col = 0; col < 9; col++) {
        		if (board[row][col] == '.') { continue; }
        		// false: exist, true: none exist
        		// whether the count contains "r50", where the first r means row
        		// the second number is the number at board[row][col]
        		// the third is the row index. Same as column
        		if (!count.add("r" + board[row][col] + row)) return false;
        		if (!count.add("c" + board[row][col] + col)) return false;
        		int block = 3 * (row / 3) + col / 3;
        		if (!count.add("b" + board[row][col] + block)) return false;
        	}
        }
        return true;
    }
}