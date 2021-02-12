package prakticne_vezbe.pv08_z02_p01;
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


	@Override
    public void start(Stage primaryStage) {
        
		primaryStage.setTitle("Checkout");
		primaryStage.setScene(new Scene(initGUI(), 575, 210));
		
		primaryStage.show();
    }
	
	
	private FlowPane initGUI() {
		// TODO Auto-generated method stub

		FlowPane root = new FlowPane();
		root.setAlignment(Pos.CENTER_LEFT);
		root.getChildren().add(initLeft());
		root.getChildren().add(initRight());
		root.setAlignment(Pos.CENTER);
		
		return root;
	}
	
	
	private VBox initLeft() {		
		// TODO Auto-generated method stub
		
		// text fields
		predmet = new TextField();
		vrednost = new TextField();
		
		// 'Add Item' button
		Button btnAddItem = new Button("Add Item");
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
	

	private VBox initRight() {
		// TODO Auto-generated method stub
		
		VBox center = new VBox();

		listData = FXCollections.observableArrayList();
		listView = new ListView<>(listData);
		listView.setPrefSize(400, 200);
		
		center.getChildren().add(listView);
		
		return center;
	}

	public static void main(String[] args) {
        launch(args);
    }
	
	
	private void saveToFile(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (listData.isEmpty())
			new Alert(Alert.AlertType.INFORMATION, "Lista unesenih podataka je prazna!").showAndWait();
		else {
			try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE, true)))){
				for (String s : listData)
					out.println(s);
			} catch (IOException io) {
				// TODO: handle exception
				new Alert(Alert.AlertType.ERROR, "Greska prilikom upisivanja u fajl! " + io.getMessage()).showAndWait();
			}
			new Alert(Alert.AlertType.INFORMATION, "Uspesno upisano u fajl!").showAndWait();
			resetAll();
		}
	}
	
	
	private void resetFields() {
		predmet.setText("");
		vrednost.setText("");
	}
	
	
	private void resetAll() {
		resetFields();
		listData.removeAll();
		listView.getItems().clear();
	}
	

	private void addToObsList(ActionEvent e) {
		
		if (!inputCorrectly()) {
			new Alert(Alert.AlertType.ERROR, "Neispravno uneti podaci o predmetu!").show();
		} else {
			listData.add(predmet.getText() + " - " + vrednost.getText());
			resetFields();
		}
	}
	

	private boolean inputCorrectly() {
		
		if (blankField(predmet) || blankField(vrednost))
			return false;
		
		try {
			int v = Integer.parseInt(vrednost.getText().trim());
			return true;
		} catch(NumberFormatException nfe) {
			return false;
		}
	}
	

	private boolean blankField(TextField f) {
		return f.getText() == null || f.getText().trim().isEmpty();
	}
}
