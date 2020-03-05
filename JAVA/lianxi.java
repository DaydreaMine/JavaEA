  1.
int a = 10;
    int b = 10;
    int c = 10;
    a = b++;    
    c = --a;    
    b = ++a;    
    a = c--;    
System.out.println("a="+a+",b="+b+",c="+c);
求出a  b  c的值

a=9 b=10 c=8

2.
int x = 4;
    int y =(x++)+(++x)+(x*10);
System.out.println("x="+x+",y="+y);        
求出x  y的值

x=6 y=70;

3
byte b = 10;
b++;          
b = b + 1;   
b=b+1;不兼容，左边byte型，右边int型

4.
public static void main(String[] args) {
          int i = 0;
          test(i);
          i = ++i;
         System.out.println("----" + i); //i=2
         i = i++;
         System.out.println("****" + i);  //i=2       
     }
     
     public static void test(int i){
         i++;
         System.out.println("++++" + i);  //i=1
     }

5.int x = 5, y = 6, z;
   A.z = ++x + y++;
  B.z = ++x + x++;
   C.x = ++x + x++；
  D.z = x > y ? ++x : y++; 
输出ABCD题目中x、y、z的值
A.x=6,y=7,z=12;
B.x=6,y=6,z=12
C.x=6+6;
D.z=6,y=7,x=6


6. String a ="aa";  
int c = 555;  
String b = a+"bbb"+c;  
double d = 5.66600;  
int e = (int) d;  
int f = 3;  
double g = 3.53; 
float h = 1.7f;  
int i = 1;  
System.out.println(b); 
System.out.println(e);  
System.out.println( f/i );  
System.out.println( g/f);  
System.out.println( h/f );
System.out.println(  9.5<8 );  
System.out.println( (int)'a' +  (int)'z' );  
System.out.println("A~Z："+((int)'A')+"~"+((int)'Z'));  
System.out.println("'A' < 'a':"+('A' < 'a'));


7.10011101  转换成八进制  和十六进制
235  9D

8. 
short price = ...; // 先计算出原价
short realPrice = price * 8 / 10; //再计算出打折之后的价格

问：这段代码是否正确？
如果正确，假设price  为100 ，那计算之后的
realPrice值为多少？如果不正确，应该怎么改正？
不正确 short realPrice =(short)price*8/10;

9.找错
	void public main(){   //publice void main(String[] args)  

			int i=1,j;  // int i=1;int j=0;

			float f1=0.1;  //f
			float f2=123;   //f
			long  l1=123141L,l2=88888888888;
			double d1=2e20,d2=124;
			byte b1=1,b2=2,b3=129;
			j=j+10;
			i=i/10;
			i=i*0.1;

			char c1='a',c2=125;   

			byte b=b1-b2;

			char c=c1+c2-1;   
			float f3=f1+f2;

			float f4=f1+f2*0.1;

			double d=d1*i+j;

			float f=(float)(d1*5+d2);
	
		}

10.已知a,b均是整型变量，写出将a,b两个变量中的值互换的程序
int   a=2;
int  b=3;
int  c=a;
a=b;
b=c;
a=a+b;
b=a-b;
int temp=0
temp=a;
a=b;
b=temp;

11.写出下列变量a和b的运算结果。

int a = 9 / 3;

int b = 9 % 2;

a=3;
b=1;

12.判断代码是否有错误，如有，请修改。

float a = 2.1;

float b = (double)20.9;  //double b=20.9;

int b3 = 210.9f +2.51;

int b4 = (int)20.9 + (int)2.51;//int b4=(int)(20.9+2.51);

13.java的命名规范
类名：首字母大写，如果2个单词或以上则每个单词首字母大写,不能以关键字,八大数据类型修饰符命名.



















