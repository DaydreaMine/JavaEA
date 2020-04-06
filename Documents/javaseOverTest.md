一、填空题（共20个题目，总计20分）
1.Java(  虚拟机  )就是一个虚拟的用于执 字节码文件 .class 的计算机。它是Java最核心的技术，是Java跨平台的基础。
2.使用Java开发应用程序包括编写源程序，编译源程序，解释并运行三个步骤，其中编译和解释分别需要使用(javac.exe)和 (java.exe) 实现。
3.一个十进制整数转换成八进制数后是1234，则它转为十六进制数后是 (29c) 。

4.Java中浮点数据类型包括float和double两种类型，其中float类型又被称作单精度类型，尾数可以精确到7位有效数字，在内存中占用(   4)个字节。

5.使用Math.random()返回带正号的 double值，该值大于等于0.0且小于1.0。使用该函数生成[30,60]之间的随机整数的语句是((int)(Math.random()*31)+30)

6.for循环的语法格式是for (表达式1;表达式2;表达式3) {循环体}，其中在整个循环过程中只执行一次的部分是 表达式1 。

7.Java中 (构造方法)与类名相同，没有(返回值)，在创建对象实例时由new运算符自动调用。

8.(Package)语句作为Java源文件的第一条语句，指明该源文件定义的类所在的包。

9.局部变量的名字与成员变量的名字相同，若想在该方法内使用成员变量，必须使用关键字 (this)

10.Java异常处理中，如果一个方法中出现了多个Checked异常，可以在方法声明中使用关键字(throws)声明抛出，各异常类型之间使用(,)分隔。

11.声明数组仅仅是给出了数组名字和元素的数据类型，要想真正地使用数组还必须为它 (分配内存空间) 。

12.Arrays类的binarySearch( ) 方法使用二分搜索法来搜索指定的数组，以获得指定的值。必须在进行此调用之前对数组进行(排序) ，否则否则结果是不确定的。

13.Object类有一个public方法是(toString()) ，一个对象通过调用该方法可以获得该对象的字符串表示。

14.StringBuilder类是StringBuffer类的替代类，两者的共同点是都是(可变长度字符串)，其中线程安全的类是 (StringBuffer) 。

15(集合)框架提供了一套性能优良、使用方便的接口和类，包括Collection和Map两大类，它们都位于 java.util 包中

16.(Treeset)是一种Collection类型的集合类，其中元素唯一，并采用二叉树作为存储结构，元素按照自然顺序排列。

17.Java IO流可以分为 (节点流)  和( 处理流 )两大类，其中前者处于IO操作的第一线，所有操作必须通过他们进行。

18.处于新建状态的线程被启动后，将进入线程队列排队等待CPU服务，此时它已经具备了运行条件，一旦轮到享用CPU资源时，就可以脱离创建它的主线程独立开始自己的生命周期。上述线程是处于(就绪)状态。

19.在线程通信中，调用 wait() 方法可以是当前线程处于(等待)，而为了唤醒一个等待的线程，需要调用的方法(notify())。

20.在Socket编程中，(ip)用来标志一台计算机，但是一台计算机上可能提供多种应用程序，使用 (端口号) 来区分这些应用程序。

二、选择题
有一段Java 程序，其中public类名是A1，那么保存它的源文件名可以是（ A  ）。（选择一项）

A A1.java
B. A1.class
C. A1
D. 都不对

在Java中，byte数据类型的取值范围是（ A ）。（选择一项）

A -128 ~ 127
B. -228 ~128
C. -255 ~ 256
D. -255 ~ 255

有以下方法的定义，请选择该方法的返回类型（ D ）。（选择一项）
method(byte x, double y) {
return (short)x/y*2;
}

A byte
B. short
C. int
D. double

以下选项中添加到代码中横线处会出现错误的是（ BD  ）。（选择二项）
public class Test {
public float aMethod(float a, float b) {
return 0;
}

}

A public float aMethod(float a, float b, float c) {
return 0;
}
B. public float aMethod(float c, float d) {
return 0;
}
C. public int aMethod(int a, int b) {
return 0;
}
D. private int aMethod(float a, float b) {
return 0;
}

