package dfs;

import java.util.Stack;

/**
 * 初见这道题，直觉感觉要用栈
 */
public class LC394_DecodingString {
    public String decodeString(String s) {
        if(s.length()==0) return "";
        StringBuilder res = new StringBuilder();

        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=']'){
                stack.push(s.charAt(i)+"");
            } else {
                StringBuilder tmpString = new StringBuilder();
                // 弹出所有的字母
                while (!stack.peek().equals("[")) {
                    tmpString.insert(0, stack.pop());
                }

                //弹出这个"["
                stack.pop();

                StringBuilder tmpNumber = new StringBuilder();
                // 弹出重复的次数
                while ((!stack.isEmpty())&&
                        (stack.peek().charAt(0)>='0')&&
                        (stack.peek().charAt(0)<='9')) {
                    tmpNumber.insert(0, stack.pop());
                }

                int times = Integer.parseInt(tmpNumber.toString());
                StringBuilder retString = new StringBuilder();

                //重复这个字符串
                for (int j = 0; j < times; j++){
                    retString.append(tmpString);
                }

                // 这里非常关键，如果不重新入栈，就相当于不能接到前面的字符串上去！
                stack.push(retString.toString());
            }
        }
        // 当上述结果完成后，栈里从深到浅存储着所有的结果
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }
}
