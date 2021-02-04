package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17_LetterCombinationsOfAPhone {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        Map<Character,String[]> phone= new HashMap<>();
        phone.put('2',new String[]{"a", "b", "c"});
        phone.put('3',new String[]{"d", "e", "f"});
        phone.put('4',new String[]{"g", "h", "i"});
        phone.put('5',new String[]{"j", "k", "l"});
        phone.put('6',new String[]{"m", "n", "o"});
        phone.put('7',new String[]{"p", "q", "r", "s"});
        phone.put('8',new String[]{"t", "u", "v"});
        phone.put('9',new String[]{"w", "x", "y", "z"});

        String tmp = "";

        // index 是现在扫描到digits的第几位了

        helper(res, phone,digits,0,tmp);

        return res;
    }

    private void helper(List<String> res,
                        Map<Character,String[]> phone,
                        String digits,
                        Integer index,
                        String tmp){
        if(index==digits.length()) {
            return;
        }

        // i负责遍历当前index位的所有的字母
        for(int i = 0; i<phone.get(digits.charAt(index)).length; i++) {
            tmp += phone.get(digits.charAt(index))[i];
            if (tmp.length() == digits.length()) {
                res.add(new String(tmp));
            }

            helper(res, phone, digits, index + 1, tmp);
            // 这里如果不删掉的话，那么下一个for循环就不对了
            tmp = tmp.substring(0, index);
        }
    }
}
