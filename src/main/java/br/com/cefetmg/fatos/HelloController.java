package br.com.cefetmg.fatos;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onExitButtonClick(){
        System.exit(0);
    }
}