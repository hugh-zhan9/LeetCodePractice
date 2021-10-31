package study_plan.entry.fifth_day;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *  
 *
 * 示例 1：
 * ![](https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg)
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 *
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyk
 * @description
 * @since 2021/10/31 11:57
 */
public class RemoveNthFromEnd_19 {


    /** 解法一： 求链表的长度 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head; int count = 1;
        while (cur.next != null){
            cur = cur.next;
            count++;
        }
        // 对于删除头节点的链表做处理
        if (count==1){
            return new ListNode();
        }
        // 对于有多个节点的链表做处理
        int i=0; cur = head;
        while (i<count-1){
            if (i==count-n){
                ListNode oth = cur.next.next;
                cur.next = oth;
            }
            cur = cur.next;
            i++;
        }
        return head;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了57.31%的用户
     */


    /** 对于删除第一个节点的情况可以使用一个前驱的哑节点来处理 */



    /** 解法二：利用栈先进后出的特性，来处理倒数的问题 */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null){
            stack.push(dummy);
            cur = cur.next;
        }

        for (int i=0; i<n; i++){
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }


    /** 解法三：快慢指针处理 */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode buff = new ListNode(0,head);
        ListNode slow = buff, quick = head;
        // 让快慢指针之间相差n个节点
        for (int i=0; i<n; i++){
            quick = quick.next;
        }
        // 当快指针到达了最后，那么慢指针的下一个节点就是要删除的节点
        while (quick != null){
            slow = slow.next;
            quick = quick.next;
        }
        slow.next = slow.next.next;
        return buff.next;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了72.51%的用户
     */

}
