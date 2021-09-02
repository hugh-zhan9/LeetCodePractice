package first_practice.list.easy.剑指Offer;

/**
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 *
 * 示例 1：
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 *
 * 示例 2：
 * 输入: head = [1,2]
 * 输出: fasle
 *  
 *
 * 提示：
 * 链表 L 的长度范围为 [1, 105]
 * 0 <= node.val <= 9
 *  
 * 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/aMhZSa
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * @author zyk
 * @description
 * @since 2021/9/2 20:06
 */
public class IsPalindrome_27 {

    /** 双指针 */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 翻转转链表的半部分
        slow = reverseList(slow);
        while (slow != null){
            if (slow.val != head.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
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

    /** 这道题的递归写法我还是不太理解 */

}
