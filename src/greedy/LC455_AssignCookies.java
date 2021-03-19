package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LC455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0;

        boolean[] visited = new boolean[g.length];
        Arrays.sort(s);

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < g.length; j++) {

                if (!visited[j] && s[i] >= g[j]) {
                    pq.offer(g[j]);
                    visited[j] = true;
                }

            }

            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }

        return res;
    }
}
