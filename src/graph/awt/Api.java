package graph.awt;

import graph.Circle;
import graph.DrawingApi;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Api implements DrawingApi {
    protected Frame frame;
    protected Graphics2D ga;

    public Api(Frame frame) {
        this.frame = frame;
        this.ga = (Graphics2D) frame.getGraphics();
    }

    @Override
    public long getDrawingAreaWidth() {
        return frame.getWidth();
    }

    @Override
    public long getDrawingAreaHeight() {
        return frame.getHeight();
    }

    @Override
    public void drawCircle(Circle circle) {
        ga.fill(new Ellipse2D.Float((float) (circle.point.x - circle.radius), (float) (circle.point.y - circle.radius), (float) (2 * circle.radius), (float) (2 * circle.radius)));
    }

    @Override
    public void drawLine(Circle.Point from,  Circle.Point to) {
        ga.drawLine((int) from.x, (int) from.y, (int) to.x, (int) to.y);
    }
}
