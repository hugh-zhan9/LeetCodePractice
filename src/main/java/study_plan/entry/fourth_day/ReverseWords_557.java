package study_plan.entry.fourth_day;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *  
 *
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 *
 * 提示：
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/10/30 21:10
 */
public class ReverseWords_557 {

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        for (int i=0; i<s1.length; i++){
            s1[i] = new StringBuffer(s1[i]).reverse().toString();
        }
        StringBuffer res = new StringBuffer();
        for (String str:s1){
            res.append(str).append(" ");
        }
        return res.toString().trim();
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了68.21%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了98.74%的用户
     */

}
