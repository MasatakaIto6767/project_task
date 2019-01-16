import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Replace {
    static void templateFile(List<String> templateList) {
        try {
            //ファイルのパスを指定
            File file = new File("/Users/itom817/Task_FE2/src/template.txt");
            //ファイルが存在しない場合は例外の発生
            if (!file.exists()) {
                System.out.println("ファイルが存在しません");
                return;
            }
            //BufferedReaderクラスのreadLineメソッドを使い１行ずつ読み込み表示する
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                templateList.add(data);
            }
            //ファイルを閉じてリソースを解放
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void defFile(List<String> defList) {
        try {
            //ファイルのパスを指定
            File file = new File("/Users/itom817/Task_FE2/src/replacement.txt");
            //ファイルが存在しない場合は例外の発生
            if (!file.exists()) {
                System.out.println("ファイルが存在しません");
                return;
            }
            //BufferedReaderクラスのreadLineメソッドを使い１行ずつ読み込み表示する
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                defList.add(data);
            }
            //ファイルを閉じてリソースを解放
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void defListLoop(List<String> defList, List<String> templateList) {
        //defListを１行ずつ取り出す
        for (int i = 0; i < defList.size(); i++) {
            String str = defList.get(i);
            //「：」の文字より前をkeyと後をvalueに設定
            int index = str.indexOf(":");
            String key = str.substring(0, index);
            String value = str.substring(index + 1);
            //placeholderの作成
            String placeholder = "<" + key + ">";

            //templateListを１行ずつ取り出す
            for (int k = 0; k < templateList.size(); k++) {
                String str1 = templateList.get(k);
                //取り出した１行を置換
                String replacedTemplate = str1.replace(placeholder, value);
                //templateListに置換済みのものを上書き
                templateList.set(k, replacedTemplate);
            }
        }
    }

    //上書きしたtemplateListを１行ずつ取り出して標準出力
    public static void main(String[] args) {
        List<String> templateList = new ArrayList<String>();
        templateFile(templateList);
        List<String> defList = new ArrayList<String>();
        defFile(defList);
        defListLoop(defList, templateList);
        for (int j = 0; j < templateList.size(); j++) {
            System.out.println(templateList.get(j));
        }
    }
}
