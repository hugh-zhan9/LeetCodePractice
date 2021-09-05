package first_practice.sort.easy;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zyk
 * @description
 * @since 2021/9/5 19:12
 */
public class Intersection_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0){
            return null;
        }
        Set<Integer> result = new HashSet<>();
        for (int i=0; i<nums1.length; i++){
            for (int j=0; j<nums2.length; j++){
                if (nums1[i] == nums2[j]){
                    result.add(nums1[i]);
                }
            }
        }
        int[] array = new int[result.size()];
        Iterator<Integer> iterator = result.iterator();
        int i = 0;
        while (iterator.hasNext()){
            array[i] = iterator.next();
            i++;
        }
        return array;
    }

    /**
     * 执行用时：13 ms, 在所有 Java 提交中击败了5.93%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了86.58%的用户
     */

    /** 题解的解答，感觉差不太多 */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        return getIntersection(set1, set2);
    }

    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }
        Set<Integer> intersectionSet = new HashSet<Integer>();
        for (int num : set1) {
            if (set2.contains(num)) {
                intersectionSet.add(num);
            }
        }
        int[] intersection = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            intersection[index++] = num;
        }
        return intersection;
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了58.66%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了63.73%的用户
     */

    /** 集合的用法 */
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(),set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i:nums1){
            list.add(i);
        }
        for(int i:nums2){
            set2.add(i);
        }
        // retainAll() 方法用于保留 arraylist 中在指定集合中也存在的那些元素，也就是删除指定集合中不存在的那些元素
        list.retainAll(set2);
        set1.addAll(list);
        return set1.stream().mapToInt(i->i).toArray();
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了18.58%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了58.61%的用户
     */


    /** 评论精通stream调用 */
    public int[] intersection4(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了8.76%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了75.94%的用户
     */

}
