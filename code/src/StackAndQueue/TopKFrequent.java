package StackAndQueue;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 */
public class TopKFrequent {
    private static class ValueComparator implements Comparator<Map.Entry<Integer,Integer>>
    {
        public int compare(Map.Entry<Integer,Integer> m,Map.Entry<Integer,Integer> n)
        {
            return n.getValue()-m.getValue();
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i,map.get(i) + 1);
            } else {
                map.put(i,map.getOrDefault(i,0) + 1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        ValueComparator vc = new ValueComparator();
        Collections.sort(list,vc);
        int[] res = new int[k];
        for (Map.Entry<Integer, Integer> m : list){
            if (k > 0) {
                res[--k] = m.getKey();
            }
        }
        return res;
    }
}
