package first_practice.array.easy;

/**
 * 给你一个单词序列，判断其是否形成了一个有效的单词方块。
 * 有效的单词方块是指此由单词序列组成的文字方块的 第k行和第k列 (0≤k<max(行数,列数)) 所显示的字符串完全相同。
 *
 * 注意：
 * 给定的单词数大于等于 1 且不超过 500。
 * 单词长度大于等于 1 且不超过 500。
 * 每个单词只包含小写英文字母 a-z。
 *  
 *
 * 示例 1：
 * 输入：
 * [
 *   "abcd",
 *   "bnrt",
 *   "crmy",
 *   "dtye"
 * ]
 *
 * 输出：
 * true
 *
 * 解释：
 * 第 1 行和第 1 列都是 "abcd"。
 * 第 2 行和第 2 列都是 "bnrt"。
 * 第 3 行和第 3 列都是 "crmy"。
 * 第 4 行和第 4 列都是 "dtye"。
 *
 * 因此，这是一个有效的单词方块。
 *  
 *
 * 示例 2：
 * 输入：
 * [
 *   "abcd",
 *   "bnrt",
 *   "crm",
 *   "dt"
 * ]
 *
 * 输出：
 * true
 *
 * 解释：
 * 第 1 行和第 1 列都是 "abcd"。
 * 第 2 行和第 2 列都是 "bnrt"。
 * 第 3 行和第 3 列都是 "crm"。
 * 第 4 行和第 4 列都是 "dt"。
 *
 * 因此，这是一个有效的单词方块。
 *  
 *
 * 示例 3：
 * 输入：
 * [
 *   "ball",
 *   "area",
 *   "read",
 *   "lady"
 * ]
 *
 * 输出：
 * false
 *
 * 解释：
 * 第 3 行是 "read" ，然而第 3 列是 "lead"。
 * 因此，这 不是 一个有效的单词方块。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-word-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/8/21 11:09
 */
public class ValidWordSquare_422 {
    public boolean validWordSquare(List<String> words) {
        if (words == null) {
            return false;
        }
        //column String
        Map<Integer, String> map = new HashMap<>();
        int maxLength = 0;
        for (String s : words) {
            maxLength = Math.max(maxLength, s.length());
        }
        for (int i = 0; i < maxLength; i++) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (word.length() < i + 1) {
                    break;
                }
                sb.append(word.charAt(i));
            }
            map.put(i, sb.toString());
        }
        for (int i = 0; i < words.size(); i++) {
            if (!map.get(i).equals(words.get(i))) {
                return false;
            }
        }
        return true;
    }


    public boolean validWordSquare2(List<String> words) {
        int rows = words.size();
        for (int i = 0; i < rows; i++) {
            String word = words.get(i);
            int cols = word.length();

            // 列数大于行数，直接返回错误
            if (cols > rows) return false;

            for (int j = 0; j < cols; j++) {
                String temp = words.get(j);
                // 比对第i行第j列的字符 是否等于 第j行第i列的字符
                // 获取第j行第i列字符前需判断i是否合法
                // 如果字符不相等则返回错误
                if (i >= temp.length() || word.charAt(j) != temp.charAt(i))
                    return false;
            }
        }
        return true;
    }

    public boolean validWordSquare3(List<String> words) {
        int n = words.size();
        for(int i=0;i<n;i++){
            int len = words.get(i).length();
            if(len>n){
                return false;
            }
            for(int j=0;j<len;j++){
                if(i>=words.get(j).length()){
                    return false;
                }
                if(words.get(i).charAt(j)!=words.get(j).charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
