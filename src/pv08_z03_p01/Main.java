package pv08_z03_p01;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	private static final int BTN_WIDTH = 100;
	private static final int PADDING = 5;
	
	
	private Fibonacci f;
	private int pos;

	private Label numDisplay;

	private Random rng = new Random();
	
	private Color[] color = {
			Color.web("8c8c8c"),
			Color.web("613c82"),
			Color.web("a9aa49"),
			Color.web("000000")
	};
	
	
	public Main() {
		this.pos = 1;
		this.f = new Fibonacci();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane bp = new BorderPane();
		
		bp.setCenter(initCenter());
		bp.setBottom(initBottom());
		
		Scene scene = new Scene(bp, 3 * (BTN_WIDTH + PADDING), 2 * (BTN_WIDTH + PADDING));
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Fibonacci");
		primaryStage.show();
	}


	private VBox initCenter() {
		
		VBox vb = new VBox();
		
		this.numDisplay = new Label("" + this.pos);
		this.numDisplay.setFont(new Font("Arial", 48));
		this.numDisplay.setTextFill(color[0]);
		
		vb.getChildren().addAll(numDisplay);
		vb.setAlignment(Pos.CENTER);
		
		return vb;
	}
	
	
	private FlowPane initBottom() {
		
		FlowPane fp = new FlowPane();
		
		// "Previous" button
		Button btnPrev = new Button("Previous");
		btnPrev.setPrefWidth(BTN_WIDTH);
		btnPrev.setOnAction(e -> { 
			prevNum(e); 
		});
		
		// "Next" button
		Button btnNext = new Button("Next");
		btnNext.setPrefWidth(BTN_WIDTH);
		btnNext.setOnAction(e -> { 
			nextNum(e); 
		});
		
		fp.getChildren().addAll(btnPrev, btnNext);
		fp.setAlignment(Pos.BOTTOM_CENTER);
		fp.setPadding(new Insets(PADDING));
		fp.setHgap(PADDING);
		
		return fp;
	}
	

	private void nextNum(ActionEvent e) {
		
		this.pos++;
		int value = f.greater();
		
		if (value < 0) {
			new Alert(Alert.AlertType.ERROR, "Izasli smo van opsega vrednosti tipa Integer!").showAndWait();
			this.pos--;
			updateLabels(f.lesser());
		} else {
			updateLabels(value);
		}
	}


	private void prevNum(ActionEvent e) {
		
		if (this.pos == 0) {
			new Alert(Alert.AlertType.ERROR, "Elementi Fibonaccijevog niza su nenegativni brojevi!").showAndWait();
			return;
		} else {
			this.pos--;
			updateLabels(f.lesser());
		}		
	}
	
	
	private void updateLabels(int displayValue) {
		
		this.numDisplay.setText("" + displayValue);
		this.numDisplay.setTextFill(color[rng.nextInt(4)]);
	}
}
