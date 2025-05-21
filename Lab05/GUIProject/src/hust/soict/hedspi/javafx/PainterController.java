/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hust.soict.hedspi.javafx;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;

public class PainterController {

	private Color currentColor;
	
    @FXML
    private Pane drawingAreaPane;
    
    public void initialize(){
    	currentColor = Color.BLACK;
    }
    
    @FXML
    void eraseSelected(ActionEvent event) {
    	this.currentColor = Color.WHITE;
    }

    @FXML
    void penSelected(ActionEvent event) {
    	this.currentColor = Color.BLACK;
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(
    			event.getX(), event.getY(), 4, this.currentColor);
    	drawingAreaPane.getChildren().add(newCircle);  	
    }

}