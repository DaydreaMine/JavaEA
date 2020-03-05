package com.skr;

public class Dog extends animal {
	 public int age=20;
public void eat() {
	// TODO Auto-generated method stub
System.out.println("狗吃东西");
}
public void method() {
	System.out.println(super.age);
	 super.eat();
	eat();
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Dog other = (Dog) obj;
	if (age != other.age)
		return false;
	return true;
}
}

