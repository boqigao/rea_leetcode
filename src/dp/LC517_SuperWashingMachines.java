package dp;

import java.util.Arrays;

/**
 * 解题思路: 有四个洗衣机，装的衣服数为[0, 0, 11, 5]，
 * 最终的状态会变为[4, 4, 4, 4]，那么我们将二者做差，
 * 得到*[-4, -4, 7, 1]，
 * 这里负数表示当前洗衣机还需要的衣服数，正数表示当前洗衣机多余的衣服数。
 * 我们要做的是*要将这个差值数组每一项都变为0.
 * 对于第一个洗衣机来说，需要四件衣服可以从第二个洗衣机获得，
 * 那么就可以 把-4移给二号洗衣机，那么差值数组变为[0, -8, 7, 1]，
 * 此时二号洗衣机需要八件衣服，那么至少需要移动8次。
 * 然后二号洗衣机把这八件衣服从三号洗衣机处获得，
 * 那么差值数组变为[0, 0, -1, 1]，此时三号洗衣机还缺1件，
 * 就从四号洗衣机处获得，此时差值数组成功变为了[0, 0, 0, 0]，成功。
 * 那么移动的最大次数就是差值 数组中出现的绝对值最大的数字，8次
 *
 * https://leetcode-cn.com/problems/super-washing-machines/solution/tan-xin-zai-dong-yi-dian-dian-nao-zi-by-whiteashes/
 * 这个讲的更清楚
 *
 */
public class LC517_SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        if (machines.length == 0){
            return -1;
        }
        if (machines.length == 1){
            return 0;
        }

        int sum = Arrays.stream(machines).sum();
        if (sum % machines.length != 0 ){
            return -1;
        }

        int avg = sum/machines.length;
        int[] helper = new int[machines.length];

        for (int i = 0; i < machines.length; i++) {
            helper[i] = machines[i] - avg;
        }
        int ans = 0;
        for (int i = 0; i < machines.length - 1; i++) {
            ans = Math.max(ans, Math.abs(helper[i]));

            //对于第1个洗衣机来说，需要的衣服得从第二个获得
            ans = Math.max(ans, helper[i + 1]);
            // 这时候我们已经把第i+1个洗衣机的衣服差值加上第i个洗衣机的衣服
            helper[i+1] += helper[i];
        }

        return ans;
    }
}
