package chainhash;

public class Chain<K, D>{

	//ハッシュ構成
	class Node <K, D>{

		private K key ;
		private D data ;
		private Node<K, D> next ;

		Node(K key , D data , Node<K, D> next) {

			this.key = key ;
			this.data = data ;
			this.next = next ;
		}

		K getKey() {

			return key ;
		}

		D getValue() {

			return data ;
		}

		public int hashCode() {

			return key.hashCode();
		}
	}

	//ハッシュ表作成
	private int size ;
	private Node<K, D>[] table;

	public Chain(int capacity) {

		try{

			table = new Node[capacity];
			this.size = capacity ;

		}	catch (OutOfMemoryError e) {

			this.size = 0 ;
		}
	}

	//ハッシュ値求める
	public int hashValue(Object key) {

		return key.hashCode() % size ;
	}

	//キー値の探索
	public D search(K key) {

		int hash = hashValue(key) ;

		Node<K, D> p = table[hash] ;

		while (p != null) {

			if (p.getKey().equals(key))	return p.getValue();

			p = p.next ;
		}

		return null ;
	}

	//キー値，データの追加
	public int add (K key , D data) {

		int hash = hashValue(key) ;

		Node<K, D> p = table[hash] ;

		while (p != null) {

			//キー値がすでに入っていたら1を返す
			if (p.getKey().equals(key))	return 1 ;

			p = p.next ;
		}

		Node<K, D> temp = new Node<K, D> (key, data, table[hash]) ;

		table[hash] = temp ;

		return 0 ;
	}

	//キー値の削除
	public int remove(K key) {

		int hash = hashValue(key) ;

		Node<K, D> p = table[hash] ;
		Node<K, D> pp = null ;

		while (p != null) {

			//同じのを見つけたらそこに次の奴をぶちこむ
			if (p.getKey().equals(key)) {

				//一回目で見つけたら今の場所に次のをぶち込む
				if(pp == null)		table[hash] = p.next ;

				//二回目以降は前の奴の次（今のとこ）に次のをぶち込む
				else 				pp.next = p.next ;

				return 0 ;
			}

			pp = p ;
			p = p.next ;

		}

		return 1 ;
	}

	//ハッシュ表全表示
	public void dump () {

		for (int i = 0 ; i < size ; i++ ) {

			Node<K, D> p = table[i] ;

			System.out.printf("%02d  " , i) ;

			while (p != null) {

				System.out.printf ("→ %s (%s)  " , p.getKey() , p.getValue()) ;

				p = p.next ;
			}

			System.out.println() ;
		}
	}
}
