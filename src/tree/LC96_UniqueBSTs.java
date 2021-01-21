package tree;

import java.util.ArrayList;
import java.util.List;

// 见卡塔兰数
/*
i的意思是以i作为根
j的意思是以i为根左边子树的排列组合乘以以i为根右边子树的排列组合
 */
public class LC96_UniqueBSTs {
    public int numTrees(int n) {
        int[] T = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        for (int i = 2; i <n+1; i++){
            for (int j = 0; j<i; j++){
                T[i] = T[i] + T[j] * T[i-j-1];
            }
        }
        return T[n];
    }
}
