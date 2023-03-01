package array.minSubArrayLen;

/**
 * 209. 长度最小的子数组
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 11;
        System.out.println(minSubArrayLen(target,nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0, j ,subLength;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (j = 0; j < nums.length; j++){
            sum += nums[j];
            while (sum >= target){
                subLength = j - i + 1;
                result = Math.min(result,subLength);
                sum = sum - nums[i++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
