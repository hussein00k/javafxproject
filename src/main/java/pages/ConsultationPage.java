package pages;

import database.ConsultationDB;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import system.Consultation;
import system.Hospital_doctor;

public class ConsultationPage {
    public Text consultationText = new Text("Enter Consultation Information");
    public Label nameLabel = new Label("Consultation Name : ");
    public TextField nameTF = new TextField();
    public Label capacityLabel = new Label("Consultation Capacity : ");
    public TextField capacityTF = new TextField();
    public Button button = new Button("Save");

    public Text hDoctorText = new Text("Enter Hospital Doctor Information");
    public Label hDnameLabel = new Label("Hospital Doctor Name : ");
    public TextField hDnameTF = new TextField();
    public Label hDphoneLabel = new Label("Phone : ");
    public TextField hDphoneTF = new TextField();
    public Label hDspecialtyLabel=new Label("Specialty : ");
    public TextField hDspecialtyTF=new TextField();
    public Label hDnumberLabel=new Label("Number in Hospital : ");
    public TextField hDnumberTF=new TextField();
    public Label hDconsultation_idLabel=new Label("Consultation ID : ");
    public TextField hDconsultationTF=new TextField();

    public Button cbutton = new Button("Save");
    Consultation consultation=new Consultation("",0);
    ConsultationDB consultationDB=new ConsultationDB();
    VBox vBox=new VBox();
    public ScrollPane inputP() {
        StackPane consultationStack = new StackPane(consultationText);
        consultationText.setStyle("-fx-font: 14 arial;");
        VBox nameVbox = new VBox(nameLabel, nameTF);
        StackPane nameStack = new StackPane(nameVbox);
        VBox capacityVbox = new VBox(capacityLabel, capacityTF);
        StackPane capacityStack = new StackPane(capacityVbox);
        //Hospital Doctor input

        StackPane hDoctorTextStack = new StackPane(hDoctorText);
        hDoctorText.setStyle("-fx-font: 14 arial;");
        VBox hDnameVbox = new VBox(hDnameLabel, hDnameTF);
        StackPane hDnameStack = new StackPane(hDnameVbox);
        VBox hDphoneVbox = new VBox(hDphoneLabel, hDphoneTF);
        StackPane hDphoneStack = new StackPane(hDphoneVbox);
        VBox hDspecialtyVbox=new VBox(hDspecialtyLabel,hDspecialtyTF);
        StackPane hDspecialyStack=new StackPane(hDspecialtyVbox);
        VBox hDnumber=new VBox(hDnumberLabel,hDnumberTF);
        StackPane hDnumberStack=new StackPane(hDnumber);
        VBox hDcons_idVbox=new VBox(hDconsultation_idLabel,hDconsultationTF);
        StackPane hDcons_idStack=new StackPane(hDcons_idVbox);



        vBox.getChildren().addAll(consultationStack, nameStack, capacityStack,button,hDoctorTextStack, hDnameStack, hDphoneStack,hDspecialyStack,hDnumberStack,hDcons_idStack,cbutton);
        vBox.setMargin(consultationStack, new Insets(6, 300, 0, 40));
        vBox.setMargin(nameStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(capacityStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(button, new Insets(5, 250, 0, 40));
        vBox.setMargin(hDoctorTextStack, new Insets(6, 300, 0, 40));
        vBox.setMargin(hDnameStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(hDphoneStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(hDspecialyStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(hDnumberStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(hDcons_idStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(cbutton, new Insets(5, 250, 0, 40));

        button.setOnAction(e->{
            consultation=new Consultation(nameTF.getText(),Integer.parseInt(capacityTF.getText()));
            consultationDB.insert(consultation.getName(),consultation.getCapacity());
            nameTF.clear();
            capacityTF.clear();
        });
        cbutton.setOnAction(e->{
            Hospital_doctor hospital_doctor=new Hospital_doctor(hDnameTF.getText(),hDphoneTF.getText(),hDspecialtyTF.getText(),Integer.parseInt(hDnumberTF.getText()));
            consultationDB.insertC(hospital_doctor.getName(),hospital_doctor.getPhone(),hospital_doctor.getSpecialty(),hospital_doctor.getNumber(),Integer.parseInt(hDconsultationTF.getText()));
            hDnameTF.clear();
            hDphoneTF.clear();
            hDspecialtyTF.clear();
            hDnumberTF.clear();
        });
        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(vBox);
        return scrollPane;
    }
}
