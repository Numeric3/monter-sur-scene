package tef.util.view;


import javafx.geometry.NodeOrientation;
import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.transform.Rotate;

public class Cam3D extends PerspectiveCamera{
	private String left;
	private String up;
	private String right;
	private String down;
	private Scene scene = null;
	protected boolean mnemo = false;
	
	protected boolean[] firstUsed = {false, false, false, false};
	protected double[] transX = {0.0, 0.0, 0.0, 0.0};
	protected double[] transY = {0.0, 0.0, 0.0, 0.0};
	protected double [] transZ = {0.0, 0.0, 0.0, 0.0};
	protected Point3D[] pt3D = {new Point3D(0.0,0.0,0.0),
			new Point3D(0.0,0.0,0.0),new Point3D(0.0,0.0,0.0),
			new Point3D(0.0,0.0,0.0)};

	protected double[] angle = {0.0, 0.0, 0.0, 0.0};
	

	public Cam3D() {
        super(true);
        this.setTranslateX(0); 
        this.setTranslateY(0); 
        this.setTranslateZ(0); 
        
        this.setTranslateZ (-1000);
        this.setNearClip (0.1);
        this.setFarClip (2500.0);
        this.setFieldOfView (35);
 
	}
	public Cam3D(double x, double y, double z) {
		super(true);
		this.setTranslateX(x); 
        this.setTranslateY(y); 
        this.setTranslateZ(z); 
        this.setFarClip(2000.0);
	}
	
	
	private void loadInitializeCameraPos(int x) {
		this.setRotationAxis(pt3D[x]);
		this.setTranslateX(transX[x]);
		this.setTranslateY(transY[x]);
		this.setTranslateZ(transZ[x]);
	}
	
	public void reinitialize() {
		for(int x = 0;x < 4; x++)
			loadInitializeCameraPos(x);	
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
		scene.setCamera(this);
		
		
		if(this.mnemo) {
			setMnemonic(this.left,this.up,this.right,this.down);
		}
	}
	
	public void setMnemonic() {
		this.mnemo = true;
		this.left = KeyCode.LEFT.toString();
		this.right = KeyCode.RIGHT.toString();
		this.up = KeyCode.UP.toString();
		this.down = KeyCode.DOWN.toString();
		setKeyEvents();
				
	}
	
	private void setKeyEvents() {
		if(this.scene != null) {
		    this.scene.setOnKeyPressed((f) ->{
		    	  String keyCode = f.getCode().toString();
		    	  if(keyCode.equals(this.up)) {
		    		 
		    		  this.setTranslateX(this.getTranslateX());
		    		  this.setTranslateY(this.getTranslateY()-1);
		    		  this.setTranslateZ(this.getTranslateZ()+1);
		    		  this.setRotationAxis(Rotate.X_AXIS);
		    		  this.setRotate(this.getRotate()-1);
		    		  getInitialPos(0);	 
		    		  
		    	  }
		    	  if(keyCode.equals(this.down)) {
		    		 
		    		  this.setTranslateX(this.getTranslateX());
		    		  this.setTranslateY(this.getTranslateY()+1);
		    		  this.setTranslateZ(this.getTranslateZ()-1);
		    		  this.setRotationAxis(Rotate.X_AXIS);
		    		  this.setRotate(this.getRotate()+1);
		    		  getInitialPos(1);
		    		  
		    	  }
		    	  if(keyCode.equals(this.left)) {
		    		
		    		  this.setTranslateY(this.getTranslateY());
		    		  this.setTranslateX(this.getTranslateX()+1);
		    		  this.setTranslateZ(this.getTranslateZ()-1);
		    		  this.setRotationAxis(Rotate.Y_AXIS);
		    		  this.setRotate(this.getRotate()+1);
		    		  getInitialPos(2);
		    		  		    	  }
		    	  if(keyCode.equals(this.right)) {
		    		  
		    		  this.setTranslateY(this.getTranslateY());
		    		  this.setTranslateX(this.getTranslateX()+1);
		    		  this.setTranslateZ(this.getTranslateZ()-1);
		    		  this.setRotationAxis(Rotate.Y_AXIS);
		    		  this.setRotate(this.getRotate()-1);
		    		  getInitialPos(3);
		    		  
		    		  
		    	  }
		    	  
		    	  if(keyCode.equals(KeyCode.ALT.toString())) {reinitialize(); }
		    	  
		    });    
		}
	}
	
	public void getInitialPos(int x) {
		if(!firstUsed[x]) {
  		  this.transX[x] = this.getTranslateX();
  		  this.transY[x] = this.getTranslateY();
  		  this.transZ[x] = this.getTranslateZ();
  		  this.pt3D[x] = this.getRotationAxis();
  		  this.angle[x] = this.getRotate();
  		  firstUsed[x] = true;  
  	  }
		
	}
		
		
	public void setMnemonic(String left, String up,
			String right, String down) {
		    this.mnemo = true;
	
		    this.left = left;
		    this.up = up;
		    this.right = right;
		    this.down = down;
		    
		    setKeyEvents();  
	}
		    
}
