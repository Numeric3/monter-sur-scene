package tef.util.view;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.util.Duration;

public class Mvmt3D {
	
	protected RotateTransition rotate = new RotateTransition();
	protected ScaleTransition scale = new ScaleTransition();
	protected double duration = 1000;
	protected int angle = 360;
	protected int cycle = 50;
	protected boolean autoRev = false;
	
	public Mvmt3D() {
		
        rotate.setDuration(Duration.millis(duration)); 
        
      //Setting the angle of the rotation 
        rotate.setByAngle(angle);
        
      //Setting the cycle count for the transition 
        rotate.setCycleCount(cycle);
        
      //Setting auto reverse value to false 
        rotate.setAutoReverse(autoRev); 
	}
	
	
	
	public void setElement(Node el) {
		rotate.setNode(el);
	}

	
	public void setV_Rmvt(boolean mvt) {
		rotate.setAxis(justPoint(new Point3D(0.0 ,-10.0 ,0.0),mvt));
	}
	public void setV_Lmvt(boolean mvt) {
		rotate.setAxis(justPoint(new Point3D(0.0, 10.0, 0.0),mvt));
	}
	public void setH_Fmvt(boolean mvt) {
		rotate.setAxis(justPoint(new Point3D(-10.0, 0.0, 0.0),mvt));
	}
	public void setH_Bmvt(boolean mvt) {
		rotate.setAxis(justPoint(new Point3D(10.0, 0.0, 0.0),mvt));
	}
	public void setProf_LMvmt(boolean mvt) {
		rotate.setAxis(justPoint(new Point3D(0.0, 0.0, 10.0),mvt));
	}
	public void setProf_RMvmt(boolean mvt) {
		rotate.setAxis(justPoint(new Point3D(0.0, 0.0, -10.0),mvt));
	}
	public void setCroix_Lmvt(boolean mvt) {
		rotate.setAxis(justPoint(new Point3D(0.0,10.0,10.0),mvt));
	}
	public void setCroix_Rmvt(boolean mvt) {
		rotate.setAxis(justPoint(new Point3D(0.0,-10.0,10.0),mvt));
		
	}
	public void addScaling(boolean value) {
		if(value) {
			scale.play();
		}else {
			scale.stop();
		}
	}
	
	public void setAction() {
		rotate.play();
	}
	
	public void setAllwaysAnim(boolean var) {
		if(var) { rotate.setOnFinished((f) -> {
			rotate.play();
		});}else {
			rotate.setOnFinished((f) -> {
				rotate.stop();
			});
		}
	}
	
	private Point3D justPoint(Point3D point, boolean value){
		if(value)
			return point;
		return rotate.getAxis();
	}

}
