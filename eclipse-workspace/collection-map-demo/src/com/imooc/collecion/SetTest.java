package com.imooc.collecion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {
	
	public List<course>coursestoSelect;
	
	public SetTest() {
		coursestoSelect =new ArrayList<course>();
		
	}
	 public void testAdd() {
		 /**
		  * 用于往coursesToSelect中添加课程
		  */
		 course cr1=new course("1","语文");
		 coursestoSelect.add(cr1);
		 course temp=(course) coursestoSelect.get(0);
		// System.out.println("添加了课程："+temp.id+":"+temp.name);
		 
		 course cr2=new course("2","数学");
		 coursestoSelect.add(0, cr2);
		 course temp2=(course) coursestoSelect.get(0);
		// System.out.println("添加了课程："+temp2.id+":"+temp2.name);
		 
		 course[] c1= {new course("3","外语"),new course("4","音乐")};
				 coursestoSelect.addAll(Arrays.asList(c1));
				 course temp3=(course) coursestoSelect.get(2);
				 course temp4=(course) coursestoSelect.get(3);
				 
		 course[] c2={new course("5","美术"),new course("6","体育")};
		 coursestoSelect.addAll(2,Arrays.asList(c2));
		 course temp5=(course) coursestoSelect.get(2);
		 course temp6=(course) coursestoSelect.get(3);
		/** System.out.println("添加了两门课程："+temp5.id+":"+temp5.name+
			 temp6.id+":"+temp6.name);	*/ 
	 }
	 public void testForEach() {
		 System.out.println("有如下课程待选(通过for each访问):");
		 for (Object obj:coursestoSelect) {
			 course c=(course) obj;
			// System.out.println("课程:"+c.id+":"+c.name);
		 }
	 }

	public static void main(String[] args) {
		String[] strArr = new String[] {"1","2","4"};
		for (int i=0;i<=3;i++) {
			System.out.println(i);
		
		
		}
		
		
		// TODO Auto-generated method stub
		SetTest st=new SetTest();
		st.testAdd();
		st.testForEach();
		//创建一个学生对象
		student s1=new student("1","小明");
		System.out.println("欢迎同学"+s1.id+":"+s1.name);
//		创建一个scanner对象，接受输入的课程id
		Scanner console =new Scanner(System.in);
      	for(int i=0;i<3;i++) {
			System.out.println("输入课程名");
			String courseId=console.next();
			System.out.println("course is " + courseId);
		}

	}

}
