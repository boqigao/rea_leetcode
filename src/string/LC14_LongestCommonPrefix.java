package string;

public class LC14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String s = strs[1];

        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length() && j < s.length(); j++) {
                if (strs[i].charAt(j) == s.charAt(j)) {
                    continue;
                } else {
                    s = s.substring(0, j);
                }
            }
        }

        return s;
    }

    public static void main(String[] args) {
        LC14_LongestCommonPrefix test = new LC14_LongestCommonPrefix();
        String[] strs = new String[] {"flower", "flow", "flight"};
        System.out.println(test.longestCommonPrefix(strs));
    }
}
