package Week01.leichunhong.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 哈希表+双向链表
 * @author leichunhong
 * @create 2020-06-09
 * @since 1.0.0
 */
public class LRUCache {


        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
            public DLinkedNode() {}
            public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 使用伪头部和伪尾部节点
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }
        /**
        * @auther  leichunhong
        * @desc 拿不到返回-1 拿到了返回值，并且把该值移动到链表的头部
        * @date  2020-06-09 00:30  
        * @param  [key] 
        * @return  int
        */
        public int get(int key) {
            
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 如果 key 存在，先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.value;
        }
        /**
        * @auther  leichunhong
        * @desc 1.如果key不存在，插入，插入之前判断链表是否满了，如果满了删除链表尾的节点，把插入的值放到头部，哈希code和链表值
         *      2.如果key存在直接更新，并把值放到头部（哈希code和链表）
        * @date  2020-06-09 00:32
        * @param  [key, value] 
        * @return  void
        */
        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                // 如果 key 不存在，创建一个新的节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                // 添加进哈希表
                cache.put(key, newNode);
                // 添加至双向链表的头部
                addToHead(newNode);
                ++size;
                if (size > capacity) {
                    // 如果超出容量，删除双向链表的尾部节点
                    DLinkedNode tail = removeTail();
                    // 删除哈希表中对应的项
                    cache.remove(tail.key);
                    --size;
                }
            }
            else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.value = value;
                moveToHead(node);
            }
        }
        /**
        * @auther  leichunhong
        * @desc 把获取的节点放到头部，头部是经常用的
        * @date  2020-06-09 00:28
        * @param 
        * @return  void
        */
        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
        /**
        * @auther  leichunhong
        * @desc 看不懂
        * @date  2020-06-09 00:28  
        * @param  
        * @return  void
        */
        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        /**
        * @auther  leichunhong
        * @desc 向头部移动
        * @date  2020-06-09 00:29  
        * @param  [node] 
        * @return  void
        */
        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }


}
