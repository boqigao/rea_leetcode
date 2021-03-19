package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);

        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }

        while (pq.size()>1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if (stone1 == stone2) {
                pq.offer(0);
            } else {
                pq.offer(Math.abs(stone1- stone2));
            }
        }

        return pq.poll();
    }
}
