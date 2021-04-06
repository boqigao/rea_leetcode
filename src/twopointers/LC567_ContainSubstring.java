package twopointers;

public class LC567_ContainSubstring {
    public boolean checkInclusion(String s1, String s2) {
        int[] sub = new int[26];

        int s1CharCnt = 0;
        for (int i = 0; i < s1.length(); i++)  {
            if (sub[s1.charAt(i) - 'a'] == 0) {
                s1CharCnt++;
            }
            sub[s1.charAt(i) - 'a']++;
        }

        int left = 0, right = 0;
        int[] tmpSub = new int[sub.length];
        int tmpS1CharCnt = s1CharCnt;
        System.arraycopy(sub,0,tmpSub,0,sub.length);

        while (right < s2.length()){

            if (tmpSub[s2.charAt(right) - 'a'] > 0) {
                tmpSub[s2.charAt(right) - 'a']--;
                if (tmpSub[s2.charAt(right) - 'a'] == 0) {
                    tmpS1CharCnt--;
                    if (tmpS1CharCnt == 0) {
                        return true;
                    }
                }
                right++;
            } else {
                left++;
                right = left;
                System.arraycopy(sub,0,tmpSub,0,sub.length);
                tmpS1CharCnt = s1CharCnt;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC567_ContainSubstring test = new LC567_ContainSubstring();
        System.out.println(test.checkInclusion("adc", "dcda"));

    }
}
