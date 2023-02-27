package BinarySearch;

/**
 * 704. 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int nums[] = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if (nums[middle] > target){
                right = middle -1;
            } else if(nums[middle] < target){
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
