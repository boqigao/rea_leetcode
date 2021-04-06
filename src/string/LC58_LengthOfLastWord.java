package string;

public class LC58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.length()==1) {
            if (s.charAt(0) == ' ') {
                return 0;
            } else {
                return 1;
            }
        }

        int cnt = 0;
        for (int i = s.length() - 1; i >=0; i--) {
            if (s.charAt(i) != ' ') {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LC58_LengthOfLastWord test = new LC58_LengthOfLastWord();
        System.out.println(test.lengthOfLastWord("a"));
    }
}
