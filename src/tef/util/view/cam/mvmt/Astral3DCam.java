package tef.util.view.cam.mvmt;

import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tef.util.view.Cam3D;

public class Astral3DCam extends PerspectiveCamera{
	protected double[] x_coordinate = {0.0,0.0};
	protected double[] y_coordinate = {0.0,0.0};
	protected double[] z_coordinate = {0.0,0.0};
	protected double[] xy_point = {0.0,0.0};
	protected double oldCoord[] = {0.0,0.0,0.0, 0.0};
	protected Scene scene;
	
	public Astral3DCam() {
		super(true);
	}
	
	public void isLeftMovable() {
		show(this.boundsInParentProperty().get());
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
