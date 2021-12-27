package pages;

import database.ConsultationDB;
import database.MedAndTretDB;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import system.Medication;
import system.Treatment;

public class MedAndTret {
    public Text medicationText = new Text("Enter Medication Information");
    public Label nameLabel = new Label("Medication : ");
    public TextField nameTF = new TextField();
    public Label mDayNumberLabel = new Label("Number of Day to take Medication : ");
    public TextField mDayNuberTF = new TextField();
    public Label mTimeLabel = new Label("Medication Time : ");
    public TextField mTimeTF = new TextField();
    public Label mPatientIdLabel = new Label("Patient ID : ");
    public TextField mPatientIdTF = new TextField();
    public Button button = new Button("Save");

    public Text treatmentText = new Text("Enter Treatment Information");
    public Label tNameLabel = new Label(" Treatment : ");
    public TextField tNameTF = new TextField();
    public Label tNumberDayLabel = new Label("Number of Day : ");
    public TextField tNumberDayTF = new TextField();
    public Label tPatienetIdLabel=new Label("Patient ID : ");
    public TextField tpIdTF=new TextField();
    public Button cbutton = new Button("Save");
    VBox vBox=new VBox();
    MedAndTretDB medAndTretDB=new MedAndTretDB();
    public ScrollPane inputP() {
        StackPane medicationTextStack = new StackPane(medicationText);
        medicationText.setStyle("-fx-font: 14 arial;");
        VBox nameVbox = new VBox(nameLabel, nameTF);
        StackPane nameStack = new StackPane(nameVbox);
        VBox mDayNumberVbox = new VBox(mDayNumberLabel, mDayNuberTF);
        StackPane mDayNumberStack = new StackPane(mDayNumberVbox);
        VBox mtimeVbox=new VBox(mTimeLabel,mTimeTF);
        StackPane mtimeStack=new StackPane(mtimeVbox);
        VBox mPatientIdVbox = new VBox(mPatientIdLabel, mPatientIdTF);
        StackPane mPatientIdStack = new StackPane(mPatientIdVbox);

        StackPane treatmentTextStack = new StackPane(treatmentText);
        treatmentText.setStyle("-fx-font: 14 arial;");
        VBox tNameVbox = new VBox(tNameLabel, tNameTF);
        StackPane tNameStack = new StackPane(tNameVbox);
        VBox tNumberDayVbox = new VBox(tNumberDayLabel, tNumberDayTF);
        StackPane tNumberDayStack = new StackPane(tNumberDayVbox);
        VBox tPatientVbox=new VBox(tPatienetIdLabel,tpIdTF);
        StackPane tPatientStack=new StackPane(tPatientVbox);

        vBox.getChildren().addAll(medicationTextStack, nameStack, mDayNumberStack,mtimeStack,mPatientIdStack,button,treatmentTextStack, tNameStack, tNumberDayStack,tPatientStack,cbutton);
        vBox.setMargin(medicationTextStack, new Insets(6, 300, 0, 40));
        vBox.setMargin(nameStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(mDayNumberStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(mtimeStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(mPatientIdStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(button, new Insets(5, 250, 0, 40));
        vBox.setMargin(treatmentTextStack, new Insets(6, 300, 0, 40));
        vBox.setMargin(tNameStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(tNumberDayStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(tPatientStack, new Insets(5, 250, 0, 40));
        vBox.setMargin(cbutton, new Insets(5, 250, 0, 40));

        cbutton.setOnAction(e->{
            //treatment
            Treatment treatment=new Treatment(tNameTF.getText(),tNumberDayTF.getText());
            medAndTretDB.insertt(treatment.getName(),treatment.getTime(),Integer.parseInt(tpIdTF.getText()));
        });
        button.setOnAction(e->{
            Medication medication=new Medication(nameTF.getText(),mDayNuberTF.getText(),mTimeTF.getText());
            medAndTretDB.insertm(medication.getName(),medication.getDay(),medication.getTime(),Integer.parseInt(mPatientIdTF.getText()));
        });

        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(vBox);
        return scrollPane;
    }
}
