package pv08_z04_p01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	public static final String FAJL_STUDENTI = "res//pv08_z04_studenti.txt";
	public static final String FAJL_SLUZBENICI = "res//pv08_z04_sluzbenici.txt";
	
	
	public static Stage primaryStage;
	
	
	private BorderPane bpLogin = new BorderPane();
	private BorderPane bpReferent = new BorderPane();
	
	// loginIO() komponente
	private TextField txtUser = new TextField();
	private PasswordField txtPass = new PasswordField();
	
	// loginControlPanel() komponente
	private Button btnLogin = new Button("Login");
	
	// referentIO() komponente
	private TextField txtStudentIme = new TextField();
	private TextField txtStudentPrezime = new TextField();
	private TextField txtStudentBrInd = new TextField();
	ComboBox<String> comboStudijskiProgram = new ComboBox<String>();
	ComboBox<Integer> comboGodina = new ComboBox<Integer>();
	private TextField txtStudentProsek = new TextField();
	
	// referentControlPanel() komponente
	Button btnUpisi = new Button("Upisi studenta u narednu godinu");
	
	
	private List<String> listaZaIspis;
	
	
	public static void main(String[] args) {
        launch(args);
    }

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage = primaryStage;
		
		bpLogin.setPadding(new Insets(10));
		bpLogin.setLeft(loginIO());
		bpLogin.setBottom(loginControlPanel());
		
		btnLogin.setOnAction(this::action);
		
		Scene scene = new Scene(bpLogin, 320, 130);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Studentska sluzba: Login");
		primaryStage.show();
	}


	private Node loginIO() {
		
		GridPane gp = new GridPane();
		gp.setHgap(20);
		gp.setVgap(10);
		
		gp.add(new Label("Unesite username"), 0, 0);
		gp.add(txtUser, 1, 0);
		gp.add(new Label("Unesite password"), 0, 1);
		gp.add(txtPass, 1, 1);
		
		return gp;
	}


	private Node loginControlPanel() {
		
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.getChildren().add(btnLogin);
		hb.setAlignment(Pos.BOTTOM_CENTER);
		
		return hb;
	}


	private void action(ActionEvent evt) {
		
		if (txtUser.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije uneseno korisnicko ime.").showAndWait();
			return;
		} 
		
		if (txtPass.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije unesena lozinka.").showAndWait();
			return;
		}
		
		if (login()) {
			Alert a = new Alert(Alert.AlertType.INFORMATION, "Uspesno ste ulogovani!");
			Optional<ButtonType> btn = a.showAndWait();
			
			if (btn.isPresent() && btn.get() == ButtonType.OK) {
				showNext();
				primaryStage.hide();
			}
		} else {
			new Alert(Alert.AlertType.ERROR, "Pogresni podaci, pokusajte ponovo.").showAndWait();
			resetLoginFields();
		}
	}


	private boolean login() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(FAJL_SLUZBENICI))) {
			
			String line = null;
			
			while ((line = br.readLine()) != null) {
				
				String[] tokens = line.split(",");
				String user = tokens[0].trim();
				String pass = tokens[1].trim();
				
				if (txtUser.getText().trim().equals(user))
					if (txtPass.getText().trim().equals(pass))
						return true;
			}
			
			return false;
			
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja fajla -> " + e.getMessage());
			return false;
		}
	}
	
	
	private void resetLoginFields() {
		txtUser.setText("");
		txtPass.setText("");
	}
	
	
	private void showNext() {
		
		bpReferent.setPadding(new Insets(10));
		bpReferent.setLeft(referentIO());
		bpReferent.setBottom(referentControlPanel());
		
		btnUpisi.setOnAction(this::compute);
		
		Stage stage = new Stage();
		Scene scene = new Scene(bpReferent, 350, 275);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Referent : " + txtUser.getText());
		stage.show();
	}


	private Node referentIO() {
		
		GridPane gp = new GridPane();
		gp.setHgap(20);
		gp.setVgap(10);
		
		gp.add(new Label("Ime studenta"), 0, 0);
		gp.add(txtStudentIme, 1, 0);
		gp.add(new Label("Prezime studenta"), 0, 1);
		gp.add(txtStudentPrezime, 1, 1);
		gp.add(new Label("Broj indeksa"), 0, 2);
		gp.add(txtStudentBrInd, 1, 2);
		gp.add(new Label("Studijski program"), 0, 3);
		
		ObservableList<String> cbProgram = comboStudijskiProgram.getItems();
		cbProgram.add("Informacione tehnologije");
		cbProgram.add("Racunarske nauke");
		comboStudijskiProgram.getSelectionModel().select(0);
		gp.add(comboStudijskiProgram, 1, 3);
		
		gp.add(new Label("Godina stidja"), 0, 4);
		
		ObservableList<Integer> cbGod = comboGodina.getItems();
		cbGod.add(1);
		cbGod.add(2);
		cbGod.add(3);
		cbGod.add(4);
		comboGodina.getSelectionModel().select(0);
		gp.add(comboGodina, 1, 4);
		
		gp.add(new Label("Prosecna ocena"), 0, 5);
		gp.add(txtStudentProsek, 1, 5);
		
		return gp;
	}


	private Node referentControlPanel() {
		
		HBox hb = new HBox();
		hb.setSpacing(15);
		hb.setAlignment(Pos.BOTTOM_CENTER);
		hb.getChildren().add(btnUpisi);
		
		return hb;
	}


	private void compute(ActionEvent evt) {
		
		if (txtStudentIme.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije uneseno ime studenta.").showAndWait();
			return;
		}
		
		if (txtStudentPrezime.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije uneseno prezime studenta.").showAndWait();
			return;
		}

		if (txtStudentBrInd.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije unesen broj indeksa studenta.").showAndWait();
			return;
		}

		if (txtStudentProsek.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije unesena prosecna ocena studenta.").showAndWait();
			return;
		}
		
		double d;
		
		try {
			d = Double.parseDouble(txtStudentProsek.getText().trim());
		} catch (NumberFormatException nfe) {
			new Alert(Alert.AlertType.ERROR, "Prosecna ocena nije broj.").showAndWait();
			return;
		}
		
		saveInFile();
		
		resetReferentFields();
	}


	private void saveInFile() {
		
		Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Student " + studentInfo() + " ce biti sacuvan. Nastaviti?");
		Optional<ButtonType> btn = a.showAndWait();
		
		if (btn.isPresent() && btn.get() == ButtonType.OK) {
			save();
		} else {
			return;
		}
	}


	private void save() {
		
		listaZaIspis = new ArrayList<String>();
		
		String ime = txtStudentIme.getText();
		String prz = txtStudentPrezime.getText();
		String idx = txtStudentBrInd.getText();
		String prg = comboStudijskiProgram.getValue();
		int	   god = comboGodina.getValue();
		String avg = txtStudentProsek.getText();
		
		String msc = "";
		
		if (god == 4) {
			
			Alert a0 = new Alert(Alert.AlertType.CONFIRMATION, "Studenti cetvrte godine mogu biti upisani na master. Nastaviti?");
			Optional<ButtonType> btn0 = a0.showAndWait();
			
			if (btn0.isPresent() && btn0.get() == ButtonType.OK) {
				msc = "Master";
			} else {
				
				Alert a1 = new Alert(Alert.AlertType.CONFIRMATION, "Ispisati studenta?");
				Optional<ButtonType> btn1 = a1.showAndWait();
				
				if (btn1.isPresent() && btn1.get() == ButtonType.OK) {
					msc = "Ispisan";
				}
			}
			
			String line = ime + " | " + prz + " | " +  idx + " | " + prg + " | " + msc + " | " + avg + "\n";
			listaZaIspis.add(line);
		} else {
			
			god++;
			String line = ime + " | " + prz + " | " +  idx + " | " + prg + " | " + god + " | " + avg + "\n";
			listaZaIspis.add(line);
		}
		
		try (PrintWriter pw = new PrintWriter(new FileWriter(FAJL_STUDENTI))) {
			
			for (String s : listaZaIspis)
				pw.write(s);
			
		} catch (IOException e) {
			new Alert(Alert.AlertType.ERROR, "Greska prilikom snimanja fajla! -> " + e.getMessage());
			return;
		}
	}


	private String studentInfo() {
		return txtStudentIme.getText() + " " + txtStudentPrezime.getText() + " " + txtStudentBrInd.getText();
	}


	private void resetReferentFields() {
		
		txtStudentIme.setText("");
		txtStudentPrezime.setText("");
		comboStudijskiProgram.getSelectionModel().select(0);
		comboGodina.getSelectionModel().select(0);
		txtStudentBrInd.setText("");
		txtStudentProsek.setText("");
	}
}
