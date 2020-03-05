class txt1{
public static void main(String[] args){
	String[] cha= {"A","BB","CCC","DDDD","E","FF","GGG","HH","I","J"};
	for (int i=0;i<cha.length;i++ ) {
		for(int j=i+1;j<cha.length;j++){
		if (cha[i].length()>cha[j].length()){
			String a=cha[i];
			cha[i]=cha[j];
			cha[j]=a;
		}
		}
		System.out.print(cha[i]);
	}
	
}
}