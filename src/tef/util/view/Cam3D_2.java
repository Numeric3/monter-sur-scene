package tef.util.view;

import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tef.util.view.Cam3D;

public class Cam3D_2 extends PerspectiveCamera{
	protected double[] x_coordinate = {0.0,0.0};
	protected double[] y_coordinate = {0.0,0.0};
	protected double[] z_coordinate = {0.0,0.0};
	protected double[] xy_point = {0.0,0.0};
	protected double oldCoord[] = {0.0,0.0,0.0, 0.0};
	protected Scene scene;
	
	public Cam3D_2() {
		super(true);
		this.setTranslateX(0); 
        this.setTranslateY(0); 
        this.setTranslateZ(0); 
        
        //On récule suffisament la cam en arrière
        //Afin de voir toute la scène
      
        this.setNearClip (0.1);
        this.setFarClip (100.0);
        this.setFieldOfView (30);
	}
	
	public void isLeftMovable(Stage stage) {
		stage.setWidth(500);
		double angle = this.getRotate();
		double far = this.getFarClip();
		double disWidth = stage.getWidth();
		double limite = Math.sin(angle)*(Math.sqrt((disWidth*disWidth)+(far*far)));
		if(this.getTranslateX()<= limite) {
			show("mouvable" + limite);
		}else show("No mouvable" + limite);
	}
	
	public double distance(double a, double b) {
		return Math.abs(b-a);
	}
	
	public void rotateAroundY(String key) {
		double[] oldCoord = {this.getTranslateX(),
				this.getTranslateY(),this.getTranslateZ(),this.getRotate()};
		if(key == "up"){
			oldCoord[1] -=1;
			oldCoord[2] +=1;
			oldCoord[3] -=1;
			this.setTranslateY(oldCoord[2]);
		    this.setTranslateZ(oldCoord[3]);
		    
		}
		
	}
	
	public void show(Object obj) {
		System.out.println(obj.toString());
	}
	
	 
	

}
