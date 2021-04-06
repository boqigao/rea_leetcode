package string;

import java.util.Stack;

public class LC20_ValidParentheses {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c!= stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
