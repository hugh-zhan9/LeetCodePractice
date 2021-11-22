package one_question_everyday.Z021_11;

/**
 * 给你一个整数数组nums，设计算法来打乱一个没有重复元素的数组。
 * 实现 Solution class:
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *  
 *
 * 示例：
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *  
 *
 * 提示：
 * 1 <= nums.length <= 200
 * -106 <= nums[i] <= 106
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 5 * 104 次 reset 和 shuffle
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Random;

/**
 * @author zyk
 * @description
 * @since 2021/11/22 15:40
 */

public class Z021_11_22_Solution {

    private int[] array = null;
    private Random random = new Random();

    public Z021_11_22_Solution(int[] nums) {
        array = nums;
    }

    public int[] reset() {
        return array;
    }

    public int[] shuffle() {
        int[] arrayClone = array.clone();
        for (int i=0; i<arrayClone.length; i++){
            int j = i + random.nextInt(arrayClone.length-i);
            int temp = arrayClone[i];
            arrayClone[i] = arrayClone[j];
            arrayClone[j] = temp;
        }
        return arrayClone;
    }

    /**
     * 执行用时：85 ms, 在所有 Java 提交中击败了55.05%的用户
     * 内存消耗：46.4 MB, 在所有 Java 提交中击败了85.54%的用户
     */


}


/** 题解解法 */
class Solution {
    int[] nums;
    int[] original;

    public Solution(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            int j = i + random.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length);
        return nums;
    }

    /**
     * 执行用时：83 ms, 在所有 Java 提交中击败了72.54%的用户
     * 内存消耗：46.5 MB, 在所有 Java 提交中击败了80.14%的用户
     */
}
