package one_question_everyday.Z021_10;

/**
 * 在LeetCode商店中， 有n件在售的物品。每件物品都有对应的价格。
 * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 *
 * 给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。
 * 另有一个整数数组 needs 表示购物清单，其中 needs[i] 是需要购买第 i 件物品的数量。
 *
 * 还有一个数组 special 表示大礼包，special[i] 的长度为 n+1 ，
 * 其中special[i][j]表示第 i 个大礼包中内含第 j 件物品的数量，且special[i][n]（也就是数组中的最后一个整数）为第i个大礼包的价格。
 *
 * 返回确切满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。
 * 你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。任意大礼包可无限次购买。
 *
 *  
 *
 * 示例 1：
 * 输入：price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
 * 输出：14
 * 解释：有 A 和 B 两种物品，价格分别为 ¥2 和 ¥5 。
 * 大礼包 1 ，你可以以 ¥5 的价格购买 3A 和 0B 。
 * 大礼包 2 ，你可以以 ¥10 的价格购买 1A 和 2B 。
 * 需要购买 3 个 A 和 2 个 B ， 所以付 ¥10 购买 1A 和 2B（大礼包 2），以及 ¥4 购买 2A 。
 *
 * 示例 2：
 * 输入：price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
 * 输出：11
 * 解释：A ，B ，C 的价格分别为 ¥2 ，¥3 ，¥4 。
 * 可以用 ¥4 购买 1A 和 1B ，也可以用 ¥9 购买 2A ，2B 和 1C 。
 * 需要买 1A ，2B 和 1C ，所以付 ¥4 买 1A 和 1B（大礼包 1），以及 ¥3 购买 1B ， ¥4 购买 1C 。
 * 不可以购买超出待购清单的物品，尽管购买大礼包 2 更加便宜。
 *  
 *
 * 提示：
 * n == price.length
 * n == needs.length
 * 1 <= n <= 6
 * 0 <= price[i] <= 10
 * 0 <= needs[i] <= 10
 * 1 <= special.length <= 100
 * special[i].length == n + 1
 * 0 <= special[i][j] <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shopping-offers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/10/24 8:40
 */
public class Z021_10_24_ShoppingOffers_638_not_do {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int needSize = needs.size();
        special.size();
        List<List<Integer>> specialContent = new ArrayList<>();
        for (List<Integer> list : special){
            int i=0;
            while (i<needSize && !specialContent.contains(list)){
                if (list.get(i) > needs.get(i)){
                    specialContent.add(list);
                }
                i++;
            }
        }

        for (List<Integer> list:specialContent){
            specialContent.remove(list);
        }

        int temp = 0;
        int sum = Integer.MAX_VALUE;
        for (List<Integer> list:special){
            for (int i=0; i<needSize; i++){
                temp += (needs.get(i) - list.get(i))*price.get(i);
            }
            temp+= list.get(list.size()-1);
            if (temp<sum) sum = temp;
            temp = 0;
        }
        // 写到这发现有可能会存在多个礼包同时购买的情况，这种写法cover不了
        return sum;
    }

    /**
     * 每次分为不拿这个礼包了，以及（如果可以的话）拿这个礼包，两条路，一路搜到最后一个礼包即可
     */


    /** 动态规划，欸... */
    Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers2(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();

        // 过滤不需要计算的大礼包，只保留需要计算的大礼包
        List<List<Integer>> filterSpecial = new ArrayList<List<Integer>>();
        for (List<Integer> sp : special) {
            int totalCount = 0, totalPrice = 0;
            for (int i = 0; i < n; ++i) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > sp.get(n)) {
                filterSpecial.add(sp);
            }
        }

        return dfs(price, special, needs, filterSpecial, n);
    }

    // 记忆化搜索计算满足购物清单所需花费的最低价格
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> curNeeds, List<List<Integer>> filterSpecial, int n) {
        if (!memo.containsKey(curNeeds)) {
            int minPrice = 0;
            for (int i = 0; i < n; ++i) {
                minPrice += curNeeds.get(i) * price.get(i); // 不购买任何大礼包，原价购买购物清单中的所有物品
            }
            for (List<Integer> curSpecial : filterSpecial) {
                int specialPrice = curSpecial.get(n);
                List<Integer> nxtNeeds = new ArrayList<Integer>();
                for (int i = 0; i < n; ++i) {
                    if (curSpecial.get(i) > curNeeds.get(i)) { // 不能购买超出购物清单指定数量的物品
                        break;
                    }
                    nxtNeeds.add(curNeeds.get(i) - curSpecial.get(i));
                }
                if (nxtNeeds.size() == n) { // 大礼包可以购买
                    minPrice = Math.min(minPrice, dfs(price, special, nxtNeeds, filterSpecial, n) + specialPrice);
                }
            }
            memo.put(curNeeds, minPrice);
        }
        return memo.get(curNeeds);
    }




}