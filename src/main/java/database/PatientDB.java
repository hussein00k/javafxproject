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

public class PatientDB {
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

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "123456");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * from patient ;");
            while (resultSet.next()) {
                HBox hBox = new HBox();
                hBox.setSpacing(10);
                Text text = new Text(resultSet.getInt("id")+". " + resultSet.getString("name"));
                text.setFill(Color.GREEN);
                hBox.getChildren().addAll(text);
                text.setStyle("-fx-font: 14 arial;");
                HBox hBox1 = new HBox();
                Label label1 = new Label("Phone Number ");
                Text text1 = new Text(resultSet.getString("phone"));
                text1.setStyle("-fx-font: 14 arial;");
                hBox1.getChildren().addAll(label1, text1);
                HBox hBox2 = new HBox();
                Label label2 = new Label("Address ");
                Text text2 = new Text(resultSet.getString("address"));
                text2.setStyle("-fx-font: 14 arial;");
                hBox2.getChildren().addAll(label2,text2);
                HBox hBox3=new HBox();
                Label label3=new Label("Age ");
                Text textage=new Text(resultSet.getString("age"));
                textage.setStyle("-fx-font: 14 arial;");
                hBox3.getChildren().addAll(label3,textage);
                vBox.setMargin(hBox, new Insets(10, 0, 0, 60));
                vBox.setMargin(hBox1, new Insets(10, 0, 0, 90));
                vBox.setMargin(hBox2, new Insets(10, 0, 0, 90));
                vBox.setMargin(hBox3, new Insets(10, 0, 0, 90));
                vBox.getChildren().addAll(hBox, hBox1, hBox2,hBox3);
                int c=resultSet.getInt("id");
                statement1 = connect.createStatement();
                resultSet1 = statement1.executeQuery("SELECT name from consultant where id = "+resultSet.getInt("doctor_id"));
                while (resultSet1.next()) {
                    Text text3 = new Text("-Dr."+resultSet1.getString("name"));
                    text3.setFill(Color.BLUE);
                    vBox.getChildren().addAll(text3);
                    vBox.setMargin(text3, new Insets(0, 0, 0, 100));
                }
                statement2=connect.createStatement();
                resultSet2=statement2.executeQuery("SELECT * FROM hospital.condition where patient_id="+resultSet.getInt("id"));
                while (resultSet2.next()){
                    Text text4=new Text("Condition : "+resultSet2.getString("name"));
                    text4.setStyle("-fx-font: 14 arial;");
                    Text text5=new Text("Its Dgree from 1 to 10 is : "+resultSet2.getString("Dgree"));
                    text5.setStyle("-fx-font: 14 arial;");
                    text4.setFill(Color.RED);
                    text5.setFill(Color.RED);
                    vBox.getChildren().addAll(text4,text5);
                    vBox.setMargin(text4, new Insets(5, 0, 5, 100));
                    vBox.setMargin(text5, new Insets(5, 0, 5, 100));
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
    public void insert(String name,int age,String address,String phone,int doctor_id,int consultation_id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "batman2019ali");
            connect.prepareStatement("INSERT INTO `hospital`.`patient`\n" +
                    "(`name`,\n" +
                    "`phone`,\n" +
                    "`address`,\n" +
                    "`doctor_id`,\n" +
                    "`age`,\n" +
                    "`consultation_id`)\n" +
                    " VALUES\n" +
                    "('"+name+"',\n" +
                    "'"+phone+"',\n" +
                    "'"+address+"',\n" +
                    doctor_id+",\n" +
                    age+",\n" +
                    consultation_id+");").executeUpdate();

        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void insertC(String name,String dgree,int patient_id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "batman2019ali");
            connect.prepareStatement("INSERT INTO `hospital`.`condition`\n" +
                    "(`name`,\n" +
                    "`Dgree`,\n" +
                    "`patient_id`)\n" +
                    " VALUES\n" +
                    "('"+name+"',\n" +
                    "'"+dgree+"',\n" +
                    patient_id+");").executeUpdate();
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    }


