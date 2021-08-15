package first_practice.array.easy;

/**
 * 给定一个已按照 升序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 *  
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 *
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 *  
 *
 * 提示：
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 递增顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 * 通过次数263,264提交次数449,697
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/8/15 9:49
 */
public class TwoSum_167 {

    /** 暴力解法，时间复杂度为O(n²)，空间复杂度为O(1) */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i=0; i<numbers.length-1; i++){
            for (int j=i+1; j<numbers.length; j++){
                if (numbers[i] + numbers[j] == target){
                    result[0] = i+1;
                    result[1] = j+1;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 执行用时：244 ms, 在所有 Java 提交中击败了6.07%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了54.77%的用户
     */


    /** 使用hashmap来存储数据，以空间换时间 时间复杂度O(n)，空间复杂度O(n) */
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<numbers.length; i++){
            if (map.containsKey(target - numbers[i])){
                result[0] = map.get(target-numbers[i]);
                result[1] = i+1;
            }
            map.put(numbers[i],i+1);
        }
        return result;
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了19.42%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了43.82%的用户
     */

    /** 数组有序，首先就应该要想到对撞指针啊。 */
    /** 对撞指针法，时间复杂度O(n)，空间复杂度O(1)。*/
    /** 不知道为什么别hashmap快这么多，可能hashmap的containsKey方法的时间复杂度比较高，可以探究一下*/
    public int[] twoSum3(int[] numbers, int target){
        int left = 0; int right = numbers.length-1;
        while (left<right){
            if (numbers[left]+numbers[right] == target){
                return new int[]{left+1,right+1};
            }else if (numbers[left]+numbers[right] < target){
                left++;
            }else {
                right--;
            }
        }
        return new int[]{-1,-1};
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了76.45%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了41.35%的用户
     */


    /** 想到对撞指针，就应该要想到二分查找，毕竟二分查找用到了对撞指针 */
    /** 二分查找法，时间复杂度O(nlogn)，空间复杂度O(1)*/
    public int[] twoSum4(int numbers, int target){
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSum_167 solution = new TwoSum_167();
        int[] nums = new int[]{2,3,4};
        int target = 6;
        int[] ints = solution.twoSum3(nums,target);
        for (int a:ints){
            System.out.println(a);
        }
    }
}
