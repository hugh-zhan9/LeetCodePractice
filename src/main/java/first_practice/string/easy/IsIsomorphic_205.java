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
                if (map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }

    /**
     * 执行用时：10 ms, 在所有 Java 提交中击败了79.35%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了69.68%的用户
     */



    /** 不知道为什么空间效率还不如上面，可能是containsValue方法的原因 */
    public boolean isIsomorphic2(String s, String t) {
        int length = s.length();
        if (length != t.length()){
            return false;
        }
        Map<Character, Character> map = new HashMap();
        for (int i=0; i<length; i++){
            if (map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i)) != t.charAt(i) ){
                    return false;
                }
            }else {
                if (map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }

    /**
     * 执行用时：10 ms, 在所有 Java 提交中击败了79.35%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了35.59%的用户
     */




    /** 保存两个字符串之间的映射 */
    public boolean isIsomorphic3(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), t.charAt(j)); // map1保存 s[i] 到 t[j]的映射
            }
            if (!map2.containsKey(t.charAt(j))) {
                map2.put(t.charAt(j), s.charAt(i)); // map2保存 t[j] 到 s[i]的映射
            }
            // 无法映射，返回 false
            if (map1.get(s.charAt(i)) != t.charAt(j) || map2.get(t.charAt(j)) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 执行用时：21 ms, 在所有 Java 提交中击败了39.21%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了48.88%的用户
     */

}
