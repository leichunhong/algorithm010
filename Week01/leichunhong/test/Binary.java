package Week01.leichunhong.test;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-07-01
 * @since 1.0.0
 */
public class Binary {
    /**
    * @auther  leichunhong
    * @desc 普通二分法
    * @date  2020-07-01 14:36  
    * @param  [nums, target] 
    * @return  int
    */
    int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }
    /**
    * @auther  leichunhong
    * @desc 左边界的二分法
    * @date  2020-07-01 14:36  
    * @param  [nums, target] 
    * @return  int
    */
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    /**
    * @auther  leichunhong
    * @desc 右边界的二分法
    * @date  2020-07-02 09:05
    * @param  [nums, target] 
    * @return  int
    */
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }
}
