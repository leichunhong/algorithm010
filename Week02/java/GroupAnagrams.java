package Week02.java;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *    49：字母异位词分组
 *    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 *    1.哈希做法 key是排序一样的字符 value是排序相同的字符放到一个list<String>
 *    2.循环当从map里面有key存在的时候放到list里面 list 就越来越多相同的字符
 *    3.当map没有key的时候往map放key和list的value值
 *
 * @author leichunhong
 * @create 2020-06-16
 * @since 1.0.0
 */
public class GroupAnagrams {
    /**
    * @auther  leichunhong
    * @desc    hash 表存 字符和相同的list集合 HashMap<String, List<String>> 把相等的add到一个list里面
    * @date  2020-06-16 09:17  
    * @param
    * @return  java.util.List<java.util.List<java.lang.String>>
    */
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hash = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (hash.containsKey(key)) {
                //取List<String>
                List<String> stringList = hash.get(key);
                //放strs[i]
                stringList.add(strs[i]);

            } else {
                //初始化List<String>
                List<String> stringList = new ArrayList<>();
                //add
                stringList.add(strs[i]);
                //put哈希
                hash.put(key, stringList);
            }


        }
        return new ArrayList<>(hash.values());


    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String,List<String>> hashMap=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] chars=strs[i].toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars);
            if(hashMap.containsKey(key)){
                List<String> mapValue=hashMap.get(key);
                mapValue.add(strs[i]);
            }else{
                //初始化List<String>
                List<String> stringList = new ArrayList<>();
                //add
                stringList.add(strs[i]);
                hashMap.put(key, stringList);
            }

        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        String[] strs=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
       System.out.println(groupAnagrams1(strs));
    }


    }
