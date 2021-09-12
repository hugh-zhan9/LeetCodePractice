package first_practice.sort.easy;

/**
 * 集合 s 包含从 1 到 n 的整数。
 * 不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合丢失了一个数字并且有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 *
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *  
 *
 * 提示：
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/9/12 9:10
 */
public class FindErrorMums_645 {

    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] temp = new int[nums.length+1];
        for(int num : nums) {
            temp[num]++;
        }

        for(int i = 1; i < temp.length; i++){
            if(temp[i] == 1) {
                continue;
            }
            if(temp[i] == 2) {
                result[0] = i;
            } else {
                result[1] = i;
            }
        }
        return result;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了10.23%的用户
     */


    /** 一种原地算法的思路，时间 O(n)，空间 O(1) */
    public int[] findErrorNums2(int[] nums) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // 不在正确的位置上
            while (nums[i] != i+1) {
                // 找到 nums[i] 应该出现的位置：idx = nums[i] - 1
                // 如果该位置上的数是正确的，那么 nums[i] 就是重复的数
                int idx = nums[i] - 1;
                if (nums[idx] == nums[i]) {
                    res[0] = nums[idx];
                    break;
                }
                swap(nums, i, idx);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                res[1] = i+1;
                break;
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了84.62%的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了81.71%的用户
     */



    /** 题解：
     * 这道题做不出来的，肯定是上学的时候数学老师长得不够漂亮！
     *
     * 纯数学解题：
     * sum(nums) - sum(set(nums)) = 重复的数字
     * (1 + len(nums)) * len(nums) // 2 - sum(set(nums)) = 丢失的数字
     *
     * 循环数组解题：
     * 如何一次for循环获取到重复的数字和丢失的数字呢？
     *
     * 我们需要对数组进行排序
     * 重复的数字就是nums[i + 1] == nums[i]
     * 丢失的数字呢需要分情况考虑
     * 当nums[0] ！= 1，丢失的数字是1
     * 当nums[-1] != len(nums),丢失的数字是len(nums)
     * 排除上面两种场景，那么当nums[i + 1] - nums[i] = 2时， 丢失的数字为nums[i] + 1
     *
     * 哈希表操作解题：
     * 使用Counter将nums转化为一个字典dict
     * 然后for循环1 -- n
     * 没有在dict中找到的数字为丢失的
     * 找到的数字value为2的便是重复的
     *
     * 数学解题
     * class Solution:
     *     def findErrorNums(self, nums):
     *         ln, total = len(nums), sum(set(nums))
     *         return [sum(nums) - total, (1 + ln) * ln // 2 - total]
     *
     * 循环数组解题
     * class Solution:
     *     def findErrorNums(self, nums):
     *         ln = len(nums)
     *         repeat = lose = -1
     *         nums.sort()
     *         if nums[0] != 1:
     *             lose = 1
     *         elif nums[-1] != ln:
     *             lose = ln
     *         for i in range(1, ln):
     *             if nums[i] == nums[i - 1]:
     *                 repeat = nums[i]
     *             if nums[i] - nums[i - 1] == 2:
     *                 lose = nums[i] - 1
     *         return [repeat, lose]
     *
     * 哈希表解题
     * from collections import Counter
     *
     * class Solution:
     *     def findErrorNums(self, nums):
     *         ln = len(nums)
     *         dic = Counter(nums)
     *         repeat = lose = -1
     *         for i in range(1, ln + 1):
     *             tmp = dic.get(i, 0)
     *             if tmp == 0:
     *                 lose = i
     *             elif tmp == 2:
     *                 repeat = i
     *         return [repeat, lose]
     *
     * 欢迎关注我的公众号: **清风Python**，带你每日学习Python算法刷题的同时，了解更多python小知识。
     * 有喜欢力扣刷题的小伙伴可以加我微信（King_Uranus）互相鼓励，共同进步，一起玩转超级码力！
     *
     * 我的个人博客：https://qingfengpython.cn
     * 力扣解题合集：https://github.com/BreezePython/AlgorithmMarkdown
     */

    /** 排序 */
    public int[] findErrorNums3(int[] nums) {
        int[] errorNums = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (curr == prev) {
                errorNums[0] = prev;
            } else if (curr - prev > 1) {
                errorNums[1] = prev + 1;
            }
            prev = curr;
        }
        if (nums[n - 1] != n) {
            errorNums[1] = n;
        }
        return errorNums;
    }

    /**
     * 执行用时：10 ms, 在所有 Java 提交中击败了44.35%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了99.69%的用户
     */

    /** 哈希表 */
    public int[] findErrorNums4(int[] nums) {
        int[] errorNums = new int[2];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                errorNums[0] = i;
            } else if (count == 0) {
                errorNums[1] = i;
            }
        }
        return errorNums;
    }


    /** 位运算 */
    public int[] findErrorNums5(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int lowbit = xor & (-xor);
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lowbit) == 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        for (int num : nums) {
            if (num == num1) {
                return new int[]{num1, num2};
            }
        }
        return new int[]{num2, num1};
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了84.62%的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了63.30%的用户
     */

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               