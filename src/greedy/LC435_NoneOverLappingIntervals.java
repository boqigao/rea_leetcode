package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 记录一下大佬的思想：
 * 贪心算法，按照起点排序：选择结尾最短的，后
 * 面才可能连接更多的区间（如果两个区间有重叠，应该保留结尾小的）
 * 把问题转化为最多能保留多少个区间，使他们互不重复，
 * 则按照终点排序.
 *
 * 每个区间的结尾很重要，结尾越小，则后面越有可能容纳更多的区间。
 */
public class LC435_NoneOverLappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            //按照结尾大小升序排序
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 能组成的不重叠区间的个数
        int count = 1;

        int end = intervals[0][1];

        for (int[] interval : intervals) {
            if (interval[0] < end) {
                continue;
            }

            end = interval[1];
            count++;
        }
        return  intervals.length - count;
    }
}
