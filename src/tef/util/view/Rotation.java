package tef.util.view;


import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.util.Duration;

public class Rotation{
    
	protected RotateTransition rotateTransition = null;
	protected double duration = 1000;
	protected int angle = 360;
	protected int cycle = 50;
	protected boolean autoRev = false;
	
	
	// Default constructor
	public Rotation() {
	   //Creating a rotate transition  
	    rotateTransition = new RotateTransition();
	    
       //Setting the duration for the transition 
        rotateTransition.setDuration(Duration.millis(1000)); 
    
       //Setting the node for the transition 
       //rotateTransition.setNode(node);       
       
      
      //Setting the angle of the rotation 
       rotateTransition.setByAngle(360); 
      
      //Setting the cycle count for the transition 
      rotateTransition.setCycleCount(50); 
      
      //Setting auto reverse value to false 
       rotateTransition.setAutoReverse(false); 
    }
	public Rotation(double duration, int angle, int cycleCount, boolean autoRev) {
		
		//Setting the duration for the transition 
        rotateTransition.setDuration(Duration.millis(duration)); 
        
      //Setting the angle of the rotation 
        rotateTransition.setByAngle(angle);
        
      //Setting the cycle count for the transition 
        rotateTransition.setCycleCount(cycle);
        
      //Setting auto reverse value to false 
        rotateTransition.setAutoReverse(autoRev); 
	}
	
	public void setDuration(double duration) {
		this.rotateTransition.setDuration(Duration.millis(duration)); 

	}
	public void setAngle(int angle) {
		this.rotateTransition.setByAngle(angle);
	}
	public void setCycle(int cycle) {
		this.rotateTransition.setCycleCount(cycle);
	}
	public void setAutoRev(boolean autoRev) {
		this.rotateTransition.setAutoReverse(autoRev);
	}
	public void setElement(Node node) {
		this.rotateTransition.setNode(node);
	}
	public void setRotateAxe(Point3D point) {
		this.rotateTransition.setAxis(point);
		
	}
	public  RotateTransition getRotate() {
		return this.rotateTransition;
	}
	
	public void play() {
	    this.rotateTransition.play(); 
	}
	

	

}
