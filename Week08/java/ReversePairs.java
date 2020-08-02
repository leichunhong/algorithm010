package Week08.java;

/**
 * 〈功能简述〉<br>
 * 〈〉493. 翻转对
 * 只是打了一遍，还需要理解
 *
 * @author leichunhong
 * @create 2020-08-01
 * @since 1.0.0
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);

    }

    private int mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return 0;
        }
        int mid = (left + right) >> 1;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int[] cache = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int temp = left;
        while (j <= right) {

            while (temp <= mid && nums[temp] <= 2 * (long) nums[j]) {
                temp++;
            }
            while (i <= mid && nums[i] < nums[j]) {
                cache[k++] = nums[i++];
            }
            cache[k++] = nums[j++];
            count += mid - temp + 1;

        }
        while (i <= mid) {

            cache[k++] = nums[i++];
        }
        System.arraycopy(cache, 0, nums, left, right - left + 1);
        return count;


    }

}
