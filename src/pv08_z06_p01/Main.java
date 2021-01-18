package pv08_z06_p01;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	public static final int DIM = 4;
	
	
	private Image imgPineapple = new Image(new File("img//pv08_z06_Pineapple.png").toURI().toString());
	
	
	private Button reset;
	private Button[] btnsInRow;
	private Button[][] btns;
	
	
	private int inRow;
	
	
	public static Stage primaryStage;
	

	public static void main(String[] args) {
		launch(args);
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage = primaryStage;
		
		StackPane container = makeContainer();
		
		Scene s = new Scene(container);
		primaryStage.setScene(s);
		primaryStage.setTitle("Puzzle");
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	
	private StackPane makeContainer() {
		
		btnsInRow = new Button[2];
		inRow = 0;
		
		StackPane sp = new StackPane();
		sp.getChildren().addAll(makeBackground(), makeButtons());
		
		return sp;
	}


	private ImageView makeBackground() {
		
		ImageView ivPineapple = new ImageView();
		ivPineapple.setImage(imgPineapple);
		
		return ivPineapple;
	}


	@SuppressWarnings("static-access")
	private BorderPane makeButtons() {
		
		BorderPane bp = new BorderPane();
		
		reset = new Button("Reset");
		reset.setOnAction(this::resetting);
		
		bp.setTop(reset);
		bp.setMargin(reset, new Insets(15, 5, 30, 5));
		bp.setCenter(makeCenter());
		
		return bp;
	}


	@SuppressWarnings("static-access")
	private Node makeCenter() {
		
		GridPane gp = new GridPane();
		
		btns = new Button[DIM][DIM];
		
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				
				btns[i][j] = new Button();
				btns[i][j].setPrefSize(97, 97);
				btns[i][j].setOnAction(this::clicked);
				
				gp.setMargin(btns[i][j], new Insets(5));
				gp.add(btns[i][j], i, j);
			}
		}
		
		setText();
		return gp;
	}


	private void setText() {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 1; i < DIM * 2 + 1; i++) {
			list.add(i);
			list.add(i);
		}
		
		Collections.shuffle(list);
		
		inRow = 0;		// ???
		
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				btns[i][j].setVisible(true);
				btns[i][j].setText(list.get(inRow++).toString());
			}
		}
	}


	private void resetting(ActionEvent evt) {
		inRow = 0;
		setText();
	}


	private void clicked(ActionEvent evt) {
		if (inRow++ % 2 == 0) {
			btnsInRow[0] = (Button) evt.getSource();
		} else {
			btnsInRow[1] = (Button) evt.getSource();
			
			if (btnsInRow[0].getText().equals(btnsInRow[1].getText()) && btnsInRow[0] != btnsInRow[1]) {
				btnsInRow[0].setVisible(false);
				btnsInRow[1].setVisible(false);
				
				if (isComplete()) showMessage();
			}
		}
	}


	private boolean isComplete() {
		
		for (int i = 0; i < DIM; i++)
			for (int j = 0; j < DIM; j++)
				if (btns[i][j].isVisible()) return false;
		
		return true;
	}
	
	
	private void showMessage() {
		
		Alert a = new Alert(Alert.AlertType.INFORMATION, "You completed the game in " + inRow + "moves.");
		a.showAndWait();
	}
}
