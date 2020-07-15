package design.pattern.factoryMethod;

import org.junit.Test;

public class EditorTest {

    @Test
    public void editorTest() {
        Editor editor = new TextEditor();
        editor.open("Main.java");
        editor.open("Editor.java");
        editor.close();
    }
}
