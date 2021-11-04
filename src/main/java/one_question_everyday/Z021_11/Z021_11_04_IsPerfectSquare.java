package one_question_everyday.Z021_11;

/**
 * 给定一个正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回true ，否则返回false 。
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 *
 *  
 *
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 *
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 *  
 *
 * 提示：
 * 1 <= num <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/11/4 16:59
 */
public class Z021_11_04_IsPerfectSquare {


    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // int product = mid * mid;   越界
            int t = num / mid;
            if (t == mid) {
                if (num%mid == 0) return true;
                low = mid + 1;
            } else if (t < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Z021_11_04_IsPerfectSquare test = new Z021_11_04_IsPerfectSquare();
        System.out.println(test.isPerfectSquare(2000105819));
    }

}
