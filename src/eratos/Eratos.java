package eratos;

public class Eratos {
	
	 public static void main(String[] args){
		 
		int NT[] = new int[1000];
		 
		
		 
		 for(int i = 2 ; i < NT.length / 2 ; i++ ) {
			 
			 NT[i * 2] = 1 ;
		 }
		 
		 int p = 3 ;
		 
		 while ( p * p <= NT.length ) {
			 
			 for(int i = p ; i < NT.length / p ; i++ ) {
				 
				 NT[i * p] = 1 ;
			 }
			 
			 p++ ;
			 
			 while ( NT[p] == 1)		p++;
		 }
		 
		 for (int i = 2 ; i < NT.length ; i++) {
			 
			 if (NT[i] == 0 ) {
				 
				 System.out.println(i);
			 }
		 }
	 }

}
