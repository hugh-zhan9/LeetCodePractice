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

import java.util.ArrayList;
import java.util.List;

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
    public ListNode reverseByRecursion (ListNode head){
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
    public ListNode reverseByIteration(ListNode head){
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



    /** 将值复制到数组中后用双指针法， 时间复杂度O(n)，空间复杂度O(n)*/
    public boolean isPalindrome2(ListNode head) {
        List<Integer> array = new ArrayList<>();
        while (head != null){
            array.add(head.val);
            head = head.next;
        }
        int i=0;
        int j=array.size()-1;
        while (i <= j){
            if (!array.get(i).equals(array.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了45.51%的用户
     * 内存消耗：50.8 MB, 在所有 Java 提交中击败了35.58%的用户
     */



    /** 递归实现，完全没有思路。。。 */
    /**
     * 思想：
     * 递归为我们提供了一种优雅的方式来方向遍历节点。
     * function print_values_in_reverse(ListNode head)
     *     if head is NOT null
     *         print_values_in_reverse(head.next)
     *         print head.val
     * 如果使用递归反向迭代节点，同时使用递归函数外的变量向前迭代，就可以判断链表是否为回文。
     *
     * 算法：
     * currentNode 指针是先到尾节点，由于递归的特性再从后往前进行比较。
     * frontPointer 是递归函数外的指针。若 currentNode.val != frontPointer.val 则返回 false。
     * 反之，frontPointer 向前移动并返回 true。
     *
     * 时间复杂度：O(n)，空间复杂度：O(n)，
     * 我们要理解计算机如何运行递归函数，
     * 在一个函数中调用一个函数时，计算机需要在进入被调用函数之前跟踪它在当前函数中的位置（以及任何局部变量的值），通过运行时存放在堆栈中来实现（堆栈帧）。
     * 在堆栈中存放好了数据后就可以进入被调用的函数。
     * 在完成被调用函数之后，他会弹出堆栈顶部元素，以恢复在进行函数调用之前所在的函数。
     * 在进行回文检查之前，递归函数将在堆栈中创建 n 个堆栈帧，计算机会逐个弹出进行处理。
     * 所以在使用递归时空间复杂度要考虑堆栈的使用情况。
     * 这种方法不仅使用了 O(n) 的空间，且比第一种方法更差，因为在许多语言中，堆栈帧的开销很大（如 Python），
     * 并且最大的运行时堆栈深度为 1000（可以增加，但是有可能导致底层解释程序内存出错）。
     * 为每个节点创建堆栈帧极大的限制了算法能够处理的最大链表大小。
     */
    public boolean isPalindrome3(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
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
        System.out.println(solution.isPalindrome2(head));
    }

}
