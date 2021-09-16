package first_practice.sort.easy;

/**
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：
 * 我们选择某个索引i并将A[i]替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * 以这种方式修改数组后，返回数组可能的最大和。
 *
 *  
 *
 * 示例 1：
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 *
 * 示例 2：
 * 输入：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 *
 * 示例 3：
 * 输入：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 *  
 *
 * 提示：
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * @author zyk
 * @description
 * @since 2021/9/16 8:51
 */
public class LargestSumAfterKNegations_1005 {

    /** 思路：找到最小的k个数 */


    /** 暴力解，错了9次，哭出声。。。一道破题写一天。。  http://47.98.158.110:8888/group1/M00/00/01/L2KebmFCtueAakR3AAB1m8OafBs136.png */
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int zeroPost = -1;
        int minusPost = -1;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            if (nums[i] == 0){
                zeroPost = i;
            }
            if(nums[i]<0){
                minusPost =i;
            }
        }
        if (zeroPost != -1){
            if (k-1<=zeroPost){
                for (int i=0; i<k; i++){
                    sum -= 2*nums[i];
                }
            }else {
                for (int i=0; i<zeroPost; i++){
                    sum -= 2*nums[i];
                }
            }
        }else {
            if (k-1 <= minusPost){
                for (int i=0; i<k; i++){
                    sum -= 2*nums[i];
                }
            }else {
                if (minusPost == -1){
                    sum += (int) (2*nums[0] * Math.pow(-1,k));
                }else {
                    int min = 0, count=0;
                    if(minusPost<nums.length-1 && nums[minusPost+1]+nums[minusPost]<=0){
                        min = nums[minusPost+1];
                        count = k-minusPost-1;
                    } else {
                        min = nums[minusPost];
                        count = k-minusPost;
                    }

                    for (int i=0; i<minusPost+1; i++){
                        sum -= 2*nums[i];
                        nums[i] = -nums[i];
                    }
                    if (min * Math.pow(-1,k-minusPost-1) == min){
                        sum = sum;
                    }else {
                        sum += 2*min * Math.pow(-1, count);
                    }
                }
            }
        }
        return sum;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了76.61%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了42.25%的用户
     */

    public int largestSumAfterKNegations2(int[] nums, int k) {
        // -100 <= A[i] <= 100,这个范围的大小是201
        int[] number = new int[201];
        for (int t : nums) {
            // 将[-100,100]映射到[0,200]上
            number[t + 100]++;
        }
        int i = 0;
        while (k > 0) {
            // 找到A[]中最小的数字
            while (number[i] == 0)
            {
                i++;
            }
            // 此数字个数-1
            number[i]--;
            // 其相反数个数+1
            number[200 - i]++;
            // 若原最小数索引>100,则新的最小数索引应为200-i.(索引即number[]数组的下标)
            if (i > 100) {
                i = 200 - i;
            }
            k--;
        }
        int sum = 0;
        //遍历number[]求和
        for (int j = i; j <number.length ; j++) {
            //j-100是数字大小,number[j]是该数字出现次数.
            sum += (j-100)*number[j];
        }
        return sum;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.8 MB, 在所有 Java 提交中击败了63.41%的用户
     */

    /** 贪心算法 */
    public int largestSumAfterKNegations3(int[] nums, int k) {
        if (nums.length == 1) {
            return k % 2 == 0 ? nums[0] : -nums[0];
        }

        Arrays.sort(nums);
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            if (i < nums.length - 1 && nums[idx] < 0) {
                nums[idx] = -nums[idx];
                if (nums[idx] >= Math.abs(nums[idx + 1])) {
                    idx++;
                }
                continue;
            }
            nums[idx] = -nums[idx];
        }

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了76.61%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了54.33%的用户
     */

}