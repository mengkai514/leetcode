package DP;

/**
 * @author MK
 * @date 2023/5/10 - 15:22
 * 377. 组合总和 Ⅳ
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        /*
        先放物品 不会取重复的，先背包大小，会有重复的，以{1,2,3},target = 4,为例可以很明显发现 因为是先循环背包大小，
        所以放物品i和放物品target-i是两种情况，dp1和dp3都会被算一遍，其原因是因为是背包大小固定了，去装东西，
        比如当背包大小为4去循环时,当循环到第一个物品1,,根据递推公式dp4 = dp4 + dp3,这个dp3是已经装过了3号物品的，
        当循环到三号物品时又会把1号物品再装一遍所以就成了两种方案。
        如果是循环的是物品，则只被计算一次，因为循环到一个物品时，只能用该物品及之前的来装(定义)，
        就不会存在先装大小为3再装大小为1之后，还会存在先装1和3，因为在循环到1的时候，还不可以装3这个物品。
         */
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
