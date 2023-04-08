package Backtracking;

import java.util.*;

/**
 * 491. 递增子序列
 */
public class FindSubsequences {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> paths = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        getFindSubsequences(nums, 0);
        return result;
    }

    private void getFindSubsequences(int[] nums, int startIndex) {
        if (paths.size() >= 2) {
            result.add(new ArrayList<>(paths));
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!paths.isEmpty() && nums[i] < paths.getLast() ||
                    (map.getOrDefault( nums[i],0 ) >=1)) continue;
            map.put(nums[i],map.getOrDefault( nums[i],0 )+1);
            paths.add(nums[i]);
            getFindSubsequences(nums, i + 1);
            paths.removeLast();
        }
    }
}
