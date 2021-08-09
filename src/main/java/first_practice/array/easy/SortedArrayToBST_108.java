package first_practice.array.easy;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 *  
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * @author zyk
 * @description 虽然是一道简单题，但没写出来，还是需要更多的锻炼啊
 * @since 2021/8/9 6:29
 */
public class SortedArrayToBST_108 {

    /** Definition for a binary tree node. */
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

    /**
     * 二分查找中间节点，作为root节点，左右子区间作为左右节点
     * 时间复杂度O(n)，空间复杂度O(logn)
     * 空间复杂度不考虑返回值，因此空间复杂度主要取决于递归栈的深度，递归栈的深度是 O(logn)。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return queryLR(0,nums.length-1,nums);
    }

    public TreeNode queryLR(int left,int right,int[] nums){
        if (right < left){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = queryLR(left,mid-1,nums);
        treeNode.right = queryLR(mid+1,right,nums);
        return treeNode;
    }


    public static void main(String[] args) {
        SortedArrayToBST_108 solution = new SortedArrayToBST_108();
        int[] test = new int[] {-10,-3,0,5,9};
        TreeNode ints = solution.sortedArrayToBST(test);
        System.out.println(ints);
    }
}

