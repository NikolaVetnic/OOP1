package pv08_z01_p02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AppMainFX extends Application implements EventHandler<ActionEvent> {
	
	public static final int BR_UZASTOPNIH = 2;
	public static final int DIM = 4;
	public static final int DIM_DUGMETA = 50;
	public static final int RAZMAK = 5;
	
	private Button[][] dugmici;
	
	private Label labelNep;
	private Label labelPar;
	
	private Matrica matrica;

	public static void main(String[] args) {
		launch(args);
	}
	
	public AppMainFX() {
		this.matrica = new Matrica(DIM, BR_UZASTOPNIH);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane bp = new BorderPane();
		
		bp.setCenter(initCenter());
		bp.setBottom(initBottom());
		
		Scene scene = new Scene(bp, DIM * (RAZMAK + DIM_DUGMETA), DIM * (RAZMAK + DIM_DUGMETA));
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Dugmici");
		primaryStage.show();
	}
	
	private Node initCenter() {
		
		GridPane gp = new GridPane();
		
		gp.setPadding(new Insets(RAZMAK));
		gp.setVgap(RAZMAK);
		gp.setHgap(RAZMAK);
		
		this.dugmici = new Button[DIM][DIM];
		
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				
				Button dugme = new Button("" + matrica.brojNaLokaciji(i, j));
				dugme.setPrefSize(DIM_DUGMETA, DIM_DUGMETA);
				dugme.setOnAction(this);
				
				dugmici[i][j] = dugme;
				
				gp.add(dugme, j, i);
			}
		}
		
		return gp;
	}

	private Node initBottom() {
		
		FlowPane fp = new FlowPane();
		
		fp.setPadding(new Insets(RAZMAK));
		fp.setHgap(RAZMAK);
		
		this.labelPar = new Label("Kliknuto parnih: 0");
		this.labelNep = new Label("Kliknuto neparnih: 0");
		
		fp.getChildren().addAll(labelPar, labelNep);
		
		return fp;
	}
	
	private void azurirajLabele() {
		this.labelPar.setText("Kliknuto parnih: " + this.matrica.getBrParnih());
		this.labelNep.setText("Kliknuto neparnih: " + this.matrica.getBrNeparnih());
	}

	@Override
	public void handle(ActionEvent evt) {
		
		Button b = (Button) evt.getSource();
		int broj = Integer.parseInt(b.getText());
		
		this.matrica.odaberiBroj(broj);
		
		this.azurirajLabele();
		
		if (this.matrica.sviIsti())
			new Alert(Alert.AlertType.INFORMATION, "Dva puta zaredom isto dugme!").showAndWait();
	}
}
