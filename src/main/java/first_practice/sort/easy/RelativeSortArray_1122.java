package first_practice.sort.easy;

import java.util.*;

public class RelativeSortArray_1122 {


    /** 计数排序 */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了92.12%的用户
     */


    /** 自定义排序 */
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : arr1) list.add(num);
        for(int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        Collections.sort(list, (x, y) -> {
            if(map.containsKey(x) || map.containsKey(y)) return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            return x - y;
        });
        for(int i = 0; i < arr1.length; i++) arr1[i] = list.get(i);
        return arr1;
    }


    /** 双指针再排序 */
    public int[] relativeSortArray3(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (len1 == 0 || len2 == 0) return new int[0];

        int left = 0, right = 0;
        for (int num : arr2) {
            while(right < len1) {
                if (arr1[right] == num) {
                    int temp = arr1[left];
                    arr1[left++] = arr1[right];
                    arr1[right++] = temp;
                }else {
                    right++;
                }
            }
            right = left;
        }
        Arrays.sort(arr1, left, len1);
        return arr1;
    }

}
