package chainhash;

import java.util.Scanner;

public class ChainHash {

	static Scanner stdIn = new Scanner(System.in) ;

	//データ
	static class Data {

		static final int NUM = 1 ;
		static final int NAME = 2 ;
		
		private Integer num ;
		private String name ;

		int keyCode() {

			return num ;
		}
		
		public String toString() {
			
			return name ;
		}

		void scanData(String guide , int sw) {

			System.out.println(guide + "するデータを入力．");

			if ( (sw & NUM) == NUM ) {
			
				System.out.print("番号: ") ;
				num = stdIn.nextInt();
			}
				
			if ( (sw & NAME) == NAME ) {
				
				System.out.print("名前: ") ;
				name = stdIn.next();
			}
		}
	}

	//メニュー
	enum Menu {

		ADD(		"データ追加"),
		REMOVE(		"データ削除"),
		SEARCH(		"データ探索"),
		DUMP(		"全データ表示"),
		TERMINATE(	"終了");

		private final String message ;

		static Menu MenuAt(int idx) {

			for (Menu m : Menu.values()){

				if(m.ordinal() == idx)	return m;
			}

			return null ;
		}

		Menu(String string) {

			message = string ;
		}

		String getMessage() {

			return message ;
		}
	}

	//メニュー選択
	static Menu SelectMenu() {

		int key ;

		do{

			for(Menu m : Menu.values()){

				System.out.printf("(%d) %s  " , m.ordinal(), m.getMessage());

				//3つ目まで表示したら改行
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal()){

					System.out.println() ;
				}
			}

			System.out.print(": ");
			key = stdIn.nextInt();

		}while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal()) ;
		//入力値が番号内でなければ繰り返す

		return Menu.MenuAt(key) ;

	}

	//メイン
	public static void main (String[] args) {

		Menu menu ;
		Data data ;
		Data temp = new Data() ;

		Chain<Integer , Data> hash = new Chain<Integer , Data>(13);

		do {

			switch (menu = SelectMenu()) {

			 case ADD :

				 data = new Data() ;
				 data.scanData("追加" , Data.NUM | Data.NAME );

				 if(hash.add(data.keyCode(), data) == 1l )	System.out.println("そのキー値はすでに登録済みです．");

				 break ;

			 case REMOVE :

				 temp.scanData("削除" , Data.NUM ) ;

				 if(hash.remove(temp.keyCode()) == 1)	System.out.println("該当するデータはありません．") ;

				 break ;

			 case SEARCH :

				 temp.scanData("探索" , Data.NUM );

				 Data t = hash.search(temp.keyCode()) ;

				 if ( t != null)	System.out.println("そのキーを持つデータは" + t + "です．") ;

				 else 				System.out.println("該当するデータはありません．") ;

				 break ;

			 case DUMP :

				 hash.dump();

				 break ;
			}

		}while (menu != Menu.TERMINATE) ;
	}
}
