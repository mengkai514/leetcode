package DP;

/**
 * @author MK
 * @date 2023/5/8 - 15:36
 * 494. 目标和
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        //如果target过大 sum将无法满足
        if ( target < 0 && sum < -target) return 0;
        if ((target + sum) % 2 != 0) return 0;
        int size = (target + sum) / 2;
        if(size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                // 递推公式
                // 遍历到i物品，此时dp[j]有两种来源：
                // 不放入i物品，填满容量为j的背包的方式为,上一层的值：dp[j]
                // 放入i物品，填满容量为j的背包的方式为，上一层减掉物品重量的值：dp[j - nums[i]]
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}
