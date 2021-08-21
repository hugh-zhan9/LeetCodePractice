package first_practice.list.easy;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素只出现一次 。
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 * ![](https://assets.leetcode.com/uploads/2021/01/04/list1.jpg)
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * ![](https://assets.leetcode.com/uploads/2021/01/04/list2.jpg)
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *  
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/8/21 10:44
 */
public class DeleteDuplicate_83 {

    /** 遍历一次有序链表，移除重复的元素。时间复杂度O(n)，空间复杂度O(1) */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode current = head;
        while (current.next != null){
            if (current.val == current.next.val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了5.01%的用户
     */

    /** 尝试使用递归解一下 */

}
