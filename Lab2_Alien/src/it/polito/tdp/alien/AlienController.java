package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

	private static final String ALIEN_WORD_REG_EXP_VALIDATION = "^[A-Za-z]*$";
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private TextField txtWord;
	@FXML
	private TextArea txtResult;
	@FXML
	private Button btnTranslate;
	@FXML
	private Button btnReset;

	AlienDictionary ad = new AlienDictionary();
	
	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

	}

	@FXML
	void doTranslate(ActionEvent event) {
		String text = txtWord.getText();
		System.out.println("<doTranslate> Testo inserito: " + text);

		if(text==null || "".equals(text.trim())){
			txtResult.setText("Reinserire il testo.\n <parola> <traduzione> se si vole inserire "
					+ "una nuova parola nel dizionario, altrimenti solo <parola>");
			return;
		}
		
		String[] values = text.trim().split(" ");
		int valuesNumber = values.length;
		System.out.println("<doTranslate> Numero di parole inserite: " + valuesNumber);


		switch(valuesNumber){
		case 1:
			txtResult.setText(ad.translateWord(values[0]));
			break;
		case 2:
			System.out.println("<doTranslate> parola: " + values[0]);
			if(!values[0].matches(ALIEN_WORD_REG_EXP_VALIDATION)){
				txtResult.setText("Gli unici caratteri ammessi sono [a-zA-Z]");
				return;
			}
			ad.addWord(values[0], values[1]);
			txtResult.setText("Parola " + values[0] + " aggiunta al dizionario.");
			break;
		default:	
			txtResult.setText("Reinserire il testo.\n <parola> <traduzione> se si vole inserire "
					+ "una nuova parola nel dizionario, altrimenti solo <parola>");
			break;
		}
		
	}

	@FXML
	void doReset(ActionEvent event) {
		txtWord.setText("");
		txtResult.setText("");
	}

}
