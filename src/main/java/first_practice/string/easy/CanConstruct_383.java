package first_practice.string.easy;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 *  
 *
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 *
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *  
 *
 * 提示：
 * 你可以假设两个字符串均只含有小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/10/8 9:38
 */
public class CanConstruct_383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> magazineMap = new HashMap<>();
        int magazineLength = magazine.length(), ransomNoteLength = ransomNote.length();
        for (int i=0; i<magazineLength; i++){
            magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i),0)+1);
        }
        for (int i=0; i<ransomNoteLength; i++){
            if (!magazineMap.containsKey(ransomNote.charAt(i)) || magazineMap.get(ransomNote.charAt(i))==0){
                return false;
            }
            magazineMap.put(ransomNote.charAt(i), magazineMap.getOrDefault(ransomNote.charAt(i),0)-1);
        }
        return true;
    }

    /**
     * 执行用时：17 ms, 在所有 Java 提交中击败了9.14%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了23.59%的用户
     */


    /** 这尼玛差这么多。。 */
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] array = new int[26];
        int magazineLength = magazine.length(), ransomNoteLength = ransomNote.length();
        for (int i=0; i<magazineLength; i++){
            array[magazine.charAt(i)-'a']++;
        }
        for (int i=0; i<ransomNoteLength; i++){
            if (array[ransomNote.charAt(i)-'a']==0){
                return false;
            }
            array[ransomNote.charAt(i)-'a']--;
        }
        return true;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.88%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了74.55%的用户
     */

}
