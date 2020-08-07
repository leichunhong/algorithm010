package Week09.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-08-06
 * @since 1.0.0
 */
public class Permute {
    /**
    * @auther  leichunhong
    * @desc 复习了一遍全排列
    * @date  2020-08-06 22:36  
    * @param
    * @return  java.util.List<java.util.List<java.lang.Integer>>
    */
    public List<List<Integer>> permute(int[] nums) {
        //返回结果不需要每次传可以提出去
        List<List<Integer>> res=new ArrayList<>();
        //当前这一步已经选择的选项就是已经排列好的数组
        List<Integer> temp=new ArrayList<>();
        dfs(res,temp,nums);
        return res;

    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        //当排列的数组等于nums的长度的时候res.add一遍 返回上一步开始
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return ;
        }
        //循环n个值
        for(int i=0;i<nums.length;i++){
            //已经被选过 排列过，不选了
            if(temp.contains(nums[i])){
                continue;
            }
            //没排列过加到排列数组中来
            temp.add(nums[i]);
            //传到下一层去排列直到排完n个
            dfs( res,  temp,  nums);
            //每一层回来都需要删掉下去的这一个值，意思如果回到跟节点的话temp是空的
            temp.remove(temp.size() - 1);
        }
    }
}
