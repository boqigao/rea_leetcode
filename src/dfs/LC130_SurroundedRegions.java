package dfs;

public class LC130_SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null || board.length==0) return;
        int m = board.length;
        int n = board[0].length;


        for(int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);
            if (board[i][n-1] == 'O') dfs(i, n-1, board );
        }

        for(int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(0, j, board);
            if (board[m-1][j] == 'O') dfs(m-1, j, board);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 先把O变x，不然岂不是所有的O都变成x了？？
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    public void dfs(int i, int j, char[][] board)
 {
     //这里一定要加等号，否则会越界
        if(i<0 || j <0 || i >= board.length || j >=board[0].length ||
        board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T';
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);

    }
}
