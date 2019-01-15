import java.util.List;

import static org.junit.Assert.*;

public class ReplaceTest {

    @org.junit.Test
    public void testFacade() {
        // --------------------------------------------------
        // 準備
        // --------------------------------------------------
        final String[] EXPECT_ARRAY = {
                "情報 太郎 様",
                "",
                "情報 太郎 様のお買い上げ明細は次の通りです。",
                "",
                "メモリ;5,000円",
                "",
                "---------------------------------",
                "",
                "合計;5,000円"
        };

        // --------------------------------------------------
        // 実行
        // --------------------------------------------------
        List<String> resultList = Replace.facade();

        // --------------------------------------------------
        // 確認
        // --------------------------------------------------
        // サイズが一致していること
        assertEquals(EXPECT_ARRAY.length, resultList.size());

        // 全ての行が、完全一致していること
        for (int resultIdx = 0; resultIdx < resultList.size(); resultIdx++) {
            assertEquals(EXPECT_ARRAY[resultIdx], resultList.get(resultIdx));
        }
    }

    @org.junit.Test
    public void testTemplateFile() {
    }
}
