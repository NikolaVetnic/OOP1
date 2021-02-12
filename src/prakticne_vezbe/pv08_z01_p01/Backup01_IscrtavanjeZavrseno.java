package prakticne_vezbe.pv08_z01_p01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Backup01_IscrtavanjeZavrseno extends Application {
	
	private static int DIM = 4;
	private static int DIM_DUGMETA = 50;
	private static int RAZMAK = 5;
	
	private Button[][] dugmici;
	
	private Label labelNep;
	private Label labelPar;
	
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
	
	private Pane initCenter() {
		
		GridPane gp = new GridPane();
		
		gp.setPadding(new Insets(RAZMAK));	// udaljenost od ivice prozora
		gp.setVgap(RAZMAK);					// vertikalni razmak izmedju dugmica
		gp.setHgap(RAZMAK);					// horizontalni razmak izmedju dugmica

		this.dugmici = new Button[DIM][DIM];

		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				Button dugme = new Button("x");
				dugme.setPrefSize(DIM_DUGMETA, DIM_DUGMETA);
				
				dugmici[i][j] = dugme;
				
				gp.add(dugme, i, j);
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
