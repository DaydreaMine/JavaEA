//手动输入任意三个数，求三个数的和，差

import java.util.*;

class txt4{
	public static void main(String[] args){
		int sum=0;int sub =0;
		int[] a=new int[3];
		for (int i=0;i<3 ;i++ ) {
			System.out.println("输入一个数:");
			Scanner sc=new Scanner(System.in);
			int num=sc.nextInt();
			a[i]=num;
		}
		for (int j=0;j<3 ;j++ ) {
			sum+=a[j];
		}
		System.out.println(sum);
		for (int j=0;j<2 ;j++ ) {
		    sub=a[j+1]-a[j];
			System.out.println(sub);
            
	}
}
}