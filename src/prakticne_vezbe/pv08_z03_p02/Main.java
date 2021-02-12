package prakticne_vezbe.pv08_z03_p02;

import java.io.File;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	private static final int BTN_WIDTH = 100;
	private static final int PADDING = 5;

	
	private Random rng = new Random();
	
	
	private int pos;
	private Fibonacci f;
	
	
	private BorderPane bp = new BorderPane();
	
	// initCenter()
	private VBox vb = new VBox();
	private Label numDisplay;
	private Color[] color = {
			Color.web("8c8c8c"),
			Color.web("613c82"),
			Color.web("a9aa49"),
			Color.web("000000")
	};
	
	// initBottom()
	private FlowPane fp = new FlowPane();
	Button btnPrev;
	Button btnNext;
	private Image imgArrow = new Image(new File("img//pv08_z03_arrow.png").toURI().toString());
	
	
	public Main() {
		this.pos = 1;
		this.f = new Fibonacci();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		bp.setCenter(initCenter());
		bp.setBottom(initBottom());
		
		Scene s = new Scene(bp, 3 * (BTN_WIDTH + PADDING), 2 * (BTN_WIDTH + PADDING));
		
		primaryStage.setScene(s);
		primaryStage.setTitle("Fibonacci");
		primaryStage.show();
	}

	private VBox initCenter() {
		
		numDisplay = new Label("" + pos);
		numDisplay.setFont(new Font("Arial", 48));
		numDisplay.setTextFill(color[0]);
		
		vb.getChildren().add(numDisplay);
		vb.setAlignment(Pos.CENTER);
		
		return vb;
	}

	private FlowPane initBottom() {
		
		// "Next" button
		ImageView ivNext = new ImageView();
		
		ivNext.setImage(imgArrow);
		ivNext.setPreserveRatio(true);
		ivNext.setFitWidth(25);
		
		btnNext = new Button("Next", ivNext);
		btnNext.setPrefWidth(BTN_WIDTH);
		btnNext.setOnAction(this::nextNum);
		
		// "Previous" button
		ImageView ivPrev = new ImageView();
		
		ivPrev.setImage(imgArrow);
		ivPrev.setPreserveRatio(true);
		ivPrev.setFitWidth(25);
		ivPrev.setRotate(180);
		
		btnPrev = new Button("Previous", ivPrev);
		btnPrev.setPrefWidth(BTN_WIDTH);
		btnPrev.setOnAction(this::prevNum);

		// Flow Pane
		fp.getChildren().addAll(btnPrev, btnNext);
		fp.setAlignment(Pos.BOTTOM_CENTER);
		fp.setPadding(new Insets(PADDING));
		fp.setHgap(PADDING);		
		
		return fp;
	}


	private void prevNum(ActionEvent evt) {
		
		if (pos == 0) {
			new Alert(Alert.AlertType.ERROR, "Fibonacci numbers are non-negative!").showAndWait();
			return;
		} else {
			pos--;
			updateLabels(f.prev());
		}
	}


	private void nextNum(ActionEvent evt) {
		
		this.pos++;
		int value = f.next();
		
		if (value < 0) {
			new Alert(Alert.AlertType.ERROR, "Integer out of bounds!").showAndWait();
			this.pos--;
			updateLabels(f.prev());
		} else {
			updateLabels(value);
		}
	}
	
	
	private void updateLabels(int displayValue) {
		numDisplay.setText("" + displayValue);
		numDisplay.setTextFill(color[rng.nextInt(4)]);
	}
}
