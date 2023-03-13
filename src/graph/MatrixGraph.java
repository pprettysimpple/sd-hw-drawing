package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MatrixGraph extends Graph {
    private ArrayList<ArrayList<Boolean>> graph;

    public MatrixGraph(DrawingApi drawingApi, String fileName) {
        super(drawingApi, fileName);
    }

    @Override
    public int getVerticesCount() {
        return graph.size();
    }

    @Override
    public void readGraph() throws FileNotFoundException {
        graph = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>(Collections.nCopies(n, false)));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean hasEdge = scanner.nextInt() == 1;
                graph.get(i).set(j, hasEdge);
            }
        }
    }

    @Override
    protected void drawEdges() {
        for (int i = 0; i < getVerticesCount(); i++) {
            for (int j = 0; j < getVerticesCount(); j++) {
                if (graph.get(i).get(j)) {
                    drawingApi.drawLine(circles[i].point, circles[j].point);
                }
            }
        }
    }

}
