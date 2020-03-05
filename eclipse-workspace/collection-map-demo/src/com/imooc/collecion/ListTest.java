package com.imooc.collecion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {
	
public List coursestoSelect;

public ListTest() {
	this.coursestoSelect=new ArrayList();
}
 
 public void testAdd() {
	 /**
	  * 用于往coursesToSelect中添加课程
	  */
	 course cr1=new course("1","语文");
	 coursestoSelect.add(cr1);
	 course temp=(course) coursestoSelect.get(0);
	 System.out.println("添加了课程："+temp.id+":"+temp.name);
	 
	 course cr2=new course("2","数学");
	 coursestoSelect.add(0, cr2);
	 course temp2=(course) coursestoSelect.get(0);
	 System.out.println("添加了课程："+temp2.id+":"+temp2.name);
	 
	 /**
	  * 以下方法会抛出数组下标越界异常
	  *  course cr3=new course("3","英语");
	 coursestoSelect.add(4, cr3);
	  */
	 
	 course[] c1= {new course("3","外语"),new course("4","音乐")};
			 coursestoSelect.addAll(Arrays.asList(c1));
			 course temp3=(course) coursestoSelect.get(2);
			 course temp4=(course) coursestoSelect.get(3);
			 System.out.println("添加了两门课程："+temp3.id+":"+temp3.name+
					 temp4.id+":"+temp4.name);
			 
	 course[] c2={new course("5","美术"),new course("6","体育")};
	 coursestoSelect.addAll(2,Arrays.asList(c2));
	 course temp5=(course) coursestoSelect.get(2);
	 course temp6=(course) coursestoSelect.get(3);
	 System.out.println("添加了两门课程："+temp5.id+":"+temp5.name+
			 temp6.id+":"+temp6.name);	 
 }
 
 /**
  * 取得List中元素的方法
  * @param args
  */
 public void testGet() {
	 int size =coursestoSelect.size();
	 System.out.println("有如下课程可选:");
	 for(int i=0;i<size;i++) {
		 course c=(course) coursestoSelect.get(i);
		 System.out.println("课程:"+c.id+":"+c.name);
		 
	 }
 }
	 public void testIterator(){
		 Iterator it=coursestoSelect.iterator();
		 System.out.println("有如下课程待选(通过迭代器访问):");
	     while(it.hasNext()) {
	    	 course c=(course) it.next();
	    	 System.out.println("课程:"+c.id+":"+c.name);
	     }	 
	 }
	 
	 /**
	  * for each 方法
	  */
	 public void testForEach() {
		 System.out.println("有如下课程待选(通过for each访问):");
		 for (Object obj:coursestoSelect) {
			 course c=(course) obj;
			 System.out.println("课程:"+c.id+":"+c.name);
		 }
	 }
	 
	 public void testModify() {
		 coursestoSelect.set(4, new course("7","毛概") );
	 }
	 /**
	  *  删除list中的元素
	  * @param args
	  */
	 public void testRemove() {
		//course c=(course) coursestoSelect.get(4);
		// System.out.println("课程:"+c.id+":"+c.name);
		 System.out.println("即将删除4位置课程");
 		// coursestoSelect.remove(4);
		 course[] CR= {(course) coursestoSelect.get(4),(course) coursestoSelect.get(5)};
		 coursestoSelect.removeAll(Arrays.asList(CR));
		 System.out.println("成功删除毛概课程");
		 testForEach();
	 }
	 
	 public static void main(String[]args) {
		 ListTest a=new ListTest();
		 a.testAdd();
		 a.testGet();
		 a.testIterator();
         a.testModify();
         a.testForEach();
         a.testRemove();
	
 }

}
