package one_question_everyday.Z021_10;

/**
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
 *
 *  
 *
 * 示例 1：
 * 输入：arr = [0,1,0]
 * 输出：1
 *
 * 示例 2：
 * 输入：arr = [1,3,5,4,2]
 * 输出：2
 *
 * 示例 3：
 * 输入：arr = [0,10,5,2]
 * 输出：1
 *
 * 示例 4：
 * 输入：arr = [3,4,5,1]
 * 输出：2
 *
 * 示例 5：
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 *  
 *
 * 提示：
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 *  
 *
 * 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 *
 *  
 * 注意：本题与主站 852 题相同：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/B1IidL
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * @author zyk
 * @description
 * @since 2021/10/14 8:53
 */
public class Z021_10_14_PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int[] clone = arr.clone();
        int result = -1;
        Arrays.sort(clone);
        int length = arr.length;
        for (int i=0; i<length; i++){
            if (arr[i] == clone[length-1]){
                result = i;
            }
        }
        return result;
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了10.88%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了37.88%的用户
     */


    /** 双指针查找时间复杂度O(n) */
    public int peakIndexInMountainArray2(int[] arr) {
        int i=1, j=arr.length-1; int max = 0;
        while (i<=j){
            if (arr[i]>arr[max]){
                max = i;
            }
            if (arr[j]>arr[max]){
                max =j;
            }
            i++;j--;
        }
        return max;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了52.23%的用户
     */


    /** 二分查找，时间复杂度O(logn) */
    public int peakIndexInMountainArray3(int[] arr) {
        int n = arr.length;
        // 因为题目保证了arr是山脉数组，所以arr[0] 和 arr[length-1]肯定不是最大值
        int left = 1, right = n - 2;
        while (left<=right){
            int mid = (left+right)/2;
            if (arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
                return mid;
            }else if (arr[mid]<arr[mid+1]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了89.71%的用户
     */


    public static void main(String[] args) {
        Z021_10_14_PeakIndexInMountainArray test = new Z021_10_14_PeakIndexInMountainArray();
        System.out.println(test.peakIndexInMountainArray3(new int[]{3,4,5,1}));
    }

}
