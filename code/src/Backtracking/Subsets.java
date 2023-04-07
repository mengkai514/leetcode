package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 */
public class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> paths = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        getSubsets(nums, 0);
        return result;
    }

    private void getSubsets(int[] nums, int startIndex) {
        result.add(new ArrayList<>(paths));
        for (int i = startIndex; i < nums.length; i++) {
            paths.add(nums[i]);
            getSubsets(nums, i + 1);
            paths.removeLast();
        }
    }
}
