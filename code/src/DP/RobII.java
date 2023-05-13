package DP;

/**
 * @author MK
 * @date 2023/5/13 - 19:17
 * 213. 打家劫舍 II
 */
public class RobII {
    private int rob1(int[] nums, int start, int end) { // [start,end)
        int f0 = 0, f1 = 0;
        for (int i = start; i < end; ++i) {
            int newF = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        /**
         * 分类讨论：
         * 如果偷nums[0]，那么nums[1]和nums[n-1]不能偷，问题变成nums[2]到nums[n-2]的非环形版本
         * 如果不偷nums[0]，问题变成nums[1]到nums[n-1]的非环形版本
         */
        return Math.max(nums[0] + rob1(nums, 2, n - 1), rob1(nums, 1, n));
    }
}
