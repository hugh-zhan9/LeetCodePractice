package first_practice.string.easy;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *  
 *
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 *
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 *  
 *
 * 提示：
 * 可以假设 s 和 t 长度相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/9/29 6:06
 */
public class IsIsomorphic_205 {

    /** 时间复杂度O(n)，空间复杂度O(n) */
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        if (length != t.length()){
            return false;
        }
        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> tmap = new HashMap<>();
        for (int i=0; i<length; i++){
            if (!smap.containsKey(s.charAt(i))) smap.put(s.charAt(i),i);
            if (!tmap.containsKey(t.charAt(i))) tmap.put(t.charAt(i),i);
        }
        if (smap.size()>tmap.size()){
            String temp = s;
            s =t;
            t =temp;
        }
        Map<Character, Character> map = new HashMap();
        for (int i=0; i<length; i++){
            if (map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i)) != t.charAt(i) ){
                    return false;
                }
            }else {
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }

    /**
     * 执行用时：10 ms, 在所有 Java 提交中击败了79.35%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了69.68%的用户
     */



    public static void main(String[] args) {
        IsIsomorphic_205 test = new IsIsomorphic_205();
        System.out.println(test.isIsomorphic("badc", "baba"));

    }
}
