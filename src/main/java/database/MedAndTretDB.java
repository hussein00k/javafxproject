package database;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.sql.*;

public class MedAndTretDB {
    public Connection connect=null;
    public Statement statement=null;
    public Statement statement1=null;
    public Statement statement2=null;
    public PreparedStatement preparedStatement=null;
    public ResultSet resultSet=null;
    public ResultSet resultSet1=null;
    public ResultSet resultSet2=null;
    VBox vBox=new VBox();

    public ScrollPane display(){
        Text mtext=new Text("Medication");
        mtext.setStyle("-fx-font: 20 arial;");
        vBox.getChildren().add(mtext);
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "123456");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * from medication ;");
            while (resultSet.next()) {
                HBox hBox = new HBox();
                hBox.setSpacing(10);

                Text text = new Text(resultSet.getInt("id")+". " + resultSet.getString("name"));
                text.setFill(Color.GREEN);
                hBox.getChildren().addAll(text);
                text.setStyle("-fx-font: 18 arial;");
                HBox hBox1 = new HBox();
                Label label1 = new Label("For ");
                label1.setStyle("-fx-font: 14 arial;");
                Text text1 = new Text(resultSet.getString("day"));
                text1.setStyle("-fx-font: 14 arial;");
                hBox1.getChildren().addAll(label1, text1);
                HBox hBox2 = new HBox();
                Label label2 = new Label("For ");
                label2.setStyle("-fx-font: 14 arial;");
                Text text2 = new Text(resultSet.getString("time"));
                Text daytext=new Text(" day");
                daytext.setStyle("-fx-font: 14 arial;");
                text2.setStyle("-fx-font: 14 arial;");
                hBox2.getChildren().addAll(label2,text2,daytext);
                vBox.setMargin(mtext, new Insets(10, 0, 0, 30));
                vBox.setMargin(hBox, new Insets(10, 0, 0, 60));
                vBox.setMargin(hBox1, new Insets(10, 0, 0, 90));
                vBox.setMargin(hBox2, new Insets(10, 0, 0, 90));
                vBox.getChildren().addAll(hBox, hBox1, hBox2);
                int c=resultSet.getInt("id");
                statement1 = connect.createStatement();
                resultSet1 = statement1.executeQuery("SELECT name from patient where id = "+resultSet.getInt("patient_id"));
                while (resultSet1.next()) {
                    Text mtextp = new Text("patient "+resultSet1.getString("name"));
                    mtextp.setStyle("-fx-font: 14 arial;");
                    mtextp.setFill(Color.BLUE);
                    vBox.getChildren().addAll(mtextp);
                    vBox.setMargin(mtextp, new Insets(5, 0, 10, 100));
                }
                Line line1=new Line(0.0,0.0,450.0,0);
                line1.setStroke(Color.GREY);
                vBox.getChildren().add(line1);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        Text ttext=new Text("Treatment");
        ttext.setStyle("-fx-font: 20 arial;");
        vBox.getChildren().add(ttext);
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "batman2019ali");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * from treatment ;");
            while (resultSet.next()) {
                HBox hBox = new HBox();
                hBox.setSpacing(10);
                Text text = new Text(resultSet.getInt("id")+". " + resultSet.getString("name"));
                text.setFill(Color.GREEN);
                hBox.getChildren().addAll(text);
                text.setStyle("-fx-font: 14 arial;");
                HBox hBox2 = new HBox();
                Label label2 = new Label("for ");
                label2.setStyle("-fx-font: 14 arial;");
                Text text2 = new Text(resultSet.getString("time"));
                text2.setStyle("-fx-font: 14 arial;");
                hBox2.getChildren().addAll(label2,text2);
                vBox.setMargin(ttext, new Insets(10, 0, 0, 30));
                vBox.setMargin(hBox, new Insets(10, 0, 0, 60));
                vBox.setMargin(hBox2, new Insets(10, 0, 0, 90));
                vBox.getChildren().addAll(hBox,hBox2);
                int c=resultSet.getInt("id");
                statement1 = connect.createStatement();
                resultSet1 = statement1.executeQuery("SELECT name from patient where id = "+resultSet.getInt("patient_id"));
                while (resultSet1.next()) {
                    Text text3 = new Text("patient "+resultSet1.getString("name"));
                    text3.setFill(Color.BLUE);
                    text3.setStyle("-fx-font: 14 arial;");
                    vBox.getChildren().addAll(text3);
                    vBox.setMargin(text3, new Insets(5, 0, 10, 100));
                }
                Line line=new Line(0.0,0.0,450.0,0);
                vBox.getChildren().add(line);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(vBox);
        return scrollPane;
    }

    public void insertt(String name, String time, int patient_id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "batman2019ali");
            connect.prepareStatement("INSERT INTO `hospital`.`treatment`\n" +
                    "(`name`,\n" +
                    "`time`,\n" +
                    "`patient_id`)\n" +
                    " VALUES\n" +
                    "('"+name+"',\n" +
                    "'"+time+"',\n" +
                    patient_id+");").executeUpdate();

        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void insertm(String name,String day,String time,int patient_id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "batman2019ali");
            connect.prepareStatement("INSERT INTO `hospital`.`medication`\n" +
                    "(`name`,\n" +
                    "`day`,\n" +
                    "`time`,\n" +
                    "`patient_id`)\n" +
                    " VALUES\n" +
                    "('"+name+"',\n" +
                    "'"+day+"',\n" +
                    "'"+time+"',\n" +
                    patient_id+");").executeUpdate();
        }catch (Exception ex){
            System.out.println(ex);
        }


    }

}
