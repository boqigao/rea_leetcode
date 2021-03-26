package twopointers;

public class LC75_SortColors {
    public void sortColors(int[] nums) {
        int numZero = 0, numOne = 0, numTwo = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[numTwo++] = 2;
                nums[numOne++] = 1;
                nums[numZero++] = 0;
            } else if (nums[i] == 1) {
                nums[numOne++] = 1;
                nums[numTwo++] = 2;
            } else {
                nums[numTwo++] = 2;
            }
        }
    }
}
