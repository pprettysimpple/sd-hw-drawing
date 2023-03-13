package graph;

import java.io.FileNotFoundException;

public abstract class Graph {
    public final String fileName;
    protected final DrawingApi drawingApi;
    protected Circle[] circles;

    public Graph(DrawingApi drawingApi, String fileName) {
        this.drawingApi = drawingApi;
        this.fileName = fileName;
    }

    public abstract int getVerticesCount();

    public abstract void readGraph() throws FileNotFoundException;

    public void drawGraph() {
        circles = new Circle[getVerticesCount()];
        drawNodes();
        drawEdges();
    }

    private void drawNodes() {
        long h = drawingApi.getDrawingAreaHeight();
        long w = drawingApi.getDrawingAreaWidth();
        Circle.Point center = new Circle.Point(w / 2., h / 2.);
        for (int i = 0; i < getVerticesCount(); i++) {
            drawNode(i, center);
        }
    }

    private void drawNode(int i, Circle.Point center) {
        int n = getVerticesCount();
        double alpha = Math.PI / 2. - i * 2. * Math.PI / n;
        circles[i] = new Circle(
                center.x + drawingApi.CIRCLE_RADIUS * Math.cos(alpha),
                center.y + drawingApi.CIRCLE_RADIUS * Math.sin(alpha),
                drawingApi.NODE_RADIUS
        );

        drawingApi.drawCircle(circles[i]);
    }

    protected abstract void drawEdges();
}
