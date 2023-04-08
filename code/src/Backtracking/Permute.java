package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 */
public class Permute {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> paths = new LinkedList<>();
    HashMap<Integer,Integer> map;
    public List<List<Integer>> permute(int[] nums) {
        map = new HashMap<>();
        getPermute(nums, 0);
        return result;
    }

    private void getPermute(int[] nums, int startIndex) {
        if (paths.size() == nums.length) {
            result.add(new ArrayList<>(paths));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) >= 1) continue;
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            paths.add(nums[i]);
            getPermute(nums, 0);
            map.put(paths.getLast(), map.get(paths.getLast()) - 1);
            paths.removeLast();
        }
    }
}
