package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 先假设全部的人去A市，计算总和sum。 在分别计算 A - B的费用存入数组，
 * 由小到大排序，得到每个人去A 市比去B市多花的钱。
 * 用sum 减去多花钱最多的前一般的钱数，即为最终最低总费用
 *
 * 这题核心是每个人和自己比就行了
 * 如果小明去a 100块，去b200块，那小明绝壁去a便宜，对吧
 * 和小红没关系
 */
public class LC1029_TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int len = costs.length;
        int res = 0;
        int[] diff = new int[len];

        for (int i = 0; i < len; i++) {
            res += costs[i][0];
            diff[i] = costs[i][0] - costs[i][1];
        }
        Arrays.sort(diff);

        for (int i = len - 1; i >= len / 2; i--) {
            res -= diff[i];
        }

        return res;
    }
}
