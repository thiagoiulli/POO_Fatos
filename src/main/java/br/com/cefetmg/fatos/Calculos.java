package br.com.cefetmg.fatos;

import java.util.Random;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Calculos {
    private int pontuacao;
    private int num1;
    private int num2;
    private char op;
    private String campo;
    Random rand;

    public Calculos(Label l1, Label l2, Label o1, Label c1, Button b1){
        pontuacao = 0;
        rand = new Random();
        novojogo(l1, l2, o1, c1, b1);
    }

    private char operator(int n){
        switch (n){
            case 1:
                return '+';
            case 2:
                return '-';
            case 3:
                return '*';
            case 4:
                return '/';
            default:
                return '^'; //talvez eu mude isso
        }
    }

    public void atualizarcampo(int n, Label l, Button b1){
        removeborder(b1);
        campo = campo + n;
        l.setText(campo);
    }

    public void tentar(Label pont, Label l1, Label l2, Label o1, Label r1, Button b1){
        int resultado = -1;
        switch (op){
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                resultado = num1 / num2;
                break;
        }
        if (resultado == Integer.parseInt(campo)){
            atualizarpontuacao(pont);
            novojogo(l1, l2, o1, r1, b1);
        }
        else{
            b1.setStyle("-fx-border-color: #FF0000; -fx-border-width: 2;");
        }
    }

    public void novojogo(Label l1, Label l2, Label o1, Label r1, Button b1) {
        removeborder(b1);
        num1 = rand.nextInt(90) + 10;
        l1.setText(String.valueOf(num1));
        num2 = rand.nextInt(90) + 10;
        l2.setText(String.valueOf(num2));
        op = operator(rand.nextInt(4) + 1);
        o1.setText(String.valueOf(op));
        r1.setText("_");
        campo = "";
    }
    public void atualizarpontuacao(Label pont){
        pontuacao++;
        pont.setText("Voce tem " + pontuacao + " pontos!");
    }

    public void zerarjogo(Label l1, Label l2, Label o1, Label r1, Label pont, Button b1){
        novojogo(l1, l2, o1, r1, b1);
        pontuacao = -1;
        atualizarpontuacao(pont);
    }

    public void deletar(Label l, Button b1){
        removeborder(b1);
        campo = campo.substring(0, campo.length()-1);
        l.setText(campo);
    }

    private void removeborder(Button b1){
        b1.setStyle("-fx-border-width: 0;");
    }
}
