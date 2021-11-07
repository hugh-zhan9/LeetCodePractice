package study_plan.entry.twelve_day;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *  
 *
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *  
 *
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zyk
 * @description
 * @since 2021/11/6 21:29
 */
public class Combine_77 {


    /** 思路是，从 [1,n]选一个数i，再从[i,n]选一个数j这样一层层下去。写了一晚上加一个早上，总算写出来了。。。 */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=1; n-i>=k-1; i++){
            list.push(i);
            sets(n, i, k, list, res);
            list.clear();
        }
        return res;
    }

    public void sets (int n, int i, int k, LinkedList<Integer> list, List<List<Integer>> res){
        if (list.size() == k) {
            List<Integer> resList = new ArrayList<>();
            for (int x=0; x<list.size(); x++){
                resList.add(list.get(x));
            }
            res.add(resList);
            return;
        }
        for (int j=i+1; j<=n; j++){
            list.push(j); // 为什么这里add 了， res 中也add 了？
            if (list.size() == k){
                List<Integer> resList = new ArrayList<>();
                for (int x=0; x<list.size(); x++){
                    resList.add(list.get(x));
                }
                res.add(resList);
                list.pollFirst();
                continue;
            }else {
                sets(n,j,k,list,res);
            }
            list.pollFirst();
        }
    }


    /**
     * 执行用时：16 ms, 在所有 Java 提交中击败了40.89%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了10.10%的用户
     */




    /** 官方题解的递归写法 */
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine2(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }




    /** 官方题解的非递归写法 */
    public List<List<Integer>> combine3(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        // 初始化
        // 将 temp 中 [0, k - 1] 每个位置 i 设置为 i + 1，即 [0, k - 1] 存 [1, k]
        // 末尾加一位 n + 1 作为哨兵
        for (int i = 1; i <= k; ++i) {
            temp.add(i);
        }
        temp.add(n + 1);

        int j = 0;
        while (j < k) {
            ans.add(new ArrayList<>(temp.subList(0, k)));
            j = 0;
            // 寻找第一个 temp[j] + 1 != temp[j + 1] 的位置 t
            // 我们需要把 [0, t - 1] 区间内的每个位置重置成 [1, t]
            while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
                temp.set(j, j + 1);
                ++j;
            }
            // j 是第一个 temp[j] + 1 != temp[j + 1] 的位置
            temp.set(j, temp.get(j) + 1);
        }
        return ans;
    }


}
