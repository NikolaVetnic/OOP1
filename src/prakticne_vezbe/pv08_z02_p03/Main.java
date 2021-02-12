package prakticne_vezbe.pv08_z02_p03;

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

	
	public static final String FILE = "res//pv08_z02_spisak.txt";
	
	
	private TextField predmet;
	private TextField vrednost;
	
	
	private ObservableList<String> listData;
	private ListView<String> listView;
	
	
	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Checkout");
		primaryStage.setScene(new Scene(initGUI(), 575, 210));
		
		primaryStage.show();
	}


	private FlowPane initGUI() {
		
		FlowPane root = new FlowPane();
		
		root.setAlignment(Pos.CENTER_LEFT);
		root.getChildren().addAll(initLeft(), initRight());
		
		return root;
	}
	
	
	private VBox initLeft() {
		
		// text fields
		predmet = new TextField();
		vrednost = new TextField();
		
		// "Add Item" button
		Button btnAddItem = new Button("Add item");
		btnAddItem.setPrefWidth(170);
		btnAddItem.setOnAction(e -> { 
			addToObsList(e); 
		});
		
		// "Print" button
		Button btnPrint = new Button("Print");
		btnPrint.setPrefWidth(170);
		btnPrint.setOnAction(e -> {
			saveToFile(e);
		});
		
		VBox left = new VBox(predmet, vrednost, btnAddItem, btnPrint);
		left.setAlignment(Pos.TOP_LEFT);
		
		return left;
	}


	private void saveToFile(ActionEvent e) {
		
		if (listData.isEmpty()) {
			new Alert(Alert.AlertType.ERROR, "Lista unesenih podataka je prazna!").showAndWait();
		} else {
			try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)))) {
				for (String s : listData)
					out.println(s);
			} catch (IOException io) {
				new Alert(Alert.AlertType.ERROR, "Greska prilikom upisivanja u fajl! " + io.getMessage()).showAndWait();
			}
			new Alert(Alert.AlertType.INFORMATION, "Uspesno upisano u fajl!").showAndWait();
		}
	}


	private void addToObsList(ActionEvent e) {
		if (!inputCorrectly()) {
			new Alert(Alert.AlertType.ERROR, "Neispravno uneti podaci o predmetu!").showAndWait();			
		} else {
			listData.add(predmet.getText() + " - " + vrednost.getText());
			resetFields();
		}
	}


	@SuppressWarnings("unused")
	private boolean inputCorrectly() {
		
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
		return f.getText() == null || f.getText().trim().isEmpty();
	}
	
	
	private void resetFields() {
		this.predmet.setText("");
		this.vrednost.setText("");
	}
	
	
	private void resetAll() {
		resetFields();
		this.listData.removeAll();
		this.listView.getItems().clear();
	}
	
	
	private VBox initRight() {

		VBox center = new VBox();
		
		listData = FXCollections.observableArrayList();
		listView = new ListView<>(listData);
		listView.setPrefSize(400, 200);
		
		center.getChildren().addAll(listView);
		
		return center;
	}
}
