package first_practice.sort.easy;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：
 * A[i]是爱丽丝拥有的第i根糖果棒的大小，B[j]是鲍勃拥有的第j根糖果棒的大小。
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中ans[0]是爱丽丝必须交换的糖果棒的大小，ans[1]是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 *  
 *
 * 示例 1：
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 *
 * 示例 4：
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 *  
 *
 * 提示：
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fair-candy-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/9/13 15:41
 */
public class FairCandySwap_888 {

    /** 暴力解。时间复杂度O(n²) */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] result = new int[2];
        int sumAlice = 0, sumBob = 0;
        for (int i=0; i<aliceSizes.length; i++){
            sumAlice += aliceSizes[i];
        }
        for (int j=0; j<bobSizes.length; j++){
            sumBob += bobSizes[j];
        }
        int value = sumAlice - sumBob;
        for (int i=0; i<aliceSizes.length; i++){
            for (int j=0; j<bobSizes.length; j++){
                if (aliceSizes[i] - bobSizes[j] == value/2){
                    result[0] = aliceSizes[i];
                    result[1] = bobSizes[j];
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 执行用时：625 ms, 在所有 Java 提交中击败了9.99%的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了50.32%的用户
     */

    /** 排序+双指针，时间复杂度O(nlogn) */
    public int[] fairCandySwap2(int[] aliceSizes, int[] bobSizes) {
        int[] result = new int[2];
        int sumAlice = 0, sumBob = 0;
        for (int i=0; i<aliceSizes.length; i++){
            sumAlice += aliceSizes[i];
        }
        for (int j=0; j<bobSizes.length; j++){
            sumBob += bobSizes[j];
        }
        int value = (sumAlice - sumBob)/2;
        int i=0, j=0;
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        while (aliceSizes[i] - bobSizes[j] != value){
            if (aliceSizes[i] - bobSizes[j] > value){
                j++;
            }else if (aliceSizes[i] - bobSizes[j] < value){
                i++;
            }
        }
        result[0] = aliceSizes[i];
        result[1] = bobSizes[j];
        return result;
    }

    /**
     * 执行用时：12 ms, 在所有 Java 提交中击败了75.98%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了88.37%的用户
     */


    /** 空间换时间，时间复杂度O(n) */
    public int[] fairCandySwap3(int[] aliceSizes, int[] bobSizes) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        int sumAlice = 0, sumBob = 0;
        for (int i=0; i<aliceSizes.length; i++){
            sumAlice += aliceSizes[i];
        }
        for (int j=0; j<bobSizes.length; j++){
            sumBob += bobSizes[j];
            map.put(bobSizes[j],j);
        }
        int value = (sumAlice - sumBob)/2;
        for (int i=0; i<aliceSizes.length; i++){
            if (map.get(aliceSizes[i] - value) != null){
                result[0] = aliceSizes[i];
                result[1] = aliceSizes[i] - value;
                return result;
            }
        }
        return result;
    }

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了95.32%的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了62.58%的用户
     */

}

