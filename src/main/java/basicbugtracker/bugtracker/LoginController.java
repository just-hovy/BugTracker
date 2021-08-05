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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class LoginController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


    @FXML
    protected void onLoginButton() {
        byte[] salt;
        String passwordHash;

        if (username.getLength() >= 6 && password.getLength() >= 1) {
            String sqlGetUser = "SELECT userPassword, userSalt FROM User WHERE userUsername=" + username.toString();

            DBConnection connection = new DBConnection();
            ResultSet resultSet = connection.sqlQuery(sqlGetUser);
            if (resultSet != null) {
                try {
                    System.out.println(resultSet.getString("userSalt"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                /*try {
                    salt = resultSet.getString("userSalt").getBytes();
                    System.out.println(salt);
                    passwordHash = resultSet.getString("userPassword");

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
                        if (base64Hash.equals(passwordHash)) {
                            System.out.println("Hurray!");
                        }
                    } catch (InvalidKeySpecException e) {
                        e.printStackTrace();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
            }


        }

        // do registrace => co uživatel, to nová sůl :-)
        /*SecureRandom random = new SecureRandom();
        /* = new byte[16];
        /*random.nextBytes(salt);
        System.out.println(salt);*/
        //salt = "[B@4139561c".getBytes();


    }

}
