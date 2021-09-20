package first_practice.sort.easy;

/**
 * 给你个整数数组 arr，其中每个元素都不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 *  
 *
 * 示例 1：
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 *
 * 示例 2：
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 *
 * 示例 3：
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *  
 *
 * 提示：
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyk
 * @description
 * @since 2021/9/19 9:40
 */
public class MinimumAbsDifference_1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i=0; i<arr.length-1; i++){
            if (Math.abs(arr[i+1]-arr[i]) < min){
                min = Math.abs(arr[i+1]-arr[i]);
            }
        }for (int i=0; i<arr.length-1; i++){
            if (Math.abs(arr[i+1]-arr[i]) == min){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(0,arr[i]);
                list.add(1,arr[i+1]);
                result.add(list);
            }
        }

        return result;
    }

    /**
     * 执行用时：17 ms, 在所有 Java 提交中击败了66.59%的用户
     * 内存消耗：49.2 MB, 在所有 Java 提交中击败了52.16%的用户
     */


    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        int min = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i=0; i<arr.length-1; i++){
            if (Math.abs(arr[i+1]-arr[i]) < min){
                min = Math.abs(arr[i+1]-arr[i]);
                result.clear();
                ArrayList<Integer> list = new ArrayList<>();
                list.add(0,arr[i]);
                list.add(1,arr[i+1]);
                result.add(list);
            }else if (Math.abs(arr[i+1]-arr[i]) == min){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(0,arr[i]);
                list.add(1,arr[i+1]);
                result.add(list);
            }
        }
        return result;
    }

    /**
     * 执行用时：19 ms, 在所有 Java 提交中击败了32.93%的用户
     * 内存消耗：49 MB, 在所有 Java 提交中击败了75.24%的用户
     */


}
