package nibun;

import java.util.Scanner;
		
public class Nibun {
	
	//二分探索
	static int binSearch (int[] a , int n , int key) {
		
		int pl = 0 ;
		int pr = n - 1 ;
		
		do {
			
			int pc = (pl + pr) / 2 ;
			
			if (a[pc] == key) 		return pc ; //探索成功
			
			else if (a[pc] < key) 	pl = pc + 1 ;//後半にずらす
			
			else					pr = pc - 1 ;//前半にずらす
			
		}while (pl <= pr) ;
		
		return -1 ;	//探索失敗
		
	}
	
	public static void main (String[] args){
		
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("要素数:");
		int num = stdIn.nextInt();
		
		int [] x = new int[num];
		
		System.out.print("x[0]:") ;
		x[0] = stdIn.nextInt();
		
		
		for(int i = 1; i < num ; i++ ) {
			
			do{
				System.out.print("x[" + i + "]:") ;
				x[i] = stdIn.nextInt();
				
			}while(x[i] < x[i - 1]) ;	//前の要素より小さいなら再入力
		}
		
		System.out.print("探索する値:") ;
		int ky = stdIn.nextInt();
		
		int idx = binSearch(x , num , ky) ;
		
		if(idx == -1) 	System.out.printf("探索失敗");
		
		else 			System.out.printf("値は" + idx );
	}
	
}
