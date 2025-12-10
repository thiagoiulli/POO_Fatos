package br.com.cefetmg.fatos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label labelresultado;
    @FXML
    private Label labelnum1;
    @FXML
    private Label labelnum2;
    @FXML
    private Label labelop;
    @FXML
    private Label labelPont;
    @FXML
    private Button tentarbutton;

    private Calculos calc;

    @FXML
    public void initialize(){
        calc = new Calculos(labelnum1, labelnum2, labelop, labelresultado, tentarbutton);
    }

    @FXML
    protected void onExitButtonClick(){
        System.exit(0);
    }

    @FXML
    protected void numpadButtonsClick(ActionEvent e){
        int value = Integer.parseInt(((Button) e.getSource()).getText());
        calc.atualizarcampo(value, labelresultado, tentarbutton);
    }

    @FXML
    protected void tentarButtonClick(){
        calc.tentar(labelPont, labelnum1, labelnum2, labelop, labelresultado, tentarbutton);
    }

    @FXML
    protected void passarButtonClick(){
        calc.novojogo(labelnum1, labelnum2, labelop, labelresultado, tentarbutton);
    }

    @FXML
    protected void reiniciarButtonClick(){
        calc.zerarjogo(labelnum1, labelnum2, labelop, labelresultado, labelPont, tentarbutton);
    }

    @FXML
    protected void backspaceButtonClick(){
        calc.deletar(labelresultado, tentarbutton);
    }
}