package array.minSubArrayLen;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 */
public class MinWindow {
    public static void main(String[] args) {
        String myStr = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(myStr,t));
    }
    public static String minWindow(String s, String t) {
        //1.维护两个map记录窗口中的符合条件的字符以及need的字符
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();//need中存储的是需要的字符以及需要的对应的数量
        for(char c : t.toCharArray())
            need.put(c,need.getOrDefault(c,0)+1);
        int left = 0,right = 0;//双指针
        int count = 0;//count记录当前窗口中符合need要求的字符的数量,当count == need.size()时即可shrink窗口
        int start = 0;//start表示符合最优解的substring的起始位序
        int len = Integer.MAX_VALUE;//len用来记录最终窗口的长度，并且以len作比较，淘汰选出最小的substring的len

        //一次遍历找“可行解”
        while(right < s.length()){
            //更新窗口
            char c = s.charAt(right);
            right++;//窗口扩大
            // window.put(c,window.getOrDefault(c,0)+1);其实并不需要将s中所有的都加入windows map，只需要将need中的加入即可
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c))){
                    count++;
                }
            }
            //shrink左边界，找符合条件的最优解
            while(count == need.size()){
                if(right - left < len){//不断“打擂”找满足条件的len最短值,并记录最短的子串的起始位序start
                    len = right - left;
                    start = left;
                }
                //更新窗口——这段代码逻辑几乎完全同上面的更新窗口
                char d = s.charAt(left);
                left++;//窗口缩小
                if(need.containsKey(d)){
                    //window.put(d,window.get(d)-1);——bug：若一进去就将window对应的键值缩小，就永远不会满足下面的if，while也会一直执行，知道left越界，因此，尽管和上面对窗口的处理几乎一样，但是这个处理的顺序还是很关键的！要细心！
                    if(need.get(d).equals(window.get(d))){
                        count--;
                    }
                    window.put(d,window.get(d)-1);

                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
