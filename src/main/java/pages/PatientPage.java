package pages;

import database.DoctorDB;
import database.PatientDB;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import system.Condtion;
import system.Consultant;
import system.Patient;

public class PatientPage {
    public Text patieentText = new Text("Enter Patient Information");
    public Label nameLabel = new Label("Patient Name : ");
    public TextField nameTF = new TextField();
    public Label phoneLabel = new Label("Patient Phone : ");
    public TextField phoneTF = new TextField();
    public Label addressLabel = new Label("Patient Address : ");
    public TextField addressTF = new TextField();
    public Label ageLabel = new Label("Patient Age : ");
    public TextField ageTF = new TextField();
    public Label doctorLabel = new Label("Doctor ID : ");
    public TextField doctorTF = new TextField();
    public Label consultation_idLabel=new Label("Consultation ID : ");
    public TextField consultation_idTF=new TextField();
    public Button button = new Button("Save");

    public Text conditionText = new Text("Enter Patient Condition Information");
    public Label cnameLabel = new Label("Condition Name : ");
    public TextField cnameTF = new TextField();
    public Label cDgreeLabel = new Label("Condition Dgree : ");
    public TextField cDgreeTF = new TextField();
    public Label cpidLabel=new Label("Patient ID : ");//cpid=condition patient id
    public TextField cpidTF=new TextField();
    public Button cbutton = new Button("Save");
    public VBox vBox = new VBox();
    public Patient patient = new Patient("", 0, "", "");
    PatientDB patientDB=new PatientDB();
    public ScrollPane inputP() {
        StackPane patientStack = new StackPane(patieentText);
        patieentText.setStyle("-fx-font: 14 arial;");
        VBox nameVbox = new VBox(nameLabel, nameTF);
        StackPane nameStack = new StackPane(nameVbox);
        VBox phoneVbox = new VBox(phoneLabel, phoneTF);
        StackPane phoneStack = new StackPane(phoneVbox);
        VBox addressVbox = new VBox(addressLabel, addressTF);
        StackPane addressStack = new StackPane(addressVbox);
        VBox ageVbox = new VBox(ageLabel, ageTF);
        StackPane ageStack = new StackPane(ageVbox);
        VBox doctorVbox = new VBox(doctorLabel, doctorTF);
        StackPane doctorStack = new StackPane(doctorVbox);
        VBox consultation_idVbox = new VBox(consultation_idLabel, consultation_idTF);
        StackPane consultation_idStack = new StackPane(consultation_idVbox);

        //conditioin input

        StackPane pCondStack = new StackPane(conditionText);
        conditionText.setStyle("-fx-font: 14 arial;");
        VBox cnameVbox = new VBox(cnameLabel, cnameTF);
        StackPane cnameStack = new StackPane(cnameVbox);
        VBox cDgreeVbox = new VBox(cDgreeLabel, cDgreeTF);
        StackPane cDgreeStack = new StackPane(cDgreeVbox);
        VBox cpidVbox=new VBox(cpidLabel,cpidTF);
        StackPane cpidStack=new StackPane(cpidVbox);



        vBox.getChildren().addAll(patieentText, nameStack, phoneStack, addressStack, ageStack,doctorStack,consultation_idStack,button,conditionText,cnameStack, cDgreeStack, cpidStack,cbutton);
        vBox.setMargin(patieentText, new Insets(6, 300, 0, 40));
        vBox.setMargin(nameStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(phoneStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(addressStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(ageStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(doctorStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(button, new Insets(5, 250, 0, 40));
        vBox.setMargin(cnameStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(cDgreeStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(cpidStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(conditionText, new Insets(5, 250, 0, 40));
        vBox.setMargin(cbutton, new Insets(5, 250, 0, 40));
        vBox.setMargin(consultation_idStack, new Insets(5, 250, 0, 40));

        button.setOnAction(e->{
            Patient patient=new Patient(nameTF.getText(),Integer.parseInt(ageTF.getText()),addressTF.getText(),phoneTF.getText());
            patientDB.insert(patient.getName(),patient.getAge(),patient.getAddress(),patient.getPhone(),Integer.parseInt(doctorTF.getText()),Integer.parseInt(consultation_idTF.getText()));
        });
        cbutton.setOnAction(e->{
            Condtion condtion=new Condtion(cnameTF.getText(),cDgreeTF.getText());
            patientDB.insertC(condtion.getName(),condtion.getDgree(),Integer.parseInt(cpidTF.getText()));

        });
        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(vBox);
        return scrollPane;
    }
}
