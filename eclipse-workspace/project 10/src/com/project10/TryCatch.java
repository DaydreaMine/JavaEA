package com.project10;

public class TryCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TryCatch tct=new TryCatch();
		int result=tct.test();
		System.out.println("test()方法，执行完毕，返回值为 "+result);
		int result2=tct.test2();
       System.out.println("test2()执行了");
    
	}
	public int test() {
	int divider=10;
	int result =100;
	try {
		while(divider>-1) {
			divider--;
			result =result+100/divider;
		}
		return result;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("循环抛出异常");
			return -1;
		}
	}

	public int test2() {
		int divider=10;
		int result=100;
		try {while(divider>-1) {
			divider--;
			result =result+100/divider;
		}
		return result;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("循环抛出异常");
			return result=999;
		}finally {
			System.out.println("这是finally");
			System.out.println("我是result"+result);
		}
	}
}
