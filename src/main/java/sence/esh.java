//event Scene Hangler
package sence;

import desgin.PrimaryDesgin;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class esh {
    Stage stage;
    PrimaryDesgin pd;
    Scene scene,scene2,scene3,scene4;
    DropShadow exitE = new DropShadow(5,5,5.0,Color.RED);

    public esh(Stage stage, PrimaryDesgin pd, Scene scene, Scene scene2, Scene scene3, Scene scene4) {
        this.stage = stage;
        this.pd = pd;
        this.scene = scene;
        this.scene2 = scene2;
        this.scene3 = scene3;
        this.scene4 = scene4;
    }
    public void re(){
        pd.p1.setOnMouseClicked(e->{
            stage.setTitle("screen1");
            stage.setScene(scene);
        });
        pd.p2.setOnMouseClicked(e->{
            stage.setTitle("screen2");
            stage.setScene(scene2);
        });
        pd.p3.setOnMouseClicked(e->{
            stage.setTitle("screen3");
            stage.setScene(scene3);
        });
        pd.p4.setOnMouseClicked(e->{
            stage.setTitle("screen4");
            stage.setScene(scene4);
        });
    }
}
