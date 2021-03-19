package greedy;

/**
 * 重点就两句话： 1、两个数组之差的总和必须大于等于0，否则不能完成绕行
 * 2、 一个站的收益如果小于0，肯定不能作为起点；
 * 而连续的多个站也可以等效地看做一个站，如果其累积收益小于0，
 * 就跳过，寻找下一个。
 */
public class LC134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;
        int curTank = 0;
        int startingStation = 0;
        for (int i = 0; i < n; i++) {
            totalTank += gas[i] - cost[i];
            curTank += gas[i] - cost[i];

            // 如果走到当前站为负，肯定不能从这里或者前面开始
            if (curTank < 0) {
                startingStation = i + 1;
                // 还原到初始状态
                // 这里很重要，注意totaltank是一定不能修正就行了
                // 即：只要gas的和大于cost的和，就一定有某个站可以做到
                curTank = 0;
            }
        }

        //总和必须大于等于0，否则不能完成绕行
        return totalTank >= 0?startingStation : -1;
    }
}
