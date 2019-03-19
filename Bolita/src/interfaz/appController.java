package interfaz;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import modelo.Circulo;

public class appController {
	
	
	@FXML private Circle circulo;
	@FXML private Button iniciar;
	@FXML private Button acelerar;
	
	private int speed;
	
	private Timeline hilo;
	
	private Circulo circuloModelo;
	
	public void initialize() {
		circuloModelo=new Circulo(60, 120);
	}
	
	public void iniciarHilo() {
		speed=100;
		hilo=new Timeline(new KeyFrame(Duration.ZERO, e-> {
			circuloModelo.mover();
			circulo.setLayoutX(circuloModelo.getX());
			circulo.setLayoutY(circuloModelo.getY());
			
			
		}),new KeyFrame(Duration.millis(speed)));
		
		hilo.setCycleCount(Animation.INDEFINITE);
		hilo.play();
		
	}
	
	public void acelerar() {
		iniciarHilo();
		circuloModelo.cambiarColor();
		circulo.setStyle("-fx-fill: "+circuloModelo.getColorActual()+";");
		
	}
	
	
	

	
}
