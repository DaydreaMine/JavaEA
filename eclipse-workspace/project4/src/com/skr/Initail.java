package com.skr;

public class Initail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Animal op1=new Animal();
Animal op2=new Dog();
Animal op3=new cat();
   Animal animal=new Dog();
   if(animal instanceof Dog) {
	   Dog dog2=(Dog)animal;
   }else{System.out.println("无法");}
   if(animal instanceof cat) {
	   cat op =(cat)animal;
   }else {
	   System.out.println("无法");
   }
op2.eat();
op1.eat();
op3.eat();
	}

}
