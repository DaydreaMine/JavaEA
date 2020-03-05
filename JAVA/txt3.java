class txt3{

	public static void main(String[] args){
		int[][] odds=new int[10][];
		for(int i=0;i<10;i++){
			odds[i]=new int[i+1];}
			for(int i=0;i<odds.length;i++){
			for(int j=0;j<odds[i].length;j++){
				odds[i][0]=1;
				odds[i][i]=1;
				if(i>1&&j>0&&j<i){
			 odds[i][j]=odds[i-1][j-1]+odds[i-1][j];}
			 System.out.print(odds[i][j]);
			}System.out.println();
	}
}
}