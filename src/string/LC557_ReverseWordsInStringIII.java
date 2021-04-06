package string;

public class LC557_ReverseWordsInStringIII {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            buffer.append(new StringBuffer(strs[i]).reverse().toString());
            buffer.append(" ");
        }
        return buffer.toString().trim();
    }

    public static void main(String[] args) {
        LC557_ReverseWordsInStringIII test = new LC557_ReverseWordsInStringIII();
        System.out.println(test.reverseWords("Let's take LeetCode contest"));
    }
}
