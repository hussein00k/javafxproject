package pages;
import database.DoctorDB;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import system.*;
import desgin.*;
import sence.*;

public class DoctorPage {
    public Text consultantText=new Text("Enter Consultant Information");
    public Label nameLabel=new Label("Doctor Name : ");
    public TextField nameTF=new TextField();
    public Label phoneLabel=new Label("Doctor Phone : ");
    public TextField phoneTF=new TextField();
    public Label specialtyLabel=new Label("Doctor Specialty : ");
    public TextField specialtyTF=new TextField();
    public Button button=new Button("Save");

    public Text gPractitonerText=new Text("Enter General Practitoner Information");
    public Label gnameLabel=new Label("Doctor Name : ");
    public TextField gnameTF=new TextField();
    public Label gphoneLabel=new Label("Doctor Phone : ");
    public TextField gphoneTF=new TextField();
    public Label gspecialtyLabel=new Label("Doctor Specialty : ");
    public TextField gspecialtyTF=new TextField();
    public Label gconidlabel=new Label("enter the contuslant #");
    public TextField gconidTF=new TextField();
    public Button gbutton=new Button("Save");

    public VBox vBox=new VBox();
    public Consultant consultant=new Consultant("", "","");
    DoctorDB doctorDB=new DoctorDB();
    public VBox inputD(){
        StackPane consultantStack=new StackPane(consultantText);
        consultantStack.setStyle("-fx-font: 14 arial;");
        VBox nameVbox=new VBox(nameLabel,nameTF);
        StackPane nameStack=new StackPane(nameVbox);
        VBox phoneVbox=new VBox(phoneLabel,phoneTF);
        StackPane phoneStack=new StackPane(phoneVbox);
        VBox specialtyVbox=new VBox(specialtyLabel,specialtyTF);
        StackPane specialtyStack=new StackPane(specialtyVbox);
        StackPane gPractitonerStack=new StackPane(gPractitonerText);
        gPractitonerStack.setStyle("-fx-font: 14 arial;");
        VBox gnameVbox=new VBox(gnameLabel,gnameTF);
        StackPane gnameStack=new StackPane(gnameVbox);
        VBox gphoneVbox=new VBox(gphoneLabel,gphoneTF);
        StackPane gphoneStack=new StackPane(gphoneVbox);
        VBox gspecialtyVbox=new VBox(gspecialtyLabel,gspecialtyTF);
        StackPane gspecialtyStack=new StackPane(gspecialtyVbox);
        VBox gconidVbox=new VBox(gconidlabel,gconidTF);
        StackPane gconidStack=new StackPane(gconidVbox);
        vBox.getChildren().addAll(consultantStack,nameStack,phoneStack,specialtyStack,button,gPractitonerStack,gnameStack,gphoneStack,gspecialtyStack,gconidStack,gbutton);
        vBox.setMargin(consultantStack,new Insets(7,300,0,40));
        vBox.setMargin(nameStack,new Insets(20,250,0,40));
        vBox.setMargin(phoneStack,new Insets(7,250,0,40));
        vBox.setMargin(specialtyStack,new Insets(7,250,0,40));
        vBox.setMargin(button,new Insets(7,250,0,40));
        vBox.setMargin(gPractitonerStack,new Insets(10,300,0,40));
        vBox.setMargin(gnameStack,new Insets(20,250,0,40));
        vBox.setMargin(gphoneStack,new Insets(7,250,0,40));
        vBox.setMargin(gspecialtyStack,new Insets(10,250,0,40));
        vBox.setMargin(gconidStack,new Insets(7,250,0,40));
        vBox.setMargin(gbutton,new Insets(7,250,0,40));

        button.setOnAction(e->{
            consultant=new Consultant(nameTF.getText(),phoneTF.getText(),specialtyTF.getText());
            doctorDB.insert(consultant.getName(),consultant.getPhone(),consultant.getSpecialty());
            System.out.println(consultant.getName()+consultant.getPhone()+consultant.getSpecialty());
        });
        gbutton.setOnAction(e->{
            Gerneral_Practitoner gerneral_practitoner=new Gerneral_Practitoner(gnameTF.getText(),gphoneTF.getText(),gspecialtyTF.getText());
            doctorDB.gInsert(gerneral_practitoner.getName(),gerneral_practitoner.getPhone(),gerneral_practitoner.getSpecialty(),Integer.parseInt(gconidTF.getText()));
        });
        return vBox;
    }

}

