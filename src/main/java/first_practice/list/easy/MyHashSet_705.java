package first_practice.list.easy;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。实现 MyHashSet 类：
 *  void add(key) 向哈希集合中插入值 key 。
 *  bool contains(key) 返回哈希集合中是否存在这个值 key 。
 *  void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *  
 * 示例：
 *
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 *
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 *  
 *
 * 提示：
 * 0 <= key <= 106
 * 最多调用 104 次 add、remove 和 contains 。
 *  
 *
 * 进阶：你可以不使用内建的哈希集合库解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/8/27 9:38
 */
public class MyHashSet_705 {

    private ListNode head;
    private ListNode current;

    /** 暴力实现，哭了。。。好多边界条件没考虑到 */

    /** Initialize your data structure here. */
    public MyHashSet_705() {
        head = new ListNode();
        head.val = -1;
        current = head;
    }

    public void add(int key) {
        if (contains(key)){
            return;
        }
        ListNode next = new ListNode();
        next.val = key;
        current.next = next;
        current = next;
    }

    public void remove(int key) {
        if (!contains(key)){
            return;
        }
        ListNode point = head;
        while (point != null){
            if (point.next.val == key){
                if (point.next != null){
                    point.next = point.next.next;
                    ListNode start = point;
                    while (start.next != null){
                        start = start.next;
                    }
                    current = start;
                    return;
                }
            }
            point = point.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        ListNode point = head;
        while (point != null){
            if (point.val == key){
                return true;
            }
            point = point.next;
        }
        return false;
    }

    /**
     * 执行用时：220 ms, 在所有 Java 提交中击败了10.24%的用户
     * 内存消耗：45 MB, 在所有 Java 提交中击败了63.48%的用户
     */

    /**
     * 执行用时：16 ms, 在所有 Java 提交中击败了72.14%的用户
     * 内存消耗：44.7 MB, 在所有 Java 提交中击败了81.36%的用户
     */

    // leetcode 测试例
    public static void main(String[] args) {
        MyHashSet_705 myHashSet = new MyHashSet_705();
        myHashSet.add(58);
        myHashSet.contains(0);
        myHashSet.add(14);
        myHashSet.contains(58);
        myHashSet.remove(91);
        myHashSet.add(6);
        myHashSet.contains(58);
        myHashSet.add(66);
        myHashSet.add(51);
        myHashSet.add(16);
        myHashSet.add(40);
        myHashSet.add(52);
        myHashSet.add(48);
        myHashSet.contains(40);
        myHashSet.add(42);
        myHashSet.add(85);
        myHashSet.add(36);
        myHashSet.contains(16);
        myHashSet.remove(0);
        myHashSet.contains(43);
        myHashSet.contains(6);
        myHashSet.add(3);
        myHashSet.remove(25);
        myHashSet.add(99);
        myHashSet.remove(66);
        myHashSet.add(60);
        myHashSet.remove(58);
        myHashSet.add(97);
        myHashSet.contains(3);
        myHashSet.add(35);
        myHashSet.add(65);
        System.out.println(myHashSet.contains(40));
        myHashSet.add(41);myHashSet.add(10);myHashSet.add(37);myHashSet.add(65);myHashSet.remove(37);myHashSet.contains(40);
        myHashSet.add(28);myHashSet.contains(60);myHashSet.add(30);myHashSet.add(63);myHashSet.add(76);myHashSet.remove(90);myHashSet.remove(3);myHashSet.add(43);
        myHashSet.contains(81);myHashSet.add(61);myHashSet.add(39);myHashSet.contains(75);myHashSet.remove(10);myHashSet.add(55);myHashSet.contains(92);myHashSet.add(71);myHashSet.remove(2);myHashSet.remove(20);
        myHashSet.add(7);myHashSet.contains(55);myHashSet.add(88);myHashSet.contains(39);myHashSet.contains(97);myHashSet.add(44);myHashSet.add(1);myHashSet.remove(51);myHashSet.remove(89);
        myHashSet.add(37);myHashSet.remove(19);myHashSet.add(3);myHashSet.add(13);myHashSet.add(11);myHashSet.add(68);myHashSet.add(18);myHashSet.add(17);myHashSet.remove(41);myHashSet.remove(87);
        myHashSet.add(48);myHashSet.remove( 43);myHashSet.add(68);myHashSet.add(80);
        myHashSet.add(35);
        myHashSet.add(2 );
        myHashSet.contains(17);
        myHashSet.add(71);
        myHashSet.remove(90);
        myHashSet.remove(83);
        myHashSet.remove(42);
        myHashSet.remove(88);
        myHashSet.add(16);
        myHashSet.add(37);
        myHashSet.add(33);
        myHashSet.add(66);
        myHashSet.contains(59);
        myHashSet.add(6 );
        myHashSet.add(79);
        myHashSet.add(77);
        myHashSet.add(14);
        myHashSet.add(69);
        myHashSet.add(36);
        myHashSet.add(21);
        myHashSet.add(40);
    }

}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

