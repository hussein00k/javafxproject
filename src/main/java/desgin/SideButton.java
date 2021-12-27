package desgin;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class SideButton {
    String context;
    public StackPane stackPane=new StackPane();
    public SideButton(String context) {
        this.context = context;

    }
    public StackPane but(){
        StackPane stackPane=new StackPane();
        Rectangle rectangle=new Rectangle(190,119, Color.WHITE);
        Text text=new Text(context);
        text.setStyle("-fx-font: 18 arial;");
        text.setFill(Color.GREY);
        Text text1=new Text();
        text1.setStyle("-fx-font: 12 arial;");
        text1.setFill(Color.GREY);
        text1.setText("some desdjkj");
        DropShadow exitE = new DropShadow();
        exitE.setOffsetY(3.0);
        exitE.setOffsetX(3.0);
        exitE.setColor(Color.RED);
        stackPane.getChildren().addAll(rectangle,text);

        stackPane.setOnMouseEntered(e ->{
            rectangle.setFill(Color.LINEN);
            rectangle.setWidth(200);
            text.setFill(Color.BLACK);
            stackPane.setEffect(exitE);
        });
        stackPane.setOnMouseExited(e ->{
            rectangle.setFill(Color.WHITESMOKE);
            rectangle.setWidth(190);
            text.setFill(Color.GREY);
            stackPane.setEffect(null);
        });
        return stackPane;
    }

}
