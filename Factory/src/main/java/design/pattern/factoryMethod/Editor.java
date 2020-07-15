package design.pattern.factoryMethod;

import java.util.ArrayList;
import java.util.List;

abstract class Document {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    abstract void open();

    abstract void save();

    abstract void close();
}

abstract class Editor {
    private List<Document> docs = new ArrayList<>();

    void open(String file) {
        Document doc = createDocument();
        doc.setTitle(file);
        doc.open();
        docs.add(doc);
    }

    void save(Document doc) {
        doc.save();
    }

    void close(Document doc) {
        doc.close();
        docs.remove(doc);
    }

    void close() {
        for (Document doc : docs) close(doc);
    }

    abstract Document createDocument(); // Factory Method
}

class DocumentImpl extends Document {
    @Override
    void open() {
        System.out.println("Open Text File : " + this.getTitle());
    }

    @Override
    void save() {
        System.out.println("Save Text File : " + this.getTitle());
    }

    @Override
    void close() {
        System.out.println("Close Text File : " + this.getTitle());
    }
}

class TextEditor extends Editor {
    @Override
    Document createDocument() {
        return new DocumentImpl();
    }
}
