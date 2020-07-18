package design.pattern;

import org.junit.Test;

public class NotebookBuilderTest {

    @Test
    public void testNotebookSellWork() {
        NotebookPro2018Builder builder2018 = new NotebookPro2018Builder();
        NotebookSeller seller = new NotebookSeller(builder2018);

        NotebookPro myNotebook = seller.lowSpec();
        System.out.println(myNotebook);

        NotebookPro dreamNotebook = builder2018
                .buildCPU(new NotebookPro.Processor("2.9GHz 6 核心第八代 Intel Core i9 處理器"))
                .buildMemory(new NotebookPro.Memory(32))
                .buildStorage(new NotebookPro.Storage(4096))
                .buildKeyboard(new NotebookPro.Keyboard("英文"))
                .buildGraphics(new NotebookPro.Graphics("Radeon Pro 560X 配備 4GB GDDR5 記憶體"))
                .build();
        System.out.println(dreamNotebook);
    }
}
