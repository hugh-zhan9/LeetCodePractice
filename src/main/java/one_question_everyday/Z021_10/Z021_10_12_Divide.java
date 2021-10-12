package one_question_everyday.Z021_10;
/**
 * 给定两个整数，被除数dividend和除数divisor。
 * 将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  
 *
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 *
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyk
 * @description
 * @since 2021/10/12 9:04
 */
public class Z021_10_12_Divide {


    /** 减法代替出发，超出时间限制 */
    public int divide(int dividend, int divisor) {
        int preResult = preProcess(dividend,divisor);
        if (preResult != -1){
            return preResult;
        }


        int smallThanZero = 0, result = 0;
        if (dividend<0) smallThanZero++;
        if (divisor<0) smallThanZero++;
        dividend = Math.abs(dividend); divisor = Math.abs(divisor);
        while (dividend - divisor >= 0){
            result++;
            dividend = dividend - divisor;
        }
        if (smallThanZero == 1){
            return 0-result;
        }
        return result;
    }


    public int divide2(int dividend, int divisor) {
        int preResult = preProcess(dividend,divisor);
        if (preResult != -1){
            return preResult;
        }

        int smallThanZero = 0, result = 0;
        if (dividend<0) {
            smallThanZero++;
            dividend = -dividend;  // 这里有个问题，负数转为正数可能会超出范围  eg: -2147483648 Integer.MAX_VALUE=2147483647
        }
        if (divisor<0) {
            smallThanZero++;
            divisor = 0-divisor;
        }
        while (dividend >= divisor){
            result++;
            dividend = dividend - divisor;
        }
        return smallThanZero==1 ? 0-result: result;
    }



    /** 因为转变成正数会出问题，所以转变思路转变成负数 */
    public int divide3(int dividend, int divisor) {
        int preResult = preProcess(dividend,divisor);
        if (preResult != -1){
            return preResult;
        }

        int smallThanZero = 0, result = 0;
        if (dividend>0) {
            smallThanZero++;
            dividend = -dividend;
        }
        if (divisor>0) {
            smallThanZero++;
            divisor = -divisor;
        }
        while (dividend <= divisor){
            result++;
            dividend = dividend - divisor;
        }
        return smallThanZero==1 ? -result: result;
    }

    /**
     * 执行用时：2426 ms, 在所有 Java 提交中击败了5.01%的用户
     * 内存消耗：35.5 MB, 在所有 Java 提交中击败了58.69%的用户
     */



    // 没做出来，[题解地址](https://leetcode-cn.com/problems/divide-two-integers/solution/liang-shu-xiang-chu-by-leetcode-solution-5hic/)


    /**
     * 前言:
     *
     * 对于一般的情况，根据除数和被除数的符号，需要考虑 4 种不同的可能性。因此为了方便编码，可以将被除数或者除数取相反数，使得它们符号相同。
     *
     * 如果将被除数和除数都变为正数，那么可能会导致溢出。例如当被除数为 -2^31时，它的相反数 2^31产生了int溢出。
     * 因此，可以考虑将被除数和除数都变为负数，这样就不会有溢出的问题，在编码时只需要考虑 1 种情况了。
     *
     * 如果将被除数和除数的其中（恰好）一个变为了正数，那么在返回答案之前，我们需要对答案也取相反数。
     */

    /**
     * 思路：
     *
     * 根据「前言」部分的讨论，记被除数为 X，除数为 Y，并且 X 和 Y 都是负数。我们需要找出 X/Y 的结果 Z。Z 一定是正数或 0。
     * 根据除法以及余数的定义，我们可以将其改成乘法的等价形式，即：Z×Y≥X>(Z+1)×Y
     * 因此，可以使用二分查找的方法得到 Z，即找出最大的 Z 使得 Z×Y≥X 成立。
     *
     * 由于不能使用乘法运算符，因此我们需要使用「快速乘」算法得到 Z×Y 的值。
     * 「快速乘」算法与「快速幂」类似，前者通过加法实现乘法，后者通过乘法实现幂运算。
     * 「快速幂」算法可以参考「50. Pow(x, n)」的官方题解，「快速乘」算法只需要在「快速幂」算法的基础上，将乘法运算改成加法运算即可。
     */
    public int divide4(int dividend, int divisor) {
        int preResult = preProcess(dividend,divisor);
        if (preResult != -1){
            return preResult;
        }

        // 一般情况，使用二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            // 注意溢出，并且不能使用除法
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(divisor, mid, dividend);
            if (check) {
                ans = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rev ? -ans : ans;
    }

    /**
     * 在实现「快速乘」时，需要使用加法运算，然而较大的 Z 也会导致加法运算溢出。
     * 例如要判断 A+B 是否小于 C 时（其中A,B,C 均为负数），A+B 可能会产生溢出，因此我们必须将判断改为 A<C−B 是否成立。
     * 由于任意两个负数的差一定在 [-2^31 + 1, 2^31 - 1]范围内，这样就不会产生溢出。
     */
    // 快速乘
    public boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }




    /**  */
    public int divide5(int dividend, int divisor) {
        int preResult = preProcess(dividend,divisor);
        if (preResult != -1){
            return preResult;
        }

        // 一般情况，使用类二分查找，将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        List<Integer> candidates = new ArrayList<Integer>();
        candidates.add(divisor);
        int index = 0;
        // 注意溢出
        while (candidates.get(index) >= dividend - candidates.get(index)) {
            candidates.add(candidates.get(index) + candidates.get(index));
            ++index;
        }
        int ans = 0;
        for (int i = candidates.size() - 1; i >= 0; --i) {
            if (candidates.get(i) >= dividend) {
                ans += 1 << i;
                dividend -= candidates.get(i);
            }
        }

        return rev ? -ans : ans;
    }


    /** 处理 Integer.MIN_VALUE 和 Integer.MAX_VALUE */
    public int preProcess(int dividend, int divisor){
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }
        return -1;
    }



}


