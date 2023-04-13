package Greedy;

/**
 * 53. 最大子数组和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            result = Math.max(result, sum);
            if (sum <= 0) {
                sum = 0;
            }
        }
        return result;
    }
}
