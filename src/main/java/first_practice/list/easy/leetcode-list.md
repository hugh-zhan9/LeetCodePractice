# [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

> 难度：简单

## 描述

将两个升序链表合并为一个新的 升序链表 并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例 1：
![](https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg)

>输入：`l1 = [1,2,4], l2 = [1,3,4]`
>输出：`[1,1,2,3,4,4]`

示例 2：

> 输入：`l1 = [], l2 = []`
> 输出：`[]`

示例 3：

> 输入：`l1 = [], l2 = [0]`
> 输出：`[0]`

提示：

- 两个链表的节点数目范围是 `[0, 50]`
- `-100 <= Node.val <= 100`
- `l1` 和 `l2` 均按 非递减顺序 排列

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 题解

```java
public class MergeTwoLists_21 {

    /** 递归 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 时间复杂度：O(n + m)，其中 n 和 m 分别为两个链表的长度。
     * 因为每次调用递归都会去掉 l1 或者 l2 的头节点（直到至少有一个链表为空），函数 mergeTwoList 至多只会递归调用每个节点一次。
     * 因此，时间复杂度取决于合并后的链表长度，即 O(n+m)。
     *
     * 空间复杂度：O(n + m)，其中 n 和 m 分别为两个链表的长度。
     * 递归调用 mergeTwoLists 函数时需要消耗栈空间，栈空间的大小取决于递归调用的深度。
     * 结束递归调用时 mergeTwoLists 函数最多调用 n+m 次，因此空间复杂度为 O(n+m)。
     */

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了17.00%的用户
     */

    /** 迭代 */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    /**
     * 时间复杂度：O(n + m)，其中 n 和 m 分别为两个链表的长度。
     * 因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中，因此 while 循环的次数不会超过两个链表的长度之和。
     * 所有其他操作的时间复杂度都是常数级别的，因此总的时间复杂度为 O(n+m)。
     *
     * 空间复杂度：O(1)。只需要常数的空间存放若干变量。
     */

}
```

## 总结

对于链表和递归还是不熟悉，需要多练

# 141

给定一个链表，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从0开始）。
如果 pos 是 -1，则在该链表中没有环。
注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
如果链表中存在环，则返回 true 。 否则，返回 false 。

进阶：
你能用 O(1)（即，常量）内存解决此问题吗？

示例 1：
![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。

示例 2：
![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。

示例 3：
![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
 

提示：
链表中节点的数目范围是 [0, 104]
-105 <= Node.val <= 105
pos 为 -1 或者链表中的一个 有效索引 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/linked-list-cycle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。