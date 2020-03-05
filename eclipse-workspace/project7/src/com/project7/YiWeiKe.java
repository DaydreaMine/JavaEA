package com.project7;

public class YiWeiKe extends car implements ZaiHuo, ZaiRen {

	@Override
	public void zairen() {
		// TODO Auto-generated method stub
System.out.println("载人:10人 ");
	}

	@Override
	public void zaihuo() {
		// TODO Auto-generated method stub
System.out.println("载货:8吨");
	}
public void show() {
	name ="依维柯";
	price=2000;
}
}
