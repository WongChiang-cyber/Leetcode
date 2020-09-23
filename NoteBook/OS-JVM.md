[TOC]

## JAVA内存结构

### JVM内存结构，各个部分的作用是什么

jvm内存分为：堆区，方法区（元数据区），程序计数器，本地方法栈，jvm虚拟机栈

其中前两个方法为所有线程公有的。

各个部分的作用见课本

### 堆和栈的区别是什么

线程共有/私有 存放的是 局部变量表，操作数栈，动态链接，方法出口/对象实例数据

不需要/需要垃圾回收机制

## JAVA垃圾回收

### 如何判断一个对象是否应该被回收

使用可达性分析的方法，从GC ROOTS出发，沿着引用链进行分析，如果该对象在该链上存在对其的引用，就不需要回收。

### GC Roots都有哪些（有些不懂）

- 虚拟机栈中引用的对象，比如各个线程的虚拟机栈中的局部变量，临时变量，参数等。
- 方法区中常量引用的对象，如字符串常量池中的引用。
- 本地方法栈中（Native方法）引用的对象
- java虚拟机内部的对象，如基本数据类型对应的class对象，常驻的异常对象，比如NullPointerException,OutOfMemoryException,还有系统类加载器
- 被同步锁（sychonized）持有的对象
- （不懂）放映java虚拟机内部情况的JMXBeam，JVMTI中注册的毁掉，本地的代码缓存



## 发生OOM的区域

根据Java doc的描述，OOM是指JVM的内存不够用了，同时垃圾收集器也无法提供更多的内存。从描述中可以看出，在JVM抛出OutOfMemoryError之前，垃圾收集器一般会出马先尝试回收内存。

从上面分析的Java数据区来看，除了程序计数器不会发生OOM外，哪些区域会发生OOM的情况呢？

1. **堆内存**，堆内存不足是最常见的发送OOM的原因之一。
   如果在堆中没有内存完成对象实例的分配，并且堆无法再扩展时，将抛出OutOfMemoryError异常，抛出的错误信息是“java.lang.OutOfMemoryError:Java heap space”。
   当前主流的JVM可以通过-Xmx和-Xms来控制堆内存的大小，发生堆上OOM的可能是存在内存泄露，也可能是堆大小分配不合理。
2. **Java虚拟机栈和本地方法栈**，这两个区域的区别不过是虚拟机栈为虚拟机执行Java方法服务，而本地方法栈则为虚拟机使用到的Native方法服务，在内存分配异常上是相同的。
   在JVM规范中，对Java虚拟机栈规定了两种异常：
   a. 如果线程请求的栈大于所分配的栈大小，则抛出StackOverFlowError错误，比如进行了一个不会停止的递归调用；
   b. 如果虚拟机栈是可以动态拓展的，拓展时无法申请到足够的内存，则抛出OutOfMemoryError错误。
3. **直接内存**：直接内存虽然不是虚拟机运行时数据区的一部分，但既然是内存，就会受到物理内存的限制。在JDK1.4中引入的NIO使用Native函数库在堆外内存上直接分配内存，但直接内存不足时，也会导致OOM。
4. **方法区**：随着Metaspace元数据区的引入，方法区的OOM错误信息也变成了“java.lang.OutOfMemoryError:Metaspace”
5. 对于旧版本的Oracle JDK，由于永久代的大小有限，而JVM对永久代的垃圾回收并不积极，如果往永久代不断写入数据，例如String.Intern()的调用，在永久代占用太多空间导致内存不足，也会出现OOM的问题，对应的错误信息为“java.lang.OutOfMemoryError:PermGen space”

| 内存区域   | 是否线程私有 | 是否会发生OOM |
| ---------- | ------------ | ------------- |
| 程序计数器 | 是           | 否            |
| 虚拟机栈   | 是           | 是            |
| 本地方法栈 | 是           | 是            |
| 方法区     | 否           | 是            |
| 直接内存   | 否           | 是            |
| 堆         | 否           | 是            |

