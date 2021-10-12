package one_question_everyday.Z021_10;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
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
 *
 */

import java.util.TreeSet;

/**
 * @author zyk
 * @description
 * @since 2021/10/6 17:02
 */
public class ThirdMax_2021_10_06 {

    public int thirdMax(int[] nums) {
        int length = nums.length;
        long min = Long.MIN_VALUE, mid = Long.MIN_VALUE, max = Long.MIN_VALUE;
        for (int i=0; i<length; i++){
            if (nums[i] == min || nums[i] == mid || nums[i] == max){
                continue;
            }else if (nums[i] > max){
                min = mid;
                mid = max;
                max = nums[i];
            }else if (nums[i] > mid){
                min = mid;
                mid = nums[i];
            }else if (nums[i] > min){
                min = nums[i];
            }
        }
        if (mid == Long.MIN_VALUE || min == Long.MIN_VALUE){
            return (int) max;
        }
        return (int) min;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了91.70%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了50.08%的用户
     */


    /**
     * 遍历数组，同时用一个  有序集合  来维护数组中前三大的数。
     * 具体做法是每遍历一个数，就将其插入有序集合，若有序集合的大小超过 3，就删除集合中的最小元素。
     * 这样可以保证有序集合的大小至多为 3，且遍历结束后，若有序集合的大小为 3，其最小值就是数组中第三大的数；
     * 若有序集合的大小不足 3，那么就返回有序集合中的最大值。
     */
    public int thirdMax2(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() == 3 ? set.first() : set.last();
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了42.14%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了40.53%的用户
     */

}
