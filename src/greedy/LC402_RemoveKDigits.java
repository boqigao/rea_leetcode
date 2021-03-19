package greedy;

import java.util.Stack;

/**
 * 这道题感觉和前面一个题其实很像
 * @see LC316_RemoveDuplicatedNumbers
 */
public class LC402_RemoveKDigits {
    public String removeKdigits(String num, int k) {

        int len = num.length();
        int hopeSize = len - k;

        if (len-k<=0) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {

            Character c = num.charAt(i);

            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);

            while (!stack.isEmpty() && stack.get(0) == '0'){
                stack.remove(0);
            }
        }

        int size =stack.size();

        if (size == 0) {
            return "0";
        }

        if (size > hopeSize) {
            int k1 = size - hopeSize;
            for (int i = 0; i < k1; i++){
                stack.pop();
            }
            size = stack.size();
        }

        char[] chars = new char[size];

        for (int i = 0; i < size; i++) {
            chars[i] = stack.get(i);
        }

        return new String(chars);
    }
}
