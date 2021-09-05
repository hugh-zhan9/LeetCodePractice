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
import java.util.Iterator;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/9/6 6:25
 */
public class Intersect_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length){
            intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums1.length; i++){
           int count = map.getOrDefault(nums1[i],0)+1;
           map.put(nums1[i],count);
        }
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
}
