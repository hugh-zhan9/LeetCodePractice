package first_practice.sort.easy;

/**
 * 给定一个非负整数数组 A，返回一个数组，
 * 在该数组中，A的所有偶数元素之后跟着所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *  
 *
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * @author zyk
 * @description
 * @since 2021/9/14 15:37
 */
public class SortArrayByParity_905 {

    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int j=0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]%2 == 0){
                result[j] = nums[i];
                j++;
            }
        }
        for (int i=0; i<nums.length; i++){
            if (nums[i]%2 == 1){
                result[j] = nums[i];
                j++;
            }
        }
        return result;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.91%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了70.44%的用户
     */


    public int[] sortArrayByParity2(int[] nums) {
        int[] result = new int[nums.length];
        int x=0,y=nums.length-1;
        for (int i=0; i<nums.length; i++){
            if (nums[i]%2 == 0){
                result[x] = nums[i];
                x++;
            }else {
                result[y] = nums[i];
                y--;
            }
        }
        return result;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.91%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了11.23%的用户
     */


    /** 原地算法实现 */
    public int[] sortArrayByParity3(int[] nums) {
        int i=0, j=nums.length-1;
        while (i != j){
            if (nums[i]%2 == 0){
                i++;
            }else if (nums[j]%2 == 1){
                j--;
            }else {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.91%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了86.28%的用户
     */
}
