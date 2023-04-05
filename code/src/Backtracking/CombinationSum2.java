package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 */
public class CombinationSum2 {
    LinkedList<Integer> paths = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used;
    int sum;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        sum = 0;
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        getCombinationSum2(candidates, target, 0);
        return result;
    }

    private void getCombinationSum2(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(paths));
            return;
        }
        if (sum > target) return;
        for (int i = startIndex; i < candidates.length; i++) {
            //排序后剪枝
            if (sum + candidates[i] > target) {
                break;
            }
            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            paths.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            getCombinationSum2(candidates, target, i + 1);
            used[i] = false;
            sum -= paths.getLast();
            paths.removeLast();
        }
    }
}
