package greedy;

/**
 * 思路：从右向左扫描数字，若发现当前位数字比其左边一位小
 * 则把左边一位数字减去1，并将该位以及其右边所有位数改成9
 */
public class LC738_MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        String s = N + "";
        int len = s.length();
        char[] chars = s.toCharArray();
        int flag = len;

        for (int i = len - 1; i >= 1; i--) {
            if (chars[i] < chars[i-1]) {
                chars[i - 1]--;
                for (int j = i; j < len; j++) {
                    chars[j] = '9';
                }
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
