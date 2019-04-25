package tef.util.view;

import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Clignote {
	
    //Creating scale Transition 
    protected ScaleTransition scaleTransition; 
    
    public Clignote() {
    scaleTransition = new ScaleTransition();
    //Setting the duration for the transition 
    scaleTransition.setDuration(Duration.millis(1000)); 
    
    //Setting the dimensions for scaling 
    scaleTransition.setByY(1.5); 
    scaleTransition.setByX(1.5); 
    
    //Setting the cycle count for the translation 
    scaleTransition.setCycleCount(50); 
    
    //Setting auto reverse value to true 
    scaleTransition.setAutoReverse(false); 
 
    }
    public Clignote(double duration,int scaleX, int scaleY, int cycle, boolean autoRev) {
    	//Setting the duration for the transition 
        scaleTransition.setDuration(Duration.millis(duration)); 
        
        //Setting the dimensions for scaling 
        scaleTransition.setByY(scaleY); 
        scaleTransition.setByX(scaleX); 
        
        //Setting the cycle count for the translation 
        scaleTransition.setCycleCount(cycle); 
        
        //Setting auto reverse value to true 
        scaleTransition.setAutoReverse(autoRev); 
    }
    public void setDuration(double duration) {
    	//Setting the duration for the transition 
        scaleTransition.setDuration(Duration.millis(duration)); 
    }
    public void setScaling(int x, int y) {
    	//Setting the dimensions for scaling 
        scaleTransition.setByY(y); 
        scaleTransition.setByX(x); 
    }
    public void setScaling(double x, double y) {
    	//Setting the dimensions for scaling 
        scaleTransition.setByY(y); 
        scaleTransition.setByX(x); 
    }
    public void setCycle(int cycle) {
    	scaleTransition.setCycleCount(cycle);
    }
    public void setAutoRev(boolean autoRev) {
    	scaleTransition.setAutoReverse(autoRev);
    }
    
    public void setElement(Node node) {
    	//Setting the node for the transition 
        scaleTransition.setNode(node);
    }
    public ScaleTransition getClignote() {
    	return this.scaleTransition;
    }
    
    public void play() {
    	//Playing the animation 
        scaleTransition.play(); 
    }

}