阅读下列文件定入的Java代码，其执行结果是（D）。（选择一项）
public class Test {
public static void main(String[] args) {
char ch = ‘c’;
switch (ch) {
case ‘a’:
System.out.print(“a”); break;
case ‘b’:
System.out.print(“ab”);
case ‘c’:
System.out.print(“c”);
default:
System.out.print(“d”);
}
}
}

A a
B. b
C. c
D. cd

下面程序执行的结果是在屏幕上打印（B）次Java基础班。（选择一项）
for(int i=1;i<=10;i++){
if (i<5)
continue;
System.out.println(“Java基础班”);
}

A 5
B. 6
C. 7
D. 8

以下四个选项中和下面代码功能相同的是（B）。（选择一项）
int i = 1;
int sum = 0;
while (i <= 100) {
if (i % 2 == 0)
sum = sum + i;
i++;
}

A for (int x =1; x<=100;x++){ sum=sum+x;}
B. for (int x =0; x<=100;x+=2){ sum=sum+x;}
C. for (int x =1; x<=100;x+=2){ sum=sum+x;}
D. 上述全对

以下代码中错误的语句是（B）。（选择一项）
public class Something{
public static void main(String[] args){
final Other o=new Other();
new Something().addOne(o);//1
}
public void addOne( Other o){
o.i++;//2
o = new Other();//3
}
}
class Other{
public int i;
}

A 1
B. 2
C. 3
D. 没有错误

在Java中，以下程序编译运行后的输出结果为（D）。（选择一项）
public class Test {
int x, y;
Test(int x, int y) {
this.x = x;
this.y = y;
}
public static void main(String[] args) {
Test pt1, pt2;
pt1 = new Test(3, 3);
pt2 = new Test(4, 4);
System.out.print(pt1.x + pt2.x);
}
}

A 6
B. 34
C. 8
D. 7

下列选项中关于Java中类方法的说法错误的是（AC）。（选择二项）

A 在类方法中可用this来调用本类的类方法
B. 在类方法中调用本类的类方法时可直接调用
C. 在类方法中只能调用本类中的类方法
D. 在类方法中调用实例方法需要先创建对象

下列选项中关于Java中super关键字的说法正确的是（A）。（选择一项）

A super关键字是在子类对象内部指代其父类对象的引用
B. super关键字不仅可以指代子类的直接父类，还可以指代父类的父类
C. 子类通过super关键字只能调用父类的方法，而不能调用父类的属性
D. 子类通过super关键字可以调用父类的构造方法

编译运行如下Java代码，输出结果是（B）。（选择一项）
class Base {
public void method(){
System.out.print (“Base method”);
}
}
class Child extends Base{
public void methodB(){
System.out.print (“Child methodB”);
}
}
class Sample {
public static void main(String[] args) {
Base base= new Child();
base.methodB();
}
}

A Base method
B. Child methodB
C. Base method
Child methodB
D. 编译错误

在Java中，关于引用数据类型的类型转换说法正确的是（ AB ）。（选择二项）

A 引用数据类型的类型转换有向上转型和向下转型
B. 向下转型，必须转换成其真实子类型，而不能随意转换
C. 向下转型是自动进行的，也称隐式转换
D. 向上转型可以使用instanceof操作符来判断转型的合法性

在Java接口中，下列选项中属于有效的方法声明是（ AC ）。（选择二项）

A public void aMethod( );
B. final void aMethod( );
C. void aMethod(){ }
D. private void aMethod( );

以下选项中关于匿名内部类的说法正确的是（AB）。（选择二项）

A. 匿名内部类可以实现多个接口，或者继承一个父类
B. 匿名内部类不能是抽象类，必须实现它的抽象父类或者接口里包含的所有抽象方法
C. 匿名内部类没有类名，所以匿名内部类不等定义构造方法
D. 匿名内部类可以直接访问外部类的所有局部变量

阅读如下Java代码，在控制台输入"-1",执行结果是（ B ）。（选择一项）
public class Demo {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
System.out.print(“请输入数字：”);
try {
int num = input.nextInt();
if (num < 1 || num > 4) {
throw new Exception(“必须在1-4之间！”);
}
} catch (InputMismatchException e) {
System.out.println(“InputMismatchException”);
} catch (Exception e) {
System.out.println(e.getMessage());
}
}
}

