package first_practice.array.easy;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

/**
 * @author zyk
 * @description
 * @since 2021/8/17 9:18
 */
public class ContainsDuplicate_217 {

    /** 使用hashmap存储，计数。时间复杂度O(n),可见复杂度O(n) */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        for (int i=0; i<nums.length; i++){
            int count = map.containsKey(nums[i])?map.get(nums[i])+1:1;
            if (count>1){
                return true;
            }
            map.put(nums[i],count);
        }
        return false;
    }

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了16.26%的用户
     * 内存消耗：44.3 MB, 在所有 Java 提交中击败了30.53%的用户
     */


    /** 利用HashSet的特性,元素不能重复，可以更简洁，还是不熟悉基本的API */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.add(num) == false) {
                return true;
            }
        }
        return false;
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了84.39%的用户
     * 内存消耗：42.4 MB, 在所有 Java 提交中击败了51.19%的用户
     */


    /** 排序，相邻的元素相等就返回。时间复杂度O(nlogn)，空间复杂度O(logN)*/
    public boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了99.70%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了87.93%的用户
     */


    public static void main(String[] args) {
        ContainsDuplicate_217 solution = new ContainsDuplicate_217();
        int[] nums = new int[]{1,2,3,4,4};
        System.out.println(solution.containsDuplicate(nums));
    }
}
