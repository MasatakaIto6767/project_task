import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Replace {
    static Map<String,String> readFile2Map(final String filepath) {
        Map<String,String> map = new HashMap<>();

        //ファイルのパスを指定
        File file = new File(filepath);
        try (FileReader fileReader = new FileReader(file)) {
            //BufferedReaderクラスのreadLineメソッドを使い１行ずつ読み込み表示する
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                //「：」の文字より前をkeyと後をvalueに設定
                int index = data.indexOf(":");
                String key = data.substring(0, index);
                String value = data.substring(index + 1);
                //placeholderの作成
                String placeholder = "<" + key + ">";
                map.put(placeholder,value);
            }
            //ファイルを閉じてリソースを解放
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    static List<String> templateListLoop(final String filepath, final Map<String,String> defMap) {
        List<String> resultList = new ArrayList<String>();

        //ファイルのパスを指定
        File file = new File(filepath);
        try (FileReader fileReader = new FileReader(file)) {
            //BufferedReaderクラスのreadLineメソッドを使い１行ずつ読み込み表示する
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                resultList.add(defListLoop(defMap,data));
            }
            //ファイルを閉じてリソースを解放
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    static String defListLoop(final Map<String,String> defMap,final String line) {
        String result = line;
        //defListを１行ずつ取り出す
        for (Map.Entry<String,String> entry : defMap.entrySet()) {
            result = result.replaceAll(entry.getKey(), entry.getValue());
        }
        return result;
    }

    static List<String> facade() {
        Map<String,String> defMap = readFile2Map("src/replacement.txt");

        List<String> resultList = templateListLoop("src/template.txt",defMap);

        return resultList;
    }

    static void outputResults(final List<String> resultList) {
        for (String result : resultList) {
            System.out.println(result);
        }
    }

    public static void main(String... args) {
        // 主処理
        List<String> resultList = facade();

        // 結果を出力
        outputResults(resultList);
    }
}