A 输出：InputMismatchException
B. 输出：必须在1-4之间！
C. 什么也没输出
D. 编译错误

关于Integer类中的静态方法parseInt()方法说法正确的是（ BC ）。（选择二项）

A 将小数转换成整数
B. 将数字格式的字符串转成整数
C. 使用parseInt()方法可能抛出异常
D. 将单个字符转成整数

以下程序片段中可以正常编译的是（  C ）。（选择一项）

A String s = “Gone with the wind”;
String k = s+t;
String t = “good”;
B. String s = “Gone with the wind”;
String t;
t = s[3]+“one”;
C. String s = “Gone with the wind”;
String stanfard = s.toUpperCase();
D. String s = “home directory”;
String t = s – “directory”;

以下代码的执行结果是（ C ）。（选择一项）
Set s=new HashSet();
s.add(“abc”);
s.add(“abc”);
s.add(“abcd”);
s.add(“ABC”);
System.out.println(s.size());

A. 1
B. 2
C. 3
D. 4

File类中的isDirectory( )方法的作用是（ BD   ）。（选择二项）

A. 判断File对象封装的是否是文件
B. 判断File对象封装的是否是目录
C. 判断File对象中封装的是否是根目录
D. 返回值类型是boolean

阅读下列文件定入的JAVA代码，共有（ B  ）处错误。（选择一项）
import java.io.*;
public class TestIO {
public static void main(String []args){
String str =“文件写入练习”;
FileWriter fw = null; //1
try{
fw = new FileWriter(“c:\mytext.txt”); //2
fw.writerToEnd(str); //3
}catch(IOException e){ //4
e.printStackTrace();
}finally{
//此处省略关闭流
}
}
}

A 0
B. 1
C. 2
D. 3

以下选项中关于Java中线程控制方法的说法正确的是（  AD  ）。（选择二项）

A. join ( ) 的作用是阻塞指定线程等到另一个线程完成以后再继续执行
B. sleep ( ) 的作用是让当前正在执行线程暂停，线程将转入就绪状态
C. yield ( ) 的作用是使线程停止运行一段时间，将处于阻塞状态
D. setDaemon( )的作用是将指定的线程设置成后台线程

Java中线程安全问题是通过关键字（ C  ）解决的?。（选择一项）

A. finally
B. wait( )
C. synchronized
D. notify( )

ServerSocket的监听方法accept( )方法的返回值类型是（ C  ）。（选择一项）

A. Socket
B. void
C. Object
D. DatagramSocket

以下选项中关于Java中获取Class对象的方式正确的是（  DA  ）。（选择二项）

A. Class c1 = String.getClass( );
B. String str = new String(“bjsxt”);
Class clazz = str.class;
C. Class c1 = Integer.TYPE;
D. Class clazz = Class.forName(“java.lang.Object”);

