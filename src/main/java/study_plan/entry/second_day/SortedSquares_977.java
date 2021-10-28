package study_plan.entry.second_day;

/**
 * 给你一个按非递减顺序排序的整数数组nums，
 * 返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *  
 *
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/10/28 13:44
 */
public class SortedSquares_977 {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length-1, index=nums.length-1;
        while (left<=right){
            if (nums[left]*nums[left] > nums[right]*nums[right]){
                result[index--] = nums[left]*nums[left];
                left++;
            }else {
                result[index--] = nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了79.32%的用户
     */




}
