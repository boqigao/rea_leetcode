package twopointers;

import java.util.Map;

/**
 * @see LC424_CharacterReplacement
 */
public class LC1004_MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int left = 0, res = 0, numZero = 0;
        if (K == A.length) {
            return K;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                numZero++;
            }

            while (numZero > K && left <= i) {
                if (A[left] != 1) {
                    numZero--;
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
