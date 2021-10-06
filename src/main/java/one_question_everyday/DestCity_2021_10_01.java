package one_question_everyday;

/**
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，
 * 其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi。
 * 请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 *
 * 题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * 输出："Sao Paulo"
 * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。
 * 本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
 *
 * 示例 2：
 * 输入：paths = [["B","C"],["D","B"],["C","A"]]
 * 输出："A"
 * 解释：所有可能的线路是：
 * "D" -> "B" -> "C" -> "A". 
 * "B" -> "C" -> "A". 
 * "C" -> "A". 
 * "A". 
 * 显然，旅行终点站是 "A" 。
 * 示例 3：
 *
 * 输入：paths = [["A","Z"]]
 * 输出："Z"
 *  
 *
 * 提示：
 *
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 * 所有字符串均由大小写英文字母和空格字符组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/destination-city
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */



import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;


/**
 * @author zyk
 * @description
 * @since 2021/10/1 11:23
 */
public class DestCity_2021_10_01 {

    public String destCity(List<List<String>> paths) {
        Map<String,Integer> firstMap = new HashMap();
        Map<String,Integer> secondMap = new HashMap<>();
        for (List<String> list : paths){
            String first = list.get(0);
            String second = list.get(1);
            firstMap.put(first,1);
            secondMap.put(second,1);
        }

        Set<String> keySet = secondMap.keySet();
        for (String key : keySet){
            if (!firstMap.containsKey(key)){
                return key;
            }
        }
        return "";
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了94.47%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了32.89%的用户
     */


    public String destCity2(List<List<String>> paths) {
        List<String> firstList = new ArrayList<>();
        List<String> secondList = new ArrayList<>();
        for (List<String> list : paths){
            String first = list.get(0);
            String second = list.get(1);
            firstList.add(first);
            secondList.add(second);
        }
        for (String string : secondList){
            if (! firstList.contains(string)){
                return string;
            }
        }
        return "";
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了94.47%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了45.00%的用户
     */


    public String destCity3(List<List<String>> paths) {
        List<String> firstList = new ArrayList<>();
        for (List<String> list : paths){
            firstList.add(list.get(0));
        }
        for (List<String> list : paths){
            if (! firstList.contains(list.get(1))){
                return list.get(1);
            }
        }
        return "";
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了94.47%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了28.95%的用户
     */

}
