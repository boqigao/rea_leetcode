package string;

public class LC6_ZigzagConversion {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int pos = 0;
        int dir = 1;

        for (int i = 0; i < s.length(); i++) {
            sbs[pos].append(s.charAt(i));
            pos += dir;

            if (pos == numRows-1) {
                dir = -1;
            }

            if (pos == 0) {
                dir = 1;
            }
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            res.append(sbs[i]);
        }

        return res.toString();
    }


    public static void main(String[] args) {
        LC6_ZigzagConversion test = new LC6_ZigzagConversion();

        System.out.println(test.convert("PAYPALISHIRING", 3));
    }
}
