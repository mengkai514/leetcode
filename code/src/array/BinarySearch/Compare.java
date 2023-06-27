package array.BinarySearch;

/**
 * @author MK
 * @date 2023/6/27 - 19:51
 * BM22 比较版本号
 */
public class Compare {
    public int compare (String version1, String version2) {
        int n1 = version1.length();
        int n2 = version2.length();
        int i = 0, j = 0;
        while (i < n1 || j < n2) {
            long nums1 = 0;
            //从下一个点前截取数字
            while (i < n1 && version1.charAt(i) != '.') {
                nums1 = nums1 * 10 + (version1.charAt(i) -'0');
                i++;
            }
            // 跳过'.'
            i++;
            long nums2 = 0;
            //从下一个点前截取数字
            while (j < n2 && version2.charAt(j) != '.') {
                nums2 = nums2 * 10 + (version2.charAt(j) -'0');
                j++;
            }
            // 跳过'.'
            j++;
            if (nums1 > nums2)
                return 1;
            if (nums1 < nums2)
                return -1;
        }
        return 0;
    }
}
