package prakticne_vezbe.pv08_z04_p02;

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
	
	
	public static final String F_STUDENTI = "res//pv08_z04_studenti.txt";
	public static final String F_REFERENT = "res//pv08_z04_sluzbenici.txt";

	
	private static Stage primaryStage;
	
	
	private BorderPane bpLogin = new BorderPane();
	private BorderPane bpReferent = new BorderPane();
	
	// loginIO()
	private GridPane gpLogin = new GridPane();
	private TextField txtUser = new TextField();
	private PasswordField txtPass = new PasswordField();
	
	// loginControlPanel()
	private HBox hbLogin = new HBox();
	private Button btnLogin = new Button("Login");
	
	// referentIO()
	private GridPane gpRfrnt = new GridPane();
	private TextField txtStudentIme = new TextField();
	private TextField txtStudentPrezime = new TextField();
	private TextField txtStudentBrInd = new TextField();
	ComboBox<String> comboStudijskiProgram = new ComboBox<String>();
	ComboBox<Integer> comboGodina = new ComboBox<Integer>();
	private TextField txtStudentProsek = new TextField();
	
	// referentControlPanel()
	private HBox hbRfrnt = new HBox();
	private Button btnUpisi = new Button("Upisi studenta u narednu godinu");
	
	
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
		
		btnLogin.setOnAction(this::authenticate);
		
		Scene s = new Scene(bpLogin, 320, 130);
		primaryStage.setScene(s);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Studentska sluzba : Login");
		primaryStage.show();
	}
	

	private GridPane loginIO() {
		
		gpLogin.setHgap(20);
		gpLogin.setVgap(10);
		
		gpLogin.add(new Label("Unesite username"), 0, 0);
		gpLogin.add(txtUser, 1, 0);
		gpLogin.add(new Label("Unesite password"), 0, 1);
		gpLogin.add(txtPass, 1, 1);
		
		return gpLogin;
	}

	
	private HBox loginControlPanel() {
		
		hbLogin.setSpacing(10);
		hbLogin.getChildren().add(btnLogin);
		hbLogin.setAlignment(Pos.BOTTOM_CENTER);
		
		return hbLogin;
	}
	

	private void authenticate(ActionEvent evt) {
		
		if (txtUser.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije uneseno korisnicko ime!").showAndWait();
			return;
		}
		
		if (txtPass.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije unesena lozinka!").showAndWait();
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
			new Alert(Alert.AlertType.ERROR, "Pogresni podaci, pokusajte ponovo!").showAndWait();
			resetLoginFields();
		}
	}
	
	
	private boolean login() {
		
		try (BufferedReader in = new BufferedReader(new FileReader(F_REFERENT))) {
			
			String line = null;
			
			while ((line = in.readLine()) != null) {
				
				String[] tokens = line.split(",");
				String user = tokens[0].trim();
				String pass = tokens[1].trim();
				
				if (txtUser.getText().trim().equals(user))
					if (txtPass.getText().trim().equals(pass))
						return true;
			}
			
			return false;
			
		} catch (IOException e) {
			new Alert(Alert.AlertType.ERROR, "Greska prilikom citanja fajla -> " + e.getMessage()).showAndWait();
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
		Scene s = new Scene(bpReferent, 350, 275);
		stage.setScene(s);
		stage.setResizable(false);
		stage.setTitle("Referent : " + txtUser.getText());
		stage.show();
	}
	
	
	private Node referentIO() {
		
		gpRfrnt.setHgap(20);
		gpRfrnt.setVgap(10);
		
		gpRfrnt.add(new Label("Ime studenta"), 0, 0);
		gpRfrnt.add(txtStudentIme, 1, 0);
		gpRfrnt.add(new Label("Prezima studenta"), 0, 1);
		gpRfrnt.add(txtStudentPrezime, 1, 1);
		gpRfrnt.add(new Label("Broj indeksa"), 0, 2);
		gpRfrnt.add(txtStudentBrInd, 1, 2);
		gpRfrnt.add(new Label("Studijski program"), 0, 3);
		
		ObservableList<String> cbProgram = comboStudijskiProgram.getItems();
		cbProgram.add("Informacione tehnologije");
		cbProgram.add("Racunarske nauke");
		comboStudijskiProgram.getSelectionModel().select(0);
		gpRfrnt.add(comboStudijskiProgram, 1, 3);
		
		gpRfrnt.add(new Label("Godina studija"), 0, 4);
		
		ObservableList<Integer> cbGod = comboGodina.getItems();
		for (int i = 1; i < 5; i++) cbGod.add(i);
		comboGodina.getSelectionModel().select(0);
		gpRfrnt.add(comboGodina, 1, 4);
		
		gpRfrnt.add(new Label("Prosecna ocena"), 0, 5);
		gpRfrnt.add(txtStudentProsek, 1, 5);
		
		return gpRfrnt;
	}

	
	private Node referentControlPanel() {
		
		hbRfrnt.setSpacing(15);
		hbRfrnt.setAlignment(Pos.BOTTOM_CENTER);
		hbRfrnt.getChildren().add(btnUpisi);
		
		return hbRfrnt;
	}
	

	private void compute(ActionEvent evt) {
		
		if (txtStudentIme.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije uneseno ime studenta!").showAndWait();
			return;
		}
		
		if (txtStudentPrezime.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije uneseno prezime studenta!").showAndWait();
			return;
		}
		
		if (txtStudentBrInd.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije unesen broj indeksa studenta!").showAndWait();
			return;
		}

		if (txtStudentProsek.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije unesena prosecna ocena studenta!").showAndWait();
			return;
		}
		
		double d;
		
		try {
			d = Double.parseDouble(txtStudentProsek.getText().trim());
		} catch (NumberFormatException nfe) {
			new Alert(Alert.AlertType.ERROR, "Prosecna ocena nije broj!").showAndWait();
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
		int    god = comboGodina.getValue();
		String avg = txtStudentProsek.getText();
		
		String msc = "";
		
		if (god == 4) {
			
			Alert a0 = new Alert(Alert.AlertType.ERROR, "Studenti cetvrte godine mogu biti upisani na master. Nastaviti?");
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
			
			String line = idx + "|" + ime + " | " + prz + " | " + prz+ " | " + prg + " | " + msc + " | " + avg + "\n";
			listaZaIspis.add(line);
		} else {
			
			god++;
			String line = idx + "|" + ime + " | " + prz + " | " + prz+ " | " + prg + " | " + god + " | " + avg + "\n";
			listaZaIspis.add(line);
		}
		
		try (PrintWriter pw = new PrintWriter(new FileWriter(F_STUDENTI))) {
			
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
