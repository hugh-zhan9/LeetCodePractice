package one_question_everyday.Z021_11;

/**
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
 * 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 *
 *
 * 示例 1:
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1807"
 *   |
 * "7810"
 *
 * 示例 2:
 * 输入: secret = "1123", guess = "0111"
 * 输出: "1A1B"
 * 解释: 数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1123"        "1123"
 *   |      or     |
 * "0111"        "0111"
 * 注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。
 *
 * 示例 3：
 * 输入：secret = "1", guess = "0"
 * 输出："0A0B"
 *
 * 示例 4：
 * 输入：secret = "1", guess = "1"
 * 输出："1A0B"
 *  
 *
 * 提示：
 * 1 <= secret.length, guess.length <= 1000
 * secret.length == guess.length
 * secret 和 guess 仅由数字组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulls-and-cows
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @description
 * @since 2021/11/8 9:53
 */
public class Z021_11_08_GetHint {

    /** 哈希表实现 */
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        StringBuffer res = new StringBuffer();
        Map<Character, Integer> map = new HashMap();
        Map<Integer, Character> postMap = new HashMap<>();
        for (int i=0; i<secret.length(); i++){
            char chars = secret.charAt(i);
            map.put(chars, map.getOrDefault(chars,0)+1);
            postMap.put(i,chars);
        }

        // 计算公牛
        for (int i=0; i<guess.length(); i++){
            if (guess.charAt(i) == postMap.get(i)){
                bulls++;
                map.put(guess.charAt(i),map.getOrDefault(guess.charAt(i),0)-1);
            }
        }
        // 计算奶牛
        for (int i=0; i<guess.length(); i++){
            if (guess.charAt(i) != postMap.get(i) && map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i))>0){
                cows++;
                map.put(guess.charAt(i),map.getOrDefault(guess.charAt(i),0)-1);
            }
        }
        return res.append(bulls).append("A").append(cows).append("B").toString();
    }

    /** 数组实现 */
    public String getHint2(String secret, String guess) {
        int bulls = 0, cows = 0;
        StringBuffer res = new StringBuffer();
        int[] numberChars = new int[10];
        int[] postChars = new int[secret.length()];
        for (int i=0; i<secret.length(); i++){
            int val = secret.charAt(i) - '0';
            numberChars[val] += 1;
            postChars[i] = secret.charAt(i);
        }

        // 计算公牛
        for (int i=0; i<guess.length(); i++){
            if (guess.charAt(i) == postChars[i]){
                bulls++;
                numberChars[secret.charAt(i)-'0'] += -1;
            }
        }
        // 计算奶牛
        for (int i=0; i<guess.length(); i++){
            int val = guess.charAt(i) - '0';
            if (guess.charAt(i) != postChars[i] && numberChars[val]>0){
                cows++;
                numberChars[val] += -1;
            }
        }

        return res.append(bulls).append("A").append(cows).append("B").toString();
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了78.77%的用户
     */


    /** 题解中的数组实现，更简化了内存消耗 */
    public String getHint3(String secret, String guess) {
        int bulls = 0, cows = 0;
        StringBuffer res = new StringBuffer();
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++cntS[secret.charAt(i) - '0'];
                ++cntG[guess.charAt(i) - '0'];
            }
        }

        for (int i = 0; i < 10; ++i) {
            /**
             * 对于奶牛，需要满足数字猜对但是位置不对。
             * 我们可以在 secret[i] != guess[i] 时，分别统计 secret 和 guess 的各个字符的出现次数，记在两个长度为 10 的数组中。
             * 根据题目所述的「这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字」，由于多余的数字无法匹配，对于 0 到 9 的每位数字，应取其在 secret 和 guess 中的出现次数的最小值。
             * 将每位数字出现次数的最小值累加，即为奶牛的个数。
             */
            cows += Math.min(cntS[i], cntG[i]);
        }
        return res.append(bulls).append("A").append(cows).append("B").toString();
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37 MB, 在所有 Java 提交中击败了92.76%的用户
     */

}
