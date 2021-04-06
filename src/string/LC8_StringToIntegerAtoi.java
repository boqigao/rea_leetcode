package string;

/**
 * 这道题目如果只是简单地字符串转整数的话，就是简单地ans = ans * 10 + digit
 * 从这道题要学会Character.isDigit
 */
public class LC8_StringToIntegerAtoi {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int index = 0;
        while (index < n && chars[index] == ' ') {
            // 去掉前面的空格
            index++;
        }

        if (index == n) {
            return 0;
        }

        boolean negative = false;
        if (chars[index] == '-') {
            negative = true;
            index++;
        } else if (chars[index] == '+') {
            index++;
        } else if (!Character.isDigit(chars[index])) {
            // 如果是非数字的其他符号，则返回0
            // 这里有一层隐喻就是如果是数字的话，则默认negative = false

            return 0;
        }

        int ans = 0;
        while (index < n && Character.isDigit(chars[index])) {
            int digit = chars[index] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 * 10 和 + digit都有可能越界，所以都移到右边去
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            index++;
        }
        return negative? -ans : ans;
    }
}
