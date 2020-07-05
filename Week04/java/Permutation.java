package Week04.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉  回朔算法模板
 * 全排列 步骤：1.
 *
 * @author leichunhong
 * @create 2020-06-30
 * @since 1.0.0
 */
public class Permutation {


    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute1(int[] nums) {

        //创建选择序列一版是子序列
        List<Integer> list = new ArrayList<>();
        backTrack(nums, list);
        return ans;

    }

    private void backTrack(int[] nums, List<Integer> list) {
        if (nums.length == list.size()) {
            ans.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //排除
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            backTrack(nums, list);
            //取消
            list.remove(list.size() - 1);
        }
    }


}
