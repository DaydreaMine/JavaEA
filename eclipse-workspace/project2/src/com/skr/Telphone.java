package com.skr;

public class Telphone {
private float screen;
private	float cpu;
private	float mem;

public float getScreen() {
	return screen;
}
public void setScreen(float screen) {
	this.screen = screen;
}
public float getCpu() {
	return cpu;
}
public void setCpu(float cpu) {
	this.cpu = cpu;
}
public float getMem() {
	return mem;
}
public void setMem(float mem) {
	this.mem = mem;
}

public Telphone() {
	System.out.println("执行了无惨");
	}
public Telphone(float newscreen,float newcpu,float newmem) {
	if(screen<3.5) {
		screen=3.5f;
		System.out.println("参数有问题");
	}else {
	screen=newscreen;}
	cpu=newcpu;
	mem=newmem;
System.out.println("执行了有惨");
System.out.println((screen+cpu+mem));
}
}
