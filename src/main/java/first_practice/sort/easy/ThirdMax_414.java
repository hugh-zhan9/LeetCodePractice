package first_practice.sort.easy;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 *
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 *
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *  
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *  
 *
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/9/8 14:53
 */
public class ThirdMax_414 {


    /** 时间复杂度O(nlogn)，空间复杂度O(n) */
    public int thirdMax(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        Arrays.sort(nums);
        int max=1;
        map.put(1,nums[0]);
        for (int i=1; i<nums.length; i++){
            if (nums[i] == nums[i-1]){
                continue;
            }else {
                max++;
                map.put(max,nums[i]);
            }
        }
        if (max >= 3){
            return map.get(max-2);
        }else {
            return map.get(max);
        }
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了45.32%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了5.19%的用户
     */


    /** 评论区流的做法，感觉也不好，只是简单的调用了api */
    public int thirdMax2(int[] nums) {
        final int[] array = Arrays.stream(nums).distinct()
                .sorted()
                .toArray();
        return array.length >= 3 ?
                array[array.length - 3] : array[array.length - 1];
    }

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了19.48%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了5.19%的用户
     */


    /** 时间复杂度O(n) */
    public int thirdMax3(int[] nums){
        long max = Long.MIN_VALUE;
        long mid = Long.MIN_VALUE;
        long min = Long.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==max || nums[i]==mid || nums[i]==min){
                continue;
            }else if (nums[i]>max){
                min = mid;
                mid = max;
                max = nums[i];
            }else if (nums[i]>mid){
                min = mid;
                mid = nums[i];
            }else if (nums[i]>min){
                min = nums[i];
            }
        }
        if (mid == Long.MIN_VALUE || min == Long.MIN_VALUE ){
            return (int) max;
        }
        return (int) min;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了92.42%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了22.77%的用户
     */

}
