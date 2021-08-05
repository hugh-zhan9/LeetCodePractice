package first_practice.array.easy;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 * 通过次数2,322,977提交次数4,492,044
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/8/5 6:48
 */

public class TwoSum_01 {

    /**
     * 暴力解法，时间复杂度为 O(n²)，空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] t = null;
        for (int a = 0; a<nums.length; a++){
            for(int i = a+1;i<nums.length; i++){
                if (nums[a]+nums[i]==target){
                    t = new int[]{a,i};
                    break;
                }
            }
        }
        return t;
    }

    /**
     * 执行用时：40 ms, 在所有 Java 提交中击败了 35.97% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了 54.20% 的用户
     */


    /**
     * 哈希表解法，时间复杂度为 O(n)，空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target){
        int[] result = null;
        Map<Integer,Integer> targetMap = new HashMap();
        for (int i=0; i<nums.length; i++){
            if (targetMap.containsKey(nums[i])){
                result = new int[]{targetMap.get(nums[i]), i};
            }else {
                targetMap.put(target-nums[i],i);
            }
        }
        return result;
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了 47.86% 的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了 5.54% 的用户
     */

    public static void main(String[] args) {
        TwoSum_01 solution = new TwoSum_01();
        int[] test = new int[] {2,7,11,15};
        int target = 9;
        int[] ints = solution.twoSum1(test, target);
        System.out.println(""+ints[0] + ints[1]);
    }
}
