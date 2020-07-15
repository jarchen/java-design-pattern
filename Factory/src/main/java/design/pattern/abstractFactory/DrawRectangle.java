package design.pattern.abstractFactory;

interface PointCornerFactory {
    Point getPoint();

    Corner getCorner();
}

interface Point {
    void line(int width);
}

interface Corner {
    void leftUp();

    void rightUp();

    void leftDown();

    void rightDown();
}

class PointImpl implements Point {
    @Override
    public void line(int width) {
        for (int i = 0; i < width; i++) System.out.print("●");
    }
}

class CornerImpl implements Corner {
    @Override
    public void leftUp() {
        System.out.print("↖");
    }

    @Override
    public void rightUp() {
        System.out.print("↗");
    }

    @Override
    public void leftDown() {
        System.out.print("↙");
    }

    @Override
    public void rightDown() {
        System.out.print("↘");
    }
}

class PointCornerFactoryImpl implements PointCornerFactory {
    @Override
    public Point getPoint() {
        return new PointImpl();
    }

    @Override
    public Corner getCorner() {
        return new CornerImpl();
    }
}

class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    void paint(PointCornerFactory factory) {
        Point point = factory.getPoint();
        Corner corner = factory.getCorner();

        corner.leftUp();
        point.line(width - 2);
        corner.rightUp();
        System.out.println();

        for (int i = 0; i < height - 2; i++) {
            point.line(width);
            System.out.println();
        }

        corner.leftDown();
        point.line(width - 2);
        corner.rightDown();
        System.out.println();
    }
}
