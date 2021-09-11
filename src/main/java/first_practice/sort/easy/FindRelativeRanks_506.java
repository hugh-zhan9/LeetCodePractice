package first_practice.sort.easy;

/**
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。
 * 前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * (注：分数越高的选手，排名越靠前。)
 *
 * 示例 1:
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 *
 * 提示:
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

/**
 * @author zyk
 * @description
 * @since 2021/9/9 9:41
 */
public class FindRelativeRanks_506 {

    /** hashMap 实现 */
    public String[] findRelativeRanks(int[] score) {
        String[] a=new String[score.length];
        HashMap<Integer,String> map=new HashMap<>();
        int[] c = score.clone();
        Arrays.sort(c);
        for(int i=a.length-1;i>=0;i--){
            if(i==a.length-1){
                a[i] ="Gold Medal";
                map.put(c[i],a[i]);
            }
            else if(i==a.length-2){
                a[i] ="Silver Medal";
                map.put(c[i],a[i]);
            }
            else if(i==a.length-3){
                a[i] ="Bronze Medal";
                map.put(c[i],a[i]);
            }else {
                a[i] = a.length-i + "";
                map.put(c[i],a[i]);
            }
        }
        for(int i=0;i<score.length;i++) a[i]= map.get(score[i]);
        return a;
    }

    /** 使用TreeMap实现 */
    public String[] findRelativeRanks2(int[] score) {
        String[] medal = new String[score.length];
        // 指定排序方式
        Map<Integer,Integer> map = new TreeMap(Comparator.reverseOrder());
        for (int i=0; i<score.length; i++){
            map.put(score[i],i);
        }
        int rank =1;
        Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry=iterator.next();
            if(rank==1) medal[entry.getValue()] = "Gold Medal";
            else if(rank==2) medal[entry.getValue()] = "Silver Medal";
            else if(rank==3) medal[entry.getValue()] = "Bronze Medal";
            else medal[entry.getValue()] = String.valueOf(rank);
            rank++;
        }
        return medal;
    }

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了72.83%的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了10.20%的用户
     */

    /** 二分 */
    public String[] findRelativeRanks3(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        //复制score数组并进行排序
        int[] clone = Arrays.copyOf(score, n);
        Arrays.sort(clone);
        for (int i = 0; i < score.length; i++) {
            //n - 排序后的下标 == 名次
            int rank = n - Arrays.binarySearch(clone, score[i]);
            if (rank == 1) ans[i] = "Gold Medal";
            else if (rank == 2) ans[i] = "Silver Medal";
            else if (rank == 3) ans[i] = "Bronze Medal";
            else ans[i] = Integer.toString(rank);
        }
        return ans;
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了92.33%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了60.92%的用户
     */

    /** 计数排序 */
    /**
     * 我的理解是，找到最大值了，因为是整数数组，所以创建一个max + 1大小的数组，这样所有的值都能放进去，
     * 下面对arr赋值时，越小的值就会排在越前面，并且只有是原数组有的值才会赋值为1，其余没用到的都是0.
     * 所以后面遍历时，从后往前遍历，只要arr数组的值不为0，就说明找到了要给名次的数，
     * 因为前面的操作，越大的值越在后面，所以从后往前遍历就可以正确排序了，不知道有没有说清楚
     */
    public String[] findRelativeRanks4(int[] nums) {
        int n = nums.length;
        String[] result = new String[n];
        int max = 0;
        // 找出找出最高的成绩
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        // 下标为成绩，值为成绩在 nums 数组的下标
        int[] array = new int[max + 1];
        for (int i = 0; i < n; i++) {
            array[nums[i]] = i + 1;
        }
        // 记录当前成绩的排名
        int count = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != 0) {
                // 根据排名进行赋值
                switch (count) {
                    case 1:
                        result[array[i] - 1] = "Gold Medal";
                        break;
                    case 2:
                        result[array[i] - 1] = "Silver Medal";
                        break;
                    case 3:
                        result[array[i] - 1] = "Bronze Medal";
                        break;
                    default:
                        result[array[i] - 1] = String.valueOf(count);
                }
                count++;
            }
        }
        return result;
    }




    /** 原数组不能动，要想到clone一个数组来解决 */

}
