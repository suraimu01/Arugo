package sannkaku;

import java.util.Scanner; // スキャナクラスのインポート宣言

public class Sankaku { // 三角形クラス
    public static void main(String[] args){ // メイン関数
        Scanner stdIn = new Scanner(System.in);
        // スキャナークラスのインスタンス生成，System.inは標準入出力ストリーム
        int n;

        System.out.println("三角形を表示します．"); // 見出し

        do{ // 短編の長さが正になるまで入力を催促
            System.out.print("短辺の長さは：");
            n = stdIn.nextInt(); // 整数値の読み込み（キーボードから）
        }while(n<0);

        for(int i=1;i<=n;i++){ // 二重ループ
            for(int j=1;j<=i;j++)
            // ここに注意，横方向の繰り返しが徐々に少なくなる
                System.out.print('*'); // *の表示，改行しないことに注意
                System.out.println(); // 改行
        }
    }
}