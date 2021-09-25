package first_practice.string.easy;

/**
 * 给定一个字符串，验证它是否是回文串，
 * 只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。 
 *
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *  
 *
 * 提示：
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/9/25 22:58
 */
public class IsPalindrome_125 {

    public boolean isPalindrome(String s) {
        StringBuffer string = new StringBuffer();
        s = s.toLowerCase();
        for (int i=0; i<s.length(); i++){
            if (('0'<= s.charAt(i) && s.charAt(i) <= '9') || ('a' <= s.charAt(i) && s.charAt(i) <= 'z') ){
                string.append(s.charAt(i));
            }
        }
        int length = string.length();
        int i=0, j=length-1;
        while (i<length/2){
            if (string.charAt(i) != string.charAt(j)){
                return false;
            }
            i++; j--;
        }

        /**
         * 也可直接反转 string 看看是不是和原字符串相等
         * StringBuffer string_rev = string.reverse();
         * if (string.equals(string_rev)){
         *     return true;
         * }
         */
        return true;
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了31.84%的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了98.42%的用户
     */


    /** 空间复杂度 O(1) */
    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        int i=0, j=s.length()-1;
        while (i < j){
            if (!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }else {
                if (s.charAt(i) == s.charAt(j)){
                    i++; j--;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了74.37%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了81.20%的用户
     */


}
