package first_practice.array.easy;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值至多为 k。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zyk
 * @description
 * @since 2021/8/17 10:07
 */
public class ContainsNearbyDuplicate_219 {

    /** 根据217题的思路，使用map存储元素出现的位置。 时间复杂度O(n)，可见复杂度O(n) */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for (int i=0; i<nums.length; i++){
            int point = map.containsKey(nums[i])?map.get(nums[i]):i;
            if (i-point<=k && i!=point){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }

    /**
     * 执行用时：19 ms, 在所有 Java 提交中击败了58.23%的用户
     * 内存消耗：47.3 MB, 在所有 Java 提交中击败了53.53%的用户
     */

    /** 使用Set优化一下试试，看了下运行效果好像HashMap的解法还要强一点... */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            // 维护一个大小只有k的set，牛呀
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    /**
     * 执行用时：19 ms, 在所有 Java 提交中击败了58.23%的用户
     * 内存消耗：53.2 MB, 在所有 Java 提交中击败了8.16%的用户
     */


    /** 题解：https://leetcode-cn.com/problems/contains-duplicate-ii/solution/cun-zai-zhong-fu-yuan-su-ii-by-leetcode/
     *  题解中使用了二叉树，虽然没有通过，但是可以学习以下思路。
     *  也可以使用twoSum中的双指针方式，但是会超时
     */

    public static void main(String[] args) {
        ContainsNearbyDuplicate_219 solution = new ContainsNearbyDuplicate_219();
        int[] nums = new int[]{1,2,3,1,2,3};
        System.out.println(solution.containsNearbyDuplicate2(nums,2));
    }
}
