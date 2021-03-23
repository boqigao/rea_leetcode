package twopointers;

public class LC88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        // 这里隐藏了一个东西就是说
        // 如果j先填完，那么i前面的都不用动了
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }

        // 如果i先填完，那就把j都填进去好了
        while(j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}
