module com.example.tp1bourseprojetjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.tp1bourseprojetjavafx to javafx.fxml;
    opens com.example.tp1bourseprojetjavafx.dialog.AddExpenseDialogue to javafx.fxml;
    opens com.example.tp1bourseprojetjavafx.expense to javafx.fxml;
    opens com.example.tp1bourseprojetjavafx.components;
    opens com.example.tp1bourseprojetjavafx.dashboard to javafx.fxml;
    opens com.example.tp1bourseprojetjavafx.pageProjet to javafx.fxml;




    exports com.example.tp1bourseprojetjavafx;
    exports com.example.tp1bourseprojetjavafx.expense;
    exports com.example.tp1bourseprojetjavafx.dialog.AddExpenseDialogue;
    exports com.example.tp1bourseprojetjavafx.components;
    exports com.example.tp1bourseprojetjavafx.dashboard;
    exports com.example.tp1bourseprojetjavafx.pageProjet;

}