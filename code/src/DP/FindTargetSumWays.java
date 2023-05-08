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

        // dp[j]含义：填满容量为j的包，有dp[j]种方式。
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                // 递推公式
                // 遍历到i物品，此时dp[j]有两种来源：
                // 不放入i物品，填满容量为j的背包的方式为,上一层的值：dp[j]
                // 放入i物品，填满容量为j的背包的方式为，上一层减掉物品重量的值：dp[j - nums[i]]
                 /*
                这一层的和为i的组合方式数，要么就是上一层和为i的组合数，要么就是上一层加上这一层的num
                比如这一层的数字是5，target = 7，那么只要看上一层和为2的组合方式有几种就行
                如果和为2的有2种组合方式，那说明组合成7的方式也是2种（即2+5）
                dp[i]：（上一个num计算和为target的组合方式数）
                dp[i - num]： （上一个num凑成和为 target - num的数，因为它的和加上num等于target）
                 */
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}
