import first_practice.array.easy.SortedArrayToBST_108;

public class Solution {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = new TreeNode();
        return treeNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = new int[] {1,3,5,6};
        TreeNode ints = solution.sortedArrayToBST(test);
        System.out.println(ints);
    }
}