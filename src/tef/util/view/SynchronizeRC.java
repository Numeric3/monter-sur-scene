package tef.util.view;

import javafx.animation.Animation.Status;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Point3D;

public class SynchronizeRC {
	protected RotateTransition rotate = null;
	protected ScaleTransition clignote = null;
	protected double duration = 1500;
	protected int angle = 360;
	protected int cycle = 50;
	protected boolean autoRev = false;
	public boolean runR = false, runC = false;
	
	public SynchronizeRC(Rotation r, Clignote c) {
	
		rotate = r.getRotate();
		clignote = c.getClignote();
		
		//Status statusR = rotate.getStatus();
		//Status statusC = clignote.getStatus();
		if(isRunning()) {
			runR = true;
			runC = true;
			rotate.stop();
			clignote.stop();
		}
		
		clignote.setCycleCount(rotate.getCycleCount());
		clignote.setDuration(rotate.getDuration());
		clignote.setAutoReverse(true);
		
		if(mustRun()) {
			rotate.play();
			clignote.play();
		}
	}
	
	public void set3DMvmt(boolean Mvmt) {
		if(isRunning())
			stopAll();
		if(Mvmt) {
			rotate.setAxis(new Point3D(clignote.getByX(),clignote.getByY(),clignote.getByZ()));
		}else {
			rotate.setAxis(new Point3D(10.0,-10.0,10.0));
		}
		
		if(mustRun()) {
			start();
		}
	}
	public boolean mustRun() {
		if(runR || runC) {
			return true;
		}
		return false;
	}
	
	public boolean isRunning() {
		if(rotate.getStatus() == Status.RUNNING || clignote.getStatus() == Status.RUNNING) {
			return true;
		}
		return false;
	}
	
	
	public void start() {
		rotate.play();
		clignote.play();
	}
	public void stopAll() {
		rotate.stop();
		clignote.stop();
	}

}
