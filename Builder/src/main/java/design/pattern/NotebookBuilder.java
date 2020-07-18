package design.pattern;

class NotebookPro {
    private Processor processor;
    private Memory memory;
    private Storage storage;
    private Graphics graphics;
    private Keyboard keyboard;

    public NotebookPro() {
    }


    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }


    @Override
    public String toString() {
        return "NotebookPro{" +
                "processor=" + processor.name + '\n' +
                ", memory size=" + memory.size + "GB\n" +
                ", graphics=" + graphics.name + '\n' +
                ", storage size=" + storage.size + "GB\n" +
                ", keyboard language=" + keyboard.language +
                '}';
    }

    static class Processor {
        String name;

        public Processor(String name) {
            this.name = name;
        }
    }

    static class Memory {
        int size;

        public Memory(int size) {
            this.size = size;
        }
    }

    static class Graphics {
        String name;

        public Graphics(String name) {
            this.name = name;
        }
    }

    static class Storage {
        int size;

        public Storage(int size) {
            this.size = size;
        }
    }

    static class Keyboard {
        String language;

        public Keyboard(String language) {
            this.language = language;
        }
    }
}


abstract class NotebookProBuilder {
    protected NotebookPro notebookPro;

    public NotebookProBuilder() {
        notebookPro = new NotebookPro();
    }

    abstract NotebookProBuilder buildCPU(NotebookPro.Processor processor);

    abstract NotebookProBuilder buildMemory(NotebookPro.Memory memory);

    abstract NotebookProBuilder buildGraphics(NotebookPro.Graphics graphics);

    abstract NotebookProBuilder buildStorage(NotebookPro.Storage storage);

    abstract NotebookProBuilder buildKeyboard(NotebookPro.Keyboard keyboard);

    NotebookPro build() {
        return notebookPro;
    }
}

class NotebookPro2018Builder extends NotebookProBuilder {

    public NotebookPro2018Builder() {
        super();
    }

    @Override
    NotebookProBuilder buildCPU(NotebookPro.Processor processor) {
        this.notebookPro.setProcessor(processor);
        return this;
    }

    @Override
    NotebookProBuilder buildMemory(NotebookPro.Memory memory) {
        this.notebookPro.setMemory(memory);
        return this;
    }

    @Override
    NotebookProBuilder buildGraphics(NotebookPro.Graphics graphics) {
        this.notebookPro.setGraphics(graphics);
        return this;
    }

    @Override
    NotebookProBuilder buildStorage(NotebookPro.Storage storage) {
        this.notebookPro.setStorage(storage);
        return this;
    }

    @Override
    NotebookProBuilder buildKeyboard(NotebookPro.Keyboard keyboard) {
        this.notebookPro.setKeyboard(keyboard);
        return this;
    }

    @Override
    NotebookPro build() {
        return super.build();
    }
}

class NotebookSeller {
    private NotebookProBuilder notebookProBuilder;

    public NotebookSeller(NotebookProBuilder notebookProBuilder) {
        this.notebookProBuilder = notebookProBuilder;
    }

    public NotebookPro lowSpec() {
        return notebookProBuilder
                .buildCPU(new NotebookPro.Processor("2.2GHz 6 核心第八代 Intel Core i7 處理器"))
                .buildMemory(new NotebookPro.Memory(16))
                .buildGraphics(new NotebookPro.Graphics("Radeon Pro 555X 配備 4GB GDDR5 記憶體"))
                .buildStorage(new NotebookPro.Storage(256))
                .buildKeyboard(new NotebookPro.Keyboard("中文注音"))
                .build();
    }

    public NotebookPro highSpec() {
        return notebookProBuilder
                .buildCPU(new NotebookPro.Processor("2.6GHz 6 核心第八代 Intel Core i7 處理器"))
                .buildMemory(new NotebookPro.Memory(16))
                .buildGraphics(new NotebookPro.Graphics("Radeon Pro 560X 配備 4GB GDDR5 記憶體"))
                .buildStorage(new NotebookPro.Storage(512))
                .buildKeyboard(new NotebookPro.Keyboard("中文注音"))
                .build();
    }
}
