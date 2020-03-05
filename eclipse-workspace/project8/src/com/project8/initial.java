package com.project8;
import java.util.Scanner;
public class initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("欢迎使用答答租车系统:");
		System.out.println("您是否要租车：1是 0否");
		 
  Scanner input =new Scanner(System.in);
  int x=input.nextInt();
  if(x!=1) {
	  System.out.println("感谢您的使用");
  }else {
	  System.out.println("您可租车的类型及其价目表：");
	  System.out.println("序号 汽车名称 租金     容量");
	  System.out.println("1.  奥迪A6  500/天   载人:5人");
	  System.out.println("2.  通用gl8 700/天   载人:15人");
	  System.out.println("3.  金杯    600/天   载货:5吨");
	  System.out.println("4.  松花江  1500/天   载货:20吨");
	  System.out.println("5.  依维柯  1000/天   载人:10人 载货:8吨");
	  System.out.println("请输入您要租车的数量:");
	  int sum=0;
	  int zaizhong =0;
	  int zairen=0;
	  String aa="";
	  String ab="";
	  int num=input.nextInt();
	  for(int i=1;i<=num;i++) {
		  System.out.println("请输入第"+i+"辆车的序号");
		  int a=input.nextInt();
		  switch(a) {
		  case 1:
			  sum+=500;
			  zaizhong+=0;
			  zairen+=5;
			  aa+="奥迪";
			  break;
		  case 2:
			  sum+=700;
			  zaizhong+=0;
			  zairen+=15;
			  aa+="通用gl8";
			  break;
		  case 3:
			  sum+=600;
			  zaizhong+=5;
			  zairen+=0;
			  ab+="金杯";
			  break;
		  case 4:
			  sum+=1500;
			  zaizhong+=20;
			  zairen+=0;
			  ab+="松花江";
			  break;
		  case 5:
			  sum+=1000;
			  zaizhong+=8;
			  zairen+=10;
			  aa+="依维柯";
				ab+="依维柯";	  
			  break;
		  }
	  }
	  System.out.println("请"
	  		+ "输入租车天数");
	  int d=input.nextInt();
	  System.out.println("您的账单为：");
	  System.out.println("载人的租车有"+aa+"可载人量"+zairen);
	  System.out.println("载重的租车有"+ab+"可载重量"+zaizhong);
	  System.out.println("租车总价为:"+sum*d);
  }
  
	}

}