## JAVA内存泄漏

由于java的JVM引入了垃圾回收机制，垃圾回收器会自动回收不再使用的对象，了解JVM回收机制的都知道JVM是使用引用计数法和可达性分析算法来判断对象是否是不再使用的对象，**本质都是判断一个对象是否还被引用**。那么对于这种情况下，由于代码的实现不同就会出现很多种内存泄漏问题（让JVM误以为此对象还在引用中，无法回收，造成内存泄漏）。

### 1、**静态集合类**
如HashMap、LinkedList等等。如果这些容器为静态的，那么它们的生命周期与程序一致，则容器中的对象在程序结束之前将不能被释放，从而造成内存泄漏。简单而言，长生命周期的对象持有短生命周期对象的引用，尽管短生命周期的对象不再使用，但是因为长生命周期对象持有它的引用而导致不能被回收。

### 2、**各种连接，如数据库连接、网络连接和IO连接等**
在对数据库进行操作的过程中，首先需要建立与数据库的连接，当不再使用时，需要调用close方法来释放与数据库的连接。只有连接被关闭后，垃圾回收器才会回收对应的对象。否则，如果在访问数据库的过程中，对Connection、Statement或ResultSet不显性地关闭，将会造成大量的对象无法被回收，从而引起内存泄漏。

### 3、**变量不合理的作用域**。
一般而言，一个变量的定义的作用范围大于其使用范围，很有可能会造成内存泄漏。另一方面，如果没有及时地把对象设置为null，很有可能导致内存泄漏的发生。

```java
public class UsingRandom {

		private String msg;

		public void receiveMsg(){
		
		readFromNet();// 从网络中接受数据保存到msg中
		
		saveDB();// 把msg保存到数据库中

}

}
```
```
123456789101112131415
```

**如上面这个伪代码**，通过readFromNet方法把接受的消息保存在变量msg中，然后调用saveDB方法把msg的内容保存到数据库中，此时msg已经就没用了，由于msg的生命周期与对象的生命周期相同，此时msg还不能回收，因此造成了内存泄漏。

实际上这个msg变量可以放在receiveMsg方法内部，当方法使用完，那么msg的生命周期也就结束，此时就可以回收了。还有一种方法，在使用完msg后，把msg设置为null，这样垃圾回收器也会回收msg的内存空间。

### 4、**内部类持有外部类**
如果一个外部类的实例对象的方法返回了一个内部类的实例对象，这个内部类对象被长期引用了，即使那个外部类实例对象不再被使用，但由于内部类持有外部类的实例对象，这个外部类对象将不会被垃圾回收，这也会造成内存泄露。

### 5、**改变哈希值**
当一个对象被存储进HashSet集合中以后，就不能修改这个对象中的那些参与计算哈希值的字段了，否则，对象修改后的哈希值与最初存储进HashSet集合中时的哈希值就不同了，在这种情况下，即使在contains方法使用该对象的当前引用作为的参数去HashSet集合中检索对象，也将返回找不到对象的结果，这也会导致无法从HashSet集合中单独删除当前对象，造成内存泄露

###  6、**举个例子-看你能否找出内存泄漏**

```java
import java.util.Arrays;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}

1234567891011121314151617181920212223242526272829
```

 **6.1原因分析**

