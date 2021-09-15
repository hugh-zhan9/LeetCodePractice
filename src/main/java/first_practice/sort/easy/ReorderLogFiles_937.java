package first_practice.sort.easy;

/**
 * 给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的标识符 。
 * 有两种不同类型的日志：
 * 字母日志：除标识符之外，所有字均由小写字母组成
 * 数字日志：除标识符之外，所有字均由数字组成
 *
 * 请按下述规则将日志重新排序：
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
 * 数字日志 应该保留原来的相对顺序。
 * 返回日志的最终顺序。
 *
 *  
 *
 * 示例 1：
 * 输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * 输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * 解释：
 * 字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
 * 数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
 *
 * 示例 2：
 * 输入：logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *  
 *
 * 提示：
 * 1 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] 中，字与字之间都用 单个 空格分隔
 * 题目数据保证 logs[i] 都有一个标识符，并且在标识符之后至少存在一个字
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-data-in-log-files
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * @author zyk
 * @description
 * @since 2021/9/15 8:54
 */
public class ReorderLogFiles_937 {

    /**
     * 官方题解：本质是重写了排序比较器
     *
     * 排序规则如下：
     * 字母日志先于数字日志；
     * 字母日志按字母数字顺序排列，先按内容排序，再按标识符排序；
     * 数字日志的顺序保持不变。
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            // 如果是字母则直接排序
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                // 如果内容不同直接排序
                if (cmp != 0) {
                    return cmp;
                }
                // 内容相同比较标识符
                return split1[0].compareTo(split2[0]);
            }
            // 如果是一个是数字，一个是字母
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    /***
     * 执行用时：6 ms, 在所有 Java 提交中击败了74.17%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了36.25%的用户
     */


    public String[] reorderLogFiles2(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            // 分割字符串，split(String regex, int limit)，limit表示分割的份数。
            String[] splitA = a.split(" ", 2);
            String[] splitB = b.split(" ", 2);
            // 判断日志类型
            boolean aIsDigit = Character.isDigit(splitA[1].charAt(0));
            boolean bIsDigit = Character.isDigit(splitB[1].charAt(0));
            // a和b都是字母日志
            if (!aIsDigit && !bIsDigit) {
                // 在内容不同时，忽略标识符，按内容字母顺序排序；
                if (!splitA[1].equals(splitB[1])) {
                    return splitA[1].compareTo(splitB[1]);
                }
                //在内容相同时，按标识符排序。
                else {
                    return splitA[0].compareTo(splitB[0]);
                }
            }
            //a和b都是数字日志
            else if (aIsDigit && bIsDigit) {
                //保留原来的相对顺序。
                return 0;
            }
            //a是字母日志
            else if (!aIsDigit) {
                //所有字母日志都排在数字日志之前。
                return -1;
            }
            //b是字母日志
            else {
                //所有字母日志都排在数字日志之前。
                return 1;
            }
        });
        return logs;
    }

    /** 题解：归并排序 */
    public String[] reorderLogFiles3(String[] logs) {
        if(logs.length <= 1){
            return logs;
        }
        return mergeSort(logs, 0, logs.length-1);
    }

    private String[] mergeSort(String[] logs, int left, int right){
        if(left == right){
            return new String[]{logs[left]};
        }
        int mid = (left+right)/2;
        String[] leftRes = mergeSort(logs, left, mid);
        String[] rightRes = mergeSort(logs, mid+1, right);
        return merge(leftRes, rightRes);
    }

    private String[] merge(String[] a, String[] b){
        String[] res = new String[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        int rIndex = 0;
        while(aIndex < a.length && bIndex < b.length){
            if(compare(a[aIndex], b[bIndex])){//在此处调用自定义比较方法
                res[rIndex] = a[aIndex];
                aIndex++;
            }else{
                res[rIndex] = b[bIndex];
                bIndex++;
            }
            rIndex++;
        }
        while(aIndex<a.length){
            res[rIndex++] = a[aIndex++];
        }
        while(bIndex<b.length){
            res[rIndex++] = b[bIndex++];
        }
        return res;
    }

    private boolean compare(String one, String two){
        //如果String one应该出现在String two前面，则返回true，否则返回false
        char a=' ',b=' ';//a,b代表两个String中第一个有效数据的内容
        int x=0,y=0;//x,y代表两个String中第一个有效数据所在index。
        for(int i=0; i<one.length();i++){
            if(one.charAt(i) == ' '){
                x = i+1;
                a = one.charAt(i+1);
                break;
            }
        }
        for(int i=0; i<two.length();i++){
            if(two.charAt(i) == ' '){
                y=i+1;
                b = two.charAt(i+1);
                break;
            }
        }
        if((a<'0' || a>'9') && (b<'0'||b>'9')){
            //如果ab均为字符，则逐个比较每个有效数据，
            while(x<one.length() || y<two.length()){
                char temp1,temp2;
                if(x<one.length()){
                    temp1 = one.charAt(x);
                    x++;
                }else{
                    temp1 = ' ';
                }
                if(y<two.length()){
                    temp2 = two.charAt(y);
                    y++;
                }else{
                    temp2 = ' ';
                }
                if(temp1 < temp2){
                    return true;
                }else if(temp1>temp2){
                    return false;
                }
            }
            //如果有效数据全都相等，则比较标识符。
            if(x == one.length() && y == two.length()){
                return one.charAt(0) <= two.charAt(0);
            }
        }else if(b<'0'||b>'9'){//如果b是字符a不是返回false
            return false;
        }
        return true;//如果a是字符b不是，或者ab都是数字，返回true
    }

    /** 这应该不算是一道简单题，确实是没见过的思路 */

}
