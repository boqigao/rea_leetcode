package dfs;

public class LC79_WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] words = word.toCharArray();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == words[0]) {
                    // 和岛的问题一样，需要一个数组来记录走过的路
                    boolean[][] used = new boolean[m][n];
                    if(search(board, words, m, n, i, j, 0, used)) return true;
                }

            }
        }
        return false;
    }
    public boolean search(char[][] board, char[] words, int m, int n, int i, int j, int index, boolean[][] used) {
        if (index == words.length) {
            return true;
        }
        if (i < 0 || i > m-1 || j < 0 || j > n-1 || used[i][j] || board[i][j] != words[index]) {
            return false;
        }

        // 这个其实并不是回溯，而是用一个used来记录找寻中曾经发生过的
        used[i][j] = true;
        // 下面没有及时返回！
//        return  search(board, words, m, n, i+1, j, index+1, used) ||
//                search(board, words, m, n, i-1, j, index+1, used) ||
//                search(board, words, m, n, i, j+1, index+1, used) ||
//                search(board, words, m, n, i, j-1, index+1, used);

        boolean a1 = search(board, words, m, n, i+1, j, index+1, used);
        if (a1) return true;  //及时返回
        boolean a2 = search(board, words, m, n, i-1, j, index+1, used);
        if (a2) return true;
        boolean a3 = search(board, words, m, n, i, j+1, index+1, used);
        if (a3) return true;
        boolean a4 = search(board, words, m, n, i, j-1, index+1, used);
        if (a4) return true;
        // 如果某一层都找过了，也没结果，就更新这一层
        // 这个操作类似于LC329
        used[i][j] = false;
        return false;
    }
}
