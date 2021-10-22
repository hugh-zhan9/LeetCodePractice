package one_question_everyday.Z021_10;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 n/3 次的元素。
 *  
 *
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：[3]
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：[1]
 *
 * 示例 3：
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 *  
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.*;

/**
 * @author zyk
 * @description
 * @since 2021/10/22 10:48
 */
public class Z021_10_22_MajorityElement {

    /** 该题与{@link first_practice.array.easy.MajorityElement_169} 相同，解法思路一样，但是前者效率更高 */

    /** 最简单的想法是map记录次数，过滤 */
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int length = nums.length;
        int count = length/3;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (map.get(next)>count){
                res.add(next);
            }
        }
        return res;
    }

    /**
     * 执行用时：11 ms, 在所有 Java 提交中击败了28.12%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了86.27%的用户
     */


    /** 排序后统计出现的次数 */
    public List<Integer> majorityElement2(int[] nums) {
        int length = nums.length;
        int border = length/3;
        Arrays.sort(nums);
        int num = nums[0];
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<length; i++){
            if (nums[i] == num){
                count++;
            }else {
                num = nums[i];
                count =1;
            }
            if (count>border && !list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        return list;
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了34.93%的用户
     * 内存消耗：42.4 MB, 在所有 Java 提交中击败了25.14%的用户
     */



    /** 摩尔投票法 */
    public List<Integer> majorityElement3(int[] nums) {
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;

        for (int num : nums) {
            //如果该元素为第一个元素，则计数加1
            if (vote1 > 0 && num == element1) {
                vote1++;
                //如果该元素为第二个元素，则计数加1
            } else if (vote2 > 0 && num == element2) {
                vote2++;
                // 选择第一个元素
            } else if (vote1 == 0) {
                element1 = num;
                vote1++;
                // 选择第二个元素
            } else if (vote2 == 0) {
                element2 = num;
                vote2++;
                //如果三个元素均不相同，则相互抵消1次
            } else {
                vote1--;
                vote2--;
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == element1) {
                cnt1++;
            }
            if (vote2 > 0 && num == element2) {
                cnt2++;
            }
        }
        // 检测元素出现的次数是否满足要求
        List<Integer> ans = new ArrayList<>();
        if (vote1 > 0 && cnt1 > nums.length / 3) {
            ans.add(element1);
        }
        if (vote2 > 0 && cnt2 > nums.length / 3) {
            ans.add(element2);
        }

        return ans;
    }


}
