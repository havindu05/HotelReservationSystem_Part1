package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomePageController {

    public void btnNext(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/DashBoard.fxml"));

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
