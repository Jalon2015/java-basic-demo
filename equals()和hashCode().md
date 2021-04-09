## 前言

大家好啊，我是汤圆，今天给大家带来的是《equals()和hashCode()》，希望对大家有帮助，谢谢

> 文章纯属原创，个人总结难免有差错，如果有，麻烦在评论区回复或后台私信，谢啦

## 简介

说到equals和hashCode，要先说下Object
我们都知道，这个Object是Java所有类的超类，其他类都是从Object直接或间接继承而来的
而Object中自带的equals和hashCode方法就是今天我们要谈论的话题

## 目录

- 什么是equals()方法

- 什么是hashCode()方法

- equals和hashCode有啥关系

- JS中的 == 和 ===

- 等等
## 正文
PS：正文可能比较长，显得有点啰嗦，需要看结论的可以直接跳到文末看总结
### 什么是equals方法
**equals方法用来比较两个对象的属性是否相等**

因为在Object中没有属性，所以就只比较了两个引用指向的对象是否相等
只要对象不相等，那么就返回false（其实这样对子类来说是很不友好的，太绝对了，请往下看）
如下所示：
```java
public class Object {
    public boolean equals(Object obj) {
        // 可以看到，官方括号的写法很规范（向老人家学习）
        return (this == obj);
    }
}
```
但是我们平时在定义类时，都或多或少会包含几个属性
比如下面的例子
```java
public class EqualsDemo {
    private int m;
    // 省略 getter,setter,constructor(m)
    public static void main(String[] args) {
        EqualsDemo demo1 = new EqualsDemo(1);
        EqualsDemo demo2 = new EqualsDemo(1);
        // 这里期望返回true，实际却是false
        System.out.println(demo1.equals(demo2));
    }

    // 这里延续Object的写法，只单纯地比较两个引用指向的对象是否相等
    @Override
    public boolean equals(Object o) {
        return this == o;
    }
}
```
其中定义了一个基本类型的属性 int m；
然后两个实例 demo1 和 demo2 都拥有相同的属性 m = 1;
**但是equals方法却返回false**
原因就是，equals方法没有正确地编写
> equals怎么才算正确编写呢？
**我们应该把属性也进行比对，而不是单纯地比较对象的引用**
（这就好比我们选一半，不能只看外在，而是要外在内在一起看，那样就。。。就太难了）
如下所示：
```java
public class EqualsDemo {
    private int m;
    // 省略 getter,setter,constructor(m)
    public static void main(String[] args) {
        EqualsDemo demo1 = new EqualsDemo(1);
        EqualsDemo demo2 = new EqualsDemo(1);
        // 这时就会返回true
        System.out.println(demo1.equals(demo2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // 加了下面这两行，对属性进了比对
        EqualsDemo that = (EqualsDemo) o;
        return m == that.m;
    }
}
```
上面看起来好像没什么问题了，但是实际运行却很容易出现空指针异常或者类型转换异常
因为equals方法中，我们在强转之前没有对参数 o 进行检查
> 检查什么呢？
检查两个地方
1. 首先要确保o不能为空null
2. 其次确保o是EqualsDemo类或者子类（父类行不行？不行，父类没有子类特有的属性，强转还是会报错）
代码如下：

```java

public class EqualsDemo {
    private int m;
    // 省略 getter,setter,constructor(m)
    public static void main(String[] args) {
        EqualsDemo demo1 = new EqualsDemo(1);
        EqualsDemo demo2 = new EqualsDemo(1);
        System.out.println(demo1.equals(demo2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // 加了这一行判断
        if (!(o instanceof EqualsDemo)) return false;
        EqualsDemo that = (EqualsDemo) o;
        return m == that.m;
    }
}
```
上面用到了instanceof来判断
instanceof的用法是 A instanceof B，用来判断A是否为B类或者B的子类
这样就可以防止空指针和转换异常的出现

**所以equals判断的内容总结下来就是三步**：
1. 判断两个引用指向的对象是否相等
2. 判断传来的参数是否为当前类或者当前类的子类
3. 比较各个属性值是否相等

