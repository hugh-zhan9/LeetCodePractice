package one_question_everyday.Z021_10;

/**
 * 给你一个长度为 n 的整数数组，每次操作将会使 n-1 个元素增加 1。返回让数组所有元素相等的最小操作次数。
 *
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * 示例 2：
 * 输入：nums = [1,1,1]
 * 输出：0
 *  
 *
 * 提示：
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 答案保证符合 32-bit 整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * @author zyk
 * @description
 * @since 2021/10/20 6:45
 */
public class Z021_10_20_MinMoves_453_interesting {

    /**
     * 思路：每次找到最大的数，然后让其他几个数+1，直到所有数相等
     * 没有写完，实现过于复杂。。。好像不太对
     */
    public int minMoves(int[] nums) {
        int count = 0;
        int length = nums.length;
        int sum =0;
        while (sum%length == 0 & everyOneEqual(nums)){
            for (int i=0; i<length; i++){
                sum += nums[i];
            }
        }
        return count;
    }


    public boolean everyOneEqual(int[] nums){
        int length = nums.length;
        for (int i=0; i<length-1; i++){
            if (nums[i] != nums[i+1]){
                return false;
            }
        }
        return true;
    }



    /**
     * 每次操作既可以理解为使 n-1 个元素增加 1，也可以理解使 1 个元素减少 1。显然，后者更利于我们的计算。
     * 于是，要计算让数组中所有元素相等的操作数，我们只需要计算将数组中所有元素都减少到数组中元素最小值所需的操作数。
     */


    /**
     * 转换思路，把加换成减
     * 只需要把所有数减小成和最小数一致就可以了，
     */
    public int minMoves2(int[] nums) {
        int min = Integer.MAX_VALUE, res =0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]<min){
                min = nums[i];
            }
        }
        for (int i=0; i<nums.length; i++){
            res += nums[i]-min;
        }
        return res;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了95.75%的用户
     */

    public int minMoves3(int[] nums) {
        // 求最小值的stream写法
        int min = Arrays.stream(nums).min().getAsInt();
        int res =0;
        for (int i=0; i<nums.length; i++){
            res += nums[i]-min;
        }
        return res;
    }

}
