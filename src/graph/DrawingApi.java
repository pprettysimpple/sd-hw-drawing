package graph;

public interface DrawingApi {
    double CIRCLE_RADIUS = 200;
    double NODE_RADIUS = 30;

    long getDrawingAreaWidth();

    long getDrawingAreaHeight();

    void drawCircle(Circle circle);

    void drawLine(Circle.Point from, Circle.Point to);
}
