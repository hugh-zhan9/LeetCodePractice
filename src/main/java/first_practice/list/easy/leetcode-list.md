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



# 83. 删除排序链表中的重复元素

## 描述

存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素只出现一次 。
返回同样按升序排列的结果链表。
示例 1：

>![](https://assets.leetcode.com/uploads/2021/01/04/list1.jpg)
>输入：`head = [1,1,2]`
>输出：`[1,2]`

示例 2：

>![](https://assets.leetcode.com/uploads/2021/01/04/list2.jpg)
>输入：`head = [1,1,2,3,3]`
>输出：`[1,2,3]`

提示：

- 链表中节点数目在范围 [0, 300] 内
- -100 <= Node.val <= 100
- 题目数据保证链表已经按升序排列



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 题解

 ```java
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
 
 ```



# 141. 环形链表
> 难度：简单
## 描述
给定一个链表，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从0开始）。
如果 pos 是 -1，则在该链表中没有环。
注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
如果链表中存在环，则返回 true 。 否则，返回 false 。

进阶：
你能用 O(1)（即，常量）内存解决此问题吗？

示例 1：
>![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)
 输入：head = [3,2,0,-4]，pos = 1
 输出：true
 解释：链表中有一个环，其尾部连接到第二个节点。

示例 2：
>![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)
 输入：head = [1,2]，pos = 0
 输出：true
 解释：链表中有一个环，其尾部连接到第一个节点。

示例 3：
>![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)
 输入：head = [1]，pos = -1
 输出：false
 解释：链表中没有环。


提示：
- 链表中节点的数目范围是 [0, 104]
- -105 <= Node.val <= 105
- pos 为 -1 或者链表中的一个 有效索引 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/linked-list-cycle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 题解

https://leetcode-cn.com/problems/linked-list-cycle/solution/yi-wen-gao-ding-chang-jian-de-lian-biao-wen-ti-h-2/


```java
public class HasCycle_141 {

    /** 时间复杂度O(n)，空间复杂度O(n)。写的时候没怎么过脑子，提交好几次都错了，要不是没考虑好边界，要不就是搞混了变量 */
    public boolean hasCycle(ListNode head) {
        int pos = -1;
        Map<ListNode,Integer> hashMap = new HashMap();
        ListNode post = head;
        while (head != null && post.next != null){
            post = post.next;
            if (!hashMap.containsKey(post)){
                hashMap.put(post,pos++);
                pos++;
            }else {
                pos = hashMap.get(post);
                return true;
            }
        }
        return false;
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了7.49%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了72.97%的用户
     */

    /** 想到了快慢指针来解，但是不知道怎么循环 */
    public boolean hasCycle2(ListNode head){
        
        /* 我尝试写的...
        ListNode post = head;
        ListNode fastNode = head;

        while (post != null && post.next != null){
            post = post.next;
            // 怎么做到循环一遍跳出循环呢？
            while (fastNode!=null && fastNode.next != null){
                fastNode = fastNode.next;
                ListNode start = fastNode;
                if (post == fastNode.next){
                    return true;
                }
                if (start == fastNode.next){
                    break;
                }
            }
        }*/

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了44.37%的用户
     */

}
```

## 总结
双指针解法明明知道了思路，却写不出来，还是写的太少了。。

# 160 相交链表

## 描述

给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
图示两个链表在节点 c1 开始相交：
![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png)

题目数据 **保证** 整个链式结构中不存在环。
注意，函数返回结果后，链表必须 保持其原始结构 。

示例 1：
![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_1.png)

>输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
> 输出：Intersected at '8'
> 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
> 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
> 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

示例 2：
![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_2.png)
> 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
> 输出：Intersected at '2'
> 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
> 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
> 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。

示例 3：
![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_3.png)
> 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
> 输出：null
> 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
> 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
> 这两个链表不相交，因此返回 null 。

提示：

- listA 中节点数目为 m
- listB 中节点数目为 n
- 0 <= m, n <= 3 * 104
- 1 <= Node.val <= 105
- 0 <= skipA <= m
- 0 <= skipB <= n
- 如果 listA 和 listB 没有交点，intersectVal 为 0
- 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]

进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 题解

```java
public class GetIntersectionNode_160 {

    /** Hash解法，时间复杂度O(m+n)，空间复杂度O(m) */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了25.50%的用户
     * 内存消耗：42.2 MB, 在所有 Java 提交中击败了11.72%的用户
     */


    /** 题解还有一种双指针的解法。没看题解之前完全想不到 */
    /**
     * 指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
     * 如果 pA 到了末尾，则 pA = headB 继续遍历
     * 如果 pB 到了末尾，则 pB = headA 继续遍历
     * 比较长的链表指针指向较短链表head时，长度差就消除了
     * 如此，只需要将最短链表遍历两次即可找到位置
     * ![](https://pic.leetcode-cn.com/e86e947c8b87ac723b9c858cd3834f9a93bcc6c5e884e41117ab803d205ef662-%E7%9B%B8%E4%BA%A4%E9%93%BE%E8%A1%A8.png)
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        ListNode postA = headA;
        ListNode postB = headB;
        while (postA != postB){
            postA = postA==null?headB:postA.next;
            postB = postB==null?headA:postB.next;
        }
        return postA;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.1 MB, 在所有 Java 提交中击败了68.15%的用户
     */

}

```
# 203. 移除链表元素

>难度：简单

## 描述

给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。

示例 1：

> ![](https://assets.leetcode.com/uploads/2021/03/06/removelinked-list.jpg)
>
> 输入：head = [1,2,6,3,4,5,6], val = 6
> 输出：[1,2,3,4,5]

示例 2：

> 输入：head = [], val = 1
> 输出：[]

示例 3：

> 输入：head = [7,7,7,7], val = 7
> 输出：[]



提示：

- 列表中的节点数目在范围 [0, 104] 内
- 1 <= Node.val <= 50
- 0 <= val <= 50



来源：力扣（LeetCode)
链接：https://leetcode-cn.com/problems/remove-linked-list-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 题解

```java
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

import org.w3c.dom.ls.LSException;

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

```
# 206. 反转链表

> 难度：简单

## 描述

给你单链表的头节点 `head` ，请你反转链表，并返回反转后的链表。

**示例 1：**

![](https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg)

>输入：head = [1,2,3,4,5]
>输出：[5,4,3,2,1]

**示例 2：**

![](https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg)

>输入：head = [1,2]
>输出：[2,1]

**示例 3：**

>输入：head = []
>输出：[]



**提示：**

- 链表中节点的数目范围是 `[0, 5000]`
- `-5000 <= Node.val <= 5000`

 

**进阶：**链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list/
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 题解

```java
public class ReverseList_206 {

    /** 尝试使用hash法来解决，发现测试例[]过不了。 */
    public ListNode reverseList(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        int post = 0;
        ListNode header = new ListNode();
        header.next = head;
        while (header.next!=null){
            map.put(post,header.next);
            header = header.next;
            post++;
        }
        ListNode position = header;
        for (int i=post-1; i>=0; i--){
            position.next = map.get(i);
            position = position.next;
            position.next= null;
        }
        return header;
    }

    /** 双指针实现 */
    public ListNode reverseList2(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了23.54%的用户
     */

    /** 递归求解 */
    /**
     * 假设链表为：
     * n1 -> ... -> nk -> nk+1 -> ... -> nm -> null
     * 若从节点 `nk+1` 到 `nm` 已经被反转，而我们正处于
     * n1 -> ... -> nk -> nk+1 <- ... <- nm <- null
     * 我们希望`nk+1`的下一个节点指向 `nk`
     * 所以，`nk.next.next = nk`。
     * 需要注意的是 n1 的下一个节点必须指向 null。如果忽略了这一点，链表中可能会产生环。
     */
    public ListNode reverseList3(ListNode head){
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了39.67%的用户
     */


    public static void main(String[] args) {
        ListNode head = new ListNode();
        ReverseList_206 solution = new ReverseList_206();
        solution.reverseList(head);
    }
}

```
# 234. 回文链表
> 难度：简单
## 描述
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

示例 1：
![](https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg)
>输入：head = [1,2,2,1]
>输出：true

示例 2：
![](https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg)
>输入：head = [1,2]
>输出：false
 

提示：
- 链表中节点数目在范围[1, 105] 内
- 0 <= Node.val <= 9
 

进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 题解
```java
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

```
# 237 删除节点
> 难度：简单
## 描述
请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
现有一个链表 -- head = [4,5,1,9]，它可以表示为:
![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/01/19
示例 1：
>输入：head = [4,5,1,9], node = 5
>输出：[4,1,9]
>解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

示例 2：
>输入：head = [4,5,1,9], node = 1
>输出：[4,5,9]
>解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 
提示：
- 链表至少包含两个节点。
- 链表中所有节点的值都是唯一的。 
- 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
- 不要从你的函数中返回任何结果。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。