上述程序并没有明显的错误，但是这段程序有一个内存泄漏，随着GC活动的增加，或者内存占用的不断增加，程序性能的降低就会表现出来，严重时可导致内存泄漏，但是这种失败情况相对较少。
代码的主要问题在pop函数，下面通过这张图示展现
假设这个栈一直增长，增长后如下图所示
![这里写图片描述](https://images2018.cnblogs.com/blog/981342/201804/981342-20180428150421031-1509154389.jpg)
当进行大量的pop操作时，由于引用未进行置空，gc是不会释放的，如下图所示
![这里写图片描述](https://images2018.cnblogs.com/blog/981342/201804/981342-20180428150429656-842490031.jpg)

从上图中看以看出，如果栈先增长，在收缩，那么从栈中弹出的对象将不会被当作垃圾回收，即使程序不再使用栈中的这些队象，他们也不会回收，因为栈中仍然保存这对象的引用，俗称过期引用，这个内存泄露很隐蔽。

**解决方法**

```java
public Object pop() {
    if (size == 0)
    throw new EmptyStackException();
    Object result = elements[--size];
    elements[size] = null;
    return result;
}
1234567
```

一旦引用过期，清空这些引用，将引用置空。
![这里写图片描述](https://images2018.cnblogs.com/blog/981342/201804/981342-20180428150436795-2072703019.jpg)

### 7、**缓存泄漏**

内存泄漏的另一个常见来源是缓存，一旦你把对象引用放入到缓存中，他就很容易遗忘，对于这个问题，可以使用WeakHashMap代表缓存，此种Map的特点是，当除了自身有对key的引用外，此key没有其他引用那么此map会自动丢弃此值

** 7.1代码示例**

```java
package com.ratel.test;

/**
 * @业务描述：
 * @package_name： com.ratel.test
 * @project_name： ssm
 * @author： ratelfu@qq.com
 * @create_time： 2019-04-18 20:20
 * @copyright (c) ratelfu 版权所有
 */
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class MapTest {
    static Map wMap = new WeakHashMap();
    static Map map = new HashMap();
    public static void main(String[] args) {
        init();
        testWeakHashMap();
        testHashMap();
    }



    public static void init(){
        String ref1= new String("obejct1");
        String ref2 = new String("obejct2");
        String ref3 = new String ("obejct3");
        String ref4 = new String ("obejct4");
        wMap.put(ref1, "chaheObject1");
        wMap.put(ref2, "chaheObject2");
        map.put(ref3, "chaheObject3");
        map.put(ref4, "chaheObject4");
        System.out.println("String引用ref1，ref2，ref3，ref4 消失");

    }
    public static void testWeakHashMap(){

        System.out.println("WeakHashMap GC之前");
        for (Object o : wMap.entrySet()) {
            System.out.println(o);
        }
        try {
            System.gc();
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("WeakHashMap GC之后");
        for (Object o : wMap.entrySet()) {
            System.out.println(o);
        }
    }
    public static void testHashMap(){
        System.out.println("HashMap GC之前");
        for (Object o : map.entrySet()) {
            System.out.println(o);
        }
        try {
            System.gc();
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("HashMap GC之后");
        for (Object o : map.entrySet()) {
            System.out.println(o);
        }
    }

}
/** 结果
 String引用ref1，ref2，ref3，ref4 消失
 WeakHashMap GC之前
 obejct2=chaheObject2
 obejct1=chaheObject1
 WeakHashMap GC之后
 HashMap GC之前
 obejct4=chaheObject4
 obejct3=chaheObject3
 Disconnected from the target VM, address: '127.0.0.1:51628', transport: 'socket'
 HashMap GC之后
 obejct4=chaheObject4
 obejct3=chaheObject3
 **/

123456789101112131415161718192021222324252627282930313233343536373839404142434445464748495051525354555657585960616263646566676869707172737475767778798081828384858687888990
```

![这里写图片描述](https://images2018.cnblogs.com/blog/981342/201804/981342-20180428150445132-511764820.jpg)
上面代码和图示主演演示WeakHashMap如何自动释放缓存对象，当init函数执行完成后，局部变量字符串引用weakd1,weakd2,d1,d2都会消失，此时只有静态map中保存中对字符串对象的引用，可以看到，调用gc之后，hashmap的没有被回收，而WeakHashmap里面的缓存被回收了。

### 8、**监听器和回调**

内存泄漏第三个常见来源是监听器和其他回调，如果客户端在你实现的API中注册回调，却没有显示的取消，那么就会积聚。需要确保回调立即被当作垃圾回收的最佳方法是只保存他的若引用，例如将他们保存成为WeakHashMap中的键。



## JAVA 类加载器



## JAVA进程和线程

