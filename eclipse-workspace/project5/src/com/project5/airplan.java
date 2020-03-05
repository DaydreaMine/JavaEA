package com.project5;

public class airplan extends Transport implements IFly{
	public void show() {
		name ="飞机";
		way ="空中";
		person=200;
	super.show();
	
	}
	@Override
	public void Fly() {
		// TODO Auto-generated method stub
		System.out.println("飞");
	}
}
