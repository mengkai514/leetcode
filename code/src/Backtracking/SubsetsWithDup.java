package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. 子集 II
 */
public class SubsetsWithDup {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> paths = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        getSubsetsWithDup(nums, 0);
        return result;
    }

    private void getSubsetsWithDup(int[] nums,  int startIndex) {
        result.add(new ArrayList<>(paths));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            paths.add(nums[i]);
            getSubsetsWithDup(nums, i + 1);
            used[i] = false;
            paths.removeLast();
        }
    }
}
