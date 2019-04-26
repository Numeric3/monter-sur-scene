package tef.util.view;


import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;

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
	
	private Hashtable<String,Object[][]> ht = new Hashtable<String,Object[][]>();
	private int hsCompteur = -1;
 
	private Object initInfo[][] = {{new double[1],new double[1],new double[1],new Point3D[1]}};
	

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
		//for(int x = 0;x < 4; x++)
			//loadInitializeCameraPos(x);
		Enumeration<Object[][]> e = ht.elements();
		while(e.hasMoreElements()) {
			Object[][] obj = e.nextElement();
			this.setTranslateX((double) obj[0][0]);
			this.setTranslateY((double) obj[0][1]);
			this.setTranslateZ((double) obj[0][2]);
			this.setRotationAxis((Point3D) obj[0][3]);
		}
		
		
		
		
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
		    		 //On enregistre la position initiale par ordre
		    		  initInfo[0][0] = this.getTranslateX();
		    		  initInfo[0][1] = this.getTranslateY();
		    		  initInfo[0][2] = this.getTranslateZ();
		    		  initInfo[0][3] = this.getRotationAxis();
		    		  setFirstUsedOrder("up",initInfo);
		    		  
		    		  //On définit le mouvement en fonction de la touche
		    		  this.setTranslateX(this.getTranslateX());
		    		  this.setTranslateY(this.getTranslateY()-1);
		    		  this.setTranslateZ(this.getTranslateZ()+1);
		    		  this.setRotationAxis(Rotate.X_AXIS);
		    		  this.setRotate(this.getRotate()-1);
		    		  getInitialPos(0);
		   
		    		  
		    		  
		    		  
		    	  }
		    	  if(keyCode.equals(this.down)) {
		    		//On enregistre la position initiale par ordre
		    		  initInfo[0][0] = this.getTranslateX();
		    		  initInfo[0][1] = this.getTranslateY();
		    		  initInfo[0][2] = this.getTranslateZ();
		    		  initInfo[0][3] = this.getRotationAxis();
		    		  setFirstUsedOrder("down",initInfo);
		    		  
		    		  
		    		  this.setTranslateX(this.getTranslateX());
		    		  this.setTranslateY(this.getTranslateY()+1);
		    		  this.setTranslateZ(this.getTranslateZ()-1);
		    		  this.setRotationAxis(Rotate.X_AXIS);
		    		  this.setRotate(this.getRotate()+1);
		    		  getInitialPos(1);
		    		  
		    	  }
		    	  if(keyCode.equals(this.left)) {
		    		//On enregistre la position initiale par ordre
		    		  initInfo[0][0] = this.getTranslateX();
		    		  initInfo[0][1] = this.getTranslateY();
		    		  initInfo[0][2] = this.getTranslateZ();
		    		  initInfo[0][3] = this.getRotationAxis();
		    		  setFirstUsedOrder("left",initInfo);
		    		
		    		  this.setTranslateY(this.getTranslateY());
		    		  this.setTranslateX(this.getTranslateX()+1);
		    		  this.setTranslateZ(this.getTranslateZ()-1);
		    		  this.setRotationAxis(Rotate.Y_AXIS);
		    		  this.setRotate(this.getRotate()+1);
		    		  getInitialPos(2);
		    		  		    	  }
		    	  if(keyCode.equals(this.right)) {
		    		//On enregistre la position initiale par ordre
		    		  initInfo[0][0] = this.getTranslateX();
		    		  initInfo[0][1] = this.getTranslateY();
		    		  initInfo[0][2] = this.getTranslateZ();
		    		  initInfo[0][3] = this.getRotationAxis();
		    		  setFirstUsedOrder("right",initInfo);
		    		  
		    		  
		    		  this.setTranslateY(this.getTranslateY());
		    		  this.setTranslateX(this.getTranslateX()+1);
		    		  this.setTranslateZ(this.getTranslateZ()-1);
		    		  this.setRotationAxis(Rotate.Y_AXIS);
		    		  this.setRotate(this.getRotate()-1);
		    		  getInitialPos(3);
		    		  
		    		  
		    	  }
		    	  
		    	  if(keyCode.equals(KeyCode.ALT.toString())) {
		    		  reinitialize(); }
		    	  
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
	public void setFirstUsedOrder(String order,Object[][] list) {
		if((hsCompteur<=3) && (!ht.containsKey(order))) { 
			ht.put(order, list);
			hsCompteur+=1;
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
