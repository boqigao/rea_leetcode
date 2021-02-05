package dfs;

import java.util.ArrayList;
import java.util.List;

public class LC131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> tmpRes = new ArrayList<>();
        dfs(s, 0, res, tmpRes);
        return res;
    }


    // 判定s是否是回文字符串
    private boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void dfs (String s, int start, List<List<String>> res, List<String> tmpRes) {
        // 如果start比end大了，那就递归结束
        if(start==s.length()) {
            res.add(new ArrayList<>(tmpRes));
        }

        // 从start处开始，到end为止，尝试截取长度为，1,2,3...end-start+1 的字符串进行递归
        // * 注意，长度为1的话，就是string[start]这个位置本身 *
        // 如果是回文字符串，那就增加长度，并且递归剩余部分
        for (int i = start; i < s.length(); i++){
            String validateString = s.substring(start, i + 1);
            if (isPalindrome(validateString)){
                tmpRes.add(validateString);
                // 只要递归后半段就好了
                dfs(s,i+1, res, tmpRes);
                // 把当前的放回去，再递归下一段
                tmpRes.remove(tmpRes.size()-1);
            }
        }
    }
}
