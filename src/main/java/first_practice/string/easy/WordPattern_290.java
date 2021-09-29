package first_practice.string.easy;

/**
 * 给定一种规律 pattern和一个字符串str，判断str是否遵循相同的规律。
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 说明:
 * 你可以假设pattern只包含小写字母，str包含了由单个空格分隔的小写字母。    
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/9/30 6:27
 */
public class WordPattern_290 {

    public boolean wordPattern(String pattern, String s) {
        int length = pattern.length();
        String[] split = s.split(" ");
        if (length != split.length){
            return false;
        }
        Map<Character,String> map = new HashMap<>();
        for (int i=0; i<length; i++){
            if (map.containsKey(pattern.charAt(i))){
                if (!map.get(pattern.charAt(i)).equals(split[i])){
                    return false;
                }
            }else {
                if (map.containsValue(split[i])){
                    return false;
                }
                map.put(pattern.charAt(i),split[i]);
            }
        }
        return true;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了92.19%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了27.88%的用户
     */

    public static void main(String[] args) {
        WordPattern_290 test = new WordPattern_290();
        System.out.println(test.wordPattern("aaba","dog cat cat dog"));
    }

}
