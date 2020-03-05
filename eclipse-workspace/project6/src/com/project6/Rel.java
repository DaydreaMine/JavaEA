package com.project6;
import java.util.Scanner;
public class Rel extends Shape {
	public void inf() {
		System.out.println("请输入长度和宽度：");
	}
	Scanner input =new Scanner(System.in);
		@Override
	public void primeter() {
			double a=input.nextDouble();
			double b=input.nextDouble();

		// TODO Auto-generated method stub
System.out.println("周长为"+(a+b*2));
	}

	public void area() {
		double a=input.nextDouble();
		double b=input.nextDouble();

		// TODO Auto-generated method stub
System.out.println("面积为"+a*b);
	}

}
