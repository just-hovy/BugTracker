package basicbugtracker.bugtracker;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginController {
    @FXML
    private Label userName;
    private Label password;
    private Label status;

    @FXML
    protected void onHelloButtonClick() {
        status.setText("Welcome to JavaFX Application!");
    }
}
