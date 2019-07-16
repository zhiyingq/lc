class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    count++;
                    int p = i, q = j;
                    while (++p < m && board[p][j] == 'X') board[p][j] = '.';
                    while (++q < n && board[i][q] == 'X') board[i][q] = '.';
                }
            }
        }
        return count;
    }
}