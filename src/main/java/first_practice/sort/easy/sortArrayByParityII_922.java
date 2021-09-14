package first_practice.sort.easy;

/**
 * 给定一个非负整数数组A，A中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当A[i]为奇数时，i也是奇数；
 * 当A[i]为偶数时，i也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 *
 * 提示：
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author zyk
 * @description
 * @since 2021/9/14 15:56
 */
public class sortArrayByParityII_922 {

    public int[] sortArrayByParityII(int[] nums) {
        int i=0, j=nums.length-1;
        while (i<j){
            if (nums[i]%2 != i%2){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
            }else {
                i++;
                j = nums.length-1;
            }
        }
        return nums;
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了47.25%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了64.49%的用户
     */


    /** 优化 */
    public int[] sortArrayByParityII2(int[] nums) {
        int n = nums.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) {
                    j += 2;
                }
                swap(nums, i, j);
            }
        }
        return nums;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.43%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了68.84%的用户
     */




}
