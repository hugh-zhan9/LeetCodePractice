package study_plan.entry.thirteen_day;

/**
 * 给你一个整数 n，请你判断该整数是否是2的幂次方。如果是，返回 true；否则，返回 false。
 * 如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
 *
 *
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：2^0 = 1
 *
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：2^4 = 16
 *
 * 示例 3：
 * 输入：n = 3
 * 输出：false
 *
 * 示例 4：
 * 输入：n = 4
 * 输出：true
 *
 * 示例 5：
 * 输入：n = 5
 * 输出：false
 *  
 *
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 *  
 *
 * 进阶：你能够不使用循环/递归解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/11/8 9:38
 */
public class IsPowerOfTwo_231_not_do {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
