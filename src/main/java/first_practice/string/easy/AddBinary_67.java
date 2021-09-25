package first_practice.string.easy;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/9/24 21:48
 */
public class AddBinary_67 {

    public String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length()), carry = 0;
        int minLength = Math.min(a.length(), b.length());
        if (a.length() < b.length()){
            String temp = new String();
            temp = a;
            a = b;
            b =temp;
        }
        StringBuffer result = new StringBuffer();
        for (int i=0; i<maxLength; i++){
            if (i<minLength){
                if ((a.charAt(a.length()-1-i) + b.charAt(b.length()-1-i) - 2*'0' + carry) >= 2){
                    int r = (a.charAt(a.length() - 1 - i) + b.charAt(b.length() - 1 - i) - 2 * '0' + carry)-2;
                    result.append(r);
                    carry = 1;
                }else {
                    result.append((a.charAt(a.length()-1-i) + b.charAt(b.length()-1-i) - 2*'0' + carry));
                    carry = 0;
                }
            }else {
                if ((a.charAt(a.length()-1-i) - '0' + carry) >= 2){
                    int r = (a.charAt(a.length() - 1 - i) - '0' + carry)-2;
                    result.append(r);
                    carry = 1;
                }else {
                    result.append(a.charAt(a.length()-1-i) - '0' + carry);
                    carry = 0;
                }
            }

        }
        if (carry > 0) {
            result.append('1');
        }
        result.reverse();
        return result.toString();
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了34.16%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了16.34%的用户
     */


    /** 上面的思路和这里基本一致，可以把下面的解法看做是优化之后的写法 */
    public String addBinary2(String a, String b) {
        int maxLength = Math.max(a.length(), b.length()), carry = 0;
        StringBuffer result = new StringBuffer();

        for (int i=0; i<maxLength; i++){
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            result.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            result.append('1');
        }
        result.reverse();
        return result.toString();
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了94.00%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了26.81%的用户
     */




}
