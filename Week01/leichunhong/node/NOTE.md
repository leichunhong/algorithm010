第一周笔记

# 预习笔记：
指法：看了老师的视频，学了几种指法觉得很帅总结如下：
1. 向右删除 fn+delete很实用
2. 移动到行首到和行末 command+左右箭头
3. 删除整个单词 option+delete
4. idea切打开的文件，这个太棒了 command+e

# 自顶向下编程：
1. 这种方式我们开发中也在注意，每个模块自成体系，像一块块积木一样，自顶向下堆积。
2. 关于字符串的处理收益匪浅，以前我老想自己写循环，不会想到用现成的api，记住字符串反转的写法StringBuffer.reverse.toString()


# api总结：
1. 是否数字和字母：Character.isLetterOrDigit(c)

2. 循环快捷键：s.toCharArray().for

# 习题
1.`数组的市价复杂度
delete O(n)
insert O(n)
lookup O(1)
append O(1)
prepend O(1)

# 注意点
 1. 二分查找必须有序，没有顺序无法使用
 2. 跳表元素始终有序。时间复杂度O(logn) 比如之前查询1024次调表查询为log1024=10
 3. 一维提高效率可以升维，或者空间换时间（缓存）
 4. LRU (least recently used 最近最少使用) 缓存机制
 5. 双层for循环，如果第一层循环完i，第二层不循环自己第i个，第二层for循环j=i+1就是第一层for循环的，冒泡不循环最后的就是j=length-i-1
 
 
 # 懵逼的时候
 1. 有暴力的思路没
 2. 化繁为简，列举法
 3. 找最近重复子问题
 4. 算法只能  if else loop while 
 
 # java搜索api/下载源码
 1. xx java 8 xx代表搜索的内容  8代表具体版本号
 2. java source code
 
 
 





