package first_practice.hash.easy;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 *
 * 美式键盘中：
 * ![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/keyboard.png)
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 *
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 *
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 *
 * 示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 *  
 *
 * 提示：
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyk
 * @description
 * @since 2021/10/20 20:14
 */
public class FindWords_500 {

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList();
        String first = "qwertyuiopQWERTYUIOP", second ="asdfghjklASDFGHJKL", third = "zxcvbnmZXCVBNM";
        for (String s:words){
            boolean one =false, two = false, three= false;
            for (int i=0; i<s.length(); i++){
                if (first.contains(s.subSequence(i,i+1))) one = true;
                if (second.contains(s.subSequence(i,i+1))) two = true;
                if (third.contains(s.subSequence(i,i+1))) three = true;
            }
            if ((one && two) || (one && three) || (two && three)){
                continue;
            }else {
                list.add(s);
            }
        }
        return list.toArray(new String[list.size()]);
    }


    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了14.93%的用户
     */

}
