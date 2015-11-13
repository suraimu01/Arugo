package nibun;

import java.util.Random;
import java.util.Scanner;

public class Sortnibun {

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

	//配列要素入れ替え
	static void swap(int [] a , int idx1 , int idx2) {

		int t = a[idx1];	a[idx1] = a[idx2];	a[idx2] = t ;
	}

	//クイックソート
	static void quickSort(int[] a,int left , int right ){

		int pl = left ;
		int pr = right ;
		int x = a[(pl + pr) / 2] ; //中央要素

		do {
			while (a[pl] < x) pl++ ;
			while (a[pr] > x) pr-- ;

			if (pl <= pr)	swap(a, pl++ , pr--) ;

		}while (pl <= pr) ;

		if (left < pr) 	quickSort(a, left, pr) ;
		if (pl < right) quickSort(a, pl , right) ;
		
	}
	
	public static void main (String[] args){
		
		Scanner stdIn = new Scanner(System.in);
		
		Random rnd = new Random();
		
		System.out.print("要素数:");
		int num = stdIn.nextInt();
		
		int x [] = new int[num] ;
		
		for (int i = 0 ; i < num ; i++ ) {
			
			x[i] = rnd.nextInt(3000) + 1;
		}

		//ソートする
		quickSort(x, 0 , num - 1) ;
		
		System.out.print("キー入力:");
		int ky = stdIn.nextInt();
		
		//探索
		int idx = binSearch(x, num, ky);
		
		for (int i = 0 ; i < num ; i++) {
			
			System.out.println(i + "番目:" + x[i]);
		}
		
		if (idx == -1)		System.out.print("探索失敗");
		
		else 				System.out.print("要素数" + idx + "にあります");
		
	}
}

