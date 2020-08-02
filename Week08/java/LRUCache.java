package Week08.java;
import java.util.HashMap;

/**
 * 〈功能简述〉<br>
 * 〈〉146. LRU缓存机制
 *       可以参照Java的HashMap的拉链法
 *
 * @author leichunhong
 * @create 2020-08-02
 * @since 1.0.0
 */
public class LRUCache {

    class Node {
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }


    class DoubleList {
        private Node head, tail;
        private int size;

        public void addFirst(Node node) {
            if (head == null) {
                head = tail = node;
            } else {
                Node n = head;
                n.prev = node;
                node.next = n;
                head = node;
            }
            size++;
        }

        public void remove(Node node) {
            if (head == node && tail == node) {
                head = null;
                tail = null;
            } else if (tail == node) {
                node.prev.next = null;
                tail = node.prev;
            } else if (head == node) {
                node.next.prev = null;
                head = node.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        public Node removeLast() {
            Node node = tail;
            remove(tail);
            return node;
        }

        public int size() {
            return size;
        }
    }


    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LRUCache(int capacity) {

        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();

    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key).val;
        //前插入
        put(key,value);
        return value;
    }

    public void put(int key, int val) {
        //新节点
        Node x = new Node(key, val);
        //节点存在
        if(map.containsKey(key)){
            //删除
            cache.remove(map.get(key));
            //移到最前面
            cache.addFirst(x);
            //更新map数据
            map.put(key,x);

        }else{
            if(cap==cache.size()){
                //删除最后一个元素
                Node last = cache.removeLast();
                //map移除
                map.remove(last.key);

            }
            cache.addFirst(x);
            //更新map数据
            map.put(key,x);

        }

    }

}