> 如果属性是对象的引用，那第三步该怎么比呢？
那就有点像套娃了（什么？没听过套娃？强烈推荐你去看陈翔六点半，里面有很多套娃的案例）
比如下面的代码
```java

public class EqualsDemo {
    private int m;
    private String str;

    public static void main(String[] args) {
        EqualsDemo demo1 = new EqualsDemo(1, "JavaLover1");
        EqualsDemo demo2 = new EqualsDemo(1, "JavaLover1");
        System.out.println(demo1.equals(demo2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EqualsDemo)) return false;
        EqualsDemo demo = (EqualsDemo) o;
        // 主要是这行跟之前的不一样
        return m == demo.m && str.equals(demo.str);
    }
}
```
可以看到，多了一个String对象引用作为属性
那我们在比较的时候，根据套娃的原则，再次**利用String对象的equals方法进行比较即可**
其他的部分都一样

> 好了，现在equals方法写完了
真的吗？我不信（脑补画面中。。。）
因为还是有潜在的空指针异常
设想一下，上面是str真的会存在吗？如果str为null怎么办？
> 所以我们还要对str进行空指针判断，是这样吗？
是的，不过Java7以后可以简化操作，因为有了Objects工具类，它内置的equals方法可以帮你在比较两个对象的同时加上null判断
Objects.equals方法如下：
```java
public final class Objects {
    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
}
```
改了以后的equals()最终代码如下：
```java
 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EqualsDemo)) return false;
        EqualsDemo demo = (EqualsDemo) o;
        return m == demo.m && Objects.equals(str,demo.str);
    }
```
好了，万事俱备了，只欠东风
> 东风？什么东风？
东风就是你的父亲啊
如果是在子类中定义equals，那么还要考虑到父类（Object除外）
改了之后的代码如下：
```java

@Override
public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EqualsDemo)) return false;
        // 加了这一行
        if(!super.equals(o)) return false;
        EqualsDemo demo = (EqualsDemo) o;
        return m == demo.m && Objects.equals(str,demo.str);
        }
```
> 你可能想知道，为啥放到第三行？
那是因为前两行属于最外侧的判断
你可以这样想，如果传来的对象o是父类的对象，那么父类super的判断放在这个位置就很合适了
（因为此时`o instanceof EqualsDemo`肯定返回false,这样就省去了super.equals()的判断)

> 好了，我累了，可以结束了吗？
你真的累了吗？我不信
地球还没有毁灭，事情也还没有结束。
上面的instanceof有个很大的缺陷，就是违反了equals的对称性

下面我们先说下equals方法规范的5个特性：
1. 自反性：就是自己反过来跟自己比，要返回true；比如x.equals(x) == true
2. 对称性：就是x.equals(y) == true时，也要y.equals(y) == true
3. 传递性：就是x.equals(y) == true,同时y.equals(z) == true，那么x.equals(z) == true
4. 一致性：就是传说中的幂等性，即x.equals(y)调用多次，都应该返回一样的结果
5. 非空和空比较则返回false的特性：就是x.equals(y)中，如果x非空，而y空，则返回false

好了，回到instanceof，上面提到它没有满足对称性
是因为用了instanceof来做比较的话，Son.equals(Father)永远不会为真，而Father.equals(Son)却有可能为真，这就不对称了
所以干脆就让Father.equals(Son)也永远不为真
>那要怎么做呢？
答案就是instanceof的弟弟：getClass
instanceof用来判断是否为当前类或者子类
而getClass只用来判断是否为当前类
改了之后，代码如下
```java
public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(!super.equals(o)) return false;
        EqualsDemo demo = (EqualsDemo) o;
        return m == demo.m && Objects.equals(str,demo.str);
        }
```
看朋友们也累了，今天的equals方法就先到这里了
**下面总结侠equals判断的内容，总共就是三~四步（这次真的是结束了）**：
1. 判断两个引用指向的对象是否相等
2. 判断传来的参数是否为空
3. 判断传来的参数是否属于当前类
4. 如果有继承父类，则也需要调用父类的super.equals()方法（Object除外）
5. 最后比较各个属性值是否相等（如果属性为对象引用，则需要通过Objects.equals(a,b)方法来比较引用对象的属性值）

