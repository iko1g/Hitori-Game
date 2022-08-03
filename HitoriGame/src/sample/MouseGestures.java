package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class MouseGestures {

    boolean showHoverCursor = true;

    public void fillCell( Node node) {
        if( showHoverCursor) {
            node.hoverProperty().addListener(new ChangeListener<Boolean>(){

                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    System.out.println( observable + ": " + newValue);

                    if( newValue) {
                        ((Cell) node).hoverSelect();
                    } else {
                        ((Cell) node).unHoverSelect();
                    }

                    for( String s: node.getStyleClass())
                        System.out.println( node + ": " + s);
                }
            });
        }
        node.setOnMousePressed( onMousePressedEventHandler);
    }

    EventHandler<MouseEvent> onMousePressedEventHandler = event -> {
        Cell cell = (Cell) event.getSource();

        if( event.isPrimaryButtonDown()) {
            cell.select();
        } else if( event.isSecondaryButtonDown()) {
            cell.unSelect();
        }
    };
}