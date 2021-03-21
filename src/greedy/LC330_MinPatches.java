package greedy;

/**
 * 完全没有idea
 *
 * 一个数组[a1,a2,a3...an]当前能用和表示的数字区间为[1,ach]，
 * 此时往数组内补充新数num，则此时能表示的区间为[1,ach]∪[num,ach + num]
 */
public class LC330_MinPatches {
    public int minPatches(int[] nums, int n) {
        long ach = 0;
        int index = 0, count = 0, len = nums.length;
        while (ach < n) {
            // 如果index 已经越界了，或者当前的a值比index的数字小
            // 那么当前的a值肯定是够不到ach+1的，需要补一个ach+1
            if (index >= len || ach + 1 < nums[index]) {
                count++;
                ach += ach + 1;
            } else {
                // 否则直接给nums当前index的值加一个ach
                ach += nums[index];
                index++;
            }
        }
        return count;
    }
}
