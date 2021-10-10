package one_question_everyday;

/**
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。
 * 对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。
 * 阶梯的最后一行可能是不完整的。
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 *  
 *
 * 示例 1：
 * ![](https://assets.leetcode.com/uploads/2021/04/09/arrangecoins1-grid.jpg)
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 *
 * 示例 2：
 * ![](https://assets.leetcode.com/uploads/2021/04/09/arrangecoins2-grid.jpg)
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 *  
 *
 * 提示：
 * 1 <= n <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/10/10 19:49
 */
public class ArrangeCoins_2021_10_10 {

    public int arrangeCoins(int n) {
        int i=0;
        while (n>i){
            i++;
            n=n-i;
        }
        return i;
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了43.97%的用户
     * 内存消耗：35.6 MB, 在所有 Java 提交中击败了48.68%的用户
     */


    /** 一元二次方程 (1+..+n) -->  x(1+x) = 2n */
    public int arrangeCoins2(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.7 MB, 在所有 Java 提交中击败了27.84%的用户
     */


    /**
     * 一时间没想到，核心还是那个方程
     *
     * 第 i 行必须有 i 个硬币（最后一行除外），所以，到第 i 行时总共使用的硬币数量为 total=i(i+1)/2，
     * 目标是寻找这么一个 i，使用得 total 小于或等于 n，而且这个 i 的范围我们知道它在 1 到 n 之间。
     * 这就可以使用二分法
     */
    public int arrangeCoins3(int n) {
        int left = 1, right = n;
        while (left < right) {
            // 有个小点需要注意的是
            // mid = (left + right + 1) // 2
            // 先加1再除以2是为了让中间值靠右，因为在后序对右边的值处理是 right = mid - 1
            //
            // 我觉得主要原因在于对左值的处理，这里左值的处理是 left = mid。因为正常的left+mid>>1都是向下取整，如果不加上1，left=mid会死循环
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.5 MB, 在所有 Java 提交中击败了63.74%的用户
     */

}
