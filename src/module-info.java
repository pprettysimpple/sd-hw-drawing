module HW {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.desktop;

    opens graph.jfx to javafx.graphics;
    exports graph;
}