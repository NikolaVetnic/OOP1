package kol2_2021_01_a_p01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	
    /***************************
     * NIKOLA VETNIC 438/19 IT *
     ***************************/
	
	
	private static final String SAVE_FILE = "res//kol2_2021_01_a_jelka.txt";
	
	
	private static final int PADDING = 5;
	
	
	private PonudaUkrasa ponuda;
	private Jelka jelka;
	
	
	private BorderPane bp = new BorderPane();
	
	// initCenter()
	private HBox hb = new HBox();
	
	private ObservableList<Ukras> listDataL;
	private ListView<Ukras> listViewL;
	
	private ObservableList<Ukras> listDataR;
	private ListView<Ukras> listViewR;
	
	// initBottom()
	private FlowPane fp = new FlowPane();
	
	private TextField txtBroj = new TextField();
	
	private Button btnDodaj = new Button("Dodaj ukras");
	private Button btnSacuvaj = new Button("Sacuvaj jelku");
	

	public static void main(String[] args) {
		launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		bp.setCenter(initCenter());
		bp.setBottom(initBottom());
		
		Scene s = new Scene(bp, 800, 300);
		
		primaryStage.setResizable(false);
		primaryStage.setScene(s);
		primaryStage.setTitle("Kolokvijum II");
		primaryStage.show();
	}


	private HBox initCenter() {
		
		hb.setPrefHeight(100);
		
		hb.setPadding(new Insets(PADDING));
		hb.setSpacing(15);
		hb.setAlignment(Pos.BOTTOM_CENTER);
		
		listDataL = FXCollections.observableArrayList();
		listViewL = new ListView<>(listDataL);
		listViewL.setPrefWidth(380);
		
		listDataR = FXCollections.observableArrayList();
		listViewR = new ListView<>(listDataR);
		listViewR.setPrefWidth(380);
		
		this.ponuda = new PonudaUkrasa();
		
		for (Ukras u : ponuda.ukrasi())
			listDataL.add(u);
		
		this.jelka = new Jelka();
		
		hb.getChildren().addAll(listViewL, listViewR);
		
		return hb;
	}


	private FlowPane initBottom() {
		
		fp.setAlignment(Pos.BOTTOM_CENTER);
		fp.setPadding(new Insets(PADDING));
		fp.setHgap(PADDING);
		fp.getChildren().addAll(txtBroj, btnDodaj, btnSacuvaj);
		
		btnDodaj.setOnAction(this::staviNaJelku);
		btnSacuvaj.setOnAction(this::saveToFile);
		
		return fp;
	}
	
	
	private void saveToFile(ActionEvent e) {
		
		if (listDataR.isEmpty()) {
			new Alert(Alert.AlertType.ERROR, "Jelka nije okicena ukrasima!").showAndWait();
		} else {
			try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(SAVE_FILE)))) {
				for (Ukras u : listDataR) {
					
					String line = u.boja() + ", " + (int) u.tezina() + ", " + (int) u.cena();
					
					if (u instanceof VrhZaJelku) {
						VrhZaJelku v = (VrhZaJelku) u;
						line += ", " + (int) v.visina();
					}
					
					out.println(line);
				}
				
				listDataR.clear();
				
			} catch (IOException io) {
				new Alert(Alert.AlertType.ERROR, "Greska prilikom upisivanja u fajl! " + io.getMessage()).showAndWait();
			}
			new Alert(Alert.AlertType.INFORMATION, "Uspesno upisano u fajl!").showAndWait();
		}
	}


	private void staviNaJelku(ActionEvent evt) {
		
		if (!inputCorrectly()) {
			new Alert(Alert.AlertType.ERROR, 
					"Pogresno uneta vrednost! Moguce greske: prazno polje, broj manji od nule, broj veci od broja ukrasa...").showAndWait();			
		} else {
			
			int num = Integer.parseInt(txtBroj.getText().trim());
			
			try {
				
				jelka.pokusajDodavanje((Ukras) listDataL.get(num));				
				
				listDataR.add(listDataL.get(num));
				resetField();
				
			} catch (MaksimalnoOpterecenjeDostignuto e) {
				new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
			} catch (MaksimalanBrojUkrasaNaJelci e) {
				new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
			} catch (JelkaNeMozeImatiDvaVrha e) {
				new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
			}
		}
	}


	private void resetField() {
		txtBroj.setText("");
	}


	private boolean inputCorrectly() {
		
		if (blankField(txtBroj))
			return false;
		
		try {
			int num = Integer.parseInt(txtBroj.getText().trim());
			
			if (num < 0) return false;
			if (num >= listDataL.size()) return false;
			
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}


	private boolean blankField(TextField f) {
		return f.getText() == null || f.getText().trim().isEmpty();
	}
}
