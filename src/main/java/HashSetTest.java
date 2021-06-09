import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Twitter上的一道题目
 */

/**
 * @author zyk
 * @description
 * @since 2021/6/9 9:22
 */
public class HashSetTest {
    public static void main(String[] args) {
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("ceshi");
        Set<StringBuilder> set = new HashSet<>(list);
        set.add(sb);
        System.out.println(set.contains(sb));   // should print true
        sb.append("oops");
        System.out.println(set.contains(sb));   // should print false
    }
}
