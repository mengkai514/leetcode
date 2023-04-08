package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 */
public class PermuteUnique {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> paths = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        Arrays.fill(used, false);
        getPermuteUnique(nums, 0);
        return result;
    }

    private void getPermuteUnique(int[] nums, int startIndex) {
        if (paths.size() == nums.length) {
            if (!result.contains(paths)){
                result.add(new ArrayList<>(paths));
            }
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (!used[i]) {
                used[i] = true;
                paths.add(nums[i]);
                getPermuteUnique(nums, startIndex);
                paths.removeLast();
                used[i] = false;
            }
        }
    }
}
