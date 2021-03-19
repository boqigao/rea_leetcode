package greedy;

import java.util.Stack;

/**
 * 这道题的思路是这样的，从左往右扫描字符串，然后将其入栈
 * 当扫描到第i个字符时候，如果当前字符小于栈顶字符，并且字符串中从i开始以后还有
 * 栈顶字符，那说明，栈顶字符现在还没必要添加，就将其出栈
 *
 * 比如bab这种字符串
 * b先入队，然后我们扫描了a，然后发现（1）a比b小（2）a后面还有b，那么当前栈里的b就是
 * 不必要的。
 */
public class LC316_RemoveDuplicatedNumbers {
    static public String removeDuplicateLetters(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            // 如果stack中已经有这个字母了，因为这个字母是后出现的，所以直接无视？
            if (stack.contains(c)) {
                continue;
            }

            // s.indexOf(a, 3) 的意思是，在f字符串中，如果从index3开始还有a，就回复那个index，否则回复-1
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i)!=-1) {
                stack.pop();
            }
            stack.push(c);
        }
        char[] chars = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i] = stack.get(i);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        removeDuplicateLetters("bcabc");
    }
}
