package first_practice.list.easy;

/**
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 *
 * 实现 MyHashMap 类：
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 *  
 *
 * 提示：
 * 0 <= key, value <= 106
 * 最多调用 104 次 put、get 和 remove 方法
 *  
 *
 * 进阶：你能否不使用内置的 HashMap 库解决此问题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Iterator;
import java.util.LinkedList;


/**
 * @author zyk
 * @description
 * @since 2021/8/28 8:42
 */
public class MyHashMap_706 {

     private class Node{
        private int key;
        private int value;

        public Node (int key, int value){
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static final int BASE = 769;
    private LinkedList<Node>[] list;

    /** Initialize your data structure here. */
    public MyHashMap_706() {
        list = new LinkedList[BASE];
        for (int i=0; i<BASE; ++i){
            list[i] = new LinkedList<>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Node> iterator = list[h].iterator();
        while (iterator.hasNext()){
            Node node = iterator.next();
            if (key == node.getKey()){
                node.setValue(value);
                return;
            }
        }
        // 将指定元素添加到链表末尾
        list[h].offerLast(new Node(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h  = hash(key);
        Iterator<Node> iterator = list[h].iterator();
        while (iterator.hasNext()){
            Node node = iterator.next();
            if (key == node.getKey()){
                return node.getValue();
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h  = hash(key);
        Iterator<Node> iterator = list[h].iterator();
        while (iterator.hasNext()){
            Node node = iterator.next();
            if (node.getKey() == key){
                list[h].remove(node);
                return;
            }
        }
    }

    private static int hash(int key) {
        return key % BASE;
    }

    /**
     * 执行用时：18 ms, 在所有 Java 提交中击败了79.91%的用户
     * 内存消耗：44.4 MB, 在所有 Java 提交中击败了46.56%的用户
     */

    /**
     * 时间复杂度：O( b/n)。其中 n 为哈希表中的元素数量，b 为链表的数量。假设哈希值是均匀分布的，则每个链表大概长度为 n/b
     * 空间复杂度：O(n+b)。
     *
     * [更多题解参考](https://leetcode-cn.com/problems/design-hashmap/solution/)
     */

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */