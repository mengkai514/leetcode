package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 491. 递增子序列
 */
public class FindSubsequences {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> paths = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        Arrays.sort(nums);
        getFindSubsequences(nums, 0);
        return result;
    }

    private void getFindSubsequences(int[] nums, int startIndex) {
        if (paths.size() >= 2) {
            result.add(new ArrayList<>(paths));
        }
        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (!paths.isEmpty() && nums[i] < paths.getLast() ||
                    (used[nums[i] + 100] == 1)) continue;
            used[nums[i] + 100] = 1;
            paths.add(nums[i]);
            getFindSubsequences(nums, i + 1);
            paths.removeLast();
        }
    }
}
