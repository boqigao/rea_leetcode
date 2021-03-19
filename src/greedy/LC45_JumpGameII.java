package greedy;

import java.util.*;

/**
 * 这道题的解法，初见我也觉得是bfs的感觉
 * @see LC55_JumpGame
 *
 * 实际上是dijkstra的变种，那么我们甚至可以用dist来记录所有的距离
 * 正好复习一下dijkstra
 */
public class LC45_JumpGameII {
    public int jump(int[] nums) {
        int len = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < len - 1; i++) {
            // 下一个节点的最远距离最远距离
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 其实是当前节点能达到的最远距离
            // 如果达到了，那么当前节点的最远距离就变成下一个最远距离了
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;

    }

    public int jump2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        // 当前使用的跳跃次数
        int steps = 0;
        // 当前使用的跳跃次数情况下最远能达到的距离
        int curStepsMaxReach = 0;
        // 当前使用的跳跃次数再加一次最远能达到的距离
        int oneMoreStepMaxReach = nums[0];
        for (int i = 1;i < nums.length;i++) {
            // 如果目前位置超过了curStepsMaxReach，则意味着我必须要跳一步了，即step++
            // 同时由于step++了，curStepsMaxReach就变成了oneMoreStepMaxReach
            if (i > curStepsMaxReach) {
                steps++;
                curStepsMaxReach = oneMoreStepMaxReach;
            }
            oneMoreStepMaxReach = Math.max(oneMoreStepMaxReach, i + nums[i]);
        }
        return steps;
    }

    /**
     * BFS还是比较好理解的！！
     * @param nums
     * @return
     */
    public int jump3(int[] nums) {
        if(nums.length <= 1) return 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        q.offer(0);

        int cnt = 0;
        while (!q.isEmpty()) {
            // 比如[2, 3, 1, 2,4,2,3]
            // 先拿出0，然后把 3,1放进去
            int size = q.size();

            //
            for (int i = 0; i < size; i++) {
                int curPos = q.poll();

                while (nums[curPos] != 0) {
                    if(visited.contains(curPos + nums[curPos])) {
                        // 这里很重要，就是当前节点访问过的邻居-1
                        nums[curPos] --;
                        continue;
                    }

                    // 如果已经达到终点
                    if (curPos + nums[curPos] == nums.length -1) {
                        return cnt + 1;
                    }
                    visited.add(curPos + nums[curPos]);
                    q.offer(curPos + nums[curPos]);
                    // 这里也表示当前节点的当前邻居已经访问过了
                    nums[curPos]--;
                }
            }
            cnt++;
        }
        return cnt;
    }
}

//这个更加好理解
/*
class Solution {
public:
    int jump(vector<int>& nums) {
        int steps = 0;
        int jump_idx = 0;   //用来记录再次起跳的位置
        int max_pos = 0;
        int len = nums.size();
        //不用考虑从最后一个位置起跳的情况，所以i < nums.size()-1，而不是i < nums.size()
        for (int i = 0; i < len-1; ++i){
            max_pos = max(max_pos, nums[i]+ i);
            // 会不会一直迭代下去？什么时候停止++steps？
            // 隐藏的边界条件，i < len - 1 ==> jump_idx < len - 1; 所以jump_idx超出len - 1以后，结果就定下来了
            if (i == jump_idx) {        //i到达起跳位置
                jump_idx = max_pos;     //下次起跳位置设置为本次贪心计算得到的最远距离处
                ++steps;
                if (jump_idx >= len-1) {    //优化：起跳点达到或者超过终点就可以结束循环了
                    break;
                }
            }
        }
        return steps;
    }
};
 */
