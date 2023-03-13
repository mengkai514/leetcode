package Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> reSet = new HashSet<>();
        for (int i:nums1) {
            set.add(i);
        }
        for (int i:nums2) {
            if (set.contains(i)) {
                reSet.add(i);
            }
        }
        int[] arr = new int[reSet.size()];
        int j = 0;
        for(int i : reSet){
            arr[j++] = i;
        }
        return arr;
    }
}
