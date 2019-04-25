package tef.util.view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tele {
	
	protected Group root = null;
	protected Stage stage = new Stage();
	protected Scene scene = null;
    protected Cam3D cam = new Cam3D();
	
	public Tele() {
		//Creating a Group object   
	      root = new Group();
	      
	      //Creating a scene object  
	      scene = new Scene(root, 600, 300); 
	      
	      //Setting title to the Stage 
	      stage.setTitle("Mahatma Tefnakht: Whatsapp: 00226 71 87 08 36"); 
	   
	      //Adding scene to the stage 
	      stage.setScene(scene);   
	}
	public Tele(String title,int width, int height) {
		//Creating a Group object   
	      root = new Group();
	      
	      //Creating a scene object  
	      scene = new Scene(root, width, height); 
	      
	      //Setting title to the Stage 
	      stage.setTitle(title); 
	   
	      //Adding scene to the stage 
	      stage.setScene(scene);   
	}
	
	public void setCamera(Cam3D camera) {
		this.cam = camera;
		camera.setScene(scene);
	}
	public Cam3D getCamera() {
		return this.cam;
	}
	
	public void addActor(Node actor) {
		root.getChildren().add(actor);
	}
	public Stage getTele() {
		return stage;
	}
	
	public void show() {
	   //Displaying the contents of the stage 
	   stage.show();	
	}

}
