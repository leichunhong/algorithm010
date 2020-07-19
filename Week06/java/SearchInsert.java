package Week06.java;

/**
 * 〈功能简述〉<br>
 * 〈〉35. 搜索插入位置
 *        软的 不说啦！
 *
 * @author leichunhong
 * @create 2020-07-17
 * @since 1.0.0
 */
public class SearchInsert {
    /**
     * @param
     * @return int
     * @auther leichunhong
     * @desc
     * @date 2020-07-17 12:01
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target > nums[nums.length - 1]) {
                return i;
            }
            if (target == nums[i]) {
                return i;
            }
            if (target > nums[i] && target < nums[i + 1]) {
                return i + 1;
            }

        }
        return 0;

    }

    public int searchInsert2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }


    /**
     * @param
     * @return int
     * @auther leichunhong
     * @desc 二分法
     * @date 2020-07-17 12:07
     */
    public int searchInsert1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;

            } else if (nums[mid] > target) {
                right = mid - 1;

            } else if (nums[mid] < target) {
                left = mid + 1;
            }

        }
        return left;

    }

}
