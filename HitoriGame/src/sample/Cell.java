package sample;

import javafx.scene.layout.StackPane;

public class Cell extends StackPane {
    int column;
    int row;

    public Cell(int column, int row) {
        this.column = column;
        this.row = row;

        getStyleClass().add("cell");
        setOpacity(0.9);
    }

    public void select() {
        getStyleClass().remove("cell-highlight");
        getStyleClass().add("cell-highlight");
    }

    public void unSelect() {
        getStyleClass().remove("cell-highlight");
    }

    public void hoverSelect() {
        getStyleClass().remove("cell-hover-highlight");
        getStyleClass().add("cell-hover-highlight");
    }

    public void unHoverSelect() {
        getStyleClass().remove("cell-hover-highlight");
    }

    public String toString() {
        return this.column + "/" + this.row;
    }
}
