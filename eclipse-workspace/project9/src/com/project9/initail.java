package com.project9;
import java.util.Scanner;
public class initail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("欢迎使用大保健app");
System.out.println("您是否使用:1是 2否:");
Scanner input =new Scanner(System.in);
car[] op= {new zairenCar("1号技师",500,1),new zaiwuCar("二号技师",700,8),new zaiwuCar("3号技师",1200,10),new zairenCar("4号技师",2000,3),new allCar("5号技师",1500,2,8)};
int i=input.nextInt();
if (i!=1) {
	System.out.println("欢迎下次光临");
}else {System.out.println("您可选择技师价目表：");
    System.out.println("序号\t技师编号\t价格\t花样一\t花样2");
	for(int a=0;a<op.length;a++){
		System.out.println((a+1)+"\t"+op[a].getName()+"\t"+op[a].getPrice()+"\t"+op[a].getZairen()+"\t"+op[a].getZaiwu());}	
	}System.out.println("请输入您要选择技师的数量:");
	int num=input.nextInt();
	int sum=0;
	int xum=0;
	String b="";
	String e="";
	int c=0;
    for(int x=1;x<=num;x++) {
    	System.out.println("第"+x+"个技师序号是:");
    	int a=input.nextInt();
    	switch(a) {
    	case 1:
    		b+="一号技师";
    		sum+=1;
    		c+=500;
    		break;
    	case 2:
    		e+="二号技师";
    		xum+=8;
    		c+=700;
    		break;
    	case 3:
    		e+="三号技师";
    		xum+=10;
    		c+=1200;
    		break;
    	case 4:
    		b+="四号技师";
    		sum+=3;
    		c+=2000;
    		break;
    	case 5:
    		b+="五号技师";
    		e+="五号技师";
    		sum+=2;
    		xum+=8;
    		c+=1500;
    		break;
    	}
    }
    System.out.println("请输入服务时间");
      int f=input.nextInt();
      System.out.println("您的账单为：");
      System.out.println("服务1技师有"+b+"服务1"+sum);
      System.out.println("服务2技师有"+e+"服务2"+xum);
      System.out.println("服务总价为:"+c*f);
    	
}
	}


