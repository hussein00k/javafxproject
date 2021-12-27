package desgin;

import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PrimaryDesgin {
    BorderPane borderPane=new BorderPane();
    SideButton btn1=new SideButton("Doctors");
    SideButton btn2=new SideButton("Patients");
    SideButton btn3=new SideButton("Consultation");
    SideButton btn4=new SideButton("Medication\n& Treatment");
    public StackPane p1=new StackPane();
    public StackPane p2=new StackPane();
    public StackPane p3=new StackPane();
    public StackPane p4=new StackPane();
    public StackPane addButton=new StackPane();
    public StackPane reButton=new StackPane();

    public BorderPane build(){
        p1.getChildren().add(btn1.but());
        p2.getChildren().add(btn2.but());
        p3.getChildren().add(btn3.but());
        p4.getChildren().add(btn4.but());

        //shadow
        DropShadow exitE = new DropShadow();
        exitE.setOffsetY(3.0);
        exitE.setOffsetX(3.0);
        exitE.setColor(Color.BLACK);
        DropShadow enterE=new DropShadow();
        enterE.setOffsetX(3.0);
        enterE.setOffsetY(3.0);
        enterE.setColor(Color.WHITE);

        StackPane stackPane=new StackPane();//primary stack pane
        StackPane topbar=new StackPane();//topbar stack pane
        //side rectangle
        Rectangle rectangle=new Rectangle();
        rectangle.setHeight(500);
        rectangle.setWidth(200);
        rectangle.setFill(Color.DARKVIOLET);
        //top rectangle
        Rectangle topRectangle=new Rectangle(1000,100,Color.DARKVIOLET);
        Text text=new Text("HOSPITAL MANAGMENT");
        text.setStyle("-fx-font: 24 arial;");
        text.setFill(Color.WHITE);
        text.setEffect(exitE);
        topbar.getChildren().addAll(topRectangle,text);
        VBox vBox=new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(p1,p2,p3,p4);
        stackPane.getChildren().addAll(rectangle,vBox);

        //shadow effect
        ////down add button
        Circle circle=new Circle(35,Color.DARKVIOLET);
        Text text1=new Text("+");
        text1.setFill(Color.WHITE);
        text1.setStyle("-fx-font: 28 arial;");
        addButton.getChildren().addAll(circle,text1);
        borderPane.setMargin(addButton, new Insets(300,18,12,12));
        //return button
        Circle circle1=new Circle(35,Color.LIMEGREEN);
        Text text2=new Text("VIEW");
        text2.setStyle("-fx-font: 14 arial;");
        text2.setFill(Color.WHITE);
        reButton.getChildren().addAll(circle1,text2);
        borderPane.setMargin(reButton, new Insets(300,18,12,12));
        //
        addButton.setOnMouseEntered(e->{
            addButton.setEffect(exitE);
        });
        addButton.setOnMouseExited(e->{
            addButton.setEffect(enterE);
        });
        reButton.setOnMouseEntered(e->{
            reButton.setEffect(exitE);
        });
        reButton.setOnMouseExited(e->{
            reButton.setEffect(enterE);
        });
        borderPane.setLeft(stackPane);
        borderPane.setTop(topbar);
        borderPane.setRight(addButton);
        return borderPane;
    }

    public StackPane stadd(){
        return addButton;
    }
    public StackPane streturn(){
        return reButton;
    }

}
