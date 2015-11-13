package heapsort;

import java.util.Random;
import java.util.Scanner;

public class RandomHeap extends Heapsort {

	public static void main (String[] args) {
		
		Scanner stdIn = new Scanner(System.in);
		Random rnd = new Random();
		
		System.out.println("ヒープソート");
		System.out.print("要素数:") ;
		
		int nx = stdIn.nextInt();
		int[] x = new int[nx] ;
		
		for (int i = 0 ; i < nx ; i++) {
			
			System.out.print("x[" + i + "]:") ;
			x[i] = rnd.nextInt(nx) + 1;
			System.out.println(x[i]) ;
		}
		
		heapSort (x , nx) ;
		
		System.out.println("昇順にソート");
		
		for (int i = 0 ; i < nx ; i++) {
			
			System.out.println("x[" + i + "]=" + x[i]) ;
		}
		
		System.out.println("test") ;
	}
}
