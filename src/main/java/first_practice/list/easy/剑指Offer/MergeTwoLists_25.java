package first_practice.list.easy.剑指Offer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 限制：
 * 0 <= 链表长度 <= 1000
 *
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/9/1 11:05
 */
public class MergeTwoLists_25 {

    /** 迭代 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(-1);
        ListNode curr = header;
        while (l1 != null && l2 != null){
            if (l1.val<l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1==null ? l2 : l1;
        return header.next;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了35.02%的用户
     */

    /** 递归 */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if (l2 == null){
            return l1;
        }else if (l1 == null){
            return l2;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了66.71%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了44.14%的用户
     */

}
