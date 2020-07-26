package Week01.leichunhong.test;

import java.util.HashMap;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *  找出数组中只出现一次的数字，其他的都出现了2次
 * @author leichunhong
 * @create 2020-06-15
 * @since 1.0.0
 */

/**
* @auther  leichunhong
* @desc    异或的写法 惊呆了我！只要有相同的两个数异或都是0 0和任何数异或都是其本身
* @date  2020-06-15 20:54
* @param
* @return
*/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;

        }
        return ans;

    }

    /**
    * @auther  leichunhong
    * @desc 理由哈希 就是hashMap  里面key是数组的值，value是本身或者1
     *      循环一遍put到存在的hashmap中，如果put的值存在 就更新为原来的value+1 如果不存在那么value就是0
     *      如果这个不存在的0没有被后面循环的更新掉，再循环一遍当value等于0时 就是该值
    * @date  2020-06-15 20:55  
    * @param
    * @return  int
    */
    public int singleNumber1(int[] nums) {
        
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        //循环数组 放到hashMap里面先去取一遍如果不存在直接放，如果存在更新为+1，再循环一遍发现是1的就是唯一解
        for (int num : nums) {

            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        for(int k:hashMap.keySet()){
            if(hashMap.get(k)==1){
                return k;
            }
        }
        return -1;

        //2.统计所有位数上出现1的次数再对3取余，余数就是剩下的数字 这个也很巧！



    }
}


