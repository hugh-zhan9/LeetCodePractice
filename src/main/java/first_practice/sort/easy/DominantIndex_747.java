package first_practice.sort.easy;

/**
 * 给你一个整数数组 nums ，其中总是存在唯一的一个最大整数 。
 * 请你找出数组中的最大元素并检查它是否至少是数组中每个其他数字的两倍。如果是，则返回最大元素的下标，否则返回 -1 。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 * 解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 *  
 *
 * 提示：
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * nums 中的最大元素是唯一的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * @author zyk
 * @description
 * @since 2021/9/13 14:49
 */
public class DominantIndex_747 {


    /** 排序暴力解 */
    public int dominantIndex(int[] nums) {
        if (nums.length<2){
            return 0;
        }
        int[] clone = nums.clone();
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        if (max >= 2*nums[nums.length-2]){
            for (int i=0; i<clone.length; i++){
                if (max == clone[i]){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了10.43%的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了18.25%的用户
     */

    
    public int dominantIndex2(int[] nums) {
        if (nums.length<2){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int postMax = Integer.MIN_VALUE;
        int less = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            if (nums[i] > max){
                less = max;
                max = nums[i];
                postMax = i;
            }else if (nums[i] > less){
                less = nums[i];
            }
        }
        return max >= 2*less ? postMax:-1;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了62.27%的用户
     */


}