三、判断题（正确√，错误×）
1.和C++相比，Java取消了指针，不再有多重继承，不需要手动回收垃圾。（  √  ）
2.Java具有一次编译，到处运行的特点，其含义是Java的源代码可以一次性编译成计算机的机器码，并在不同的平台上运行。（  √  ）
3.char 数据类型用来表示在ASCII编码表中的一个字符，在内存中占用1个字节空间，所以不能表示一个汉字。
（ × ）
4.赋值和条件运算符是运算级别最低的两种运算符，两者都具有自右向左的结合性。（ √  ）
5.多重循环是指一个循环体内又包含另一个完整的循环结构。外层循环变量变化一次，内层循环变量要从头到尾变化一遍。（ √ ）
6.任何可用递归解决的问题也能使用循环解决，递归既花时间又耗内存，在要求高性能的情况下尽量避免使用递归。（ × ）
7.访问权限是private的变量，只能在本类和与本类同一个包中的其他类使用。（ × ）
8.对于子类创建的一个对象，如果子类继承了父类的方法，未重写，则运行时调用子类的方法。（ × ）
9.ArithmeticException，ArrayIndexOutOfBoundsException，NullPointerException是运行时异常，而ClassNotFoundException，ClassCastException是Checked异常。（ × ）
10.数组的长度是确定的，数组一旦被创建，它的大小就是不可以改变的。但是其元素类型可以是不同类型，允许出现混合类型。（ × ）
11.创建数组后，系统会给每个数组元素一个默认值，如double型元素的默认值是0.0。（  √ ）
12.JK1.5后提供了自动装箱和自动拆箱功能，从而可以实现基本数据类型和对应包装类之间的自动转换，简化了操作。（ √   ）
13.java.sql.Date类和java.util.Date类的关系是前者是后者的父类，其中前者没有提供无参数构造方法，而后者可以提供无参数构造方法来获取当前时间。（  √  ）
14.Collection是Java集合顶级接口，其中的元素无序，唯一。Java平台不提供这个接口任何直接的实现。（  √  ）
15.Iterator接口可以遍历任何Collection接口的实现类，可以从一个Collection中使用iterator()方法来获取迭代器实例。迭代器取代了Java集合框架中的Enumeration。（  √  ）
16.序列化是指将字节序列转换成Java对象，只有实现了Serializable接口的类的对象才可以被序列化。（ × ）
17.一个进程可以包括多个线程。两者的一个主要区别是：线程是资源分配的单位，而进程CPU调度和执行的单位。（  ×  ）
18.用new关键字建立一个线程对象后，该线程对象就处于新生状态。处于新生状态的线程有自己的内存空间，通过调用start进入就绪状态。（  √  ）
19.TCP协议是一种面向无连接的、可靠的、基于字节流的传输层通信协议，该协议占用系统资源多、效率较低。（  ×  ）
20.Java反射技术中，对于一个private修饰的成员变量，可以再设置setAccessible(true)后进行暴力访问。（ √ ）

四、简答题
1.面向过程和面向对象的区别。
面向过程就是分析出解决问题所需要的步骤，然后用函数把这些步骤一步一步实现，使用的时候一个一个依次调用就可以了；面向对象是把构成问题事务分解成各个对象，建立对象的目的不是为了完成一个步骤，而是为了描叙某个事物在整个解决问题的步骤中的行为。

2.Error和Exception的区别。
Exception是java程序运行中可预料的异常情况，我们可以获取到这种异常，并且对这种异常进行业务外的处理
Error是java程序运行中不可预料的异常情况，这种异常发生以后，会直接导致JVM不可处理或者不可恢复的情况。所以这种异常不可能抓取到，比如OutOfMemoryError、NoClassDefFoundError等。

3.列举常用的字节输入流和输出流并说明其特点，至少5对。
FileInputStream 从文件系统中的某个文件中获得输入字节。FileOutputStream文件输出流是用于将数据写入File 或 FileDescriptor 的输出流。文件是否可用或能否可以被创建取决于基础平台。

ByteArrayInputStream 包含一个内部缓冲区，该缓冲区包含从流中读取的字节。内部计数器跟踪 read 方法要提供的下一个字节。
ByteArrayOutputStream此类实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用toByteArray() 和 toString() 获取数据。

FilterInputStream 包含其他一些输入流，它将这些流用作其基本数据源，它可以直接传输数据或提供一些额外的功能。
FileOutputStream文件输出流是用于将数据写入File 或 FileDescriptor 的输出流。文件是否可用或能否可以被创建取决于基础平台。

ObjectInputStream 用于恢复那些以前序列化的对象。
ObjectOutputStream 将 Java 对象的基本数据类型和图形写入 OutputStream。可以使用 ObjectInputStream 读取（重构）对象。通过在流中使用文件可以实现对象的持久存储。




4.创建线程的两种方式分别是什么？各有什么优缺点。
方式1：继承Java.lang.Thread类，并覆盖run() 方法。
     优势：编写简单；
     劣势：单继承的限制----无法继承其它父类，同时不能实现资源共享。
方式2：实现Java.lang.Runnable接口，并实现run()方法。
     优势：可继承其它类，多线程可共享同一个Thread对象；
     劣势：编程方式稍微复杂，如需访问当前线程，需调用Thread.currentThread()方法


5.简述基于UDP的Socket编程的主要步骤。
server
    1.构造DatagramSocket实例，指定本地端口。
    2.通过DatagramSocket的send和receive方法接收和发送DatagramPacket
    3.调用DatagramSocket的close()方法关闭。

