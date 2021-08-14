package first_practice.array.easy;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 通过次数463,279提交次数644,750
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/8/14 10:44
 */
public class SingleNumber_136 {

    /** 有想法使用hash来解决，但是显然空间复杂度没法达标。
     * 看了题解，居然是使用异或特性来解决的思路，
     * 刷题少，完全不知道这种思路。也算是学习了吧
     */
    /** 除了某个元素只出现一次以外，其余每个元素均出现两次。 这是个突破口 —— 异或运算！ */
    /**
     * a^b = b^a
     * a^b^c = a^(b^c) = (a^b)^c;
     * c = a^b  可以推出 a = b^c. （常用于加密）
     * a^a = 0.
     * a^0 = a.
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了65.02%的用户
     */

    public static void main(String[] args) {
        SingleNumber_136 solution = new SingleNumber_136();
        // 4^1^2^1^2 = 4
        int[] nums = new int[]{4,1,2,1,2};
        solution.singleNumber(nums);
    }

    // 题解：https://leetcode-cn.com/problems/single-number/solution/xue-suan-fa-jie-guo-xiang-dui-yu-guo-cheng-bu-na-y/
}
