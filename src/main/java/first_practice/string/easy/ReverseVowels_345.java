package first_practice.string.easy;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "hello"
 * 输出："holle"
 *
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出："leotcede"
 *  
 *
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由 可打印的 ASCII 字符组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/10/6 17:50
 */
public class ReverseVowels_345 {

    public String reverseVowels(String s){
        char[] chars = s.toCharArray();
        int i=0, j=s.length()-1;
        while (i<j){
            if (isVowels(chars[i])){
                if (isVowels(chars[j])){
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    i++; j--;
                }else {
                    j--;
                }
            }else {
                i++;
            }
        }
        return String.valueOf(chars);
    }

    private boolean isVowels(char c){
        return "aeiouAEIOU".indexOf(c) >= 0;
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了80.80%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了47.48%的用户
     */

}
