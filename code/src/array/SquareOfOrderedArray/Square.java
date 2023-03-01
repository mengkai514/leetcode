package array.SquareOfOrderedArray;

/**
 * 977. 有序数组的平方
 */
public class Square {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        int j = nums.length - 1;
        int i = 0;
        while (i <= j){
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                result[k--] = nums[j] * nums[j];
                j--;
            } else {
                result[k--] = nums[i] * nums[i];
                i++;
            }
        }
        return result;
    }
}
