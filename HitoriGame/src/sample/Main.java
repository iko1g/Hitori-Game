package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    int rows = 8;
    int columns = 8;
    double width = 650;
    double height = 650;
    Image hitoriImage = new Image(getClass().getResourceAsStream("image2.png"));
    ImageView imageView = new ImageView(hitoriImage);


    @Override
    public void start(Stage primaryStage) throws Exception{
      try{
          BorderPane pane = new BorderPane();
          FlowPane topPane = new FlowPane();
          GridPane gridPane = new GridPane();

          Button resetButton = new Button("Reset");
          pane.setTop(topPane);
          topPane.setAlignment(Pos.CENTER);
          topPane.setVgap(8);
          topPane.setHgap(8);

          topPane.getChildren().addAll(resetButton);

          pane.setCenter(gridPane);
          gridPane.setAlignment(Pos.CENTER);

          Grid grid = new Grid(columns, rows, 562, 561);
          MouseGestures  mouseGestures = new MouseGestures();

          for(int row = 0 ; row < rows  ; row++){
              for(int column = 0 ; column < columns ; column++){
                Cell cell = new Cell(column, row);
                mouseGestures.fillCell(cell);
                grid.add(cell,column,row);
              }
          }

          resetButton.addEventHandler(ActionEvent.ANY, e -> {
              Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                      "Are you sure you want to clear the board?");
              alert.setTitle("Clear the board");
              Optional<ButtonType> result = alert.showAndWait();

              if (result.isPresent() && result.get() == ButtonType.OK) {
                  grid.reset();
              }
          });

          gridPane.getChildren().addAll(imageView,grid);

          Scene scene = new Scene(pane, width, height);
          scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
          primaryStage.setScene(scene);
          primaryStage.show();

      } catch( Exception e){
          e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
