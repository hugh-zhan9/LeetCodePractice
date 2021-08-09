Tagir自己写的答案，对Java学习很有帮助： https://twitter.com/tagir_valeev/status/1402520496143540228

下面是我的理解：

首先我们知道，HashSet 里面是一个 HashMap ，set.contains(sb) 最终执行的是 HashMap 的contains 方法。通常情况下 contains 方法会先比较 hashCode，再调用 equals()。

StringBuilder 在 内容改变后（如 append ），它的 hashCode 是不会变的，而StringBuilder 也没有override equals() 也就是说如果不做什么改动，两次 print 都会打印 true 。

而 StringBuilder 是个final 类，没法继承重写，怎么办？

V2的Java 人我想八股文都背得滚瓜烂熟了吧，都知道Java 8 以后，hash冲突会形成链表，超过8个会变成红黑树，而红黑树在比较的时候会用 compareTo 而不是 equals 。如果用 compareTo 可以看到 StringBuilder 的 compareTo 实现是有比较内容的。

所以， sb.append("oops"); 执行后，HashMap 在红黑树中比较就会返回 false。

整个思路现在就很明朗了，就是制造大量的 hashCode 相同的 StringBuilder ，从而在 HashMap 中他们会都放在一个 bucket 里，并形成红黑树，调用set.contains(sb) 时，就会调用 compareTo

具体的解法很多，以 Tagir 的代码为例，比较好懂：

```java
List<StringBuilder> list = Stream.generate(() -> {
    while (true) {
        StringBuilder sb = new StringBuilder("a");
        int hc = sb.hashCode();
        if (((hc ^ (hc >>> 16)) & 0x3F) == 0) {
            return sb;
        }
    }
}).limit(40)
  .sorted(Comparator.comparingInt(Object::hashCode))
  .toList();
```

首先要想办法制造 hash 冲突的 StringBuilder，比较朴素的办法就是while循环里不断的new

`((hc ^ (hc >>> 16)) & 0x3F)` 这段其实就是hashMap 源码里的 `hash()`，0x3F即63, 是 hashMap里树化后的最小长度：

```java
static final int MIN_TREEIFY_CAPACITY = 64;

static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```

让 hash 等于 0 是为了让他们落在第一个bucket里。

构造这40个之后排序一下，之所以是40个，跟树化有关，要保证这40个 StringBuilder 恰好落在同一个 bucket里并形成红黑树。

```java
StringBuilder sb = Stream.generate(StringBuilder::new)
		.dropWhile(b -> Collections.binarySearch(list, b,
				Comparator.comparingInt(Object::hashCode)) < 0)
		.findFirst().get();
```

构造 sb 很简单，不断 new 一个StringBuilder，找到 hash碰撞的那一个 即可。

完事，当第二次执行 set.contains(sb) 时，因为会调用 compareTo ，而内容已经变化，所以会返回错误的值。


# 另一个高手的解法：

大同小异，都是大量生成，然后找碰撞，其他解法思路一样，只是找碰撞的方式不同。不过都很值得学习。

```java
List<StringBuilder> list = IntStream.range(0, 10_000_000)
.mapToObj(i -> new StringBuilder(0))
.filter(s -> ((s.hashCode() ^ s.hashCode() >>> 16) & 0xfff) == 0)
.sorted(Comparator.comparingInt(Object::hashCode))
.collect(Collectors.toList());

StringBuilder sb = list.remove(IntStream.range(1, list.size())
.filter(i -> list.get(i).hashCode() == list.get(i - 1).hashCode())
.findFirst()
.orElseThrow());
```