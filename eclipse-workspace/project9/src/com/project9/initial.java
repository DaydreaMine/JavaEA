package com.project9;
import java.util.Scanner;
public class initial {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("欢迎使用答答租车系统:");
		System.out.println("您是否要租车：1是 0否");
 car[] op= {new zairenCar("奥迪a6",500,5),new zaiwuCar("金皮",700,8),new zaiwuCar("松花江",1200,20),new zairenCar("大宇",2000,40),new allCar("依维柯",1500,10,5)};
 Scanner input =new Scanner(System.in);
 int num=input.nextInt();
if(num!=1) {  System.out.println("感谢您的使用");
  }else {
	  System.out.println("您可租车的类型及其价目表：");
	  System.out.println("序号\t汽车名称\t租金\t\t载人\t载物"
	  		+ "");
	  for(int i=0;i<op.length;i++) {
	  System.out.println((i+1)+"\t"+op[i].getName()+"\t"+op[i].getPrice()+"元/天"+"\t"+op[i].getZairen()+"人"+"\t"+op[i].getZaiwu()+"吨");
}
	  System.out.println("请输入您要租车的数量:");}
    int x=input.nextInt();
 
    double c=0;
    int b=0;
    String d="";
    String e="";
    int sum=0;
    for(int i=1;i<=x;i++) {
    	System.out.println(" 请输入第"+i+"个车的序号"); 
    	 int a =input.nextInt();
switch(a){
	case 1:
		d+="奥迪a6";
		sum+=500;
		b+=5;
		break;
	case 2:
		e+="金皮";
		sum+=700;
		c+=8;
		break;
	case 3:
		e+="松花江";
		sum+=1200;
		c+=20;
		break;
	case 4:
		d+="大宇";
		sum+=2000;
		b+=40;
		break;
	case 5:
		e+="依维柯";
		d+="依维柯";
		sum+=1500;
		b+=10;
		c+=5;
		break;				
}
    }
    System.out.println("请"
  		+ "输入租车天数");
  int f=input.nextInt();
  System.out.println("您的账单为：");
  System.out.println("载人的租车有"+d+"可载人量"+b);
  System.out.println("载重的租车有"+e+"可载重量"+c);
  System.out.println("租车总价为:"+sum*f);
	

	}
}
