package prakticne_vezbe.pv08_z07_p01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	public static final int DIM = 4;

	
	public static Stage primaryStage;
	
	
	private List<Button> btns = new ArrayList<Button>();
	private TextField txtInput = new TextField();
	private Stack<String> tekSlova = new Stack<>();
	private Button btnClear = new Button("<");
	
	
	public static void main(String[] args) {
		launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage = primaryStage;
		
		Scene s = new Scene(popuni());
		
		primaryStage.setResizable(false);
		primaryStage.setScene(s);
		primaryStage.setTitle("Slozi rec");
		primaryStage.show();
	}

	
	private GridPane popuni() {
		
		GridPane gp = new GridPane();
		
		gp.setPadding(new Insets(10));
		gp.setHgap(5);
		gp.setVgap(5);
		
		btns.add(new Button("G"));
		btns.add(new Button("U"));
		btns.add(new Button("I"));
		
		for (int i = 3; i < DIM * DIM; i++) {
			
			char c = 'A';
			boolean found = false;
			
			while (!found) {
				
				c = getRandomChar();
				
				boolean match = false;
				
				for (int j = 0; j < btns.size(); j++)
					if (btns.get(j).getText().toCharArray()[0] == c) {
						match = true;
						break;
					}
				
				if (!match) found = true;
			}
			
			btns.add(new Button("" + c));
		}
		
		Collections.shuffle(btns);
					
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Button b = btns.get(count++);
				
				b.setOnAction(this::handle);
				b.setPrefSize(50, 50);
				gp.add(b, i, j);
			}
		}
		
		txtInput.setText("");
		txtInput.setPrefWidth(150);
		gp.add(txtInput, 0, 4, 3, 1);
		
		btnClear.setOnAction(this::clear);
		btnClear.setPrefWidth(50);
		gp.add(btnClear, 3, 4);
		
		return gp;
	}

	private char getRandomChar() {
		return (char) (new Random().nextInt(26) + 'A');
	}

	
	private void handle(ActionEvent evt) {
		
		Button currBtn = (Button) evt.getSource();
		String currSlovo = currBtn.getText();
		
		txtInput.setText(txtInput.getText() + currSlovo);
		tekSlova.push(currSlovo);
		
		if (txtInput.getText().equals("GUI"))
			new Alert(Alert.AlertType.INFORMATION, "Pogodili ste zagonetnu rec 'GUI'!").showAndWait();
	}


	private void clear(ActionEvent evt) {
		
		if (txtInput.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije uneto nijedno slovo!").showAndWait();
			return;
		}
		
		tekSlova.pop();
		String tekucaRecBezPoslednjegSlova = "";
		
		for (String slovo : tekSlova)
			tekucaRecBezPoslednjegSlova += slovo;
		
		txtInput.setText(tekucaRecBezPoslednjegSlova);
		
		if (txtInput.getText().equals("GUI"))
			new Alert(Alert.AlertType.INFORMATION, "Pogodili ste zagonetnu rec 'GUI'!").showAndWait();
	}
}
