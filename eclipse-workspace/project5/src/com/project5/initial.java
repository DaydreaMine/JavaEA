package com.project5;

public class initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Transport op1=new airplan();
car op2=new car();
Transport op3=new bus();
op1.show();
op2.show();
op3.show();
IFly ip1=new airplan();
ip1.Fly();
IFly ip2=new IFly() {

	@Override
	public void Fly() {
		// TODO Auto-generated method stub
	System.out.println("使用了匿名内部类");	
	}	
};
ip2.Fly();
	}

}

