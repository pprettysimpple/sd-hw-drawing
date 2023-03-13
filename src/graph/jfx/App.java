package graph.jfx;

import graph.DrawingApi;
import graph.Graph;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.function.BiFunction;

public class App {
    private final BiFunction<DrawingApi, String, Graph> getGraph;
    String fileName;

    public App(BiFunction<DrawingApi, String, Graph> getGraph, String fileName) {
        this.getGraph = getGraph;
        this.fileName = fileName;
    }

    public static class JavaFxApp extends Application {
        static BiFunction<DrawingApi, String, Graph> getGraph;

        public static void run() {
            launch();
        }

        @Override
        public void start(Stage mainStage) throws FileNotFoundException {
            Rectangle2D screenBounds = Screen.getPrimary().getBounds();

            Canvas canvas = new Canvas(screenBounds.getWidth(), screenBounds.getHeight());

            var api = new Api((int) screenBounds.getWidth(), (int) screenBounds.getHeight(), canvas);
            var graph = getGraph.apply(api, "graph.txt");
            graph.readGraph();
            graph.drawGraph();

            Group root = new Group();
            root.getChildren().add(canvas);
            mainStage.setScene(new Scene(root));
            mainStage.setTitle("Graph");
            mainStage.show();
        }
    }

    public void run() {
        JavaFxApp.getGraph = getGraph;
        JavaFxApp.run();
    }
}
