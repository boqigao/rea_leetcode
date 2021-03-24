package twopointers;

public class LC348_DesignTicTacToe {
    class TicTacToe {

        private int[][] grid;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            this.grid = new int[n][n];
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int[][] grid = this.grid;
            if (player == 1) {
                grid[row][col] = 1;
            } else {
                grid[row][col] = 2;
            }

            int n = grid.length;
            int win = 0;

            for (int i = 0; i < n - 1; i++) {
                if (grid[0][0] == 1) {
                    if (grid[i][i] == grid[i+1][i+1]) {
                        win = 1;
                    } else {
                        win = 0;
                        break;
                    }
                } else{
                    break;
                }
            }
            if (win == 1) return 1;

            for (int i = 0; i < n - 1; i++) {
                if (grid[0][0] == 2) {
                    if (grid[i][i] == grid[i + 1][i + 1]) {
                        win = 2;
                    } else {
                        win = 0;
                        break;
                    }
                }else{
                    break;
                }
            }
            if (win == 2) return 2;

            for (int i = 0; i < n - 1; i++) {
                if (grid[i][n-i-1] == 1) {
                    if (grid[i][n-i-1] == grid[i+1][n-i-2]) {
                        win = 1;
                    } else {
                        win = 0;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (win == 1) return 1;

            for (int i = 0; i < n - 1; i++) {
                if (grid[i][n-i-1] == 2) {
                    if (grid[i][n-i-1] == grid[i+1][n-i-2]) {
                        win = 2;
                    } else {
                        win = 0;
                        break;
                    }
                }else{
                    break;
                }
            }
            if (win == 2) return 2;

            for (int i = 0; i < n; i++) {
                if (grid[i][0] == 1) {
                    for (int j = 0; j < n - 1; j++) {
                        if (grid[i][j] == grid[i][j+1]) {
                            win = 1;
                        } else {
                            win = 0;
                            break;
                        }
                    }
                }else{
                    break;
                }
            }
            if (win == 1) return 1;

            for (int i = 0; i < n; i++) {
                if (grid[i][0] == 2) {
                    for (int j = 0; j < n - 1; j++) {
                        if (grid[i][j] == grid[i][j+1]) {
                            win = 2;
                        } else {
                            win = 0;
                            break;
                        }
                    }
                }else{
                    break;
                }
            }
            if (win == 2) return 2;

            for (int j = 0; j < n; j++) {
                if (grid[0][j] == 1) {
                    for (int i = 0; i < n - 1; i++) {
                        if (grid[i][j] == grid[i+1][j]) {
                            win = 1;
                        } else {
                            win = 0;
                            break;
                        }
                    }
                } else{
                    break;
                }
            }
            if (win == 1) return 1;

            for (int j = 0; j < n; j++) {
                if (grid[0][j] == 2) {
                    for (int i = 0; i < n - 1; i++) {
                        if (grid[i][j] == grid[i+1][j]) {
                            win = 2;
                        } else {
                            win = 0;
                            break;
                        }
                    }
                }else{
                    break;
                }
            }
            if (win == 2) return 2;

            return 0;
        }
    }
}
