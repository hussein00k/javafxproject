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

public class DoctorDB {
    private Connection connect=null;
    private Statement statement=null;
    private Statement statement1=null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet=null;
    private ResultSet resultSet1=null;
    public VBox vBox=new VBox();
    public HBox hBox3=new HBox();

    public ScrollPane display() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "batman2019ali");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * from consultant ;");
            while (resultSet.next()) {
                HBox hBox = new HBox();
                hBox.setSpacing(10);
                Text text = new Text(resultSet.getInt("id")+".Dr. " + resultSet.getString("name"));
                text.setFill(Color.GREEN);
                hBox.getChildren().addAll(text);
                text.setStyle("-fx-font: 18 arial;");
                HBox hBox1 = new HBox();
                Label label1 = new Label("Phone Number ");
                Text text1 = new Text(resultSet.getString("phone"));
                text1.setStyle("-fx-font: 14 arial;");
                hBox1.getChildren().addAll(label1, text1);
                HBox hBox2 = new HBox();
                Label label2 = new Label("Doctor Specialty ");
                Text text2 = new Text(resultSet.getString("specialty"));
                text2.setStyle("-fx-font: 14 arial;");
                hBox2.getChildren().addAll(label2, text2);
                vBox.setMargin(hBox, new Insets(10, 0, 0, 60));
                vBox.setMargin(hBox1, new Insets(10, 0, 0, 90));
                vBox.setMargin(hBox2, new Insets(10, 0, 0, 90));
                vBox.getChildren().addAll(hBox, hBox1, hBox2);
                int c=resultSet.getInt("id");
                statement1 = connect.createStatement();
                resultSet1 = statement1.executeQuery("SELECT * from general_practitioner where consultant_id = "+resultSet.getInt("id"));
                while (resultSet1.next()) {
                    Text text3 = new Text("-Priact Doctor name Dr."+resultSet1.getString("name"));
                    text3.setStyle("-fx-font: 14 arial;");
                    text3.setFill(Color.BLUE);
                    Text text4 = new Text("Number "+String.valueOf(resultSet1.getString("phone")));
                    text4.setStyle("-fx-font: 14 arial;");
                    Text text5 = new Text("Doctor Specialty "+resultSet1.getString("specialty"));
                    text5.setStyle("-fx-font: 14 arial;");
                    vBox.getChildren().addAll(text3,text4,text5);
                    vBox.setMargin(text3, new Insets(5, 0, 5, 100));
                    vBox.setMargin(text4, new Insets(5, 0, 5, 120));
                    vBox.setMargin(text5, new Insets(5, 0, 5, 120));
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
        public void insert(String name,String phone,String specialty){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "batman2019ali");
            connect.prepareStatement("INSERT INTO `hospital`.`consultant`\n" +
                    "(`name`,\n" +
                    "`phone`,\n" +
                    "`specialty`)\n" +
                    " VALUES\n" +
                    "('"+name+"',\n" +
                    "'"+phone+"',\n" +
                    "'"+specialty+"');").executeUpdate();

        }catch (Exception ex){
            System.out.println(ex);
        }

        }
        public void gInsert(String name,String phone,String specialty,int s) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "batman2019ali");
            connect.prepareStatement("INSERT INTO `hospital`.`general_practitioner`\n" +
                    "(`name`,\n" +
                    "`phone`,\n" +
                    "`specialty`,\n" +
                    "`consultant_id`)\n" +
                    "VALUES\n" +
                    "('"+name+"',\n" +
                    "'"+phone+"',\n" +
                    "'"+specialty+"',\n" +
                    s+");\n").executeUpdate();
        }catch (Exception ex){
        System.out.println(ex);
    }
}
}


