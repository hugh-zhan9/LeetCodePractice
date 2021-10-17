package one_question_everyday.Z021_10;

/**
 * 给定一个二叉搜索树的根节点root ，和一个整数k，请你设计一个算法查找其中第k个最小元素（从 1 开始计数）。
 *
 *  
 *
 * 示例 1：
 * ![](https://assets.leetcode.com/uploads/2021/01/28/kthtree1.jpg)
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * 示例 2：
 * ![](https://assets.leetcode.com/uploads/2021/01/28/kthtree2.jpg)
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *  
 *
 *  
 *
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *  
 *
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zyk
 * @description
 * @since 2021/10/17 17:30
 */
public class Z021_10_17_KthSmallest_230_not_do {

    /** 中序遍历
     *
     * 二叉树的中序遍历即按照访问左子树——根结点——右子树的方式遍历二叉树；
     * 在访问其左子树和右子树时，我们也按照同样的方式遍历；直到遍历完整棵树。
     */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }