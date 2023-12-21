
/**
 * Write a description of class OldHouse here.
 *
 * Ngoc Lai
 * 
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;

public class OldHouseFX extends Application 
{
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        // Create sky
        Rectangle sky = new Rectangle(0, 0, 400, 400);
        sky.setFill(Color.SKYBLUE);

        // Create sun with glow effect
        Circle sun = new Circle(325, 70, 30, Color.YELLOW);
        Glow glow = new Glow(0.8);
        sun.setEffect(glow);

        // Create house
        Rectangle house = new Rectangle(100, 200, 200, 150);
        house.setFill(Color.LIGHTPINK);
        
        // Create roof
        Polygon roof = new Polygon();
        roof.getPoints().addAll(100.0,200.0,200.0,120.0,300.0,200.0);
        roof.setFill(Color.RED);
        
        // Create door
        Rectangle door = new Rectangle(180, 260, 40, 90);
        door.setFill(Color.WHITE);
        Circle doorknob = new Circle(210, 305, 5, Color.LIGHTPINK);

        // Create windows with innerShadow effect
        Rectangle window1 = new Rectangle(120, 220, 40, 40);
        window1.setFill(Color.LIGHTYELLOW);
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(5);
        innerShadow.setOffsetY(5);
        window1.setEffect(innerShadow);
        Line framev1 = new Line(140, 220, 140, 260);
        Line frameh1 = new Line(120, 240, 160, 240);

        Rectangle window2 = new Rectangle(240, 220, 40, 40);
        window2.setFill(Color.LIGHTYELLOW);
        window2.setEffect(innerShadow);
        Line framev2 = new Line(260, 220, 260, 260);
        Line frameh2 = new Line(240, 240, 280, 240);

        // Create clouds with moving animation 
        Circle cloud1 = new Circle(30, Color.WHITE);
        Circle cloud2 = new Circle(30, Color.WHITE);
        Circle cloud3 = new Circle(30, Color.WHITE);
        
        // Constant for the animation duration
        final double SEVEN_SEC = 7000.0;
        
        // Create Transition object
        TranslateTransition ttrans1 = new TranslateTransition(new Duration(SEVEN_SEC), cloud1);
        ttrans1.setFromX(25);
        ttrans1.setFromY(80);
        ttrans1.setToX(300);
        ttrans1.setToY(80);
        
        TranslateTransition ttrans2 = new TranslateTransition(new Duration(SEVEN_SEC), cloud2);
        ttrans2.setFromX(55);
        ttrans2.setFromY(80);
        ttrans2.setToX(330);
        ttrans2.setToY(80);
        
        TranslateTransition ttrans3 = new TranslateTransition(new Duration(SEVEN_SEC), cloud3);
        ttrans3.setFromX(85);
        ttrans3.setFromY(80);
        ttrans3.setToX(360);
        ttrans3.setToY(80);
        
        // Play animation
        ttrans1.play();
        ttrans2.play();
        ttrans3.play();
        

        root.getChildren().addAll(sky, sun, house, roof, door, doorknob, window1, framev1, frameh1, 
                                  window2,framev2, frameh2, cloud1, cloud2, cloud3);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("House Drawing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


    
    
