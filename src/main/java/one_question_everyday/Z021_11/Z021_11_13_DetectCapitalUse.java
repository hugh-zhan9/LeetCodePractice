package one_question_everyday.Z021_11;

/**
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 全部字母都是大写，比如 "USA"。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 给你一个字符串 word 。如果大写用法正确，返回 true；否则，返回 false。
 *  
 *
 * 示例 1：
 * 输入：word = "USA"
 * 输出：true
 *
 * 示例 2：
 * 输入：word = "FlaG"
 * 输出：false
 *  
 *
 * 提示：
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/11/13 20:48
 */
public class Z021_11_13_DetectCapitalUse {

    public boolean detectCapitalUse(String word) {
        // 只有一个字母都正确
        if (word.length() == 1) return true;
        // 全部大写或全部小写正确
        if (word.equals(word.toUpperCase()) || word.equals(word.toLowerCase())) return true;
        String firstWord = word.substring(0,1);
        String substring = word.substring(1);
        // 只有首字母大写，正确
        if (firstWord.equals(firstWord.toUpperCase()) && substring.equals(substring.toLowerCase())) return true;
        return false;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了13.68%的用户
     * 内存消耗：36.8 MB, 在所有 Java 提交中击败了58.06%的用户
     */



    public boolean detectCapitalUse2(String word) {
        // 如果大写字母的数量不等于字母长度且大于1，则不正确
        int count =0, length = word.length(); boolean first = false;
        for (int i=0; i<length; i++){
            char c = word.charAt(i);
            if (c - 'A'>=0 && c-'A'<=26){
                count++;
                if(i==0) first = true;
                // 如果第一个字母是小写，后面出现了大写则为false;
                if (!first) return false;
            }
        }
        if (count != length && count >1) return false;
        return true;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.19%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了97.64%的用户
     */




    /**
     * 题解思路：
     * 根据题目要求，若单词的大写用法正确，则需要满足：
     * 若第 1 个字母为大写，则其他字母必须均为大写或均为小写，即其他字母必须与第 2 个字母的大小写相同；
     * 若第 1 个字母为小写，则其他字母必须均为小写。
     *
     * 根据以上规则，可以整理得到以下更简单的判断规则：
     * 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同；
     * 若第 1 个字母为小写，则需额外判断第 2 个字母是否为小写。
     * */
    public boolean detectCapitalUse3 (String word) {
        // 若第 1 个字母为小写，则需额外判断第 2 个字母是否为小写
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        // 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < word.length(); ++i) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.19%的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了64.76%的用户
     */


    public boolean detectCapitalUse4 (String word) {
        // 如果第二个字母开始， 后面全部为小写，就不用管首字母是否为大写了。
        return word.equals(word.toUpperCase()) || word.substring(1).equals(word.substring(1).toLowerCase());
    }


}
