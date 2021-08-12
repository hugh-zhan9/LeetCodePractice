package algorithm_implementation;

import java.util.IllegalFormatCodePointException;

/**
 * @author zyk
 * @description
 * @since 2021/6/11 16:18
 */
public class Sort {

    /**
     * 冒泡排序，a表示数组，n表示数组大小
     * @param a
     * @param n
     */
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j=0; j < n-i- 1; ++j) {
                // 交换
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) break;
        }
    }

    /**
     * 插入排序，a表示数组，n表示数组大小
     * @param a
     * @param n
     */
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 数据移动
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            // 插入数据
            a[j+1] = value;
        }
    }

    /**
     * 选择排序
     * @param a
     * @param n
     */
    public void selectionSort(int[] a, int n) {
        if (n <= 1) return;
        for(int i=0; i<n-1; i++){
            int j = i+1;
            int min = i;
            // 从未排序区选择最小的
            for(; j<n; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    /**
     * 归并排序
     * @param a
     * @param n
     */
    public void mergeSort(int[] a,int n){
        decomposition(a,0,n-1);
    }

    private void decomposition(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) return;

        int point = (p+r)/2;

        decomposition(a,p,point);
        decomposition(a,point+1,r);

        merge(a,p,point,r);
    }

    private void merge(int[] a, int start, int point, int end) {
        int[] result = new int[end-start+1];
        int i=start, j=point+1, z=0;

        // 将两者中小的一个放入到数组中
        while(i <= point && j <= end){
            if (a[i] <= a[j]){
                result[z++] = a[i++];
            }else {
                result[z++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int begin = i;
        int stop = point;
        if (j <= end){
            begin = j;
            stop = end;
        }

        // 将剩余的放入到result中
        while (begin <= stop){
            result[z++] = a[begin++];
        }

        for (i = 0; i <= end-start; ++i) {
            a[start+i] = result[i];
        }
    }


    /** 快速排序 */
    public void quickSort(int[] a, int n){
        quickSortDecomposition(a,0,n-1);
    }

    private void quickSortDecomposition(int[] a, int start, int end) {
        if (start >= end) return;

        int point = partition(a,start,end);

        quickSortDecomposition(a,start,point-1);
        quickSortDecomposition(a,point+1,end);
    }

    private int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start;
        for(int j = start; j < end; ++j) {
            // 双指针，如果a[j] < pivot 就将其放到前半部分，即交换位置
            // i 只有在j指定的元素小于pivot 或 i=j时才会增加
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        // 交换 pivot 到指定位置
        int tmp = a[i];
        a[i] = a[end];
        a[end] = tmp;

        return i;
    }


    /** 桶排序 */
    public void bucketSort(int[] a, int bucketSize){
        int min = a[0];
        int max = a[0];
        for (int i=0; i<a.length; i++){
            if (a[i]>max){
                max = a[i];
            }else if (a[i]<min) {
                min = a[i];
            }
        }

        // 找到最大最小值之后进行分桶
        int bucketCount = (max-min)/bucketSize;
        if ((max-min)/bucketSize%bucketSize>0){
            bucketCount++;
        }
        int[][] bucket = new int[bucketCount][bucketSize];
        // 用来存储每个桶中放置了多少个元素
        int[] bucketCapacity = new int[bucketCount];

        /* 最开始写成这样，使用j来表示插入位置，然后发现需要保存每个桶保存了多少元素
        int j =0;
        // 把元素分桶
        for (int i=0; i<a.length; i++){
            int size = (a[i] - min)/bucketSize;
            if (i%bucketSize==0){
                j=0;
            }
            bucket[size][j++] = a[i];
        }

        int k=0;
        // 每个桶中使用快速排序进行排序
        for (int i=0; i<bucketCount; i++){
            quickSort(bucket[i],bucketSize);
            for (int e:bucket[i]){
                a[k++] = e; // 不使用扩容的话，中间的桶里会包含不存在的值
            }
        }
        */

        // 元素分桶
        for (int i = 0; i < a.length; i++) {
            int bucketIndex = (a[i] - min) / bucketSize;
            if (bucketCapacity[bucketIndex] == bucket[bucketIndex].length) {
                ensureCapacity(bucket, bucketIndex);
            }
            bucket[bucketIndex][bucketCapacity[bucketIndex]++] = a[i];
        }

        // 将桶中元素放入到原数组中
        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucketCapacity[i] == 0) {
                continue;
            }
            // 实际参与快速排序的元素只有一个，所以理论上这个数组长度为1
            quickSort(bucket[i],bucketCapacity[i]);

            for (int j = 0; j < bucketCapacity[i]; j++) {
                a[k++] = bucket[i][j];
            }
        }

    }

    // 数组扩容
    private void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] a = {1,2,3,4,9,8,7};
        sort.bucketSort(a,3);
        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
