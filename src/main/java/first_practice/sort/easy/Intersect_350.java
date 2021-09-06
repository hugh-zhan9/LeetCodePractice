package first_practice.sort.easy;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/9/6 6:25
 */
public class Intersect_350 {

    /**
     * hash法，存储长度最小数组中元素出现的个数
     * 时间复杂度O(m+n)，空间复杂度O(min(m,n))
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length){
            intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums1.length; i++){
           int count = map.getOrDefault(nums1[i],0)+1;
           map.put(nums1[i],count);
        }
        // 重复元素的数组长度不会超过最短数组的长度
        int[] array = new int[nums1.length];
        int index = 0;
        for (int j=0; j<nums2.length; j++){
            if (map.containsKey(nums2[j])){
                int count = map.get(nums2[j])-1;
                if (count>0){
                    map.put(nums2[j],count);
                }else {
                    map.remove(nums2[j]);
                }
                array[index] = nums2[j];
                index++;
            }
        }
        return Arrays.copyOf(array,index);
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了53.41%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了69.73%的用户
     */


    /** 排序+双指针 实现
     *
     * 时间复杂度 O(mlogm+nlogn)，其中 m 和 n 分别是两个数组的长度。
     * 对两个数组进行排序的时间复杂度是 O(mlogm+nlogn)，遍历两个数组的时间复杂度是 O(m+n)，因此总时间复杂度是O(mlogm+nlogn)。
     *
     * 空间复杂度：O(min(m,n))，其中 m 和 n 分别是两个数组的长度。
     * 为返回值创建一个数组 intersection，其长度为较短的数组的长度。
     */
    public int[] intersect2(int[] nums1, int[] nums2){
        if (nums1.length>nums2.length){
            intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0, x=0;
        int[] array = new int[nums1.length];
        while (i<nums1.length && j<nums2.length){
            if (nums1[i]<nums2[j]){
                i++;
            }else if (nums1[i]>nums2[j]){
                j++;
            }else {
                array[x] = nums1[i];
                x++; i++;j++;
            }
        }
        return Arrays.copyOf(array,x);
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.97%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了51.31%的用户
     */


    /**
     * 如果nums2的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中。
     * 那么就无法高效地对 nums2 进行排序，因此推荐使用方法一而不是方法二。
     * 在方法一中，nums2 只关系到查询操作，因此每次读取 nums2 中的一部分数据，并进行处理即可。
     */
}
