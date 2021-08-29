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
