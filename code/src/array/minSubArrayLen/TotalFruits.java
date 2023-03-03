package array.minSubArrayLen;

/**
 * 904.水果成篮
 */
public class TotalFruits {
    public static void main(String[] args) {
        int[] fruit = {1,0,1,4,1,4,1,2,3};
        System.out.println(totalFruit(fruit));
    }
    public static int totalFruit(int[] fruits) {
        //连续两个种类的 最大子数组长度
        //双指针
        int type = 0,res = 0;
        int[] cnt = new int[fruits.length];
        for(int left = 0,right = 0;right < fruits.length;right++){
            if(cnt[fruits[right]]==0){
                type++;
                while(type>2){
                    cnt[fruits[left]]--;
                    if(cnt[fruits[left]]==0)    type--;
                    left++;
                }
            }
            //记录种类
            cnt[fruits[right]]++;
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}
