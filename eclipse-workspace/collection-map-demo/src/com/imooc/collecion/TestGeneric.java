package com.imooc.collecion;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	
	public List<course>courses;
    public TestGeneric() {
    	this.courses=new ArrayList<course>();
    	
    }
    
    public void testAdd() {
    	course c1=new course("1","语文");
    	courses.add(c1);
    	//不能添加泛型以外对象
    	//courses.add("123");
    	course c2=new course("2","数学");
    	courses.add(c2);
    	
    }
    public void testForEach() {
    	for(course cr:courses) {
    		System.out.println(cr.id+":"+cr.name);
    	}
    }
    
    public void testChild() {
    	childcourse cc=new childcourse();
    	cc.id="3";
    	cc.name="子类";
    	courses.add(cc);
    }
    
    public void testBasicType() {
    	List<Integer>list=new ArrayList<Integer>();
    	list.add(1);
    	System.out.println("基本类型包装:"+list.get(0));
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGeneric t=new TestGeneric();
		t.testAdd();
		t.testForEach();
		t.testChild();
		t.testForEach();
		t.testBasicType();
		

	}

}
