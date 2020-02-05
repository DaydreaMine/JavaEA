package com.skr;

import java.util.Arrays;

public class InitailTelphone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Telphone phone =new Telphone();
Telphone phone2=new Telphone(1.0f,1.5f,2.0f) ;
phone2.setScreen(2.0f);
System.out.println(phone2.getScreen());
}
}