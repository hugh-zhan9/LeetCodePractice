package first_practice.array.easy;


/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 *
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 *
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 *  
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *  
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/6/4 16:52
 */
public class MaximumSubarray {

    /**
     * 暴力解法：时间复杂度 O(n²)，空间复杂度 O(1)
     * @param nums
     * @return
     */
    public int maxSubArray_Violence(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        for (int right = 0; right < len; right++) {
            int sum = 0;
            for (int left = right; left < len; left++) {
                sum += nums[left];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    /*其实这道题是一个非常经典的动态规划问题。该问题最早于 1977 年提出，但是直到 1984 年才被 Jay Kadane 发现了线性时间的最优解法。*/

    /*假设sum<=0，那么后面的子序列肯定不包含目前的子序列，所以令sum = num；如果sum > 0对于后面的子序列是有好处的。res = Math.max(res, sum)保证可以找到最大的子序和。*/

    /**
     * 动态规划解法：时间复杂度 O(n)，空间复杂度 O(1)
     * @param nums
     * @return
     */
    public int maxSubArray_DynamicProgramming(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        int sum = max;
        for(int i=1; i<length; i++){
            if(sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    /*
    该算法更为简便之处是忽略了对子序列的寻找比较,而是根据规律直接找出最佳答案.
    对于含有正数的序列而言,最大子序列肯定是正数,所以头尾肯定都是正数.我们可以从第一个正数开始算起,每往后加一个数便更新一次和的最大值;
    当当前和成为负数时,则表明此前序列无法为后面提供最大子序列和,因此必须重新确定序列首项.
    */


    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maximumSubarray.maxSubArray_DynamicProgramming(nums);
        System.out.println(result);
    }
}

/**参考：https://blog.csdn.net/lw_power/article/details/104062895*/
