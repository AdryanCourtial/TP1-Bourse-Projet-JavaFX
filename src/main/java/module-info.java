module com.example.tp1bourseprojetjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.tp1bourseprojetjavafx to javafx.fxml;
    exports com.example.tp1bourseprojetjavafx;
    exports com.example.tp1bourseprojetjavafx.expense;
}