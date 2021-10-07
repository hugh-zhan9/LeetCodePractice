package one_question_everyday;

/**
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，
 * 例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 *
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *  
 *
 * 提示：
 * 0 <= s.length <= 10^5
 * s[i] 为 'A'、'C'、'G' 或 'T'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/10/8 6:21
 */
public class FindRepeatedDnaSequences_2021_10_08 {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> element = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i=0; i<=s.length()-10; i++){
            String substring = s.substring(i, i + 10);
            element.put(substring,element.getOrDefault(substring,0)+1);
            if (element.get(substring) == 2){
                result.add(substring);
            }
        }
        return result;
    }

    /***
     * 执行用时：24 ms, 在所有 Java 提交中击败了17.94%的用户
     * 内存消耗：46.9 MB, 在所有 Java 提交中击败了62.70%的用户
     */

    /**
     * ArrayList 和 Map 的效率差的有点远呀
     */
    /** 超时 */
    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> element = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i=0; i<=s.length()-10; i++){
            String substring = s.substring(i, i + 10);
            if (element.contains(substring) && !result.contains(substring)){
                result.add(substring);
            }else {
                element.add(substring);
            }
        }
        return result;
    }



}
