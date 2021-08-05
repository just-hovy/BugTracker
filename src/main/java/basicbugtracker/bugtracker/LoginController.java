package basicbugtracker.bugtracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class LoginController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


    @FXML
    protected void onLoginButton() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        /*random.nextBytes(salt);
        System.out.println(salt);*/
        salt = "[B@4139561c".getBytes();

        KeySpec spec = new PBEKeySpec(password.getText().toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = null;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        try {
            byte[] hash = factory.generateSecret(spec).getEncoded();
            String base64Hash = Base64.getMimeEncoder().encodeToString(hash);
            System.out.println(base64Hash);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

    }

}
