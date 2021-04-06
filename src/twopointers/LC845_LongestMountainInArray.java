package twopointers;

/**
 * 初见这道题，感觉是摆动数组？
 */
public class LC845_LongestMountainInArray {
    public int longestMountain(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i-1] < arr[i] && arr[i + 1] < arr[i]) {
                int l = i - 1;
                int r = i + 1;
                while (l > 0 && arr[l-1] < arr[l]) {
                    l--;
                }
                while (r < arr.length - 1 && arr[r + 1] < arr[r]) {
                    r++;
                }
                res = Math.max(res, (r-l+1));
            }
        }
        return res;
    }
}
