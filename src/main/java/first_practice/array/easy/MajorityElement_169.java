package first_practice.array.easy;


/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 n/2 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
 *
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 *
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 *
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import algorithm_implementation.Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/8/16 9:16
 */
public class MajorityElement_169 {


    /** 使用Map来进行计数，拿到最大值，时间复杂度O(n)，空间复杂度O(n)*/
    public int majorityElement(int[] nums) {
        int max = 0;
        int result = 0;
        Map<Integer,Integer> resultMap = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int count = 0;
            if (resultMap.containsKey(nums[i])){
                count = resultMap.get(nums[i]);
            }
            count = ++count;
            resultMap.put(nums[i],count);
            if (count>max){
                max = count;
                result = nums[i];
            }
        }
        return result;
    }

    /**
     * 执行用时：16 ms, 在所有 Java 提交中击败了14.77%的用户
     * 内存消耗：43.5 MB, 在所有 Java 提交中击败了86.45%的用户
     */


    /** 根据题意，需要将时间复杂度优化至O(n)、空间复杂度优化至O(1) */
    /** 使用计数排序实现一下，发现如果有负数的话使用之前的实现不方便，而且空间复杂度也不够 */
    /**
     * 找到出现最多的元素，出现次数大于 n/2 的元素，---> 排序之后选择 第n/2个元素。
     * 时间复杂度O(n)的排序算法就是桶排序
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 摩尔投票法：时间复杂度O(N) 空间复杂度O(1)
     * 核心就是对拼消耗。
     * 玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能一对一同归于尽。最后还有人活下来的国家就是胜利。
     * 那就大混战呗，最差所有人都联合起来对付你（对应你每次选择作为计数器的数都是众数），或者其他国家也会相互攻击（会选择其他数作为计数器的数），但是只要你们不要内斗，最后肯定你赢。
     * 最后能剩下的必定是自己人。
     */
    /** 确实是一种精妙的解法，我觉得我暂时还是很难想到 */
    public int majorityElement3(int[] nums) {
        int count = 0;
        int result = nums[0];
        for (int i=0; i<nums.length; i++){
            if (nums[i] == result){
                count++;
            }else {
                count--;
            }

            if (count==0){
                result = nums[i+1];
            }
        }
        return result;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.97%的用户
     * 内存消耗：44 MB, 在所有 Java 提交中击败了65.64%的用户
     */


    /** 分治算法 */
    public int majorityElement4(int[] nums){
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // the only element in an array of size 1 is the majority element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }


    public static void main(String[] args) {
        MajorityElement_169 solution = new MajorityElement_169();
        int[] nums = new int[]{-1,1,1,1,2,1};
        int result = solution.majorityElement3(nums);
        System.out.println(result);
    }
}

