package first_practice.array.easy;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *  
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * 示例 2：
 *
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * @author zyk
 * @description
 * @since 2021/8/7 13:47
 */

public class RemoveElement_27 {

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


    /** 对比对撞指针的解法，边界条件的要好好思考一下 */
    public int removeElement3(int[] nums, int val){
        int left = 0;
        int right = nums.length-1;
        // 这里的判断条件修改为 <= ，因为right一开始就指向了最后一个元素。如果是 < 的话，left 会少走一步
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
        int[] test = new int[] {3,2,2,3};
        RemoveElement_27 solution = new RemoveElement_27();
            int ints = solution.removeElement2(test,3);
        for (int a: test){
            System.out.println(a);
        }
        System.out.println(ints);
    }
}
