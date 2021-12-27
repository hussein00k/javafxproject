//add , Return event
package sence;

import database.ConsultationDB;
import database.DoctorDB;
import database.MedAndTretDB;
import database.PatientDB;
import desgin.PrimaryDesgin;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class ARevent {
    Stage stage;
    Scene scene;
    Scene sceneadd;
    PrimaryDesgin pd;
    PrimaryDesgin pdadd;

    public ARevent(Stage stage, Scene scene, Scene sceneadd, PrimaryDesgin pd, PrimaryDesgin pdadd) {
        this.stage = stage;
        this.scene = scene;
        this.sceneadd = sceneadd;
        this.pd = pd;
        this.pdadd = pdadd;
    }
    //return 1
    public void re1(){
        pd.stadd().setOnMouseClicked(e->{
            stage.setTitle("add");
            stage.setScene(sceneadd);
            pdadd.build().setRight(pdadd.reButton);
        });
        pdadd.streturn().setOnMouseClicked(e->{
            stage.setTitle("screen1");
            DoctorDB doctorDB=new DoctorDB();
            pd.build().setCenter(doctorDB.display());
            scene.setRoot(pd.build());
            stage.setScene(scene);
        });
    }
    //return button for scene two
    public void re2(){
        pd.stadd().setOnMouseClicked(e->{
            stage.setTitle("add");
            stage.setScene(sceneadd);
            pdadd.build().setRight(pdadd.reButton);
        });
        pdadd.streturn().setOnMouseClicked(e->{
            stage.setTitle("screen2");
            PatientDB patientDB=new PatientDB();
            pd.build().setCenter(patientDB.display());
            scene.setRoot(pd.build());
            stage.setScene(scene);
        });
    }
    public void re3(){
        pd.stadd().setOnMouseClicked(e->{
            stage.setTitle("add");
            stage.setScene(sceneadd);
            pdadd.build().setRight(pdadd.reButton);
        });
        pdadd.streturn().setOnMouseClicked(e->{
            stage.setTitle("Consultation");
            ConsultationDB consultationDB=new ConsultationDB();
            pd.build().setCenter(consultationDB.display());
            scene.setRoot(pd.build());
            stage.setScene(scene);
        });
    }
    public void re4(){
        pd.stadd().setOnMouseClicked(e->{
            stage.setTitle("add");
            stage.setScene(sceneadd);
            pdadd.build().setRight(pdadd.reButton);
        });
        pdadd.streturn().setOnMouseClicked(e->{
            stage.setTitle("Consultation");
            MedAndTretDB medAndTretDB=new MedAndTretDB();
            pd.build().setCenter(medAndTretDB.display());
            scene.setRoot(pd.build());
            stage.setScene(scene);
        });
    }
}