package first_practice.array.easy;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * 进阶：
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *  
 * 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 *  
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zyk
 * @description
 * @since 2021/8/18 13:57
 */
public class MissingNumber_268 {

    /**
     * 顺序排序，对比每个元素，由于排序的时间复杂度时间复杂度是O(nlogn)，
     * 所以该算法的时间复杂度是O(nlogn)，空间复杂度O(1)
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            if (nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了30.88%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了14.61%的用户
     */


    /** 题目进阶：实现线性时间复杂度、仅使用额外常数空间的算法 */
    /** 哈希表可以将时间复杂度降低，但是会升高空间复杂度 */
    public int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums){
            set.add(i);
        }
        for (int i=0; i<nums.length; i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了30.88%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了8.28%的用户
     */

    /** 异或运算, 这题可以联想到前面的一个题目；单一元素——136 */
    public int missingNumber3(int[] nums) {
        int missing = nums.length;
        for (int i=0;i<nums.length; i++){
            missing ^= i^nums[i];
        }
        return missing;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了48.45%的用户
     */

    /** 数学方法，求和相减少的的就是那个数 */
    /** 在线性时间内可以求出数组中所有数的和，并在常数时间内求出前 n+1n+1 个自然数（包括 0）的和，将后者减去前者，就得到了缺失的数字。 */
    /**
     * 时间复杂度：O(n)。求出数组中所有数的和的时间复杂度为 O(n)，高斯求和公式的时间复杂度为 O(1)，因此总的时间复杂度为 O(n)。
     * 空间复杂度：O(1)。算法中只用到了 O(1) 的额外空间，用来存储答案。
     */
    public int missingNumber4(int[] nums) {
        // 首项加末项乘以项数/2，这种算法存在溢出风险
        int expectedSum = nums.length*(nums.length + 1)/2; 
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    /**
    * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    * 内存消耗：39 MB, 在所有 Java 提交中击败了13.61%的用户
    */

    public static void main(String[] args) {
        MissingNumber_268 solution = new MissingNumber_268();
        int[] nums = new int[]{3,0,1};
        System.out.println(solution.missingNumber3(nums));
    }
}
