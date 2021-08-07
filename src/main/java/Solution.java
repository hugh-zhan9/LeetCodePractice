public class Solution {

    /** 我写的解，时间复杂度O(n), 空间复杂度O(1)
     * 本意是想写对撞指针的，结果写成了这样
     */
    public int removeElement(int[] nums, int val) {
        int rigth = nums.length;
        if(nums.length == 0){
            return 0;
        }
        for(int left = 0;left<rigth;left++){
            if(nums[left] == val){
                for(rigth=nums.length-1;rigth>left;rigth--){
                    if(nums[rigth] != val){
                        int temp = nums[left];
                        nums[left] = nums[rigth];
                        nums[rigth] = temp;
                        break;
                    }
                }
            }
        }
        return rigth;
    }
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.2 MB, 在所有 Java 提交中击败了7.47%的用户
     */

    /**
     * 看了题解，再看我写的.... 简直是 屎，以下是题解：
     */

    /**
     * 快慢指针，时间复杂度O(n)，空间复杂度O(1)
     */
    public int removeElement1(int[] nums, int val){
        int slow =0;
        for (int fast=0; fast<nums.length; fast++){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.8 MB, 在所有 Java 提交中击败了80.04%的用户
     */

    /* 要习惯使用while循环呀 */
    /**
     * 对撞指针，时间复杂度<O(n)，空间复杂度O(1)
     */
    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37 MB, 在所有 Java 提交中击败了38.89%的用户
     */

    public int removeElement3(int[] nums, int val){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
             if (nums[left] == val){
                nums[left] = nums[right];
                right --;
            }else {
                left++;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = new int[] {3,2,2,3};
        int ints = solution.removeElement3(test,3);
        for (int a: test){
            System.out.println(a);
        }
        System.out.println(ints);
    }
}