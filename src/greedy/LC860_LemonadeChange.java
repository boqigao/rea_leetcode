package greedy;

public class LC860_LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] cnt = new int[3];
        for (int bill : bills) {
            if (bill == 5) {
                cnt[0]++;
            }
            if (bill == 10) {
                cnt[0]--;
                cnt[1]++;
                if (cnt[0] < 0) {
                    return false;
                }
            }

            if (bill == 20) {
                if(cnt[1] - 1>=0 && cnt[0] - 1>=0) {
                    cnt[1]--;
                    cnt[0]--;
                } else if (cnt[0] - 3>=0) {
                    cnt[0] -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;

    }
}
