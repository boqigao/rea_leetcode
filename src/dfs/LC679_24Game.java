package dfs;

/**
 * 这道题的核心是，要把计算的结果存到新数组里，同时，compute函数，已经起到了dfs的感觉
 */
public class LC679_24Game {
    public boolean judgePoint24(int[] nums) {
        double[] a = new double[]{nums[0], nums[1], nums[2], nums[3]};
        return helper(a);
    }

    private boolean helper(double[] a){
        if (a.length == 1) {
            return Math.abs(a[0] - 24) < 0.001;
        }

        // 把a数组中的第i位和第j拿出来计算
        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a.length; j++) {
                // 从数组a中选出了2个数进行计算，因此用于存计算结果的数组要短一位
                double[] b = new double[a.length - 1];

                for (int k = 0, index = 0; k < a.length; k++) {
                    // 把没有参与运算的其他位放入存计算结果的数组中
                    if (k != i && k != j) {
                        b[index++] = a[k];
                    }
                }

                // 查看新数组是否有24
                for (double d : compute(a[i], a[j])){
                    b[b.length-1] = d;
                    if (helper(b)){
                        return true;
                    }
                }
            }
        }

        // 如果上述全部跑完，都没有return true的话，说明没有结果
        return false;
    }

    // 这个helper考虑了y-x和y/x，所以已经起到了括号的作用
    private double[] compute(double x, double y) {
        return new double[] {
                x+y,x-y,y-x,x*y, x/y, y/x
        };
    }
}
