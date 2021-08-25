package first_practice.list.easy;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg)
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg)
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/8/25 9:29
 */

public class ReverseList_206 {

    /** 尝试使用hash法来解决，发现测试例[]过不了。 */
    public ListNode reverseList(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        int post = 0;
        ListNode header = new ListNode();
        header.next = head;
        while (header.next!=null){
            map.put(post,header.next);
            header = header.next;
            post++;
        }
        ListNode position = header;
        for (int i=post-1; i>=0; i--){
            position.next = map.get(i);
            position = position.next;
            position.next= null;
        }
        return header;
    }

    /** 双指针实现 */
    public ListNode reverseList2(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了23.54%的用户
     */

    /** 递归求解 */
    /**
     * 假设链表为：
     * n1 -> ... -> nk -> nk+1 -> ... -> nm -> null
     * 若从节点 `nk+1` 到 `nm` 已经被反转，而我们正处于
     * n1 -> ... -> nk -> nk+1 <- ... <- nm <- null
     * 我们希望`nk+1`的下一个节点指向 `nk`
     * 所以，`nk.next.next = nk`。
     * 需要注意的是 n1 的下一个节点必须指向 null。如果忽略了这一点，链表中可能会产生环。
     */
    public ListNode reverseList3(ListNode head){
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了39.67%的用户
     */


    public static void main(String[] args) {
        ListNode head = new ListNode();
        ReverseList_206 solution = new ReverseList_206();
        solution.reverseList(head);
    }
}
