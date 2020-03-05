package com.project6;
import java.util.Scanner;
public class yuan extends Shape {

	@Override
	public void inf() {
		// TODO Auto-generated method stub
		System.out.println("请输入半径：");
	}
	Scanner input = new Scanner(System.in);
	@Override
	public void primeter() {
		// TODO Auto-generated method stub
		double c=input.nextDouble();
   System.out.println(6*c);
	}

	@Override
	public void area() {
		// TODO Auto-generated method stub
		double c=input.nextDouble();
		   System.out.println(3*c*c);
	}

}
