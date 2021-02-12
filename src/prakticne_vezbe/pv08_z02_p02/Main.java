package prakticne_vezbe.pv08_z02_p02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	public static final String FILE = "res//pv08_z02_spisak.txt";	// C.O. : 00
	
	
	private TextField predmet;										// C.O. : 02
	private TextField vrednost;										// C.O. : 02
	
	private ObservableList<String> listData;						// C.O. : 06
	private ListView<String> listView;								// C.O. : 06

	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Creation order: 00
		primaryStage.setTitle("Checkout");
		primaryStage.setScene(new Scene(initGUI(), 575, 210));
		
		primaryStage.show();
	}
	

	private FlowPane initGUI() {
		// Creation order: 01
		FlowPane root = new FlowPane();
		
		root.getChildren().addAll(initLeft(), initRight());
		root.setAlignment(Pos.CENTER);
		
		return root;
	}


	private VBox initLeft() {
		// Creation order: 02
		
		// text fields
		predmet = new TextField();
		vrednost = new TextField();
		
		// 'Add Item' button
		Button btnAddItem = new Button("Add item");
		btnAddItem.setPrefWidth(170);
		btnAddItem.setOnAction(e -> { 
			addToObsList(e); 
		});
		
		// 'Print' button
		Button btnPrint = new Button("Print");
		btnPrint.setPrefWidth(170);
		btnPrint.setOnAction(e -> { 
			saveToFile(e);
		});
		
		VBox left = new VBox(predmet, vrednost, btnAddItem, btnPrint);
		left.setAlignment(Pos.TOP_LEFT);
		
		return left;
	}


	private void addToObsList(ActionEvent e) {
		// Creation order: 03
		if (!inputCorrectly()) {
			new Alert(Alert.AlertType.ERROR, "Neispravno uneti podaci o predmetu!").showAndWait();
		} else {
			listData.add(predmet.getText() + " - " + vrednost.getText());
			resetFields();
		}
	}


	@SuppressWarnings("unused")
	private boolean inputCorrectly() {
		// Creation order: 04
		if (blankField(predmet) || blankField(vrednost))
			return false;
		
		try {
			int v = Integer.parseInt(vrednost.getText().trim());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}


	private boolean blankField(TextField f) {
		// Creation order: 05
		return f.getText() == null || f.getText().trim().isEmpty();
	}
	
	
	private void resetFields() {
		// Creation order: 07
		predmet.setText("");
		vrednost.setText("");
	}
	
	
	private void resetAll() {
		// Creation order: 07
		resetFields();
		listData.removeAll();
		listView.getItems().clear();
	}


	private void saveToFile(ActionEvent e) {
		// Creation order: 08
		if (listData.isEmpty()) {
			new Alert(Alert.AlertType.ERROR, "Lista unesenih podataka je prazna!").showAndWait();
		} else {
			try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE, true)))) {
				for (String s : listData)
					out.println(s);
			} catch (IOException io) {
				new Alert(Alert.AlertType.ERROR, "Greska prilikom upisivanja u fajl! " + io.getMessage()).showAndWait();
			}
			new Alert(Alert.AlertType.INFORMATION, "Uspesno upisano u fajl!").showAndWait();
			resetAll();
		}
	}


	private VBox initRight() {
		// Creation order: 06
		VBox center = new VBox();
		
		listData = FXCollections.observableArrayList();
		listView = new ListView<>(listData);
		listView.setPrefSize(400, 200);
		
		center.getChildren().add(listView);
		
		return center;
	}
}
