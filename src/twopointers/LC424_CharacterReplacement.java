package twopointers;

public class LC424_CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[128];
        int left = 0, res = 0, maxCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'A']++;
            // maxCnt 维护的是某个出现的频率最高的字母
            maxCnt = Math.max(maxCnt, cnt[s.charAt(i)-'A']);
            // 如果数组长度大于maxCnt + k，意思是用k个maxCnt的字母全替换掉都不够，
            // 那么就要移动左边界了
            while (i - left + 1 - maxCnt > k) {
                cnt[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, i - left + 1);
        }

        return res;
    }
}
