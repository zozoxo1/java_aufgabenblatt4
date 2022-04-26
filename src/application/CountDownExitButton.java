package application;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CountDownExitButton extends Button implements EventHandler<ActionEvent>
{

   private int countDownStart;

   private static final int DEFAULT_COUNTDOWNSTART = 10;

   public CountDownExitButton(int countDownStart)
   {
      this.countDownStart = countDownStart <= 0 ? DEFAULT_COUNTDOWNSTART : countDownStart;
      
      setText("Exit [" + this.countDownStart + "]");
      setOnAction(this);
      
      Timeline timeline = new Timeline();
      timeline.setCycleCount(Timeline.INDEFINITE);
      timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), (e -> {
         
         if(this.countDownStart > 1)
         {  
            this.countDownStart--;
            
            setText("Exit [" + this.countDownStart + "]");
         } else {
            fire();
         }
         
      })));
      timeline.playFromStart();
   }

   @Override
   public void handle(ActionEvent arg0)
   {
      System.exit(0);
   }

}
