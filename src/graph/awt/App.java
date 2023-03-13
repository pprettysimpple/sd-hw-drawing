package graph.awt;

import graph.DrawingApi;
import graph.Graph;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.function.BiFunction;

public class App {
    private final BiFunction<DrawingApi, String, Graph> getGraph;
    String fileName;

    public App(BiFunction<DrawingApi, String, Graph> getGraph, String fileName) {
        this.getGraph = getGraph;
        this.fileName = fileName;
    }

    public static class AwtApp extends Frame {
        static BiFunction<DrawingApi, String, Graph> getGraph;

        @Override
        public void paint(Graphics g) {
            var api = new Api(this);
            Graph graph = getGraph.apply(api, "graph.txt");
            try {
                graph.readGraph();
            } catch (FileNotFoundException e) { // no way to avoid try-catch, cause of signature
                RuntimeException exception = new RuntimeException("Failed to read file");
                exception.addSuppressed(e);
                throw exception;
            }
            graph.drawGraph();
        }

        public static void run() {
            Frame frame = new AwtApp();
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    System.exit(0);
                }
            });
            Dimension screenBounds = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setTitle("Graph");
            frame.setSize((int) screenBounds.getWidth(), (int) screenBounds.getHeight());
            frame.setVisible(true);
        }
    }

    public void run() {
        AwtApp.getGraph = getGraph;
        AwtApp.run();
    }
}
