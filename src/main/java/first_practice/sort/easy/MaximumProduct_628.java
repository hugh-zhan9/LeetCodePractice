package first_practice.sort.easy;

/**
 * 给你一个整型数组 nums，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：6
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：24
 *
 * 示例 3：
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 *  
 *
 * 提示：
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * @author zyk
 * @description
 * @since 2021/9/11 22:13
 */
public class MaximumProduct_628 {

    /** 第一次直接写了，没考虑负负得正的情况 */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length-1],nums[nums.length-3] * nums[nums.length-2] * nums[nums.length-1]);
    }

    /**
     * 执行用时：11 ms, 在所有 Java 提交中击败了64.03%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了94.78%的用户
     */

    public int maximumProduct2(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            if (nums[i] > max3){
                max1 = max2;
                max2 = max3;
                max3 = nums[i];
            }else if (nums[i] > max2){
                max1 = max2;
                max2 = nums[i];
            }else if (nums[i] > max1){
                max1 = nums[i];
            }else if (nums[i]<min1){    // 这里不能写else if，否则min的值得不到重写
                min2 = min1;
                min1 = nums[i];
            }else if (nums[i]<min2){
                min2 = nums[i];
            }
        }
        return Math.max(max1*max2*max3, max3*min1*min2);
    }

    /** maximumProduct3在执行测试例[-1,-2,-3]时会存在 Integer.MAX_VALUE * Integer.MAX_VALUE = 1 的问题*/
    public static void main(String[] args) {
        // int result = Integer.MAX_VALUE * Integer.MAX_VALUE; // 1
        int result = Integer.MIN_VALUE * Integer.MIN_VALUE; // 0
        System.out.println(result);
    }

    public int maximumProduct3(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.57%的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了77.26%的用户
     */

}
