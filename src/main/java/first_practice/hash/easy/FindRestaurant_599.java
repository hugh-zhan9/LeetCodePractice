package first_practice.hash.easy;

/**
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用 最少的索引和 找出他们 共同喜爱 的餐厅。
 * 如果答案不止一个，则输出所有答案并且不考虑顺序。
 * 你可以假设总是存在一个答案。
 *
 * 示例 1:
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 *
 * 示例 2:
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 *
 * 提示:
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

/**
 * @author zyk
 * @description
 * @since 2021/10/20 21:48
 */
public class FindRestaurant_599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        for (int i=0; i<list2.length; i++){
            map.put(list2[i],i);
        }

        List<String> list = new ArrayList<>();
        int index = Integer.MAX_VALUE;
        for (int i=0; i<list1.length; i++){
            if (map.containsKey(list1[i]) && map.get(list1[i])+i<index){
                index = map.get(list1[i])+i;
                list.clear();
                list.add(list1[i]);
            }else if (map.containsKey(list1[i]) && map.get(list1[i])+i==index){
                list.add(list1[i]);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了62.31%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了31.73%的用户
     */


    /** 使用一个哨兵来优化，减少了循环次数 */
    public String[] findRestaurant2(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        List < String > res = new ArrayList < > ();

        int min_sum = Integer.MAX_VALUE, sum;
        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            if (map.containsKey(list2[j])) {
                sum = j + map.get(list2[j]);
                if (sum < min_sum) {
                    res.clear();
                    res.add(list2[j]);
                    min_sum = sum;
                } else if (sum == min_sum)
                    res.add(list2[j]);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了98.75%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了20.86%的用户
     */
}
