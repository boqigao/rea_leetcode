package algorithms;

public class KMP {

    /**
     * Compute temporary array to maintain size of suffix
     * which is same as prefix
     * @param pattern
     * @return
     */
    private int[] computeTemporaryArray(char[] pattern) {
        int[] lps = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length; i++) {
            if (pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index-1];
                } else {
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * KMP algorithm
     * @param text
     * @param pattern
     * @return
     */
    public boolean KMP (char[] text, char[] pattern) {
        int[] lps = computeTemporaryArray(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else { //如果当前字符不匹配
                if (j!=0) { // j就返回到前一个，即prefix的位置
                    j = lps[j-1];
                } else { // 如果j为0，且当前字符不匹配，那主字符串直接进到下一个即可
                    i++;
                }
            }
        }

        if (j == pattern.length) {
            return true;
        }
        return false;
    }
}
