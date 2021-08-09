package other_question.hashSet;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


/**
 * Twitter上的一种解法
 */

class StringBuilderInHashMap{
    public static void main(String[] args) throws Exception {
        List<StringBuilder> list = Collections.synchronizedList(new ArrayList<>(Arrays.asList(new StringBuilder(""))));
        StringBuilder sb = IntStream.of(1).mapToObj( n ->{
            int targetKeyHash;
            targetKeyHash = (targetKeyHash = list.get(0).hashCode()) ^ (targetKeyHash >>> 16);

            int targetTab = 63 & targetKeyHash;
            while (list.size() < 40){
                StringBuilder nsb = new StringBuilder();
                int keyHash;
                keyHash = (keyHash = nsb.hashCode()) ^ (keyHash >>> 16);
                int tab = 63 & keyHash;

                if (tab == targetTab){
                    list.add(nsb);
                }
            }

            ExecutorService a = Executors.newFixedThreadPool(8);
            AtomicInteger b = new AtomicInteger(0);
            int c = list.stream().mapToInt(Object::hashCode).min().getAsInt();
            for (int i=0; i<8; i++){
                a.execute(()->{
                    while (b.get() < 1){
                        StringBuilder nsb = new StringBuilder("");

                        if (nsb.hashCode() == c){
                            if (b.get() < 1){
                                list.add(nsb);
                                b.getAndIncrement();
                            }
                            break;
                        }
                    }
                });
            }

            while (b.get() < 1){
                StringBuilder nsb = new StringBuilder("");
                if (nsb.hashCode() == c){
                    list.add(nsb);
                    b.getAndIncrement();
                    break;
                }
            }
            a.shutdownNow();
            return list.get(list.size() -1);
        }).findFirst().orElseThrow(Exception::new);

        Set<StringBuilder> set = new HashSet<>(list);
        set.add(sb);
        System.out.println(set.contains(sb));
        sb.append("oops");
        System.out.println(set.contains(sb));
    }
}
