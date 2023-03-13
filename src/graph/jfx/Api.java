package graph.jfx;

import graph.Circle;
import graph.DrawingApi;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Api implements DrawingApi {
    private final GraphicsContext gc;
    private final int width;
    private final int height;

    public Api(int width, int height, Canvas canvas) {
        this.width = width;
        this.height = height;
        this.gc = canvas.getGraphicsContext2D();
    }

    @Override
    public long getDrawingAreaWidth() {
        return width;
    }

    @Override
    public long getDrawingAreaHeight() {
        return height;
    }

    @Override
    public void drawCircle(Circle circle) {
        gc.setFill(Color.BLACK);
        gc.fillOval(circle.point.x - circle.radius / 2., circle.point.y - circle.radius / 2., circle.radius, circle.radius);
    }

    @Override
    public void drawLine(Circle.Point from, Circle.Point to) {
        gc.setStroke(Color.GREEN);
        gc.strokeLine(from.x, from.y, to.x, to.y);
    }
}
