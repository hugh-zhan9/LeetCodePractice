package first_practice.list.easy;

/**
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。
 * 已知此链表是一个整数数字的二进制表示形式。请你返回该链表所表示数字的 十进制值 。
 *
 * 示例 1：
 * ![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/15/graph-1.png)
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 *
 * 示例 2：
 * 输入：head = [0]
 * 输出：0
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：1
 *
 * 示例 4：
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 *
 * 示例 5：
 * 输入：head = [0,0]
 * 输出：0
 *  
 *
 * 提示：
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/8/28 9:06
 */
public class GetDecimalValue_1290 {

    /** 直接计算 */
    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int size = 0;
        int result = 0;
        while (cur.next != null){
            size++;
            cur = cur.next;
        }
        cur = head;
        for (int i=size; i>=0; i--){
            result = result + (int) (cur.val*Math.pow(2,i));
            cur = cur.next;
        }
        System.out.println(result);
        return result;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了52.94%的用户
     */

    /** 题解中简化的写法 */
    public int getDecimalValue2(ListNode head) {
        ListNode curNode = head;
        int ans = 0;
        while (curNode != null) {
            ans = ans * 2 + curNode.val;
            curNode = curNode.next;
        }
        return ans;
    }

    // [更多题解参考](https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/solution/4chong-fang-fa-zhi-jie-bian-li-di-gui-zhan-arrayli/)
}
