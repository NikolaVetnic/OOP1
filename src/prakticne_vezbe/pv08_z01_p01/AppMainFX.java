package prakticne_vezbe.pv08_z01_p01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AppMainFX extends Application implements EventHandler<ActionEvent> {
	
	private static int DIM = 4;
	private static int DIM_DUGMETA = 50;
	private static int RAZMAK = 5;
	private static int BR_UZASTOPNIH = 2;
	
	private Button[][] dugmici;
	
	private Label labelNep;
	private Label labelPar;
	
	private Matrica matrica;
	
	/*
	 * Generalno je ideja da se celina koja se bavi grafikom aplikacije
	 * izdvaja od celine koja se bavi logikom. To znaci da pored metoda
	 * main() i launch() imamo metode koji inicijalizuju centralni i d-
	 * onji deo kopmonenti i tu se zapravo ubacuju dugmici i tamo se h-
	 * andle-uje kako aplikacija treba da izgleda. Logicki deo se nala-
	 * zi u klasi MatricaSabiranjaBrojeva.
	 */

	public static void main(String[] args) {
		launch(args);
	}

	public AppMainFX() {
		this.matrica = new Matrica(DIM, BR_UZASTOPNIH);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		/*
		 * U ovom metodu definisemo kako ce da se pokrene JavaFX aplikacija
		 * dok main metod sluzi da sa racunara pokrenemo aplikaciju uz pom-
		 * oc launch() metode.
		 * 
		 * Metod start() ocekuje neki Stage i u Stage-u se zapravo i pokre-
		 * ce aplikacija - to je prozor aplikacije. U JavaFX-u se sve svodi
		 * na layout-e koji sadrze cvorove koji sadrze druge cvorove ili n-
		 * eki sadrzaj.
		 * 
		 * Prozorcic koji ima svoje delove: top, left, right, botom i cent-
		 * er. U BorderPane se dalje stavljaju ostali cvorovi.
		 */
		BorderPane bp = new BorderPane();
				
		/*
		 * U BorderPane ubacujemo delove center i bottom.
		 */
		bp.setCenter(initCenter());
		bp.setBottom(initBottom());
		
		/*
		 * Kreiramo scenu (Scene) u koju cemo staviti pocetni BorderPane n-
		 * akon cega je stavljamo u primaryStage.
		 */
		Scene scene = new Scene(bp, DIM * (RAZMAK + DIM_DUGMETA), DIM * (RAZMAK + DIM_DUGMETA));
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Dugmici");
		primaryStage.show();
	}
	
	@Override
	public void handle(ActionEvent evt) {
		
		Button b = (Button) evt.getSource();
		int broj = Integer.parseInt(b.getText());
		
		this.matrica.odaberiBroj(broj);
		
		this.azurirajLabele();
		
		// da li je isti broj kliknut dovoljan broj puta
		if (this.matrica.sviIsti()) {
			Alert a = new Alert(Alert.AlertType.INFORMATION, "Dva puta zaredom isto dugme!");
			a.show();
		}
	}
	
	private void azurirajLabele() {
		this.labelPar.setText("Kliknuto parnih: " + this.matrica.getBrParnih());
		this.labelNep.setText("Kliknuto neparnih: " + this.matrica.getBrNeparnih());
	}
	
	private Pane initCenter() {
		
		GridPane gp = new GridPane();
		
		gp.setPadding(new Insets(RAZMAK));	// udaljenost od ivice prozora
		gp.setVgap(RAZMAK);					// vertikalni razmak izmedju dugmica
		gp.setHgap(RAZMAK);					// horizontalni razmak izmedju dugmica

		this.dugmici = new Button[DIM][DIM];

		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				Button dugme = new Button("" + matrica.brojNaLokaciji(i, j));
				dugme.setPrefSize(DIM_DUGMETA, DIM_DUGMETA);
				/*
				 * Uzeli smo dugme, dali smo mu setOnAction() - kad neko nesto ura-
				 * di sa tobom, evo ti handler za taj dogadjaj; handler je this za-
				 * to sto nasa glavna klasa nasledjuje EventHandler; definisali smo
				 * metod handle() koji ce da uzme taj Event, uzece njegov source, a
				 * to je dugme koje je kliknuto, i mi onda mozemo izvuci broj dugm-
				 * eta koje je kliknuto, odnosno tekst sa tog dugmeta a posto znamo
				 * da je to broj mozemo da ga parsiramo.
				 */
				dugme.setOnAction(this);
				
				dugmici[i][j] = dugme;
				
				gp.add(dugme, j, i);		// parametri su kolona pa vrsta
			}
		}
		
		return gp;
	}
	
	private Pane initBottom() {
		
		FlowPane fp = new FlowPane();
		
		fp.setPadding(new Insets(RAZMAK));
		fp.setHgap(RAZMAK);
		
		this.labelPar = new Label("Kliknuto parnih: 0");
		this.labelNep = new Label("Kliknuto neparnih: 0");
		
		fp.getChildren().addAll(labelPar, labelNep);
		
		return fp;
	}
}
