package one_question_everyday.Z021_10;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 */

/**
 * @author zyk
 * @description
 * @since 2021/10/7 8:42
 */
public class CountSegments_2021_10_07 {

    public int countSegments(String s) {
        int result = 0;
        for (int i=0; i<s.length(); i++){
            if ((i==0 || s.charAt(i-1)==' ') && s.charAt(i) != ' '){
                result++;
            }
        }
        return result;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了94.63%的用户
     */



    public int countSegments2(String s) {
        String[] s1 = s.split(" ");
        int result = s1.length;
        for (String string : s1){
            if ("".equals(string)){
                result--;
            }
        }
        return result;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了60.79%的用户
     */



}
