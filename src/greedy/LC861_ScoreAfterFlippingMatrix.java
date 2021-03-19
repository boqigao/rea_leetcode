package greedy;

public class LC861_ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n-1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1){
                    nOnes +=A[i][j];
                } else {
                    nOnes += (1-A[i][j]);
                }
            }
            int k = Math.max(nOnes, m-nOnes);
            ret += k * (1 << (n-j-1));
        }
        return ret;
    }
}
