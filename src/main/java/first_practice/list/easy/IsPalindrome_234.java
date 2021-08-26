package first_practice.list.easy;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 *  
 *
 * 提示：
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *  
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/8/26 6:50
 */
public class IsPalindrome_234 {

    /** 使用快慢指针找到链表的中点，翻转部分链表，对值逐一对比 */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 快慢指针找寻中点
        while (fast.next !=null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 翻转从slow开始的链表
        slow = reverseByIteration(slow.next);
        // slow = reverseByRecursion(slow.next);
        while(slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    /** 借用206题翻转链表的实现 */
    /** 时间复杂度O(n)，空间复杂度O(n)，空间复杂度主要体现在栈的深度上 */
    public ListNode reverseByRecursion (ListNode head) {
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了63.06%的用户
     * 内存消耗：50.4 MB, 在所有 Java 提交中击败了46.59%的用户
     */

    /** 时间复杂度O(n)，空间复杂度O(1) */
    public ListNode reverseByIteration(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了90.55%的用户
     * 内存消耗：48.5 MB, 在所有 Java 提交中击败了54.15%的用户
     */



    /** 将值复制到数组中后用双指针法 */
    public boolean isPalindrome3(ListNode head) {
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;
        ListNode node1 = new ListNode();
        node1.val = 2; head.next = node1;
        ListNode node2 = new ListNode();
        node2.val = 2; node1.next = node2;
        ListNode node3 = new ListNode();
        node3.val = 1; node2.next = node3;

        IsPalindrome_234 solution = new IsPalindrome_234();
        System.out.println(solution.isPalindrome(head));
    }

}
