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

public class ConsultationDB {
    private Connection connect=null;
    private Statement statement=null;
    private Statement statement1=null;
    private Statement statement2=null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet=null;
    private ResultSet resultSet1=null;
    private ResultSet resultSet2=null;
    VBox vBox=new VBox();
    public ScrollPane display(){

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "batman2019ali");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * from consultation ;");
            while (resultSet.next()) {
                HBox hBox = new HBox();
                hBox.setSpacing(10);
                Text text = new Text(resultSet.getInt("id")+". " + resultSet.getString("name"));
                text.setFill(Color.GREEN);
                hBox.getChildren().addAll(text);
                text.setStyle("-fx-font: 18 arial;");
                HBox hBox1 = new HBox();
                Label label1 = new Label("Capacity ");
                label1.setStyle("-fx-font: 14 arial;");
                Text text1 = new Text(resultSet.getString("capacity"));
                text1.setStyle("-fx-font: 14 arial;");
                hBox1.getChildren().addAll(label1, text1);

                vBox.setMargin(hBox, new Insets(10, 0, 0, 60));
                vBox.setMargin(hBox1, new Insets(10, 0, 0, 90));
                vBox.getChildren().addAll(hBox, hBox1);
                statement1 = connect.createStatement();
                Text patientText=new Text("Patient : ");
                patientText.setStyle("-fx-font: 14 arial;");
                vBox.getChildren().add(patientText);
                vBox.setMargin(patientText, new Insets(5, 0, 5, 100));
                resultSet1 = statement1.executeQuery("SELECT name from patient where consultation_id = "+resultSet.getInt("id"));
                while (resultSet1.next()) {
                    Text text3 = new Text("-Patient name "+resultSet1.getString("name"));
                    text3.setFill(Color.BLUE);
                    text3.setStyle("-fx-font: 14 arial;");
                    vBox.getChildren().addAll(text3);
                    vBox.setMargin(text3, new Insets(5, 0, 5, 150));
                }
                statement2=connect.createStatement();
                resultSet2=statement2.executeQuery("SELECT * FROM hospital.hospital_doctor where consultation_id="+resultSet.getInt("id"));
                Text doctorText=new Text("Doctors : ");
                doctorText.setStyle("-fx-font: 14 arial;");
                vBox.getChildren().add(doctorText);
                vBox.setMargin(doctorText, new Insets(5, 0, 5, 100));
                while (resultSet2.next()){
                    Text text4=new Text("-Dr."+resultSet2.getString("name"));
                    text4.setFill(Color.RED);
                    text4.setStyle("-fx-font: 14 arial;");
                    Text text5=new Text("-Phone "+resultSet2.getString("phone"));
                    text5.setFill(Color.BLACK);
                    text5.setStyle("-fx-font: 14 arial;");
                    vBox.getChildren().addAll(text4,text5);
                    vBox.setMargin(text4, new Insets(5, 0, 5, 150));
                    vBox.setMargin(text5, new Insets(5, 0, 5, 170));
                }
                Line line=new Line(0.0,0.0,450.0,0);
                line.setStroke(Color.GREY);
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
    public void insert(String name,int capacity){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "batman2019ali");
            connect.prepareStatement("INSERT INTO `hospital`.`consultation`\n" +
                    "(`name`,\n" +
                    "`capacity`)\n" +
                    " VALUES\n" +
                    "('"+name+"',\n" +
                    capacity+");").executeUpdate();

        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void insertC(String name,String phone,String specialty,int number,int consultation_id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "batman2019ali");
            connect.prepareStatement("INSERT INTO `hospital`.`hospital_doctor`\n" +
                    "(`name`,\n" +
                    "`phone`,\n" +
                    "`specialty`,\n" +
                    "`number`,\n" +
                    "`consultation_id`)\n" +
                    " VALUES\n" +
                    "('"+name+"',\n" +
                    "'"+phone+"',\n" +
                    "'"+specialty+"',\n" +
                    number+",\n" +
                    consultation_id+");").executeUpdate();
        }catch (Exception ex){
            System.out.println("the error is"+ex);
        }
    }
}
