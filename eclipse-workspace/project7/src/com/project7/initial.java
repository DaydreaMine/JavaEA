package com.project7;
import java.util.Scanner;
public class initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("欢迎使用答答租车系统：");
		System.out.println("您是否要租车：1是 0否");
		Scanner input =new Scanner(System.in);
		int i =input.nextInt();
		if (i ==1) {
			System.out.println("您可租车的类型及其价目表：");
			System.out.println("序号"+" 汽车名称"+"租金   "+" 容量");
			smallcar op1=new smallcar();
			DaYu op2=new DaYu();
			JinBei op3=new JinBei();
			SongHuaJang op4=new SongHuaJang();
			YiWeiKe op5=new YiWeiKe();
			System.out.println("1."+op1.name+op1.price+"元/天"+op1.zairen());
		}
	}

}
