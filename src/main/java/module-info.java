module com.example.tp1bourseprojetjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tp1bourseprojetjavafx to javafx.fxml;
    exports com.example.tp1bourseprojetjavafx;
}