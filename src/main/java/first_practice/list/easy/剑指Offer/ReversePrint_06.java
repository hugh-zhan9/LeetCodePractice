package first_practice.list.easy.剑指Offer;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Stack;

/**
 * @author zyk
 * @description
 * @since 2021/8/30 6:42
 */
public class ReversePrint_06 {

    /** 暴力解 */

    /** 翻转链表 */
    public int[] reversePrint_06(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        int size = 0;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            size++;
        }
        int[] result = new int[size];

        for (int i=0; i<size; i++){
            result[i] = prev.val;
            prev = prev.next;
        }
        return result;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了59.69%的用户
     */

    


    /** 使用栈的先进后出特性，时间复杂度O(n)，空间复杂度O(n)
     * 栈的特点是后进先出，即最后压入栈的元素最先弹出。
     * 考虑到栈的这一特点，使用栈将链表元素顺序倒置。
     * 从链表的头节点开始，依次将每个节点压入栈内，然后依次弹出栈内的元素并存储到数组中。
     *
     * 创建一个栈，用于存储链表的节点
     * 创建一个指针，初始时指向链表的头节点
     * 当指针指向的元素非空时，重复下列操作：
     *   将指针指向的节点压入栈内
     *   将指针移到当前节点的下一个节点
     * 获得栈的大小 size，创建一个数组 print，其大小为 size
     * 创建下标并初始化 index = 0
     * 重复 size 次下列操作：
     *   从栈内弹出一个节点，将该节点的值存到 print[index]
     *   将 index 的值加 1
     * 返回 print
     */
     public int[] reversePrint2(ListNode head) {
         Stack<ListNode> stack = new Stack<ListNode>();
         ListNode temp = head;
         while (temp != null) {
             stack.push(temp);
             temp = temp.next;
         }
         int size = stack.size();
         int[] print = new int[size];
         for (int i = 0; i < size; i++) {
             print[i] = stack.pop().val;
         }
         return print;
     }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了73.74%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了31.91%的用户
     */

    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        ReversePrint_06 solution = new ReversePrint_06();
        solution.reversePrint_06(head);
    }

}
