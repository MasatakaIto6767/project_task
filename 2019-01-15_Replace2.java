import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceDetail {
    private static final String DEF_SEPARATOR = ":";

    private static String getPlaceholder(final String line) {
        int separatorPos = line.indexOf(DEF_SEPARATOR);
        String key = line.substring(0, separatorPos);
        return "<" + key + ">";
    }

    private static String getReplaceValue(final String line) {
        int separatorPos = line.indexOf(DEF_SEPARATOR);
        return line.substring(separatorPos + 1);
    }

    private static Map<String,String> file2ReplaceDefMap(final String filepath) {
        Map<String,String> map = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filepath)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String placeholder = getPlaceholder(line);
                String replaceValue = getReplaceValue(line);
                map.put(placeholder, replaceValue);
            }
        } catch (IOException e) { throw new RuntimeException(e); }

        return map;
    }

    private static List<String> file2ReplacedList(final String filepath, final Map<String,String> defMap) {
        List<String> resultList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filepath)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultList.add(replaceAllDef(line, defMap));
            }
        } catch (IOException e) { throw new RuntimeException(e); }
        return resultList;
    }


    private static String replaceAllDef(final String line, final Map<String,String> defMap) {
        String result = line;
        for (Map.Entry<String,String> entry : defMap.entrySet()) {
            result = result.replaceAll(entry.getKey(), entry.getValue());
        }
        return result;
    }

    static List<String> facade() {
        Map<String,String> defMap = file2ReplaceDefMap("src/replacement.txt");

        List<String> replacedList = file2ReplacedList("src/template.txt", defMap);

        return replacedList;
    }

    private static void outputResults(final List<String> resultList) {
        for (String result : resultList) {
            System.out.println(result);
        }
    }

    public static void main(String... args) {
        List<String> resultList = facade();
        outputResults(resultList);
    }
}
