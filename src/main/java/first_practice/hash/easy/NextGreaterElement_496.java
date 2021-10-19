package first_practice.hash.easy;

/**
 * 给你两个没有重复元素的数组 nums1 和 nums2，其中nums1是nums2的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
 *
 *  
 *
 * 示例 1:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 * 示例 2:
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *  
 *
 * 提示：
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *  
 *
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/10/17 17:45
 */
public class NextGreaterElement_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int x= 0;
        for (int i=0; i<nums1.length;i++){
            // 找到等于nums[i] 的 nums2[j]
            for (int j=0; j<nums2.length; j++){
                if (nums1[i] == nums2[j]){
                    x = j;
                    break;
                }
            }
            for (int j=x; j<nums2.length; j++){
                result[i] = -1;
                if (nums2[j]>nums1[i]){
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了9.59%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了35.66%的用户
     */



    /** 时间复杂度O(n*m) */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums2.length; i++){
            map.put(nums2[i], i);
        }
        for (int j=0; j<nums1.length; j++){
            Integer post = map.get(nums1[j]);
            for (int i=post; i<nums2.length; i++){
                result[j] = -1;
                if (nums2[i]>nums1[j]){
                    result[j] = nums2[i];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了98.98%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了84.73%的用户
     */


    /**
     * 先对 nums2 中的每一个元素，求出它的右边第一个更大的元素；
     * 时间复杂度O(n+m)
     */
    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 先处理 nums2，把对应关系存入哈希表
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }

        // 遍历 nums1 得到结果集
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了46.78%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了8.94%的用户
     */



}
