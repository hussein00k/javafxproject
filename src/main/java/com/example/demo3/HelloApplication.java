package com.example.demo3;


import database.ConsultationDB;
import database.DoctorDB;
import database.MedAndTretDB;
import database.PatientDB;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import desgin.*;
import org.w3c.dom.Text;
import pages.ConsultationPage;
import pages.DoctorPage;
import pages.MedAndTret;
import pages.PatientPage;
import sence.ARevent;
import sence.esh;
import system.*;

public class HelloApplication extends Application {
    DoctorPage doctorPage=new DoctorPage();
    PatientPage patientPage=new PatientPage();
    ConsultationPage consultationPage=new ConsultationPage();
    MedAndTret medAndTret=new MedAndTret();
    DropShadow exitE = new DropShadow(5,5,5.0, Color.RED);
    @Override
    public void start(Stage stage) throws IOException {
        //scene2
        PrimaryDesgin pd2=new PrimaryDesgin();
        PatientDB patientDB=new PatientDB();
        pd2.build().setCenter(patientDB.display());
        pd2.p2.setEffect(exitE);
        Scene scene2=new Scene(pd2.build(),1000,600);
        //scene3
        PrimaryDesgin pd3=new PrimaryDesgin();
        ConsultationDB consultationDB=new ConsultationDB();
        pd3.build().setCenter(consultationDB.display());
        pd3.p3.setEffect(exitE);
        Scene scene3=new Scene(pd3.build(),1000,600);
        //scene4
        PrimaryDesgin pd4=new PrimaryDesgin();
        MedAndTretDB medAndTretDB=new MedAndTretDB();
        pd4.build().setCenter(medAndTretDB.display());
        pd4.p4.setEffect(exitE);
        Scene scene4=new Scene(pd4.build(),1000,600);
        //primary scene
        PrimaryDesgin pd1=new PrimaryDesgin();
        DoctorDB doctorDB=new DoctorDB();
        pd1.build().setCenter(doctorDB.display());
        pd1.p1.setEffect(exitE);
        Scene scene=new Scene(pd1.build(),1000,600);
        //
        esh event=new esh(stage,pd1,scene,scene2,scene3,scene4);
        event.re();
        esh event2=new esh(stage,pd2,scene,scene2,scene3,scene4);
        event2.re();
        esh event3=new esh(stage,pd3,scene,scene2,scene3,scene4);
        event3.re();
        esh event4=new esh(stage,pd4,scene,scene2,scene3,scene4);
        event4.re();
        //add scenes primary scene
        PrimaryDesgin pdadd1=new PrimaryDesgin();
        pdadd1.build().setCenter(doctorPage.inputD());
        Scene addScene=new Scene(pdadd1.build(),1000,600);
        ARevent arAddScene1=new ARevent(stage,scene,addScene,pd1,pdadd1);
        arAddScene1.re1();

        //add scene 2
        PrimaryDesgin pdadd2=new PrimaryDesgin();
        pdadd2.build().setCenter(patientPage.inputP());
        Scene addScene2=new Scene(pdadd2.build(),1000,600);
        ARevent arAddScene2=new ARevent(stage,scene2,addScene2,pd2,pdadd2);
        arAddScene2.re2();
        //add scene 3
        PrimaryDesgin pdadd3=new PrimaryDesgin();
        pdadd3.build().setCenter(consultationPage.inputP());
        Scene addScene3=new Scene(pdadd3.build(),1000,600);
        ARevent arAddScene3=new ARevent(stage,scene3,addScene3,pd3,pdadd3);
        arAddScene3.re3();
        //add scene 4
        PrimaryDesgin pdadd4=new PrimaryDesgin();
        pdadd4.build().setCenter(medAndTret.inputP());
        Scene addScene4=new Scene(pdadd4.build(),1000,600);
        ARevent arAddScene4=new ARevent(stage,scene4,addScene4,pd4,pdadd4);
        arAddScene4.re4();
        //
        stage.setTitle("screen1");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}