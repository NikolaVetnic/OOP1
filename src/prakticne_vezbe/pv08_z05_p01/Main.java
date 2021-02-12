package prakticne_vezbe.pv08_z05_p01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	
	public static final String IMG_CHECKMARK = "img//pv08_z05_Checkmark.png";
	public static final String IMG_NO = "img//pv08_z05_No.png";
	public static final String TXT_RECI = "res//pv08_z05_reci.txt";
	
	
	Image imgNo = new Image(new File(IMG_NO).toURI().toString());
	Image imgCheckmark = new Image(new File(IMG_CHECKMARK).toURI().toString());
	
	
	public static Stage primaryStage;
	
	// primaryStage
	private BorderPane bp = new BorderPane();
	private Button btnOk = new Button("Potvrdi", new ImageView(imgCheckmark));
	private Button btnClear = new Button("Obrisi", new ImageView(imgNo));
	
	// inputPanel()
	private Label lblInput = new Label("Unesite tajanstvenu rec: ");
	private TextField txtInput = new TextField();
	
	
	public static void main(String[] args) {
		launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		
		bp.setPadding(new Insets(15));
		bp.setCenter(inputPanel());
		bp.setBottom(controlPanel());
		
		btnOk.setOnAction(this::compute);
		btnClear.setOnAction(this::reset);
		
		Scene s = new Scene(bp, 300, 200);
		primaryStage.setScene(s);
		primaryStage.setTitle("Igra reci");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	

	private Node inputPanel() {
		
		VBox vb = new VBox();
		
		vb.setSpacing(10);;
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(lblInput, txtInput);
		
		return vb;
	}
	

	private Node controlPanel() {
		
		HBox hb = new HBox();
		
		hb.setSpacing(15);
		hb.setAlignment(Pos.BOTTOM_CENTER);
		hb.getChildren().addAll(btnOk, btnClear);
		
		return hb;
	}
		
	
	private void resetInput() {
		txtInput.setText("");
	}


	private void compute(ActionEvent evt) {
		
		if (txtInput.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Niste uneli nijedno slovo!").showAndWait();
			return;
		}
		
		try (BufferedReader in = new BufferedReader(new FileReader(TXT_RECI))) {
			
			String line;
			
			while ((line = in.readLine()) != null) {
				
				if (line.equalsIgnoreCase(txtInput.getText().trim()) ) {
					
					new Alert(Alert.AlertType.INFORMATION, "Pogodili ste tajanstvenu rec!").showAndWait();
					newGame();
					
					return;
				}
			}
		} catch (IOException e) {
			new Alert(Alert.AlertType.ERROR, "Greska prilikom citanja fajla -> " + e.getMessage()).showAndWait();
			return;
		}
		
		Alert a = new Alert(Alert.AlertType.ERROR, "Niste pogodili tajanstvenu rec!");
		Optional<ButtonType> b = a.showAndWait();
		
		if (b.isPresent() && b.get() == ButtonType.OK)
			newGame();
		else
			Platform.exit();
	}
	
	
	private void newGame() {
		
		Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Nova igra?");
		Optional<ButtonType> b = a.showAndWait();
		
		if (b.isPresent() && b.get() == ButtonType.OK) {
			resetInput();
			return;
		} else {
			Platform.exit();
		}
	}


	private void reset(ActionEvent evt) {
		resetInput();
	}
}
