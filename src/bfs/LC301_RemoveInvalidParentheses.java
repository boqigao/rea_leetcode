package bfs;

import java.beans.PropertyEditorSupport;
import java.util.*;

/**
 * 这道题有点像wordladder
 *
 */
public class LC301_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s.equals("()") || s.equals("")) {
            res.add(s);
            return res;
        }

        Queue<String> queue = new LinkedList<>();

        queue.offer(s);

        //为了防止元素重复入队列, 用集合
        Set<String> set = new HashSet<>();
        boolean isFound = false;

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            // 都是取出以后直接判定！
            if(isValid(curr)) {
                res.add(curr);
                isFound = true;
            }

            // 如果当前已经是一个结果，那么无需再裁剪
            // 题目要求是【删除最少数量的括号】，所以在当前层找到以后，就无需进行下一层，
            // 那么怎么保证所有的都不会进到下一层呢？
            // 因为这里isFound是一个写在外面的全局变量！只要找到一个，后面不管对不对，就全都跳出了
            if(isFound) {
                continue;
            }

            // 裁剪的过程
            for (int i = 0; i < curr.length(); i++) {
                //只对'('或者')'进行裁剪
                if(curr.charAt(i) == '(' || curr.charAt(i) == ')') {
                    String str;
                    if(i == curr.length()-1) {
                        str = curr.substring(0, curr.length() - 1);
                    } else {
                        str = curr.substring(0, i) + curr.substring(i+1);
                    }
                    // 如果在集合中还未有该字符串
                    if(set.add(str)) {
                        queue.offer(str);
                    }
                }
            }
        }

        if(res.isEmpty()) {
            res.add("");
        }

        return res;

    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
