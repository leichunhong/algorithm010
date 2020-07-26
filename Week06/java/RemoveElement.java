package Week06.java;

/**
 * 〈功能简述〉<br>
 * 〈〉移除重复元素 简单题 随便做做
 *    27. 移除元素
 * @author leichunhong
 * @create 2020-07-19
 * @since 1.0.0
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums==null){
            return 0;
        }
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;

    }
}
