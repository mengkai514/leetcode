package Greedy;

/**
 * 45. 跳跃游戏 II
 */
public class Jump {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int coverRange = 0;
        int count = 0;
        int currentDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == currentDistance) {
                currentDistance = coverRange;
                count++;
            }
        }
        return count;
    }
}
