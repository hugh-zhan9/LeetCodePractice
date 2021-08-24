package first_practice.list.easy;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回新的头节点 。
 *
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/03/06/removelinked-list.jpg)
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 *
 * 提示：
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/8/24 8:32
 */
public class RemoveElements_203 {

    /** 我的解法，但是测试地时候发现头节点不知道为什么删不掉，原来时leetcode默认的链表没有空val的头节点，猜测测试例的头节点 val!=null */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        ListNode last = head;
        ListNode current = head.next;
        while (last.next != null){
            if (current.val == val){
                last.next = current.next;
            }else {
                last = current;
            }
            current = last.next;
        }
        return head;
    }

    /** 在给定的链表前面接一个节点，妙呀！ */
    /**思路：
     * 此题删除链表中元素是很简单的，只需要让待删节点之前一个节点指向待删节点之后一个节点即可。
     * 此题最大的问题就是，题目要求我们要返回新链表中的头结点，如果我们就采用仅仅复制头结点的方式(用H=head)然后用H进行操作，最后返回head。
     * 这样就会导致如果头结点也是我们需要删除的节点就会导致错误。
     * 当然我们可以采用循环操作判断第一个不是我们要删除的节点，但是这样有些麻烦。
     * 最好的方式就是我们创建一个新节点来作为整个链表的头结点，该节点中的值没有意义，只是用该节点来方便我们的操作。
     * 如果用H->next=head;
     * 此时 我们操作H的话就把原先的头结点当做了一个普通节点来操作，此时原先的头结点就可以被删除了。最后返回H->next就满足条件了。
     * 正是由于有个无意义节点作为头结点会统一操作（把头结点当做普通节点）所以实际链表设计过程中都是有个无意义头结点的，遇到头结点不好解决的问题，可以设一个节点试试。
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while(cur.next != null){
            if(cur.next.val == val ){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
         return header.next;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.47%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了40.55%的用户
     */


    /** 递归求解。时间复杂度：O(n)，空间复杂度：O(n)，空间复杂度主要取决于递归调用栈 */
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.47%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了5.01%的用户
     */


    /** 我的测试例 */
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode node1 = new ListNode();
        node1.val = 7; head.next = node1;
        RemoveElements_203 solution = new RemoveElements_203();
        solution.removeElements(head,7);
    }
}
