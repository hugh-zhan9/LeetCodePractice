package arithmetic.sort;

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

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] a = {1,2,3,4,9,8,7};
        sort.insertionSort(a,7);
        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