### 什么是hashCode()方法
hashCode也叫散列码（哈希码），它用来计算对象中所有属性的散列值
关于散列这里就不展开了，我们在这里只需要知道两点：
1. 散列值为整数，可以为负值
2. 散列值可以用来确定元素在散列表中的位置（有可能两个元素拥有相同的散列值，这个就是散列冲突）

在Object中，hashCode()是一个本地方法，因为Object没有属性，所以默认返回的是对象的内存地址
代码如下所示：
```java
public class Test2 {
    public static void main(String[] args) {
        Object t = new Object();
        int a = t.hashCode();
        System.out.println(Integer.toHexString(a)); // 输出 4554617c
    }
}
```
其中 4554617c 就是对象a的内存地址,这里转成16进制显示（是因为通常地址都是用16进制显示的，比如我们电脑的Mac地址）

下面总结下hashCode的几个特性：
1. 一致性：无论hashCode调用多少次，都应该返回一样的结果(这一点跟equals很像)
2. 跟随性（自己编的一个性）：如果两个对象的equals返回为真，那么hashCode也应该相等
3. 反过来，如果两个对象的equals返回为假，那么hashCode有可能相等，但是如果散列的足够好，那么通常来说hashCode()也不应该相等
4. 覆写equals方法时，一定要覆写hashCode方法

### equals和hashCode有什么联系呢？

hashCode和equals可以说相辅相成的，他俩共同协作用来判断两个对象是否相等

分开来看的话，他俩是没什么联系的，但是由于某些原因导致被联系上了（比如Map这个小月老）
下面来细说一下
我们知道 Map集合中的key是不能重复的，那它是怎么判断重复的呢？
就是通过equals和hashCode来判断的
下面是部分源码
```java
if (e.hash == hash &&
    ((k = e.key) == key || (key != null && key.equals(k))))
    return e;
```
可以看到，map先进行hash判断，然后进行equals判断
也就是说，hash是前提，如果hash都不相等，那equals就不用比较了（先计算hash的一个原因是计算hash比equals快得多）
所以我们在自定义对象时，如果覆写了equals，那么一定要记得覆写hashCode，

覆写代码如下：
```java
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(getClass() != o.getClass()) return false;
        if(!super.equals(o)) return false;
        EqualsDemo demo = (EqualsDemo) o;
        return m == demo.m && Objects.equals(str,demo.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m, str);
    }
```
其中Objects.hash有点类似于上面的Objects.equals()方法，很实用

> 如果只覆写了equals，没有覆写hashCode,会咋样呢？
结果就是：
当你创建两个对象（属性一致，但是内存地址不一致），作为key放到map中时就会被当成两个key来存放
同理可得，获取数据的时候，也是不一致的

只覆写equals没覆写hashCode的代码：可以看到，两次取到的值是不一样的
```java

public class HashCodeDemo{

    public static void main(String[] args) {
        HashCodeDemo demo1 = new HashCodeDemo(1);
        HashCodeDemo demo2 = new HashCodeDemo(1);
        Map<HashCodeDemo, Integer> map = new HashMap<>();
        map.put(demo1, 1);
        map.put(demo2, 2);
        System.out.println(map.get(demo1)); // 输出1
        System.out.println(map.get(demo2)); // 输出2
    }

    private int n;

    public HashCodeDemo(int n) {
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCodeDemo that = (HashCodeDemo) o;
        return n == that.n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
```
同时覆写equals和hashCode的代码：可以看到，两次取到的值都是一样的
```java

public class HashCodeDemo{

    public static void main(String[] args) {
        HashCodeDemo demo1 = new HashCodeDemo(1);
        HashCodeDemo demo2 = new HashCodeDemo(1);
        Map<HashCodeDemo, Integer> map = new HashMap<>();
        map.put(demo1, 1);
        map.put(demo2, 2);
        System.out.println(map.get(demo1)); // 输出2
        System.out.println(map.get(demo2)); // 输出2
    }

    private int n;

    public HashCodeDemo(int n) {
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCodeDemo that = (HashCodeDemo) o;
        return n == that.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m, str);
    }
    
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
```
Set集合也是同理，因为它内部的元素不重复就是依赖Map实现的
### == 和 ===

## 总结

## 后记

最后，感谢大家的观看，谢谢