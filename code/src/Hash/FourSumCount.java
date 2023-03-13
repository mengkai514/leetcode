package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int temp;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                if (map.containsKey(temp)) {
                    map.put(temp,map.get(temp) + 1);
                } else {
                    map.put(temp,1);
                }
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (map.containsKey(0 - temp)){
                    res += map.get(0 - temp);
                }
            }
        }
        return res;
    }
}
