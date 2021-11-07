package not_do;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *  
 *
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 *
 * 输入：S = "12345"
 * 输出：["12345"]
 *  
 *
 * 提示：
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyk
 * @description
 * @since 2021/11/7 8:25
 */
public class LetterCasePermutation_784 {

    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        StringBuffer res = new StringBuffer();
        int length = S.length();
        dfs(S, 0, length, res, ans);
        return ans;
    }

    public void dfs(String s, int i, int length, StringBuffer res, List<String> ans){
        if (res.length() == length){
            ans.add(res.toString());
            return;
        }else {
            for (; i<length; i++){
                char chars = s.charAt(i);
                if ((chars-'a' < 26 && chars-'a'>=0) || (chars-'A'<26 && chars-'A'>=0)){
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(res.substring(0));
                    res.append(chars);
                    dfs(s, i+1, length, res, ans);

                    // 转换
                    if (chars-'a' < 26 && chars-'a'>=0){
                        stringBuffer.append(String.valueOf(chars).toUpperCase());
                    }else {
                        stringBuffer.append(String.valueOf(chars).toLowerCase());
                    }
                    dfs(s, i+1, length, stringBuffer, ans);
                }else {
                    res.append(chars);
                    dfs(s,i+1,length,res,ans);
                    if (res.length() == length){
                        break;
                    }else {
                        continue;
                    }
                }
            }
        }
    }

    /**
     * 执行用时：554 ms, 在所有 Java 提交中击败了5.08%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了5.18%的用户
     */


    /** 官方题解：递归 */
    public List<String> letterCasePermutation2(String S) {
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());

        for (char c: S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i)
                    ans.get(i).append(c);
            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb: ans)
            finalans.add(sb.toString());
        return finalans;
    }



    /** 官方题解：二分掩码 */
    public List<String> letterCasePermutation3(String S) {
        int B = 0;
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                B++;

        List<String> ans = new ArrayList();

        for (int bits = 0; bits < 1<<B; bits++) {
            int b = 0;
            StringBuilder word = new StringBuilder();
            for (char letter: S.toCharArray()) {
                if (Character.isLetter(letter)) {
                    if (((bits >> b++) & 1) == 1)
                        word.append(Character.toLowerCase(letter));
                    else
                        word.append(Character.toUpperCase(letter));
                } else {
                    word.append(letter);
                }
            }

            ans.add(word.toString());
        }

        return ans;

    }


}
