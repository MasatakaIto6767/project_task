import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileToString {
    //ファイル内容を文字列化するメソッド
    public static String fileToString(File file) throws IOException {
        BufferedReader br = null;
        try {
            //ファイルを読み込むバッファードリーダーの作成
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            //読み込んだ文字列を保持するストリングバッファを用意
            StringBuffer sb = new StringBuffer();
            //ファイルから読み込んだ1文字を保存する変数
            int c;
            //ファイルから1文字ずつ読み込みバッファへ追加
            while ((c = br.read()) != -1) {
            sb.append((char) c);
        }
        //バッファの内容を文字列化して返す
        return sb.toString();
    }finally{
            //リーダーを閉じる
        br.close();
    }
}
    //fileToStringメソッドをテスト
    public static void fileTest() throws IOException{
    String s = fileToString(new File("/Users/itom817/Task_FE/src/replacement.txt"));
    System.out.println(s);
    }
}
