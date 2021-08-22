package first_practice.list.easy;

/**
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从0开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * 示例 1：
 * ![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * ![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * ![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *  
 *
 * 提示：
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/8/22 19:51
 */
public class HasCycle_141 {

    /** 时间复杂度O(n)，空间复杂度O(n)。写的时候没怎么过脑子，提交好几次都错了，要不是没考虑好边界，要不就是搞混了变量 */
    public boolean hasCycle(ListNode head) {
        int pos = -1;
        Map<ListNode,Integer> hashMap = new HashMap();
        ListNode post = head;
        while (head != null && post.next != null){
            post = post.next;
            if (!hashMap.containsKey(post)){
                hashMap.put(post,pos++);
                pos++;
            }else {
                pos = hashMap.get(post);
                return true;
            }
        }
        return false;
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了7.49%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了72.97%的用户
     */

    /** 想到了快慢指针来解，但是不知道怎么循环 */
    public boolean hasCycle2(ListNode head){
        /* 我尝试写的...
        ListNode post = head;
        ListNode fastNode = head;

        while (post != null && post.next != null){
            post = post.next;
            // 怎么做到循环一遍跳出循环呢？
            while (fastNode!=null && fastNode.next != null){
                fastNode = fastNode.next;
                ListNode start = fastNode;
                if (post == fastNode.next){
                    return true;
                }
                if (start == fastNode.next){
                    break;
                }
            }
        }*/

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了44.37%的用户
     */


    /**
     * 知道了思路，却写不出来，还是写的太少了。。
     */

}
