package dp;

import java.util.List;

public class LC120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
            for (int j = 0; j <= i; j ++) {
                int next1 = triangle.get(i+1).get(j);
                int next2 = triangle.get(i+1).get(j+1);

                curr.set(j, Math.min(next1, next2) + curr.get(j));
            }
        }

        return triangle.get(0).get(0);
    }
}
