import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button button1, button2, button3, button4, button5;
	Label label;
	TextField textField;
	//  declare two HBoxes
	HBox hBoxOne, hBoxTwo;
	//student Task #4:
	//  declare an instance of DataManager
	DataManager data;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		button1 = new Button("Hello");
		button1.setOnAction(new ButtonHandler());
		button2 = new Button("Howdy");
		button2.setOnAction(new ButtonHandler());
		button3 = new Button("Chinese");
		button3.setOnAction(new ButtonHandler());
		button4 = new Button("Clear");
		button4.setOnAction(new ButtonHandler());
		button5 = new Button("Exit");
		button5.setOnAction(new ButtonHandler());
		label = new Label("Feedback: ");
		textField = new TextField();
		//  instantiate the HBoxes
		hBoxOne = new HBox();
		hBoxTwo = new HBox();
		//student Task #4:
		//  instantiate the DataManager instance
		data = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(button1, new Insets(0,0,0,0)); 
		HBox.setMargin(button2, new Insets(0,0,0,20)); 
		HBox.setMargin(button3, new Insets(0,0,0,20)); 
		HBox.setMargin(button4, new Insets(0,0,0,20)); 
		HBox.setMargin(button5, new Insets(0,0,0,20)); 
		hBoxOne.setAlignment(Pos.CENTER);
		hBoxTwo.setAlignment(Pos.CENTER);
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hBoxTwo.getChildren().addAll(label, textField);
		//  add the buttons to the other HBox
		hBoxOne.getChildren().addAll(button1, button2, button3, button4, button5);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hBoxOne, hBoxTwo);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			if(event.getTarget().equals(button1)) {
				textField.setText(data.getHello());
			}else if(event.getTarget().equals(button2)){
				textField.setText(data.getHowdy());
			}else if(event.getTarget().equals(button3)){
				textField.setText(data.getChinese());
			}else if(event.getTarget().equals(button4)){
				textField.setText("");
			}else if(event.getTarget().equals(button5)){
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	