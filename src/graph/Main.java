package graph;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<DrawingApi, String, Graph> getGraph;

        final String graphType = args[0];
        if (graphType.equals("matrix")) {
            getGraph = MatrixGraph::new;
        } else if (graphType.equals("list")) {
            getGraph = ListGraph::new;
        } else {
            System.err.println("Unknown graph type: " + graphType);
            return;
        }

        final String apiType = args[1];
        if (apiType.equals("javafx")) {
            new graph.jfx.App(getGraph, "graph.txt").run();
        } else if (apiType.equals("awt")) {
            new graph.awt.App(getGraph, "graph.txt").run();
        } else {
            System.err.println("Unknown api type: " + apiType);
        }
    }
}