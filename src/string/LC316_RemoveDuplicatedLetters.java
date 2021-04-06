package string;

import java.util.Stack;

/**
 * 1.通过这道题学会indexOf和lastIndexOf
 * 2.stack也有contains方法
 */
public class LC316_RemoveDuplicatedLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (stack.contains(chars[i])) {
                continue;
            }

            while (!stack.isEmpty() && chars[i] < stack.peek() && (s.indexOf(stack.peek(), i)!=-1)) {
                stack.pop();
            }

            stack.push(chars[i]);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        LC316_RemoveDuplicatedLetters test = new LC316_RemoveDuplicatedLetters();
        System.out.println(test.removeDuplicateLetters("cbacdcbc"));
    }
}
