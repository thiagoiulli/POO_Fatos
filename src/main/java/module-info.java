module br.com.cefetmg.fatos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens br.com.cefetmg.fatos to javafx.fxml;
    exports br.com.cefetmg.fatos;
}