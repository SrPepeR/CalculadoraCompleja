package dad.CalculadoraCompleja2;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class CalculadoraComplejaApp extends Application {
	
	private ComboBox<String> operadorCombo;
	
	private TextField realPrimeroText;
	private Label operacionPrimeroLabel;
	private TextField imaginarioPrimeroText;
	
	private TextField realSegundoText;
	private Label operacionSegundoLabel;
	private TextField imaginarioSegundoText;
	
	private Separator separadorSeparator;
	
	private TextField resultadoPrimeroText;
	private Label operacionResultadoLabel;
	private TextField resultadoSegundoText;

	
	private HBox principalBox;
	private VBox izquierdaBox;
	private VBox centroBox;
	private HBox arribaBox;
	private HBox centroCentroBox;
	private HBox abajoBox;
	
	private DoubleProperty a = new SimpleDoubleProperty();
	private DoubleProperty b = new SimpleDoubleProperty();
	private DoubleProperty c = new SimpleDoubleProperty();
	private DoubleProperty d = new SimpleDoubleProperty();
	private Complejo resultadoReal = new Complejo();
	private Complejo resultadoImaginario = new Complejo();
	private StringProperty operacion = new SimpleStringProperty();
	
	public void start(Stage primaryStage) throws Exception {
		
		operadorCombo = new ComboBox<String>();
		operadorCombo.getItems().addAll("+", "-", "*", "/");
		operadorCombo.setPrefWidth(50);
		
		realPrimeroText = new TextField("10");
		realPrimeroText.setPrefWidth(50);
		realPrimeroText.setAlignment(Pos.CENTER);
		operacionPrimeroLabel = new Label();
		operacionPrimeroLabel.setPrefWidth(50);
		operacionPrimeroLabel.setAlignment(Pos.CENTER);
		imaginarioPrimeroText = new TextField("10");
		imaginarioPrimeroText.setPrefWidth(50);
		imaginarioPrimeroText.setAlignment(Pos.CENTER);
		
		realSegundoText = new TextField("10");
		realSegundoText.setPrefWidth(50);
		realSegundoText.setAlignment(Pos.CENTER);
		operacionSegundoLabel = new Label();
		operacionSegundoLabel.setPrefWidth(50);
		operacionSegundoLabel.setAlignment(Pos.CENTER);
		imaginarioSegundoText = new TextField("10");
		imaginarioSegundoText.setPrefWidth(50);
		imaginarioSegundoText.setAlignment(Pos.CENTER);
		
		separadorSeparator = new Separator();
		
		resultadoPrimeroText = new TextField();
		resultadoPrimeroText.setPrefWidth(50);
		resultadoPrimeroText.setAlignment(Pos.CENTER);
		resultadoPrimeroText.setDisable(true);
		
		operacionResultadoLabel = new Label();
		operacionResultadoLabel.setPrefWidth(50);
		operacionResultadoLabel.setAlignment(Pos.CENTER);
		
		resultadoSegundoText = new TextField();
		resultadoSegundoText.setPrefWidth(50);
		resultadoSegundoText.setAlignment(Pos.CENTER);
		resultadoSegundoText.setDisable(true);
		
		izquierdaBox = new VBox(operadorCombo);
		izquierdaBox.setAlignment(Pos.CENTER);
		
		arribaBox = new HBox(5, realPrimeroText, operacionPrimeroLabel, imaginarioPrimeroText);
		centroCentroBox = new HBox(5, realSegundoText, operacionSegundoLabel, imaginarioSegundoText);
		abajoBox = new HBox(5, resultadoPrimeroText, operacionResultadoLabel, resultadoSegundoText);
		
		centroBox = new VBox(5, arribaBox, centroCentroBox, separadorSeparator, abajoBox);
		centroBox.setAlignment(Pos.CENTER);
		
		principalBox = new HBox(5, izquierdaBox, centroBox);
		principalBox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(principalBox, 250, 150);
		
		primaryStage.setTitle("CalculadoraView.fxml");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		//BINDEOS
		realPrimeroText.textProperty().bindBidirectional(a, new NumberStringConverter());
		imaginarioPrimeroText.textProperty().bindBidirectional(b, new NumberStringConverter());
		realSegundoText.textProperty().bindBidirectional(c, new NumberStringConverter());
		imaginarioSegundoText.textProperty().bindBidirectional(d, new NumberStringConverter());
		operacion.bind(operadorCombo.getSelectionModel().selectedItemProperty());
		resultadoPrimeroText.textProperty().bindBidirectional(resultadoReal.realProperty(), new NumberStringConverter());
		resultadoSegundoText.textProperty().bindBidirectional(resultadoImaginario.imaginarioProperty(), new NumberStringConverter());
		
		operacion.addListener((o, ov, nv) -> onOperacionChanged(nv)); 

		operadorCombo.getSelectionModel().selectFirst();
	}
	
	private void onOperacionChanged(String nv) {
		
		operacionPrimeroLabel.setText(nv);
		operacionSegundoLabel.setText(nv);
		operacionResultadoLabel.setText(nv);
		
		switch (nv) {
		case "+":
			resultadoReal.realProperty().bind(MathBinding.sumBinding(a, c));
			resultadoImaginario.imaginarioProperty().bind(MathBinding.sumBinding(b, d));
			break;
		case "-":
			resultadoReal.realProperty().bind(MathBinding.resBinding(a, c));
			resultadoImaginario.imaginarioProperty().bind(MathBinding.resBinding(b, d));
			break;
		case "*":
			resultadoReal.realProperty().bind(MathBinding.mulRealBinding(a, b, c, d));
			resultadoImaginario.imaginarioProperty().bind(MathBinding.mulImaginarioBinding(a, b, c, d));
			break;
		case "/":
			resultadoReal.realProperty().bind(MathBinding.divRealBinding(a, b, c, d));
			resultadoImaginario.imaginarioProperty().bind(MathBinding.divImaginarioBinding(a, b, c, d));
			break;
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}